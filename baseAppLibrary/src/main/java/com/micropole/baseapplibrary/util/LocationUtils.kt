package com.micropole.baseapplibrary.util

import android.annotation.SuppressLint
import android.content.Context
import android.location.Criteria
import android.location.Location
import android.location.LocationManager
import android.widget.Toast
import com.blankj.utilcode.util.PermissionUtils
import android.os.Bundle
import android.location.LocationListener
import android.util.Log
import com.blankj.utilcode.util.ActivityUtils
import com.weibiaogan.bangbang.common.getAddress


/**
 * Created by DarkHorse on 2018/5/7.
 */
object LocationUtils {
    var TAG: String = javaClass.name
    lateinit var mLocationManager: LocationManager
    lateinit var mProvider: String
    var mLocation: Location? = null
    private val mCriteria: Criteria = Criteria()

    @SuppressLint("MissingPermission")
    fun locate(context: Context) {
        mLocationManager = context.getSystemService(Context.LOCATION_SERVICE) as LocationManager
        initCriteria()
        mProvider = mLocationManager.getBestProvider(mCriteria, true)
        mLocation = mLocationManager.getLastKnownLocation(mProvider)
        mLocationManager.requestLocationUpdates(mProvider, 1000, 10f, mLocationListener)
    }

    private var mLocationListener: LocationListener = object : LocationListener {

        override fun onStatusChanged(provider: String, status: Int, arg2: Bundle) {

        }

        override fun onProviderEnabled(provider: String) {
            Log.d(TAG, "onProviderEnabled: " + provider + ".." + Thread.currentThread().name)
        }

        override fun onProviderDisabled(provider: String) {
            Log.d(TAG, "onProviderDisabled: " + provider + ".." + Thread.currentThread().name)
        }

        override fun onLocationChanged(location: Location) {
            Log.d(TAG, "onLocationChanged: " + ".." + Thread.currentThread().name)
            //如果位置发生变化,重新显示
            mLocation = location
        }
    }

    private fun initCriteria() {
        mCriteria.accuracy = Criteria.ACCURACY_COARSE
        mCriteria.isAltitudeRequired = false
        mCriteria.isBearingRequired = false
        mCriteria.isCostAllowed = true
        mCriteria.powerRequirement = Criteria.POWER_LOW
    }

    fun getLongitude(): Double {
        return mLocation?.longitude ?: 0.0
    }

    fun getLatitude(): Double {
        return mLocation?.latitude ?: 0.0
    }

}
