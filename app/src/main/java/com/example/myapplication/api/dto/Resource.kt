package com.example.myapplication.api.dto

import com.google.gson.annotations.SerializedName

data class ReqResData<T>(
    val page: Int?,
    @SerializedName("per_page")
    val perPage: Int?,
    val total: Int?,
    @SerializedName("total_pages")
    val totalPages: Int?,
    val data: T?
)

data class Resource(
    val id: Long?,
    val name: String?,
    val year: Int?,
    val color: String?,
    @SerializedName("pantone_value")
    val pantoneValue: String?,
)
