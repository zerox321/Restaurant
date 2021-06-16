package com.example.domainlayer.remote

import com.example.datalayer.EndPoint.urlConstant
import com.example.datalayer.MenuItem
import retrofit2.http.GET


interface MenuService {
    @GET(value = urlConstant)
    suspend fun getMenu(): List<MenuItem>
}