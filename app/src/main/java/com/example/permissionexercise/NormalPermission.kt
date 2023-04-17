package com.example.permissionexercise

import android.content.Context
import android.net.wifi.WifiManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.bumptech.glide.Glide
import com.example.permissionexercise.databinding.ActivityNormalPermissionBinding

class NormalPermission : AppCompatActivity() {
    private lateinit var binding : ActivityNormalPermissionBinding
    private lateinit var wifiManager : WifiManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNormalPermissionBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnShowImg.setOnClickListener {
            Glide.with(this).load("https://i.ibb.co/zJHYGBP/binarlogo.jpg")
                .circleCrop()
                .into(binding.imgView)
        }
        wifiManager = applicationContext.getSystemService(Context.WIFI_SERVICE) as WifiManager


        binding.btn1.setOnClickListener {
            enableWifi()
        }
        binding.btn2.setOnClickListener {
            disableWifi()
        }
    }

    private fun enableWifi() {
        wifiManager.isWifiEnabled = true
        Toast.makeText(this, "Wifi enabled", Toast.LENGTH_SHORT).show()
    }
    private fun disableWifi() {
        wifiManager.isWifiEnabled = false
        Toast.makeText(this, "Wifi disabled", Toast.LENGTH_SHORT).show()
    }
    }