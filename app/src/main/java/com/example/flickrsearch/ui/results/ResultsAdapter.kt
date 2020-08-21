package com.example.flickrsearch.ui.results

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.resource.bitmap.CircleCrop
import com.example.flickrsearch.data.entities.Photo
import com.example.flickrsearch.databinding.ItemGridviewBinding

class ResultsAdapter(private val listener: PhotoItemListener) : RecyclerView.Adapter<PhotoViewHolder>() {

    interface PhotoItemListener {
        fun onClickedPhoto(photoId: String)
    }

    private val items = ArrayList<Photo>()

    fun setItems(items: ArrayList<Photo>) {
        this.items.clear()
        this.items.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoViewHolder {
        val binding: ItemGridviewBinding = ItemGridviewBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PhotoViewHolder(binding, listener)
    }

    override fun getItemCount(): Int = items.size

    override fun onBindViewHolder(holder: PhotoViewHolder, position: Int) = holder.bind(items[position])
}

class PhotoViewHolder(private val itemBinding: ItemGridviewBinding, private val listener: ResultsAdapter.PhotoItemListener) : RecyclerView.ViewHolder(itemBinding.root),
    View.OnClickListener {

    private lateinit var photo: Photo

    init {
        itemBinding.root.setOnClickListener(this)
    }

    @SuppressLint("SetTextI18n")
    fun bind(item: Photo) {
        this.photo = item
        itemBinding.titleSmall.text = item.title
//        itemBinding.speciesAndStatus.text = """${item.species} - ${item.status}"""
        Glide.with(itemBinding.root)
            .load(item.image)
            .transform(CircleCrop())
            .into(itemBinding.imageSmall)
    }

    override fun onClick(v: View?) {
        listener.onClickedPhoto(photo.id)
    }
}