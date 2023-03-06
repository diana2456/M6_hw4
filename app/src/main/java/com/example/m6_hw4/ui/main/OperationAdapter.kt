package com.example.m6_hw4.ui.main

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.m6_hw4.databinding.ItemOperationBinding

class OperationAdapter: RecyclerView.Adapter<OperationAdapter.HistoryViewHolder>() {

    private var arrayList = ArrayList<String>()

    @SuppressLint("NotifyDataSetChanged")
    fun initList(list: ArrayList<String>){
        arrayList.clear()
        arrayList.addAll(list)
        notifyDataSetChanged()
    }

    inner class HistoryViewHolder(private val binding: ItemOperationBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(click: String) {
           binding.rvClick.text = click
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HistoryViewHolder {
        return HistoryViewHolder(
            ItemOperationBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: HistoryViewHolder, position: Int) {
        holder.bind(arrayList[position])
    }

    override fun getItemCount(): Int {
        return arrayList.size
    }
}