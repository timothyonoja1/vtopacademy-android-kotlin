package com.vtopacademy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.vtopacademy.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

/** Main Activity for app. */
@AndroidEntryPoint
class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

}