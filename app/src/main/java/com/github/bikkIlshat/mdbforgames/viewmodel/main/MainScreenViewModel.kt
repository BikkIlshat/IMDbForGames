package com.github.bikkIlshat.mdbforgames.viewmodel.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.github.bikkIlshat.mdbforgames.R
import com.github.bikkIlshat.mdbforgames.model.base.ListItem
import com.github.bikkIlshat.mdbforgames.model.game.*
import com.github.bikkIlshat.mdbforgames.util.ResourceProvider
import com.github.bikkIlshat.mdbforgames.viewmodel.base.BaseViewModel
import com.github.bikkilshat.core_network.di.NetworkComponent
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import javax.inject.Inject

class MainScreenViewModel @Inject constructor(
  private val resources: ResourceProvider,

): BaseViewModel() {

  private val api = NetworkComponent.createApi()
  private val _liveData = MutableLiveData<List<ListItem>>()
  val liveData: LiveData<List<ListItem>> = _liveData


  init {
    viewModelScope.launch(Dispatchers.IO) {
      _liveData.postValue(getLoaders())
      val items = getItems()
      _liveData.postValue(items)
    }
  }

  // Предзапуск (прогресс)
  private fun getLoaders(): List<ListItem> {
    return listOf(
      GamesHorizontalItem( // реализовали горизонтальный список внутри вертикального
        title = resources.string(R.string.most_anticipated),
        games = IntRange(1, 2).map { ProgressWideItem }
      ),
      GamesHorizontalItem( // реализовали горизонтальный список внутри вертикального
        title = resources.string(R.string.latest_releases),
        games = IntRange(1, 3).map { ProgressThinItem }
      ),
      GamesHorizontalItem( // реализовали горизонтальный список внутри вертикального
        title = resources.string(R.string.most_rated_in_2021),
        games = IntRange(1, 2).map { ProgressWideItem }
      )
    )
  }


  private suspend fun getItems(): List<ListItem> {
    val mostAnticipatedResponse = api.games(
      mapOf(
        "dates" to "2020-05-16,2021-05-16",
        "ordering" to "-added"
      )
    )
    val latestReleasesResponse = api.games(
      mapOf(
        "dates" to "2020-04-01,2020-05-16"
      )
    )
    val mostRatedResponse = api.games(
      mapOf(
        "dates" to "2020-01-01,2020-05-16",
        "ordering" to "-rated"
      )
    )

    val mostAnticipatedItems = mostAnticipatedResponse.results.map {
      GameWideItem(
        id = it.id,
        title = it.title,
        image = it.image
      )
    }
    val latestReleasesItems = latestReleasesResponse.results.map {
      GameThinItem(
        id = it.id,
        title = it.title,
        image = it.image
      )
    }
    val mostRatedItems = mostRatedResponse.results.map {
      GameWideItem(
        id = it.id,
        title = it.title,
        image = it.image
      )
    }

    return listOf(
      GamesHorizontalItem(
        title = "The most anticipated",
        games = mostAnticipatedItems
      ),
      GamesHorizontalItem(
        title = "Latest releases",
        games = latestReleasesItems
      ),
      GamesHorizontalItem(
        title = "The most rated in 2020",
        games = mostRatedItems
      )
    )
  }
}


// реализовали горизонтальный список внутри вертикального