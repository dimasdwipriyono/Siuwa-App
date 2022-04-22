package com.dimasdwipriyono_19102187.siuwa.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.dimasdwipriyono_19102187.siuwa.R
import kotlinx.android.synthetic.main.fragment_home.*

class AccountFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_account, container, false)
    }

//    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
//        super.onViewCreated(view, savedInstanceState)
//
//        home.setOnClickListener{
//            Toast.makeText(context, "Ini Halaman Akun", Toast.LENGTH_SHORT).show()
//        }
//    }
}