package com.example.quote.core.di

import android.content.Context
import com.example.quote.QuoteApp
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
class ContextModule {
    @Provides
    @Singleton
    fun provideContext(application: QuoteApp): Context {
        return application.applicationContext
    }

}