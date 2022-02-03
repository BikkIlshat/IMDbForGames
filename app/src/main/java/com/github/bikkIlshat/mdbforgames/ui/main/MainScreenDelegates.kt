package com.github.bikkIlshat.mdbforgames.ui.main

import android.app.Activity
import com.bumptech.glide.Glide
import com.github.bikkIlshat.mdbforgames.R
import com.github.bikkIlshat.mdbforgames.databinding.*
import com.github.bikkIlshat.mdbforgames.model.base.ListItem
import com.github.bikkIlshat.mdbforgames.model.game.*
import com.hannesdorfmann.adapterdelegates4.dsl.adapterDelegateViewBinding

/***
 * Тут важен порядок того как вы объявляете property  в классе
 */
object MainScreenDelegates {


  // этот делегат который умеет отрисовывать вьюшку горизонтальным списком (item в вертикальном списке)
  val gamesHorizontalDelegate =
    adapterDelegateViewBinding<GamesHorizontalItem, ListItem, ItemGamesHorizontalBinding>(
      { inflater, container ->
        ItemGamesHorizontalBinding.inflate(inflater, container, false)
      }
    ) {
      //onCreateViewHolder
      val adapter = GamesCardsAdapter()
      binding.recyclerView.adapter = adapter
      //onBindViewHolder
      bind {
        binding.titleTextView.text = item.title  // сетим title для категории
        adapter.items = item.games
      }

    }
  val wideProgressDelegate =
    adapterDelegateViewBinding<ProgressWideItem, ListItem, ItemProgressWideBinding>(
      { inflater, container ->
        ItemProgressWideBinding.inflate(inflater, container, false)
      }
    ) {}

  val wideGameDelegate =
    adapterDelegateViewBinding<GameWideItem, ListItem, ItemGameWideBinding>(
      { inflater, container ->
        ItemGameWideBinding.inflate(inflater, container, false)
      }
    ) {
      bind {
        val resources = binding.root.resources
        Glide.with(binding.root)
          .load(item.image)
          .override(
            resources.getDimensionPixelOffset(R.dimen.game_card_wide_width),
            resources.getDimensionPixelOffset(R.dimen.game_card_wide_height)
          )
          .centerCrop()
          .into(binding.imageView)
        binding.titleTextViewWide.text = item.title
      }
      //onViewRecycled
      onViewRecycled {
        // что-то для освобождения ресурсов
        if ((binding.root.context as? Activity)?.isDestroyed?.not() == true) {
          Glide.with(binding.root).clear(binding.imageView)
        }
      }
    }

  val thinProgressDelegate =
    adapterDelegateViewBinding<ProgressThinItem, ListItem, ItemProgressThinBinding>(
      { inflater, container ->
        ItemProgressThinBinding.inflate(inflater, container, false)
      }
    ) {}

  val thinGameDelegate =
    adapterDelegateViewBinding<GameThinItem, ListItem, ItemGameThinBinding>(
      { inflater, container ->
        ItemGameThinBinding.inflate(inflater, container, false)
      }
    ) {
      bind {
        val resources = binding.root.resources
        Glide.with(binding.root)
          .load(item.image)
          .override(
            resources.getDimensionPixelOffset(R.dimen.game_card_thin_width),
            resources.getDimensionPixelOffset(R.dimen.game_card_thin_height)
          )
          .centerCrop()
          .into(binding.imageView)
        binding.titleTextViewThin.text = item.title
      }

      //onViewRecycled
      onViewRecycled {
        // что-то для освобождения ресурсов
        if ((binding.root.context as? Activity)?.isDestroyed?.not() == true) {
          Glide.with(binding.root).clear(binding.imageView)
        }
      }
    }


}