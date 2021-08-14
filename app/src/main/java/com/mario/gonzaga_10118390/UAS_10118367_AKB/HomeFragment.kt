package com.mario.gonzaga_10118390.UAS_10118367_AKB

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import androidx.fragment.app.Fragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import com.jovanovic.stefan.UAS_10118367_AKB.R

// 11-08-2021 - Mario Gonzaga Muharjani - 10118390

class HomeFragment : Fragment() {

    private lateinit var fragment : Fragment
    private lateinit var frameLayout: FrameLayout
    private lateinit var bottomNavigationView: BottomNavigationView


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_home, container, false)
        bottomNavigationView = view.findViewById<BottomNavigationView>(R.id.bottom_navigation)
        frameLayout = view.findViewById<FrameLayout>(R.id.frameLayout)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        bottomNavigationView.selectedItemId =
            R.id.home

        //Perform ItemSelectedListener
        fragment = MapsFragment()
        requireActivity().supportFragmentManager.beginTransaction().replace(R.id.frameLayout, fragment)
            .commit()

        //Perform ItemSelectedListener
        bottomNavigationView.setOnNavigationItemSelectedListener { menuItem ->
            when (menuItem.itemId) {
                R.id.profile -> fragment =
                    ProfileFragment()
                R.id.home -> fragment =
                    MapsFragment()
            }
            requireActivity().supportFragmentManager.beginTransaction().replace(R.id.frameLayout, fragment)
                .commit()
            true
        }

    }

}