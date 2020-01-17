package net.kelmer.android.data.model

import com.google.gson.annotations.SerializedName

data class PhotoListResponse(
    val page: Int,
    val pages: Int,
    @SerializedName("perpage") val perPage: Int,
    val total: Int,
    val photo: List<PhotoEntity>
)