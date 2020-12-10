package com.example.cobafirebase2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_admin_home.*

class AdminHomeActivity : AppCompatActivity() {
    private lateinit var mskList : MutableList<Masakan>
    private lateinit var listMsk : ListView
    private lateinit var ref : DatabaseReference

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_admin_home)

        ref = FirebaseDatabase.getInstance().getReference("masakan")

        listMsk = findViewById(R.id.lv_msk)

        float_btn_add.setOnClickListener{
            startActivity(Intent(this,TambahMasakanActivity::class.java))
        }
        mskList = mutableListOf()

        ref.addValueEventListener(object : ValueEventListener {
            override fun onDataChange(p0: DataSnapshot) {
                if (p0.exists()) {
                    mskList.clear()
                    for (h in p0.children) {
                        val masakan = h.getValue(Masakan::class.java)
                        if (masakan != null) {
                            mskList.add(masakan)
                        }
                    }

                    val adapter = MasakanAdapter(applicationContext, R.layout.item_msk, mskList)
                    listMsk.adapter = adapter
                }
            }

            override fun onCancelled(error: DatabaseError) {
                TODO("Not yet implemented")
            }

        })

    }
}