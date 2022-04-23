package com.github.bikkIlshat.mdbforgames.ui.main

import com.github.bikkIlshat.mdbforgames.model.base.ListItem
import com.github.bikkIlshat.mdbforgames.ui.base.BaseDiffUtilItemCallback
import com.hannesdorfmann.adapterdelegates4.AsyncListDifferDelegationAdapter

/***
 * Адаптер вертикального списка
 */
class MainScreenAdapter : AsyncListDifferDelegationAdapter<ListItem>(BaseDiffUtilItemCallback()) {

init {
delegatesManager.addDelegate(MainScreenDelegates.gamesHorizontalDelegate())
}

}
