package com.example.sofascore_homework_2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sofascore_homework_2.databinding.ActivityMainBinding
import com.google.android.material.tabs.TabLayoutMediator


private lateinit var binding: ActivityMainBinding

val tabsArray = arrayOf(
    "Tab1",
    "Tab2"
)


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val viewPager = binding.viewPager
        val tabLayout = binding.tabs

        val adapter = ViewPagerAdapter(supportFragmentManager, lifecycle)
        viewPager.adapter = adapter

        TabLayoutMediator(tabLayout, viewPager) { tab, position ->
            tab.text = tabsArray[position]
        }.attach()
    }
}