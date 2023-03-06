package com.example.m6_hw4.ui.main

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.m6_hw4.databinding.FragmentOperationsBinding

class OperationsFragment : Fragment() {

    private lateinit var binding: FragmentOperationsBinding
    private lateinit var viewModel: FragmentsViewModel
    private lateinit var adapter: OperationAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
        binding = FragmentOperationsBinding.inflate(LayoutInflater.from(context),container,false)
        viewModel = ViewModelProvider(requireActivity())[FragmentsViewModel::class.java]
        adapter = OperationAdapter()
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.rvClick.adapter = adapter
        viewModel.historyClick.observe(viewLifecycleOwner) {
            adapter.initList(it)
            println(it.toString())
        }
    }
}