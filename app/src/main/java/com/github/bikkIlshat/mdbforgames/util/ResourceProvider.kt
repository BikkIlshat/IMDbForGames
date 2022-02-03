package com.github.bikkIlshat.mdbforgames.util

import androidx.annotation.StringRes

interface ResourceProvider {
  fun string(@StringRes id: Int) : String
}