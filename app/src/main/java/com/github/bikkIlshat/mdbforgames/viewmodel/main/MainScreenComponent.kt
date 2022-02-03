package com.github.bikkIlshat.mdbforgames.viewmodel.main

import androidx.lifecycle.ViewModel
import com.github.bikkIlshat.mdbforgames.DI
import com.github.bikkIlshat.mdbforgames.di.ScreenScope
import com.github.bikkIlshat.mdbforgames.di.ViewModelFactory
import com.github.bikkIlshat.mdbforgames.di.ViewModelKey
import com.github.bikkIlshat.mdbforgames.util.ResourceProvider
import dagger.Binds
import dagger.BindsInstance
import dagger.Component
import dagger.Module
import dagger.multibindings.IntoMap
import javax.inject.Scope

@Component(modules = [MainScreenModule::class])
@ScreenScope
interface MainScreenComponent {

  fun viewModelFactory(): ViewModelFactory

  @Component.Builder
  interface Builder {
    @BindsInstance
    fun resources(resourceProvider: ResourceProvider): Builder

    fun build(): MainScreenComponent
  }

  companion object {
    fun create() = with (DI.appComponent) {
      //Предоставили в DaggerMainScreenComponent стороннюю зависимость ресурсов
      DaggerMainScreenComponent.builder()
        .resources(resources())
        .build()
    }
  }
}



@Module
abstract class MainScreenModule {

  @Binds
  @IntoMap
  @ViewModelKey(MainScreenViewModel::class)
  abstract fun mainScreenViewModel(viewModel: MainScreenViewModel): ViewModel


}