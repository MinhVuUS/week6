//package com.example.week2.bottomNavigation
//
//import android.os.Bundle
//import android.view.Menu
//import android.view.MenuInflater
//import android.view.MenuItem
//import androidx.appcompat.app.AppCompatActivity
//import androidx.fragment.app.Fragment
//import com.example.week2.R
//import com.example.week2.databinding.BottomActivityBinding
//import com.example.week2.forMovieFragment.NowPlayingFragment
//import com.example.week2.forMovieFragment.TopRatedFragment
//
//class BottomActivity: AppCompatActivity() {
//    private lateinit var binding: BottomActivityBinding
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        binding = BottomActivityBinding.inflate(layoutInflater)
//        setContentView(binding.root)
//
//        replaceFragment(NowPlayingFragment())
//        binding.bottomNavigationView.setOnItemSelectedListener {
//            when (it.itemId) {
//                R.id.nplaying -> replaceFragment(NowPlayingFragment())
//                R.id.trated -> replaceFragment(TopRatedFragment())
//                else -> {
//                }
//            }
//            true
//        }
//    }
//            fun replaceFragment(fragment: Fragment) {
//                val fragmentManager = supportFragmentManager
//                val fragmentTransaction = fragmentManager.beginTransaction()
//                fragmentTransaction.replace(R.id.frame_layout, fragment)
//                fragmentTransaction.addToBackStack(null)
//                fragmentTransaction.commit()
//            }
//
////    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
////        val inflater: MenuInflater = menuInflater
////        inflater.inflate(R.menu.menu,menu)
////        return true
////    }
////
////    override fun onOptionsItemSelected(item: MenuItem): Boolean {
////        return super.onOptionsItemSelected(item)
////    }
//
//        }
