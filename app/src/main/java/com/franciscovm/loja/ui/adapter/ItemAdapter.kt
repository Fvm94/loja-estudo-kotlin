package com.franciscovm.loja.ui.adapter

import android.app.Activity
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.franciscovm.loja.data.Joia
import com.franciscovm.loja.databinding.ItemCardBinding
import com.franciscovm.loja.ui.fragment.bag.BagFragment

class ItemAdapter(private val joias : List<Joia> ): RecyclerView.Adapter<ItemAdapter.ViewHolder>() {

    class ViewHolder(private val binding: ItemCardBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(joia:Joia) {
            binding.itemCardTvName.text = joia.name
            binding.itemCardTvPrice.text = joia.price.toString()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemAdapter.ViewHolder {

        val binding = ItemCardBinding.inflate(LayoutInflater.from(parent.context),parent,false)

        return ViewHolder(binding)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val joia:Joia = joias[position]
        holder.bind(joia)
        holder.itemView.setOnLongClickListener{
            Toast.makeText(it.context,joia.description,Toast.LENGTH_SHORT).show()
            true
        }
    }

    override fun getItemCount() = joias.size

}
