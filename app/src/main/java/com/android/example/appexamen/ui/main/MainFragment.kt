package com.android.example.appexamen.ui.main

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import android.provider.ContactsContract.Data
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.navigation.navGraphViewModels
import com.android.example.appexamen.R
import com.android.example.appexamen.databinding.FragmentMainBinding

class MainFragment : Fragment() {


    private lateinit var binding : FragmentMainBinding
    private val viewModel: MainViewModel by navGraphViewModels<MainViewModel>(R.id.navigation)

    private val itemAdapter:ItemAdapter by lazy { ItemAdapter() }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding= DataBindingUtil.inflate<FragmentMainBinding>(inflater, R.layout.fragment_main,container, false)
        binding.recyclerCategories.adapter=itemAdapter
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        itemAdapter.setClick = {
            viewModel.categorySelected=it
            findNavController().navigate(R.id.action_mainFragment_to_deatilsCategoryFragment)
        }
        binding.progressCircular.visibility=View.VISIBLE
        viewModel.getListCategories()

        viewModel.lisCategory.observe(viewLifecycleOwner, Observer { categories->
            binding.progressCircular.visibility=View.GONE
            itemAdapter.listCategories=categories

        })


    }

}