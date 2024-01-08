package com.example.photofrommars.presentation.listPhotoMars

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.paging.PagingDataAdapter
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.photofrommars.databinding.PhotoMarsInfoViewGroupBinding
import com.example.cleancode.domain.entity.Photo

class PhotoMarsAdapter(
    private val onClick: (String) -> Unit
) : PagingDataAdapter<com.example.cleancode.domain.entity.Photo, PhotoMarsInfoViewHolder>(DiffUtilCallback()) {
    override fun onBindViewHolder(holder: PhotoMarsInfoViewHolder, position: Int) {
        val item = getItem(position)
        Log.d("Mylog", "OnBINDvIEWhOLDER = ${item?.img_src}")
        with(holder.binding) {
            tvRover.text = item?.rover?.name ?: ""
            tvCamera.text = item?.camera?.name ?: ""
            tvSol.text = item?.sol.toString()
            tvDate.text = item?.earth_date ?: "Default data"
            Glide.with(imageView.context)
                .load(item?.img_src)
                .into(imageView)

            holder.binding.root.setOnClickListener {
                item?.img_src?.let { onClick(it) }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PhotoMarsInfoViewHolder {
        Log.d("Mylog", " ON CREATE VIEW HOLDER")
        val binding = PhotoMarsInfoViewGroupBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return PhotoMarsInfoViewHolder(binding)
    }
}

class PhotoMarsInfoViewHolder(val binding: PhotoMarsInfoViewGroupBinding) :
    RecyclerView.ViewHolder(binding.root)

class DiffUtilCallback() : DiffUtil.ItemCallback<com.example.cleancode.domain.entity.Photo>() {
    override fun areItemsTheSame(
        oldItem: com.example.cleancode.domain.entity.Photo,
        newItem: com.example.cleancode.domain.entity.Photo
    ): Boolean = oldItem.id == newItem.id

    override fun areContentsTheSame(
        oldItem: com.example.cleancode.domain.entity.Photo,
        newItem: com.example.cleancode.domain.entity.Photo
    ): Boolean = oldItem.img_src == newItem.img_src

}