package com.vtopacademy.retrofit

import com.vtopacademy.schools.SchoolResponse
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

/** Retrofit interface for making api calls.  */
interface ApiService {

    /** Returns all categories.  */
    @get:GET("schools")
    val allSchools: Call<MutableList<SchoolResponse>>

}