package com.github.bikkIlshat.mdbforgames.di

import android.content.Context
import com.github.bikkIlshat.mdbforgames.util.AndroidResourceProvider
import com.github.bikkIlshat.mdbforgames.util.ResourceProvider
import dagger.Binds
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import javax.inject.Singleton

@Component(modules = [AppModule::class])
@Singleton
interface AppComponent {

  fun resources(): ResourceProvider

  @Component.Builder
  interface Builder {
    @BindsInstance
    fun appContext(context: Context): Builder

    fun build(): AppComponent

  }

}

@Module
abstract class AppModule {
  @Binds
  @Singleton
  abstract fun bindResourceProvider(provider: AndroidResourceProvider): ResourceProvider


}