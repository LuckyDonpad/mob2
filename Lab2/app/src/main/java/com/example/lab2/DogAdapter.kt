package com.example.lab2

import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.lab2.databinding.DogItemBinding

class DogAdapter() : RecyclerView.Adapter<DogAdapter.DogHolder>() {
    private val dogList = ArrayList<Dog>()
    private var onClickListener: OnClickListener? = null

    var onItemClick : ((Dog)->Unit)? = null

    class DogHolder(item: View) : RecyclerView.ViewHolder(item) {
        val binding = DogItemBinding.bind(item)
        fun bind(dog: Dog) = with(binding) {
            img.setImageResource(dog.imageId)
            tvBreed.text = dog.breed
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DogHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.dog_item, parent, false)
        return DogHolder(view)
    }

    override fun getItemCount(): Int {
        return dogList.size
    }

    override fun onBindViewHolder(holder: DogHolder, position: Int) {
        holder.bind(dogList[position])
        holder.itemView.setOnClickListener{
            onItemClick?.invoke(dogList[position])
        }
    }

    fun addDog(dog: Dog) {
        dogList.add(dog)
        notifyItemChanged(dogList.lastIndex)
    }
}