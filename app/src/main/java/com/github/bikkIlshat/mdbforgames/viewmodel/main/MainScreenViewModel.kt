package com.github.bikkIlshat.mdbforgames.viewmodel.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.github.bikkIlshat.mdbforgames.model.base.ListItem
import com.github.bikkIlshat.mdbforgames.model.game.*
import com.github.bikkIlshat.mdbforgames.viewmodel.base.BaseViewModel
import com.github.bikkilshat.core_network.di.NetworkComponent
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainScreenViewModel : BaseViewModel() {

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
        title = "Top upcoming",
        games = IntRange(1, 2).map { ProgressWideItem }
      ),
      GamesHorizontalItem( // реализовали горизонтальный список внутри вертикального
        title = "Latest release",
        games = IntRange(1, 3).map { ProgressThinItem }
      ),
      GamesHorizontalItem( // реализовали горизонтальный список внутри вертикального
        title = "The most rated in 2022",
        games = IntRange(1, 2).map { ProgressWideItem }
      )
    )
  }

  private suspend fun getItems(): List<ListItem> {
    val response = api.games()
    val gamesWide = response.results.map {
      GameWideItem(
        id = it.id,
        title = it.title
      )
    }
    val gamesThin = response.results.map {
      GameThinItem(
        id = it.id,
        title = it.title
      )
    }
    return listOf(
      GamesHorizontalItem( // реализовали горизонтальный список внутри вертикального
        title = "Wide games",
        games = gamesWide
      ),
      GamesHorizontalItem( // реализовали горизонтальный список внутри вертикального
        title = "Thin games",
        games = gamesThin
      ),
      GamesHorizontalItem( // реализовали горизонтальный список внутри вертикального
        title = "Wide games",
        games = gamesWide
      )
    )
  }
}