package com.github.bikkIlshat.mdbforgames.mainviewmodel.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.viewModelScope
import com.github.bikkIlshat.mdbforgames.base.ListItem
import com.github.bikkIlshat.mdbforgames.main.GameThinItem
import com.github.bikkIlshat.mdbforgames.main.GameWideItem
import com.github.bikkIlshat.mdbforgames.main.GamesHorizontalItem
import com.github.bikkIlshat.mdbforgames.mainviewmodel.base.BaseViewModel
import kotlinx.coroutines.*

class MainScreenViewModel : BaseViewModel() {
  private val _liveData = MutableLiveData<List<ListItem>>()
  val liveData: LiveData<List<ListItem>> = _liveData


  init {
    viewModelScope.launch(Dispatchers.IO) {
      val items = getItems()
      _liveData.postValue(items)
    }
  }

  private suspend fun getItems(): List<ListItem> {
    return listOf(
      GamesHorizontalItem( // реализовали горизонтальный список внутри вертикального
        title = "Wide games",
        games = IntRange(1, 20).map { GameWideItem(it.toLong(), "Game Title $it") }
      ),
      GamesHorizontalItem( // реализовали горизонтальный список внутри вертикального
        title = "Thin games",
        games = IntRange(1, 20).map { GameThinItem(it.toLong(), "Game Title $it") }
      ),
      GamesHorizontalItem( // реализовали горизонтальный список внутри вертикального
        title = "Thin games",
        games = IntRange(1, 20).map { GameThinItem(it.toLong(), "Game Title $it") }
      )
    )
  }
}