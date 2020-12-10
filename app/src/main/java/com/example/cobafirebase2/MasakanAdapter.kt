package com.example.cobafirebase2

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.TextView

class MasakanAdapter(val mCtx: Context, val layoutResId: Int, val mskList: List<Masakan>) :
    ArrayAdapter<Masakan>(mCtx, layoutResId, mskList) {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {
        val layoutInflater: LayoutInflater = LayoutInflater.from(mCtx)

        val view: View = layoutInflater.inflate(layoutResId, null)

        val tvNama: TextView = view.findViewById(R.id.tv_nama)
        val tvBahan: TextView = view.findViewById(R.id.tv_bahan)
        val tvResep: TextView = view.findViewById(R.id.tv_resep)

        val masakan = mskList[position]

        tvNama.text = masakan.nama
        tvBahan.text = masakan.bahan
        tvResep.text = masakan.resep

        return view
    }
}