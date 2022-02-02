package com.github.bikkIlshat.mdbforgames.ui.main

import com.github.bikkIlshat.mdbforgames.model.base.ListItem
import com.github.bikkIlshat.mdbforgames.ui.base.BaseDiffUtilItemCallback
import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter

/***
 * Адаптер горизонтального списка
 */
class GamesCardsAdapter : AsyncListDifferDelegationAdapter<ListItem>(BaseDiffUtilItemCallback()) {
  init {
    delegatesManager
      .addDelegate(MainScreenDelegates.wideGameDelegate)
      .addDelegate(MainScreenDelegates.thinGameDelegate)
      .addDelegate(MainScreenDelegates.wideProgressDelegate)
      .addDelegate(MainScreenDelegates.thinProgressDelegate)
  }
}