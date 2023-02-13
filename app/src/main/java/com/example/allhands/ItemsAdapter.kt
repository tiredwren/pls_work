package com.example.allhands

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.recyclerview.widget.RecyclerView
import com.example.allhands.ItemsAdapter.ItemsAdapterVH
import java.util.*
import kotlin.collections.ArrayList


class ItemsAdapter
    (var clickListener: ClickListener)
    : RecyclerView.Adapter<ItemsAdapterVH>(), Filterable {

    var itemsModalList = ArrayList<ItemsModal>();
    var itemsModalListFilter = ArrayList<ItemsModal>();

    fun setData(itemsModalList: ArrayList<ItemsModal>){
        this.itemsModalList = itemsModalList;
        this.itemsModalListFilter = itemsModalList;
        notifyDataSetChanged()

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemsAdapterVH {
        return ItemsAdapterVH(LayoutInflater.from(parent.context).inflate(R.layout.row_items,parent,false))
    }

    override fun onBindViewHolder(holder: ItemsAdapterVH, position: Int) {
        val itemsModal = itemsModalList[position];
        holder.name.text = itemsModal.name
        holder.desc.text = itemsModal.desc

        holder.itemView.setOnClickListener{
            clickListener.ClickedItem(itemsModal)
        }
    }

    override fun getItemCount(): Int {
        return itemsModalList.size
    }


    class ItemsAdapterVH(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val name = itemView.findViewById<TextView>(R.id.tvName)
        val desc = itemView.findViewById<TextView>(R.id.tvDesc)
        val image = itemView.findViewById<TextView>(R.id.imageView)
    }

    interface ClickListener{
        fun ClickedItem(itemsModal: ItemsModal)
    }

    override fun getFilter(): Filter {
        return object : Filter(){
            override fun performFiltering(charsequence: CharSequence?): FilterResults {
                val filterResults = FilterResults();
                if (charsequence == null || charsequence.length < 0){
                    filterResults.count = itemsModalListFilter.size
                    filterResults.values = itemsModalListFilter
                }
                else {
                    var searchChr = charsequence.toString().lowercase(Locale.getDefault())

                    val itemsModal = ArrayList<ItemsModal>()

                    for (item in itemsModalListFilter) {
                        if (item.name.contains(searchChr) || item.desc.contains(searchChr)) {
                            itemsModal.add(item)
                        }
                    }

                    filterResults.count = itemsModalList.size
                    filterResults.values = itemsModalList
                }

            return filterResults;
        }

            override fun publishResults(p0: CharSequence?, filterResults: FilterResults?) {

                itemsModalList = filterResults!!.values as ArrayList<ItemsModal> /* = java.util.ArrayList<com.example.allhands.ItemsModal> */
                notifyDataSetChanged()
            }

        }
    }

}
