package io.hydok.simplerepository.viewmodel

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import io.hydok.simplerepository.databinding.ItemCatBinding
import io.hydok.simplerepository.model.Cat

class RecyclerAdapter : RecyclerView.Adapter<RecyclerAdapter.Holder>(){

    private lateinit var context: Context
    private var datas : List<Cat> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerAdapter.Holder {
        context = parent.context
        val binding = ItemCatBinding.inflate(LayoutInflater.from(context), parent, false)

        return Holder(binding)
    }

    override fun onBindViewHolder(holder: RecyclerAdapter.Holder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int {
        return datas.size
    }

    inner class Holder(private val binding: ItemCatBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(position: Int) {
            binding.cat = datas[position]
        }
    }

    fun setDatas(data:List<Cat>){
        this.datas = data
        notifyDataSetChanged()
    }

}