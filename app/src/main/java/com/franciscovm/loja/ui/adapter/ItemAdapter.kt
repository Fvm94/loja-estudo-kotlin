package com.franciscovm.loja.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.franciscovm.loja.data.Joia
import com.franciscovm.loja.databinding.ItemCardBinding

class ItemAdapter(private val joias : List<Joia> ): RecyclerView.Adapter<ItemAdapter.ViewHolder>() {

    class ViewHolder(private val binding: ItemCardBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(joia:Joia) {
            binding.itemCardTvName.text = joia.name
            binding.itemCardTvPrice.text = joia.price.toString()
            binding.itemCardBt.setOnClickListener {
                Toast.makeText(binding.root.context,"bag",Toast.LENGTH_SHORT).show()
            }
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
