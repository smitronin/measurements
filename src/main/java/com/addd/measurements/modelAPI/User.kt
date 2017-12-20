package com.addd.measurements.modelAPI

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


class User(
        @SerializedName("id")
        @Expose
        val id: Int? = null,
        @SerializedName("username")
        @Expose
        val username: String? = null,
        @SerializedName("first_name")
        @Expose
        val firstName: String? = null,
        @SerializedName("last_name")
        @Expose
        val lastName: String? = null,
        @SerializedName("email")
        @Expose
        val email: String? = null,
        @SerializedName("type")
        @Expose
        val type: Int? = null,
        @SerializedName("phone")
        @Expose
        val phone: String? = null,
        @SerializedName("telegram")
        @Expose
        val telegram: String? = null

)
