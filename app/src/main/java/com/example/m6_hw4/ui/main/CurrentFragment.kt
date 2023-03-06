package com.example.m6_hw4.ui.main

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import com.example.m6_hw4.databinding.FragmentCurrentBinding

class CurrentFragment : Fragment() {

    private lateinit var binding: FragmentCurrentBinding
    private lateinit var viewModel: FragmentsViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {
       binding = FragmentCurrentBinding.inflate(LayoutInflater.from(context),container,false)
        viewModel = ViewModelProvider(this)[FragmentsViewModel::class.java]
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(requireActivity())[FragmentsViewModel::class.java]
        viewModel.counter.observe(viewLifecycleOwner) {
            binding.tvCounter.text = it.toString()
        }
    }
}