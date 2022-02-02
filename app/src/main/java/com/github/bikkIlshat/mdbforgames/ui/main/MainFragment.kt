package com.github.bikkIlshat.mdbforgames.ui.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.github.bikkIlshat.mdbforgames.R
import com.github.bikkIlshat.mdbforgames.databinding.FragmentMainBinding
import com.github.bikkIlshat.mdbforgames.viewmodel.main.MainScreenViewModel
import com.hannesdorfmann.adapterdelegates4.ListDelegationAdapter

class MainFragment : Fragment(R.layout.fragment_main) {
  private val viewBinding: FragmentMainBinding by viewBinding()
  private val viewModel by viewModels<MainScreenViewModel>()

  private val adapterDelegate =
    ListDelegationAdapter(//  родительский адаптер внутри которого остальные
      MainScreenDelegates.gamesHorizontalDelegate
    )


  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)
    with(viewBinding) {
      recyclerView.adapter = adapterDelegate

      viewModel.liveData.observe(viewLifecycleOwner) {
        adapterDelegate.apply {
          items = it
          notifyDataSetChanged()
        }
      }
    }
  }

}