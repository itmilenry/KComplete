package com.emira.kcomplete

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentStatePagerAdapter
import android.support.v4.view.GravityCompat
import android.util.Log
import android.view.MenuItem
import com.emira.fragment.ItemsFragment
import com.emira.navigation.NavigationDrawerAdapter
import com.emira.navigation.NavigationDrawerItem
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : BaseActivity() {

    override val tag = "KComplete - Main Activity"
    override fun getLayout() = R.layout.activity_main
    override fun getActivityTitle() =   R.string.app_name



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


        pager.adapter = ViewPagerAdapter(supportFragmentManager)

        val menuItems = mutableListOf<NavigationDrawerItem>()

        val today = NavigationDrawerItem( getString(R.string.today), Runnable{pager.setCurrentItem(0, true)})
        val last30Days = NavigationDrawerItem( getString(R.string.last30Days), Runnable{pager.setCurrentItem(1, true)})
        val last90Days = NavigationDrawerItem( getString(R.string.last90Days), Runnable{pager.setCurrentItem(2, true)})
        val yourCars = NavigationDrawerItem( getString(R.string.manageCars), Runnable{pager.setCurrentItem(2, true)})

        menuItems.add(today)
        menuItems.add(last30Days)
        menuItems.add(last90Days)
        menuItems.add(yourCars)

        val navigationDrawerAdapter = NavigationDrawerAdapter(this, menuItems)
        left_drawer.adapter = navigationDrawerAdapter




    }


    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId)
        {
            R.id.drawing_menu ->
            {
                    drawer_layout.openDrawer(GravityCompat.START)
                    return true
            }
            R.id.options_menu ->
            {
                    Log.v(tag, "Options Menu")
                    return true
            }
            else -> return super.onOptionsItemSelected(item)
        }

    }


    private class ViewPagerAdapter(manager: FragmentManager) : FragmentStatePagerAdapter(manager)
    {
        override fun getItem(position: Int): Fragment {
            return ItemsFragment()
        }

        override fun getCount(): Int {
            return 3
        }


    }


}
