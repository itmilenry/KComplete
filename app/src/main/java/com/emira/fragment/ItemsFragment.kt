package com.emira.fragment

import android.app.Activity
import android.app.AlertDialog
import android.content.Intent
import android.os.Bundle
import android.support.design.widget.FloatingActionButton
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.emira.kcomplete.FuelRegistrationActivity
import com.emira.kcomplete.R
import com.emira.kcomplete.RegistrationActivity
import com.emira.model.MODE
import java.text.SimpleDateFormat
import java.util.*


class ItemsFragment: BaseFragment() {

    private val FUELREGISTRATION_REQUEST = 1


    override val logTag = "KComplete - Items fragment"

    override fun getLayout(): Int {
        return R.layout.fragment_items
    }

    override fun onCreateView(inflater: LayoutInflater,
                              container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(getLayout(), container, false)

        val btn = view?.findViewById<FloatingActionButton>(R.id.new_item)

        btn?.setOnClickListener{

            val items = arrayOf( getString(R.string.fuel_registration_activity_title))
            val builder = AlertDialog.Builder(this@ItemsFragment.context)
                    .setTitle(R.string.choose_a_type)
                    .setItems(items) { _, which ->
                        when (which) {
                            0 -> {
                                openCreateFuelRegistration()
                            }
                            else -> Log.e(logTag, "Unknown option selected [ $which ]")
                        }
                    }
            builder.show()
        }
        return view

    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        when (requestCode)
        {
            FUELREGISTRATION_REQUEST -> {
                if (resultCode == Activity.RESULT_OK)
                {
                    Log.i(logTag, "Fuel Registration created!!!")
                }
                else
                {
                    Log.w(logTag, "Impossible to create Fuel Registration!!!")
                }
            }
        }
    }



    private fun openCreateFuelRegistration()
    {
        val date = Date(System.currentTimeMillis())
        val dateFormat = SimpleDateFormat("dd MMM yyyy", Locale.ITALIAN)
        val timeFormat = SimpleDateFormat("HH:mm", Locale.ITALIAN)

        val intent = Intent(context, FuelRegistrationActivity::class.java)
        val data = Bundle()
        data.putInt(MODE.EXTRAS_KEY, MODE.CREATE.mode)
        data.putString(FuelRegistrationActivity.EXTRA_DATE, dateFormat.format(date) )
        data.putString(FuelRegistrationActivity.EXTRA_TIME, timeFormat.format(date) )
        intent.putExtras(data)

        startActivityForResult(intent, FUELREGISTRATION_REQUEST)
    }


}