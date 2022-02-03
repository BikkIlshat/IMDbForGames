package com.github.bikkIlshat.mdbforgames.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject
import javax.inject.Provider

/***
 * Фабрика которая умеет по классу  ViewModel  (Class<out ViewModel>)  вызывать  Provider и получать инстенс
 */
class ViewModelFactory @Inject constructor(
  private val viewModels: MutableMap<Class<out ViewModel>, Provider<ViewModel>>
) : ViewModelProvider.Factory {

  @Suppress("UNCHECKED_CAST")
  override fun <T : ViewModel> create(modelClass: Class<T>): T {
    val viewModelProvider = viewModels[modelClass]
      ?: throw IllegalArgumentException("ViewModel $modelClass not found")
    return viewModelProvider.get() as T
  }
}