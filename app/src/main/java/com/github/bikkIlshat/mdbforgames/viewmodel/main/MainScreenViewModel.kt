package com.github.bikkIlshat.mdbforgames.viewmodel.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.github.bikkIlshat.mdbforgames.model.base.ListItem
import com.github.bikkIlshat.mdbforgames.model.game.*
import com.github.bikkIlshat.mdbforgames.viewmodel.base.BaseViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class MainScreenViewModel : BaseViewModel() {
  private val _liveData = MutableLiveData<List<ListItem>>()
  val liveData: LiveData<List<ListItem>> = _liveData


  init {
    viewModelScope.launch(Dispatchers.IO) {
      _liveData.postValue(getLoaders())
      val items = getItems()
      _liveData.postValue(items)
    }
  }

  private fun getLoaders(): List<ListItem> {
    return listOf(
      GamesHorizontalItem( // реализовали горизонтальный список внутри вертикального
        title = "Wide games",
        games = IntRange(1, 2).map { ProgressWideItem }
      ),
      GamesHorizontalItem( // реализовали горизонтальный список внутри вертикального
        title = "Thin games",
        games = IntRange(1, 3).map { ProgressThinItem }
      ),
      GamesHorizontalItem( // реализовали горизонтальный список внутри вертикального
        title = "Wide games",
        games = IntRange(1, 2).map { ProgressWideItem }
      )
    )
  }

  private suspend fun getItems(): List<ListItem> {
    delay(2000L)
    return listOf(
      GamesHorizontalItem( // реализовали горизонтальный список внутри вертикального
        title = "Wide games",
        games = IntRange(1, 20).map {
          GameWideItem(
            it.toLong(),
            "Game Title $it")
        }
      ),
      GamesHorizontalItem( // реализовали горизонтальный список внутри вертикального
        title = "Thin games",
        games = IntRange(1, 20).map {
          GameThinItem(
            it.toLong(),
            "Game Title $it")
        }
      ),
      GamesHorizontalItem( // реализовали горизонтальный список внутри вертикального
        title = "Wide games",
        games = IntRange(1, 20).map {
          GameThinItem(
            it.toLong(),
            "Game Title $it")
        }
      )
    )
  }
}