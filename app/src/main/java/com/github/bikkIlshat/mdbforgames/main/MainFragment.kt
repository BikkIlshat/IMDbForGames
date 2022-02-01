package com.github.bikkIlshat.mdbforgames.main

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import by.kirich1409.viewbindingdelegate.viewBinding
import com.github.bikkIlshat.mdbforgames.R
import com.github.bikkIlshat.mdbforgames.databinding.FragmentMainBinding

class MainFragment : Fragment(R.layout.fragment_main) {
  private val viewBinding: FragmentMainBinding by viewBinding()


  override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
    super.onViewCreated(view, savedInstanceState)

  }
}