package com.rickyslash.tablayoutapp

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter

// FragmentStateAdapter is a Jetpack Library 'class' that 'provide contents' for 'ViewPager'
// 'activity: AppCompatActivity' used to 'pass reference of the activity' 'to the adapter', so the 'Adapter could access' it's 'context' / 'resource'
// if Fragment is used, change constructor type to 'FragmentActivity'
class SectionsPagerAdapter(activity: AppCompatActivity): FragmentStateAdapter(activity) {

    // this IF you want to 'send data' from 'Activity to Fragment'
    var appName: String = ""

    /* this not used because we are going to make things more flexible

    // this will 'display assigned fragment' 'based on position'
    override fun createFragment(position: Int): Fragment {
        var fragment: Fragment? = null
        when (position) {
            0 -> fragment = HomeFragment()
            1 -> fragment = ProfileFragment()
        }
        return fragment as Fragment
    }*/

    // createFragment() will be 'executed 3 times', because 'getItemCount() return 3'
    // for each iteration, 'position' will be 'iterated'
    override fun createFragment(position: Int): Fragment {
        val fragment = HomeFragment()
        // this will bundle the 'position' to the 'arguments'
        fragment.arguments = Bundle().apply {
            putInt(HomeFragment.ARG_SECTION_NUMBER, position+1)

            // this for IF want 'send data' from 'Activity to Fragment'
            // this 'will send data to fragment'. 'AppName' 'obtained' from 'MainActivity'
            putString(HomeFragment.ARG_NAME, appName)
        }
        return fragment
    }

    // this will tell 'how much tab to be displayed'
    override fun getItemCount(): Int {
        return 3
    }


}