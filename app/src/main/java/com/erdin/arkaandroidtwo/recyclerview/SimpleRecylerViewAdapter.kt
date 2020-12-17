package com.erdin.arkaandroidtwo.recyclerview

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.erdin.arkaandroidtwo.R

class SimpleRecylerViewAdapter: RecyclerView.Adapter<SimpleRecylerViewAdapter.PetsViewHolder>() {

    val listPets = listOf("Kucing", "Kelinci", "Ayam", "Monyet", "Semut",
        "Buaya", "Merpati", "Hamster", "Marmut", "Burung Puyuh",
        "Bunglon", "Ikan Cupang", "Jangkrik", "Ular", "Rusa",
        "Kura-kura", "Kupu-kupu", "Katak", "Kambing", "Kalajengking",
        "Kuda", "Unta", "Burung Unta", "Capung", "Belalang",
        "Iguana", "Harimau", "Singa", "Komodo", "Lalat", "Nyamuk" )

    class PetsViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvPosition: TextView = itemView.findViewById<TextView>(R.id.tv_position)
        var tvTitle: TextView = itemView.findViewById(R.id.tv_title_item)
    }

    override fun getItemCount(): Int = listPets.size

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PetsViewHolder {
        return PetsViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.item_simple_recycler_view, parent, false))
    }

    override fun onBindViewHolder(holder: PetsViewHolder, position: Int) {
        holder.tvPosition.text = (position + 1).toString()
        holder.tvTitle.text = listPets[position]
    }
}