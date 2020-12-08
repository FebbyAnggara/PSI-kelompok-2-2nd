package com.example.cobafirebase2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.database.FirebaseDatabase
import kotlinx.android.synthetic.main.activity_tambah_masakan.*

class TambahMasakanActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_tambah_masakan)

        btn_add_resep.setOnClickListener {
            tambahresep()



        }
    }

    fun tambahresep () {
        val nama =et_add_nama.text.toString()
        val bahan=et_add_bahan.text.toString()
        val resep=et_add_Resep.text.toString()

        if (nama.isEmpty()){
            et_add_nama.error = "Isi nama masakan"
            et_add_nama.requestFocus()
            return
        }
        if (bahan.isEmpty()){
            et_add_bahan.error="Isi bahan masakan"
            et_add_bahan.requestFocus()
            return
        }
        if (resep.isEmpty()){
            et_add_Resep.error = "Isi resep masakan"
            et_add_Resep.requestFocus()
            return
        }

        val ref = FirebaseDatabase.getInstance().getReference("masakan")
        val masakanID = ref.push().key

        masakanID?.let {

            val masakanfinal = Masakan(masakanID,nama,bahan,resep)

            ref.child(masakanID).setValue(masakanfinal).addOnCompleteListener{
                Toast.makeText(
                    baseContext, "berhasil Ges, Kuy Valorant",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
        
        


    }

}

