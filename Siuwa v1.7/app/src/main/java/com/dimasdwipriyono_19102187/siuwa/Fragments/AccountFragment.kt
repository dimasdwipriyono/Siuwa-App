package com.dimasdwipriyono_19102187.siuwa.Fragments

import android.content.Intent
import android.net.Uri
import android.net.UrlQuerySanitizer
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.dimasdwipriyono_19102187.siuwa.LoginActivity
import com.dimasdwipriyono_19102187.siuwa.R
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.fragment_account.*
import kotlinx.android.synthetic.main.fragment_home.*

class AccountFragment : Fragment() {

//    private var _binding: FragmentUserBinding? = null
//    lateinit var auth: FirebaseAuth
    private lateinit var auth : FirebaseAuth

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_account, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        auth = FirebaseAuth.getInstance()
        val user = auth.currentUser
        if (user != null){
            etName.setText(user.displayName)
            etEmail.setText(user.email)
            if (user.isEmailVerified){
                icVerified.visibility = View.VISIBLE
            } else {
                icUnverified.visibility = View.VISIBLE
            }
        }
        icUnverified.setOnClickListener{
            user?.sendEmailVerification()?.addOnCompleteListener{
                if (it.isSuccessful){
                    Toast.makeText(activity, "Email verifikasi telah dikirim", Toast.LENGTH_SHORT).show()
                } else {
                    Toast.makeText(activity, "${it.exception?.message}", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}

