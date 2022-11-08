package com.terrinc.rundomnumbers.main.presentation

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.terrinc.rundomnumbers.R
import com.terrinc.rundomnumbers.numbers.presentation.NumbersFragment

class MainActivity : AppCompatActivity(), ShowFragment {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (savedInstanceState == null) {
            show(NumbersFragment.newInstance(), addToBackStack = false)
        }
    }

    override fun show(fragment: Fragment) {
        show(fragment, addToBackStack = true)
    }

    private fun show(fragment: Fragment, addToBackStack: Boolean) {
        val transaction = supportFragmentManager.beginTransaction()
        val container = R.id.container
        if (addToBackStack) {
            transaction.add(container, fragment)
                .addToBackStack(fragment.javaClass.name)
        }
        else {
            transaction.replace(container, fragment)
        }
        transaction.commit()
    }
}

interface ShowFragment {
    fun show(fragment: Fragment)

    class Empty: ShowFragment {
        override fun show(fragment: Fragment) = Unit
    }
}
