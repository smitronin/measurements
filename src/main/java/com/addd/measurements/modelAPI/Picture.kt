package com.addd.measurements.modelAPI

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



/**
 * Created by addd on 26.12.2017.
 */
class Picture {
    @SerializedName("id")
    @Expose
    val id: Int? = null
    @SerializedName("user")
    @Expose
    val user: String? = null
    @SerializedName("auto_date")
    @Expose
    val autoDate: String? = null
    @SerializedName("url")
    @Expose
    val url: String? = null
    @SerializedName("name")
    @Expose
    val name: Any? = null
    @SerializedName("measurement")
    @Expose
    val measurement: Int? = null
}