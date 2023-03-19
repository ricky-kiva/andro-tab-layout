package com.rickyslash.tablayoutapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.annotation.StringRes
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {

    // this for companion object is for 'tab title'
    companion object {
        // '@StringRes' will get the 'resource' from 'string.xml'
        @StringRes
        private val TAB_TITLES = intArrayOf(
            R.string.tab_text_1,
            R.string.tab_text_2,
            R.string.tab_text_3
        )
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // this will instantiate the Adapter, and the 'rest is finding the View'
        // this also 'passing adapter' to 'viewPager'
        val sectionsPagerAdapter = SectionsPagerAdapter(this)

        // this for IF want 'send data' from 'Activity to Fragment'
        // this will set the variable on the Adapter
        sectionsPagerAdapter.appName = resources.getString(R.string.app_name) // will pass 'app_name'

        // this will 'finds the View' and 'passing adapter' to 'viewPager'
        val viewPager: ViewPager2 = findViewById(R.id.view_pager)
        viewPager.adapter = sectionsPagerAdapter
        val tabs: TabLayout = findViewById(R.id.tabs)

        // this will 'link' the 'LayoutTab' & the 'ViewPager'
        TabLayoutMediator(tabs, viewPager) { tab, position ->
            // this will 'set title for the tab'
            tab.text = resources.getString(TAB_TITLES[position])
        }.attach()

        // this set 'elevation' (such 3D shadow)
        supportActionBar?.elevation = 0f

    }
}