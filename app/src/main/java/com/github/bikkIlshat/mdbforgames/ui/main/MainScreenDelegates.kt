package com.github.bikkIlshat.mdbforgames.ui.main

import com.github.bikkIlshat.mdbforgames.databinding.*
import com.github.bikkIlshat.mdbforgames.model.base.ListItem
import com.github.bikkIlshat.mdbforgames.model.game.*
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
        thinGameDelegate,
        wideProgressDelegate,
        thinProgressDelegate
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
  private val wideProgressDelegate =
    adapterDelegateViewBinding<ProgressWideItem, ListItem, ItemProgressWideBinding>(
      { inflater, container ->
        ItemProgressWideBinding.inflate(inflater, container, false) }
    ) {}

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

  private val thinProgressDelegate =
    adapterDelegateViewBinding<ProgressThinItem, ListItem, ItemProgressThinBinding>(
      { inflater, container ->
        ItemProgressThinBinding.inflate(inflater, container, false) }
    ) {}

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