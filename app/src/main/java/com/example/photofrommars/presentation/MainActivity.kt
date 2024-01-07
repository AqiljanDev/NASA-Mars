package com.example.photofrommars.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.photofrommars.R
import com.example.photofrommars.presentation.listPhotoMars.ListPhotoMarsFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, ListPhotoMarsFragment())
                .commit()
        }
    }
}