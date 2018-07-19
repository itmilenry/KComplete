package com.emira.kcomplete

import android.os.Bundle
import android.util.Log
import com.emira.model.MODE
import kotlinx.android.synthetic.main.activity_fuel_registration.*


class FuelRegistrationActivity : RegistrationActivity() {

    companion object {
        val EXTRA_DATE = "EXTRA_DATE"
        val EXTRA_TIME = "EXTRA_TIME"
    }


    override val tag="KComplete - Fuel Registration Activity"
    override fun getLayout()=R.layout.activity_fuel_registration
    override fun getActivityTitle() =   R.string.fuel_registration_activity_title

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val data = intent.extras
        data?.let{
            val date = data.getString(EXTRA_DATE, "")
            val time = data.getString(EXTRA_TIME, "")
            pick_date.text = date
            pick_time.text = time
            Log.v(tag, "Extended date [ $date - $time ]")
        }

    }


}