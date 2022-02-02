package com.github.bikkIlshat.mdbforgames.main

import com.github.bikkIlshat.mdbforgames.base.ListItem
import com.github.bikkIlshat.mdbforgames.databinding.ItemGameThinBinding
import com.github.bikkIlshat.mdbforgames.databinding.ItemGameWideBinding
import com.github.bikkIlshat.mdbforgames.databinding.ItemGamesHorizontalBinding
import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding

/***
 * Тут важен порядок того как вы объявляете property  в классе
 */
object MainScreenDelegates {


  // этот делегат который умеет отрисовывать вьюшку горизонтальным списком (item в вертикальном списке)
  val gamesHorizontalDelegate =
    adapterDelegateViewBinding<GamesHorizontalItem, ListItem, ItemGamesHorizontalBinding>(
      { inflater, container ->
        ItemGamesHorizontalBinding.inflate(inflater, container, false) }
    ) {
      //onCreateViewHolder
      binding.recyclerView.adapter = ListDelegationAdapter(
        wideGameDelegate,
        thinGameDelegate
      )
      //onBindViewHolder
      bind {
        binding.titleTextView.text = item.title  // сетим title для категории
        (binding.recyclerView.adapter as ListDelegationAdapter<List<ListItem>>).apply {
          items = item.games
          notifyDataSetChanged()
        }
      }
      //onViewRecycled
      onViewRecycled {
        // что-то для освобождения ресурсов 
      }
    }

  private val wideGameDelegate =
    adapterDelegateViewBinding<GameWideItem, ListItem, ItemGameWideBinding>(
      { inflater, container ->
        ItemGameWideBinding.inflate(inflater, container, false)
      }
    ) {
      bind {
        binding.imageView.setBackgroundColor(item.hashCode())
        binding.titleTextViewWide.text = item.title
      }
    }

  private val thinGameDelegate =
    adapterDelegateViewBinding<GameThinItem, ListItem, ItemGameThinBinding>(
      { inflater, container ->
        ItemGameThinBinding.inflate(inflater, container, false)
      }
    ) {
      bind {
        binding.imageView.setBackgroundColor(item.hashCode())
        binding.titleTextViewThin.text = item.title
      }
    }

}