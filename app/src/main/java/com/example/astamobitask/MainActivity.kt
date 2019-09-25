package com.example.astamobitask

import android.R.menu
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.viewpager.widget.ViewPager
import com.example.astamobitask.ui.FragmentBuilders
import com.example.astamobitask.ui.FragmentLoaders
import com.example.astamobitask.ui.carrierFragment.FragmentCarriers
import com.google.android.material.tabs.TabLayout
import kotlinx.android.synthetic.main.activity_main.*


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
        toolbar.title = "Головна"
        setSupportActionBar(findViewById(R.id.toolbar))
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.items,menu)

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        when (item?.itemId) {
            R.id.action_filter -> {
                Toast.makeText(this, "Filter", Toast.LENGTH_SHORT).show()
            }
            R.id.action_swap -> {
                Toast.makeText(this, "Swap", Toast.LENGTH_SHORT).show()
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
