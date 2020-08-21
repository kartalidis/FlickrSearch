package com.example.flickrsearch.ui.start

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProviders
import com.example.flickrsearch.R

class StartFragment : Fragment() {

    companion object {
        fun newInstance() = StartFragment()
    }

    private lateinit var viewModel: StartViewModel


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.start_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this).get(StartViewModel::class.java)
        // TODO: Use the ViewModel
    }


}

//    override fun onCreateView(
//        inflater: LayoutInflater,
//        container: ViewGroup?,
//        savedInstanceState: Bundle?
//    ): View? {
//        val binding = RecentPhotosBinding.inflate(inflater)
//
//        binding.toolbar.inflateMenu(R.menu.main)
//        binding.searchView.setMenuItem(binding.toolbar.menu.findItem(R.id.search))
//        binding.searchView.setOnQueryTextListener(object : MaterialSearchView.OnQueryTextListener {
//            override fun onQueryTextSubmit(query: String?): Boolean = viewModel.onQueryTextSubmit(query)
//
//            override fun onQueryTextChange(newText: String?): Boolean = false
//        })
//
//        // To configure columns for different orientations.
//        // e.g. for portrait, column count is 2 while for landscape, the count is 4.
//        binding.photosView.layoutManager = LayoutManagers
//            .grid(resources.getInteger(R.integer.galleryColumns))
//            .create(binding.photosView)
//        addDividers(binding.photosView)
//
//        binding.photoItemBinding = ItemBinding.of<PhotoViewModel>(BR.viewModel, R.layout.photo)
//        binding.viewModel = viewModel
//
//        return binding.root
//    }
//
//    private fun addDividers(photosView: RecyclerView) {
//        val verticalDividerItemDecoration = DividerItemDecoration(
//            activity, DividerItemDecoration.VERTICAL
//        ).apply {
//            setDrawable(ContextCompat.getDrawable(requireContext(), R.drawable.vertical_divider)!!)
//        }
//        photosView.addItemDecoration(verticalDividerItemDecoration)
//
//        val horizontalDividerItemDecoration = DividerItemDecoration(
//            activity, DividerItemDecoration.HORIZONTAL
//        ).apply {
//            setDrawable(ContextCompat.getDrawable(requireContext(), R.drawable.horizontal_divider)!!)
//        }
//        photosView.addItemDecoration(horizontalDividerItemDecoration)
//    }
//
//    override fun onDestroy() {
//        viewModel.onCleared()
//        super.onDestroy()
//    }
//}