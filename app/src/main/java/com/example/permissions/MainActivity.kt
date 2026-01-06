package com.example.permissions

import android.os.Bundle
import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.media.Image
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.os.Build
import android.provider.MediaStore
import android.widget.ImageView
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.appcompat.app.AppCompatActivity
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import pub.devrel.easypermissions.AfterPermissionGranted
import pub.devrel.easypermissions.EasyPermissions

const  val RC_CAMERA = 1;
const  val RC_LOCATION = 2;
const val RC_MIC = 3

class MainActivity : AppCompatActivity(), EasyPermissions.PermissionCallbacks {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val img_camera = findViewById<ImageView>(R.id.camera)
        img_camera.setOnClickListener {
            openCamera()
        }

        val img_location = findViewById<ImageView>(R.id.location)
        img_location.setOnClickListener {
            openLocation()

        }

        val img_call = findViewById<ImageView>(R.id.phone)
        img_call.setOnClickListener {
            openMic()
        }

        val img_mic = findViewById<ImageView>(R.id.audio)
        img_mic.setOnClickListener {
            openMic()
        }

    }

    // ----- Camera Permission ------ using EasyPermission
    @AfterPermissionGranted(RC_CAMERA)
    fun openCamera() {
        if (EasyPermissions.hasPermissions(this, Manifest.permission.CAMERA)) {
            Toast.makeText(this, "Ouverture de la camera...", Toast.LENGTH_SHORT).show()
        } else {
            EasyPermissions.requestPermissions(
                this,
                "l'Application a le besoin d'accés au Camera pour prendre une photo !",
                RC_CAMERA,
                Manifest.permission.CAMERA
            )
        }
    }

    // ----- LOCATION Permission ------ using EasyPermission
    @AfterPermissionGranted(RC_LOCATION)
    fun openLocation() {
        if (EasyPermissions.hasPermissions(this, Manifest.permission.ACCESS_FINE_LOCATION)) {
            Toast.makeText(this, "Ouverture de localisation...", Toast.LENGTH_SHORT).show()
        } else {
            EasyPermissions.requestPermissions(
                this,
                "l'Application a le besoin d'accés a localisation pour continuer !",
                RC_LOCATION,
                Manifest.permission.ACCESS_FINE_LOCATION
            )
        }
    }

    // ----- MICROPHONE Permission ------ using EasyPermission
    @AfterPermissionGranted(RC_MIC)
    fun openMic () {
        if (EasyPermissions.hasPermissions(this, Manifest.permission.RECORD_AUDIO)) {
            Toast.makeText(this, "Microphone Autorisé", Toast.LENGTH_SHORT).show()
        } else {
            EasyPermissions.requestPermissions(
                this,
                "l'Application a besoin d'accés au Microphone pour l'Appel",
                RC_MIC,
                Manifest.permission.RECORD_AUDIO
            )
        }
    }


    // Those are the three overrides functions those still same also when working with Multaple Permissions
    // fun 1
    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)
        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this)
    }

    // fun 2 - if Permission Granted (Accepted)
    override fun onPermissionsGranted(requestCode: Int, perms: MutableList<String>) {

    }

    // fun 3 - if Permission Denied (Refused)
    override fun onPermissionsDenied(requestCode: Int, perms: MutableList<String>) {

    }

}