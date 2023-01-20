package com.android.example.appexamen.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.navigation.navGraphViewModels
import com.android.example.appexamen.R
import com.android.example.appexamen.databinding.FragmentDeatilsCategoryBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

class DeatilsCategoryFragment : Fragment() {


    private lateinit var binding: FragmentDeatilsCategoryBinding

    private val viewModel: MainViewModel by navGraphViewModels<MainViewModel>(R.id.navigation)




    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        binding = DataBindingUtil.inflate<FragmentDeatilsCategoryBinding>(inflater, R.layout.fragment_deatils_category, container, false)

        // Inflate the layout for this fragment
        return binding.root


    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.progressCircular.visibility=View.VISIBLE
        viewModel.getCategory()
        viewModel.category.observe(viewLifecycleOwner, Observer { c->
            binding.progressCircular.visibility=View.GONE
            with(binding){
                txtId.text="ID: "+c.id
                txtCreated.text="Created at: "+c.created_at
                txtUrl.text="URL: "+c.url
                txtValue.text="Description: "+c.value
                txtUpdate.text="Update At: "+c.updated_at
                txtNameCategory.text="Category Name: "+viewModel.categorySelected
                txtUrlIcon.text="Url Icon: "+c.icon_url

            }



        })

    }



}