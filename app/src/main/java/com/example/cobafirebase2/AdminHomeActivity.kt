package com.example.cobafirebase2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_admin_home.*

class AdminHomeActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin_home)

        float_btn_add.setOnClickListener{
            startActivity(Intent(this,TambahMasakanActivity::class.java))
        }
    }
}