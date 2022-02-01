package com.github.bikkIlshat.mdbforgames.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.github.bikkIlshat.mdbforgames.R
import com.github.bikkIlshat.mdbforgames.databinding.FragmentMainBinding
import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter

class MainFragment : Fragment(R.layout.fragment_main) {
  private val viewBinding: FragmentMainBinding by viewBinding()

  private val adapterDelegate =
    ListDelegationAdapter(//  родительский адаптер внутри которого остальные
      MainScreenDelegates.gamesHorizontalDelegate
    )


  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

    with(viewBinding) {
      recyclerView.adapter = adapterDelegate
      adapterDelegate.apply {
        items = listOf(
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
        notifyDataSetChanged()
      }
    }
  }

}