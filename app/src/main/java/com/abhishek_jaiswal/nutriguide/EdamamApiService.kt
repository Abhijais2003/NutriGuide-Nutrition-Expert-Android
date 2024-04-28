package com.abhishek_jaiswal.nutriguide

import EdamamResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface EdamamApiService {
    @GET("api/nutrition-data")
    fun getNutritionData(
        @Query("app_id") appId: String,
        @Query("app_key") appKey: String,
        @Query("ingr") ingr: String
    ): Call<EdamamResponse>
}
