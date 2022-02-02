package com.github.bikkIlshat.mdbforgames.ui

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.github.bikkIlshat.mdbforgames.R
import com.github.bikkIlshat.mdbforgames.ui.main.MainFragment


class MainActivity : AppCompatActivity(R.layout.activity_main) {

  override fun onCreate(savedInstanceState: Bundle?) {
    super.onCreate(savedInstanceState)

    if (savedInstanceState == null) {
      supportFragmentManager.beginTransaction()
        .add(R.id.container,MainFragment())
        .commitAllowingStateLoss()
    }

  }
}