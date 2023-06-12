package com.example.distancetrackerapp.util

import android.Manifest
import android.content.Context
import android.os.Build
import androidx.annotation.RequiresApi
import androidx.fragment.app.Fragment
import com.example.distancetrackerapp.util.Constants.PERMISSION_BACKGROUND_LOCATION_REQUEST_CODE
import com.example.distancetrackerapp.util.Constants.PERMISSION_LOCATION_REQUEST_CODE
import com.example.distancetrackerapp.util.Constants.PERMISSION_POST_NOTIFICATIONS_REQUEST_CODE
import com.vmadalin.easypermissions.EasyPermissions

object Permissions {

    fun hasLocationPermission(context: Context) =
        EasyPermissions.hasPermissions(
                context,
                Manifest.permission.ACCESS_FINE_LOCATION
        )

    fun requestLocationPermission(fragment: Fragment){
        EasyPermissions.requestPermissions(
                fragment,
                "This application cannot work without Location Permission",
                PERMISSION_LOCATION_REQUEST_CODE,
                Manifest.permission.ACCESS_FINE_LOCATION
        )
    }

    fun hasBackgroundLocationPermission(context: Context): Boolean {
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q){
            return EasyPermissions.hasPermissions(
                    context,
                    Manifest.permission.ACCESS_BACKGROUND_LOCATION
            )
        }
        return true
    }

    fun requestBackgroundLocationPermission(fragment: Fragment){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q){
            EasyPermissions.requestPermissions(
                    fragment,
                    "Background location permission is essential to this application. Without it we will not be able to provide you with our service.",
                    PERMISSION_BACKGROUND_LOCATION_REQUEST_CODE,
                    Manifest.permission.ACCESS_BACKGROUND_LOCATION
            )
        }
    }

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    fun hasPostNotificationsPermission(context: Context) =
        EasyPermissions.hasPermissions(
            context,
            Manifest.permission.POST_NOTIFICATIONS
        )

    @RequiresApi(Build.VERSION_CODES.TIRAMISU)
    fun requestPostNotificationsPermission(fragment: Fragment){
        EasyPermissions.requestPermissions(
            fragment,
            "This app cannot display notifications without this.",
            PERMISSION_POST_NOTIFICATIONS_REQUEST_CODE,
            Manifest.permission.POST_NOTIFICATIONS
        )
    }

}








