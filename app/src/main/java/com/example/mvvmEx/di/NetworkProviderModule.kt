package com.example.mvvmEx.di

import com.example.domainlayer.remote.MenuService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped
import retrofit2.Retrofit

@Module
@InstallIn(ViewModelComponent::class)
object NetworkProviderModule {

    // provide MenuService with ViewModel Scope
    @Provides
    @ViewModelScoped
    fun provideMenuService(retrofit: Retrofit): MenuService {
        return retrofit.create(MenuService::class.java)
    }


}
