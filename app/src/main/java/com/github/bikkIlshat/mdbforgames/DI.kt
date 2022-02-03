package com.github.bikkIlshat.mdbforgames

import com.github.bikkIlshat.mdbforgames.di.AppComponent

/***
 * Singleton компоненты которые живут на уровне приложения
 */
object DI {
  lateinit var appComponent: AppComponent
    internal set
}