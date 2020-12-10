package com.example.cobafirebase2

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        auth = FirebaseAuth.getInstance()

        btn_signup.setOnClickListener {
            SignUpUser()
        }

        btn_login.setOnClickListener {
            doLogin()
        }
    }

    public override fun onStart() {
        super.onStart()
        //biar ga kesave aja usernya
        // Check if user is signed in (non-null) and update UI accordingly.
        //val currentUser = auth.currentUser
        //updateUI(currentUser)
    }

    fun updateUI(currentuser: FirebaseUser?) {

        if (currentuser != null) {
            if (currentuser.uid.equals("8CYCbHEXEqaJF3Q3xunTu9cWabg2")) {
                startActivity(Intent(this, AdminHomeActivity::class.java))
                finish()
            } else {
                startActivity(Intent(this, UserHomeActivity::class.java))
                finish()
            }
        } else {
            Toast.makeText(
                baseContext, "Login Failed, salah email/password atau belum daftar.",
                Toast.LENGTH_SHORT
            ).show()
        }
    }

    fun SignUpUser() {
        val email = et_email.text.toString()
        val pass = et_pass.text.toString()


        if (email.isEmpty()) {
            et_email.error = "Please enter email"
            et_email.requestFocus()
            return
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            et_email.error = "Please enter valid mail"
            et_email.requestFocus()
            return
        }

        if (pass.isEmpty()) {
            et_pass.error = "Please enter email"
            et_pass.requestFocus()
            return
        }

        auth.createUserWithEmailAndPassword(email, pass)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    Toast.makeText(
                        baseContext, "Sign in Succes, silahkan login.",
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    Toast.makeText(
                        baseContext, "Sign in failed.",
                        Toast.LENGTH_SHORT
                    ).show()
                }

                // ...
            }
    }

    private fun doLogin() {
        val email = et_email.text.toString()
        val pass = et_pass.text.toString()


        if (email.isEmpty()) {
            et_email.error = "Please enter email"
            et_email.requestFocus()
            return
        }

        if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            et_email.error = "Please enter valid mail"
            et_email.requestFocus()
            return
        }

        if (pass.isEmpty()) {
            et_email.error = "Please enter email"
            et_email.requestFocus()
            return
        }

        auth.signInWithEmailAndPassword(email, pass)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    val user = auth.currentUser
                    updateUI(user)
                } else {

                    updateUI(null)
                    // ...
                }

                // ...
            }
    }


}