package com.github.bikkIlshat.mdbforgames.util

import android.content.Context
import javax.inject.Inject

class AndroidResourceProvider @Inject constructor(
  private val context: Context // тут будет инжектиться ApplicationContext
): ResourceProvider {
  override fun string(id: Int): String  = context.resources.getString(id)
}