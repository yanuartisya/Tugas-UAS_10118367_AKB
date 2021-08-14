package com.mario.gonzaga_10118390.UAS_10118367_AKB.onboarding

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.jovanovic.stefan.UAS_10118367_AKB.R
import com.mario.gonzaga_10118390.UAS_10118367_AKB.onboarding.screens.FirstScreen
import com.mario.gonzaga_10118390.UAS_10118367_AKB.onboarding.screens.SecondScreen
import com.mario.gonzaga_10118390.UAS_10118367_AKB.onboarding.screens.ThirdScreen
import kotlinx.android.synthetic.main.fragment_view_pager.view.*


// 11-08-2021 - Mario Gonzaga Muharjani - 10118390


class ViewPagerFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_view_pager, container, false)

        val fragmentList = arrayListOf<Fragment>(
            FirstScreen(),
            SecondScreen(),
            ThirdScreen()
        )

        val adapter =
            ViewPagerAdapter(
                fragmentList,
                requireActivity().supportFragmentManager,
                lifecycle
            )

        view.viewPager.adapter = adapter

        return view
    }

}