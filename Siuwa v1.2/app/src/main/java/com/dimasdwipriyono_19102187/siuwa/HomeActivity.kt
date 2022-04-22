package com.dimasdwipriyono_19102187.siuwa

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.dimasdwipriyono_19102187.siuwa.Fragments.AccountFragment
import com.dimasdwipriyono_19102187.siuwa.Fragments.HomeFragment
import com.dimasdwipriyono_19102187.siuwa.Fragments.SettingsFragment
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_home.*

class HomeActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private val homeFragment = HomeFragment()
    private val settingsFragment = SettingsFragment()
    private val accountFragment = AccountFragment()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)

        auth = FirebaseAuth.getInstance()

        btnLogout.setOnClickListener {
            auth.signOut()
            Intent(this@HomeActivity, LoginActivity::class.java).also {
                it.flags = Intent.FLAG_ACTIVITY_NEW_TASK or Intent.FLAG_ACTIVITY_CLEAR_TASK
                startActivity(it)
            }
        }

        replaceFragment(homeFragment)

        bottom_navigation.setOnNavigationItemSelectedListener {
            when (it.itemId){
                R.id.ic_home -> replaceFragment(homeFragment)
                R.id.ic_settings -> replaceFragment(settingsFragment)
                R.id.ic_akun -> replaceFragment(accountFragment)
            }
            true
        }

    }

    private fun replaceFragment(fragment: Fragment){
        if (fragment != null){
            val transaction = supportFragmentManager.beginTransaction()
            transaction.replace(R.id.fragment_container, fragment)
            transaction.commit()
        }
    }
}