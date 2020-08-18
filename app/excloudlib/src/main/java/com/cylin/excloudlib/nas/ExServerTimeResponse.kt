package com.cylin.excloudlib.nas

import com.github.kittinunf.fuel.core.ResponseDeserializable
import com.google.gson.Gson


data class ExServerTimeResponse(
        val server_time: String
) {

    class Deserializer : ResponseDeserializable<ExServerTimeResponse> {
        override fun deserialize(content: String) = Gson().fromJson(content, ExServerTimeResponse::class.java)!!
    }
}