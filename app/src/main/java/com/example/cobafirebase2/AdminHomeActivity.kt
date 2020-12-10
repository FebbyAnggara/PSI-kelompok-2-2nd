package com.example.cobafirebase2

import android.content.Intent
import android.os.Bundle
import android.widget.AdapterView.OnItemClickListener
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import com.google.firebase.database.*
import kotlinx.android.synthetic.main.activity_admin_home.*
import kotlinx.android.synthetic.main.activity_show_item.*
import kotlinx.android.synthetic.main.item_msk.*


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
            startActivity(Intent(this, TambahMasakanActivity::class.java))
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
        // ListView on item selected listener.
        // ListView on item selected listener.
        listMsk.setOnItemClickListener(OnItemClickListener { parent, view, position, id -> // TODO Auto-generated method stub

            // Getting listview click value into String variable.
            val nama: String = tv_nama.text.toString()
            val bahan: String = tv_bahan.text.toString()
            val resep: String = tv_resep.text.toString()
            val intent = Intent(this@AdminHomeActivity, ShowItem::class.java)

            // Sending value to another activity using intent.
            intent.putExtra("nama", nama)
            intent.putExtra("bahan", bahan)
            intent.putExtra("resep", resep)

            startActivity(intent)
        })

    }
}