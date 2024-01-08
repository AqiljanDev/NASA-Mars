package com.example.photofrommars.presentation.viewPhoto

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.bumptech.glide.Glide
import com.example.photofrommars.R
import com.example.photofrommars.databinding.FragmentListPhotoMarsBinding
import com.example.photofrommars.databinding.FragmentPhotoViewBinding

class PhotoViewFragment : Fragment() {

    private var _binding: FragmentPhotoViewBinding? = null
    private val binding get() = _binding!!

    private val viewModel: PhotoViewViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentPhotoViewBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Log.d("Mylog", "on view created photoViewFragment = ${arguments?.getString("src")}")
        Glide.with(binding.imageViewPhoto.context)
            .load(arguments?.getString("src") ?: R.drawable.ic_launcher_background)
            .into(binding.imageViewPhoto)
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}