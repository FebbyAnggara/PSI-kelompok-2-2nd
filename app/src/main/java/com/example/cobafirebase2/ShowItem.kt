package com.example.cobafirebase2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_show_item.*
import kotlinx.android.synthetic.main.activity_tambah_masakan.*

class ShowItem : AppCompatActivity() {
    private lateinit var t_Nama: TextView



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_show_item)

//        t_Nama = findViewById(R.id.tv_Nama)


//        t_Nama.text = intent.getStringExtra("nama")



    }
}