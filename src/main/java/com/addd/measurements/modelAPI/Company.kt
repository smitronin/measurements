package com.addd.measurements.modelAPI

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName



/**
 * Created by addd on 07.12.2017.
 */
class Company {
    @SerializedName("id")
    @Expose
    val id: Int? = null
    @SerializedName("name")
    @Expose
    val name: String? = null
    @SerializedName("symbol")
    @Expose
    val symbol: String? = null
}