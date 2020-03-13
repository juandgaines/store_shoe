package com.udacity.shoestore


import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.activity.addCallback
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.udacity.shoestore.databinding.FragmentShoesListBinding

class ShoesListFragment : Fragment() {

    private lateinit var activityViewModel:MainActivityViewModel
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding: FragmentShoesListBinding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_shoes_list, container, false)

        activityViewModel=ViewModelProvider(activity!!).get(MainActivityViewModel::class.java)
        activityViewModel.shoesList.observe(viewLifecycleOwner, Observer {shoesList->

        })
        activityViewModel.isOnBoardingCompleted.observe(viewLifecycleOwner, Observer {

        })

        val callback = requireActivity().onBackPressedDispatcher.addCallback(this) {
            if(activityViewModel.isOnBoardingCompleted.value!!){
                activity?.findNavController(R.id.myNavHostFragment)?.navigateUp()
            }
        }

        requireActivity().onBackPressedDispatcher.addCallback(this,callback)


        binding.addButton.setOnClickListener {
            activity?.findNavController(R.id.myNavHostFragment)
                ?.navigate(R.id.action_shoesListFragment_to_shoeDetailFragment)
        }
        return binding.root
    }
}
