package com.jakaa.bottomnavigation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView

class MainActivity : AppCompatActivity() {

    //Step 1: Declare and Initialize Bottom Navigation view
    private lateinit var bottomNavigationView: BottomNavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNavigationView = findViewById(R.id.bottom_navigation)

        bottomNavigationView.setOnItemSelectedListener { menuItem ->
            when(menuItem.itemId){
                R.id.bottom_home -> replaceFragment(HomeFragment())
                R.id.bottom_search -> replaceFragment(SearchFragment())
                R.id.bottom_add -> Toast.makeText(this, "Upload Image & Video ", Toast.LENGTH_SHORT).show()
                R.id.bottom_reels-> replaceFragment(ReelsFragment())
                R.id.bottom_profile->replaceFragment(ProfileFragment())
            }
            true
        }
        replaceFragment(HomeFragment())

    }
    //Step 2: Create ReplaceFragment method
    private fun replaceFragment(fragment: Fragment){
        supportFragmentManager.beginTransaction().replace(R.id.frame_container, fragment).commit()
    }
}