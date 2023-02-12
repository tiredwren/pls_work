package com.example.allhands

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.example.allhands.ItemsAdapter.ItemsAdapterVH


class ItemsAdapter : RecyclerView.Adapter<ItemsAdapterVH>() {

    var itemsModalList = ArrayList<ItemsModal>();

    fun setData(itemsModalList: ArrayList<ItemsModal>){
        this.itemsModalList = itemsModalList;

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemsAdapterVH {
        return ItemsAdapterVH(LayoutInflater.from(parent.context).inflate(R.layout.row_items,parent,false))
    }

    override fun onBindViewHolder(holder: ItemsAdapterVH, position: Int) {
        val itemsModal = itemsModalList[position];
        holder.name.text = itemsModal.name
        holder.desc.text = itemsModal.desc
    }

    override fun getItemCount(): Int {
        return itemsModalList.size
    }


    class ItemsAdapterVH(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name = itemView.findViewById<TextView>(R.id.tvName)
        val desc = itemView.findViewById<TextView>(R.id.tvDesc)
        val image = itemView.findViewById<TextView>(R.id.imageView)
    }

}
