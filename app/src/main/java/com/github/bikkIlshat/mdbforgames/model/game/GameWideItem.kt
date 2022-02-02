package com.github.bikkIlshat.mdbforgames.model.game

import com.github.bikkIlshat.mdbforgames.model.base.ListItem

data class GameWideItem(
  val id: Long,
  val title: String,
) : ListItem {
  override val itemId: Long = id
}