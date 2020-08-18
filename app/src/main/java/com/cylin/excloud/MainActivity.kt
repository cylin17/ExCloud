package com.cylin.excloud

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.cylin.excloudlib.nas.ExCloud

class MainActivity : AppCompatActivity() {

    private val TAG = MainActivity::class.java.simpleName

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        ExCloud.host = "BuildConfig.NAS_HOST"
        android.util.Log.d(TAG, ">> onCreate: ${ExCloud.host}")
    }
}