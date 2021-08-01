package com.example.mvvmEx.di

import android.content.Context
import com.example.datalayer.constants.Constant
import com.example.datalayer.constants.Constant.CACHE_SIZE
import com.example.domainlayer.BuildConfig.baseUrl
import com.example.mvvmEx.BuildConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import okhttp3.Cache
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.util.concurrent.TimeUnit
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    //Hilt Provide Network Request Logger
    @Provides
    @Singleton
    fun provideLoggingInterceptor(): HttpLoggingInterceptor = HttpLoggingInterceptor().apply {
        level =
            if (BuildConfig.DEBUG)
                HttpLoggingInterceptor.Level.BODY
            else
                HttpLoggingInterceptor.Level.NONE
    }

    //Hilt Provide Network Cache
    @Provides
    @Singleton
    fun provideCache(@ApplicationContext context: Context): Cache =
        Cache(context.cacheDir, CACHE_SIZE)

    //Hilt Provide Network OkHttpClient
    @Provides
    @Singleton
    fun provideOkHttpClient(
        cache: Cache,
        loggingInterceptor: HttpLoggingInterceptor
    ): OkHttpClient = OkHttpClient.Builder().apply {

        connectTimeout(Constant.timeOut, TimeUnit.SECONDS)
        readTimeout(Constant.timeOut, TimeUnit.SECONDS)
        writeTimeout(Constant.timeOut, TimeUnit.SECONDS)

        addInterceptor(loggingInterceptor)
        cache(cache)

    }.build()


    //Hilt Provide Network Response Gson Converter
    @Provides
    @Singleton
    fun provideGsonConverterFactory(): GsonConverterFactory = GsonConverterFactory.create()


    //Hilt Provide Retrofit Builder
    @Provides
    @Singleton
    fun provideRetrofit(
        okHttpClient: OkHttpClient,
        converterFactory: GsonConverterFactory
    ): Retrofit =
        Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(baseUrl)
            .addConverterFactory(converterFactory)
            .build()


}
