package com.timothy.simplelocationapp

import android.content.pm.PackageManager
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.timothy.simplelocationapp.di.component.DaggerLocationComponent
import com.timothy.simplelocationapp.di.module.LocationModule
import com.timothy.simplelocationapp.extension.LOCATION_REQUEST_CODE
import com.timothy.simplelocationapp.extension.isLocationPermissionsGranted
import com.timothy.simplelocationapp.extension.requestLocationPermissions
import com.timothy.simplelocationapp.location.LocationContract
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var locationPresenter: LocationContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initInjector()
        checkLocationPermissions()
    }

    private fun initInjector() {
        DaggerLocationComponent.builder()
            .applicationComponent((application as SimpleLocationApp).applicationComponent)
            .locationModule(LocationModule(object : LocationContract.View {
                override fun onLocationUpdateSuccess(latLong: String) {
                    tv_geoposition?.text = getString(R.string.location_result_text, latLong)
                }

                override fun onLocationUpdateError(message: String) {
                    tv_geoposition?.text = getString(R.string.location_error_text, message)
                }
            }))
            .build()
            .inject(this)
    }

    private fun checkLocationPermissions() = if (isLocationPermissionsGranted()) {
        locationPresenter.getLocationUpdates()
    } else {
        requestLocationPermissions()
    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        when (requestCode) {
            LOCATION_REQUEST_CODE -> grantResults.all { it == PackageManager.PERMISSION_GRANTED }
                .takeIf { true }
                ?.run { locationPresenter.getLocationUpdates() }
        }
    }
}