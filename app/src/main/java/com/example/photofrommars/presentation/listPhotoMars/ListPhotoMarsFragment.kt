package com.example.photofrommars.presentation.listPhotoMars

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.commit
import androidx.fragment.app.replace
import androidx.fragment.app.viewModels
import androidx.lifecycle.lifecycleScope
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.fragment.findNavController
import com.example.photofrommars.R
import com.example.photofrommars.databinding.FragmentListPhotoMarsBinding
import com.example.photofrommars.presentation.viewPhoto.PhotoViewFragment
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.launchIn
import kotlinx.coroutines.flow.onEach

@AndroidEntryPoint
class ListPhotoMarsFragment : Fragment() {

    companion object {
        fun newInstance() = ListPhotoMarsFragment()
    }

    private var _binding: FragmentListPhotoMarsBinding? = null
    private val binding get() = _binding!!

    private val viewModel: ListPhotoMarsViewModel by viewModels()
    private val adapter = PhotoMarsAdapter {
        onClickItem(it)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentListPhotoMarsBinding.inflate(inflater, container, false)

        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.recyclerViewPhotos.adapter = adapter

        viewModel.listPhotoMars.onEach {
            Log.d("Mylog", it.toString())
            adapter.submitData(it)
        }.launchIn(viewLifecycleOwner.lifecycleScope)

    }

    private fun onClickItem(imgSrc: String) {
        Log.d("Mylog", "ON CLICK ITEM")
        val bundle = Bundle()
        bundle.putString("src", imgSrc)
        parentFragmentManager.beginTransaction().replace(
            R.id.container,
            PhotoViewFragment::class.java,
            bundle
        ).addToBackStack("ADD TO BACK STACK")
            .commit()
//        findNavController().navigate(R.id.action_listPhotoMarsFragment_to_photoViewFragment)

//        val navController = binding.root.getFragment<NavHostFragment>().navController

    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}