package com.example.mytrackerapp.module

import android.content.Context
import androidx.room.Room
import com.example.mytrackerapp.database.MyTrackerAppDatabase
import com.example.mytrackerapp.database.dao.UserDao
import com.example.mytrackerapp.database.repo.DefaultUserRepo
import com.example.mytrackerapp.database.repo.UserRepo
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class) // Choose appropriate component

object DbModule {


    @Singleton
    @Provides
    fun provideItemUserDatabase(
        @ApplicationContext context: Context
    ) = Room.databaseBuilder(context, MyTrackerAppDatabase::class.java, "db").build()

    @Singleton
    @Provides
    fun provideUserDao(
        database: MyTrackerAppDatabase
    ) = database.userDao()

    @Singleton
    @Provides
    fun provideDefaultUserRepository(
        dao: UserDao,
    ) = DefaultUserRepo(dao) as UserRepo
}
