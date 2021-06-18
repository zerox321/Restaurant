package com.example.mvvmEx.di

import com.example.datalayer.constants.Constant
import com.example.domainlayer.BuildConfig.baseUrl
import com.example.domainlayer.remote.RequestInterceptor
import com.example.mvvmEx.BuildConfig
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
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
    fun provideLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().apply {
            level =
                if (BuildConfig.DEBUG)
                    HttpLoggingInterceptor.Level.BODY
                else
                    HttpLoggingInterceptor.Level.NONE
        }
    }

    //Hilt Provide Network Interceptor
    @Provides
    @Singleton
    fun provideRequestInterceptor(): RequestInterceptor {
        return RequestInterceptor()
    }

    //Hilt Provide Network OkHttpClient
    @Provides
    @Singleton
    fun provideOkHttpClient(
        requestInterceptor: RequestInterceptor,
        loggingInterceptor: HttpLoggingInterceptor
    ): OkHttpClient {
        return OkHttpClient.Builder().apply {

            connectTimeout(Constant.timeOut, TimeUnit.SECONDS)
            readTimeout(Constant.timeOut, TimeUnit.SECONDS)
            writeTimeout(Constant.timeOut, TimeUnit.SECONDS)

            addInterceptor(requestInterceptor)
            addInterceptor(loggingInterceptor)

        }.build()

    }

    //Hilt Provide Network Response Gson Converter
    @Provides
    @Singleton
    fun provideGsonConverterFactory(): GsonConverterFactory {
        return GsonConverterFactory.create()
    }


    //Hilt Provide Retrofit Builder
    @Provides
    @Singleton
    fun provideRetrofit(
        okHttpClient: OkHttpClient,
        converterFactory: GsonConverterFactory
    ): Retrofit {
        return Retrofit.Builder()
            .client(okHttpClient)
            .baseUrl(baseUrl)
            .addConverterFactory(converterFactory)
            .build()
    }


}
