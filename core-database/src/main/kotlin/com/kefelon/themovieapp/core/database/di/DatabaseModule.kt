package com.kefelon.themovieapp.core.database.di

import android.app.Application
import androidx.room.Room
import com.kefelon.themovieapp.core.database.dao.MovieDao
import com.kefelon.themovieapp.core.database.database.MovieRoomDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object DatabaseModule {

    @Provides
    @Singleton
    fun provideMovieRoomDatabase(
        application: Application,
    ): MovieRoomDatabase {
        return Room
            .databaseBuilder(application, MovieRoomDatabase::class.java, "TMA.db")
            .fallbackToDestructiveMigration()
            .build()
    }

    @Provides
    @Singleton
    fun provideMovieDao(movieRoomDatabase: MovieRoomDatabase): MovieDao {
        return movieRoomDatabase.movieDao()
    }
}
