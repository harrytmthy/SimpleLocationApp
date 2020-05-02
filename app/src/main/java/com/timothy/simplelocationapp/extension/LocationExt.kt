package com.timothy.simplelocationapp.extension

import android.Manifest
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import androidx.core.app.ActivityCompat

/**
 * @author Harry Timothy (harry.timothy@dana.id)
 * @version LocationExt, v 0.1 02/05/20 15.49 by Harry Timothy
 */
const val LOCATION_REQUEST_CODE = 101

private val locationPermissions = arrayOf(
    Manifest.permission.ACCESS_COARSE_LOCATION,
    Manifest.permission.ACCESS_FINE_LOCATION
)

fun AppCompatActivity.isLocationPermissionsGranted() = locationPermissions.all {
    ActivityCompat.checkSelfPermission(this, it) == PackageManager.PERMISSION_GRANTED
}

fun AppCompatActivity.requestLocationPermissions()
    = ActivityCompat.requestPermissions(this, locationPermissions, LOCATION_REQUEST_CODE)