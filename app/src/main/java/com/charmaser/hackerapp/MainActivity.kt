package com.charmaser.hackerapp

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.activity.ComponentActivity
import com.charmaser.receiver.R


class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        Log.d("HackerApp", "onCreate")

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // init the textView to dipslay data
        val txtDisplay = findViewById<View>(R.id.txtDisplay) as TextView
        var DataBundel = ""

        // get app the data sent on bundle
        val bundle = intent.extras

        //lopp through all keys in the bundle
        if (bundle != null) {
            Log.d("HackerApp", "non-empty bundle")
            for (key in bundle.keySet()) {
                // get object by key( we define object became it may be text or image or whatever
                val value = bundle[key]
                //get all keys
                DataBundel += String.format("%s %s (%s)", key, value.toString(), value!!.javaClass.name)
            }
            txtDisplay.text = DataBundel
        } else {
            Log.d("HackerApp", "Empty bundle")
        }
    }
}
