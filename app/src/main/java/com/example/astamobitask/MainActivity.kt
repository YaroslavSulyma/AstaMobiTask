package com.example.astamobitask

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.example.astamobitask.ui.FragmentBuilders
import com.example.astamobitask.ui.carrierFragment.FragmentCarriers
import com.example.astamobitask.ui.FragmentLoaders
import com.google.android.material.tabs.TabLayout


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewPager = findViewById<ViewPager>(R.id.view_pager)
        val tabs = findViewById<TabLayout>(R.id.tab_layout)

        val pagerAdapter = ViewPagerAdapter(supportFragmentManager)
        pagerAdapter.addFragment(FragmentLoaders(), "Вантажники")
        pagerAdapter.addFragment(FragmentCarriers(), "Перевізники")
        pagerAdapter.addFragment(FragmentBuilders(), "Будівельники")
        viewPager.adapter = pagerAdapter
        tabs.setupWithViewPager(viewPager)
    }
}
