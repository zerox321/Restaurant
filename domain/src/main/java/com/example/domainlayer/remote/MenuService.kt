package com.example.domainlayer.remote

import com.example.datalayer.constants.Constant.urlConstant
import com.example.datalayer.model.MenuItem
import retrofit2.http.GET


interface MenuService {
    @GET(value = urlConstant)
    suspend fun getMenu(): List<MenuItem>
}