package com.example.m6_hw4.ui.main

import android.annotation.SuppressLint
import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.m6_hw4.databinding.FragmentActionBinding

class ActionFragment : Fragment() {

    private lateinit var viewModel: FragmentsViewModel
    private lateinit var binding: FragmentActionBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentActionBinding.inflate(LayoutInflater.from(context),container,false)
        viewModel = ViewModelProvider(requireActivity())[FragmentsViewModel::class.java]
        return binding.root
    }

     @SuppressLint("FragmentLiveDataObserve")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnPlus.setOnClickListener {
            viewModel.onIncrementClick()
        }
        binding.btnMinus.setOnClickListener {
            viewModel.onDecrementClick()
        }
        viewModel.counter.observe(this) {
            binding.tvCounter.text = it.toString()
        }
    }
}