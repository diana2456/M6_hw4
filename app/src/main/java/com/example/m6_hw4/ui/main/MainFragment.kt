package com.example.m6_hw4.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.m6_hw4.databinding.FragmentMainBinding

class MainFragment : Fragment() {

    private lateinit var viewModel: FragmentsViewModel
    private lateinit var binding: FragmentMainBinding
    private lateinit var adapterViewPager: AdapterViewPager
    private val fragList = arrayListOf(ActionFragment(),CurrentFragment(),OperationsFragment())


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentMainBinding.inflate(LayoutInflater.from(context),container,false)
        adapterViewPager = AdapterViewPager(requireActivity(),fragList)
        viewModel = ViewModelProvider(requireActivity())[FragmentsViewModel::class.java]
        initView()
        return binding.root
    }

    private fun initView() {
        binding.vpFrag.adapter = adapterViewPager
    }

}