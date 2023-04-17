package com.example.permissionexercise
import android.content.ActivityNotFoundException
import android.content.Intent
import android.graphics.Bitmap
import android.os.Bundle
import android.provider.MediaStore
import androidx.appcompat.app.AppCompatActivity
import com.example.permissionexercise.databinding.ActivityCameraIntegrationBinding

class CameraIntegration : AppCompatActivity() {
    private lateinit var binding : ActivityCameraIntegrationBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCameraIntegrationBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btnChoosePhoto.setOnClickListener {
            intentGallery()
        }
        binding.btnTakePhoto.setOnClickListener {
            intentCamera()
        }
    }

    private fun intentCamera() {
        val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        try {
            startActivityForResult(cameraIntent, 1)
        } catch (exception: ActivityNotFoundException) {
            // some error to be shown here
        }
    }

    private fun intentGallery() {
        val galleryIntent = Intent(
            Intent.ACTION_GET_CONTENT, MediaStore.Images.Media.EXTERNAL_CONTENT_URI
        )
        startActivityForResult(galleryIntent, 2)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1 && resultCode == RESULT_OK) {
            val bitmap = data?.extras?.get("data") as Bitmap
            binding.viewImage.setImageBitmap(bitmap)
        } else if (requestCode == 2 && resultCode == RESULT_OK) {
            binding.viewImage.setImageURI(data?.data)
        } else {
            // some error to be shown here
        }
    }
}
