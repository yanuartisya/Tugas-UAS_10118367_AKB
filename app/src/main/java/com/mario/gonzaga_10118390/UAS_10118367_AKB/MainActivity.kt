// 12-08-2021 - 10118390 - Mario Gonzaga Muharjani - IF9


package com.mario.gonzaga_10118390.UAS_10118367_AKB

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.jovanovic.stefan.UAS_10118367_AKB.R


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar?.hide()
    }
}