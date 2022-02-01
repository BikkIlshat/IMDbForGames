package com.github.bikkIlshat.mdbforgames.main

import com.github.bikkIlshat.mdbforgames.base.ListItem

data class GamesHorizontalItem(
 val title: String,
 val games: List<ListItem>
) : ListItem