package com.kefelon.themovieapp.core.data.di

import com.kefelon.themovieapp.core.data.repository.TMDBRepository
import com.kefelon.themovieapp.core.data.repository.TMDBRepositoryImpl
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
interface DataModule {

    @Binds
    fun bindTMDBRepository(impl: TMDBRepositoryImpl): TMDBRepository

}