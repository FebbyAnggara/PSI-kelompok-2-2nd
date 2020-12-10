package com.example.cobafirebase2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import com.google.firebase.database.DatabaseReference
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_next.setOnClickListener {
            Intent(this,AdminHomeActivity::class.java).also{
                startActivity(it)
            }
        }
    }
}