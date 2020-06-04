package com.example.launchmap

import android.content.Intent
import android.content.pm.ResolveInfo
import android.net.Uri
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun openTheMap(v: View?) {
        val latitude = latEditText.text.toString().toDouble()
        val longitude = lngEditText.text.toString().toDouble()
        val location = Uri.parse("geo: $latitude,$longitude")

        val mapIntent = Intent(Intent.ACTION_VIEW, location)
        val activities: List<ResolveInfo> = packageManager.queryIntentActivities(mapIntent, 0)
        val isIntentSafe: Boolean = activities.isNotEmpty()
        if (isIntentSafe) {
            Toast.makeText(this, "Searching location", Toast.LENGTH_SHORT).show();

            startActivity(mapIntent)
        } else {
            Toast.makeText(this, "There is no activity to handle map intent!", Toast.LENGTH_SHORT).show();
        }
    }
}
