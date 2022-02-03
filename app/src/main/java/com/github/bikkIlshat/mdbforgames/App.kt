package com.github.bikkIlshat.mdbforgames

import android.app.Application
import com.github.bikkIlshat.mdbforgames.di.DaggerAppComponent

class App : Application() {

  override fun onCreate() {
    super.onCreate()
    initDi()
  }

  private fun initDi() {
    DI.appComponent = DaggerAppComponent.builder()
      .appContext(this)
      .build()
  }
}