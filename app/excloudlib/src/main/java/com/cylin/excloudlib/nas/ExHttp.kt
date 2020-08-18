package com.cylin.excloudlib.nas

import com.github.kittinunf.fuel.Fuel
import com.google.gson.Gson
import java.io.File


object ExHttp {

    // NAS
    var host = ""

    enum class API(path: String) {

        UploadVideo("/upload_video.php"),
        UploadImage("/upload_image.php"),
        ServerTime("/now.php"),
        ;

        val nasUrl = host + path
    }
}

/**
 * 上傳圖片到NAS
 */
fun uploadImage(file: File): ExResponse? {

    val (request, response, result) = Fuel.upload(ExHttp.API.UploadImage.nasUrl).source { _, _ ->
        file
    }.name { "file" }.responseString()

    var obj: ExResponse? = null
    result.component1()?.let {
        obj = Gson().fromJson(it, ExResponse::class.java)
    }
    return obj
}

/**
 * 上傳影片到NAS
 */
fun uploadVideo(file: File): ExResponse? {

    val (_, _, result) = Fuel.upload(ExHttp.API.UploadVideo.nasUrl).source { _, _ ->
        file
    }.name { "file" }.responseString()

    var obj: ExResponse? = null
    result.component1()?.let {
        obj = Gson().fromJson(it, ExResponse::class.java)
    }
    return obj
}

/**
 * 取得NAS上的時間
 */
fun getServerTime(callback: (ExServerTimeResponse?) -> Unit) {

    Fuel.get(ExHttp.API.ServerTime.nasUrl)
        .responseObject(ExServerTimeResponse.Deserializer()) { _, _, result ->
            val (response, err) = result
            callback(response)
        }
}
