package com.android.example.appexamen.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.android.example.appexamen.databinding.ItemCategoryBinding

class ItemAdapter : RecyclerView.Adapter<ItemAdapter.ViewHolder>() {

    var listCategories: List<String> = emptyList()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    var setClick: (String) -> Unit = {}

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun getItemCount(): Int {
        return listCategories.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = listCategories[position]
        holder.bind(item, setClick)
    }

    class ViewHolder(private val itemBinding: ItemCategoryBinding) :
        RecyclerView.ViewHolder(itemBinding.root) {

        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val view =
                    ItemCategoryBinding.inflate(LayoutInflater.from(parent.context), parent, false)
                return ViewHolder(view)
            }
        }

        fun bind(item: String, setClick: (String) -> Unit) {
            itemBinding.txtNameCategory.text = item
            itemBinding.itemCategory.setOnClickListener {
                setClick.invoke(item)
            }

            itemBinding.executePendingBindings()
        }

    }
}