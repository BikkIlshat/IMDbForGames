package com.github.bikkIlshat.mdbforgames.model.game

import com.github.bikkIlshat.mdbforgames.model.base.ListItem

data class GamesHorizontalItem(
 val title: String,
 val games: List<ListItem>
) : ListItem