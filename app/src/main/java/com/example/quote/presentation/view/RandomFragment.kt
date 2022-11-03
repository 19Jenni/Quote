package com.example.quote.presentation.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider

import androidx.lifecycle.lifecycleScope
import com.example.quote.databinding.FragmentGalleryBinding
import com.example.quote.presentation.viewmodel.QuoteViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class RandomFragment : Fragment() {

    private var _binding: FragmentGalleryBinding? = null
    private lateinit var quoteViewModel: QuoteViewModel

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentGalleryBinding.inflate(inflater, container, false)

        quoteViewModel = ViewModelProvider(this)[QuoteViewModel::class.java]

        observer()
        binding.viewContainer.setOnClickListener {
            quoteViewModel.randomQuote()
        }


        val root: View = binding.root

        return root

    }
    private fun observer(){
        lifecycleScope.launch {
            quoteViewModel.quoteModel.collect {
                binding.tvQuote.text = it.quote
                binding.tvAuthor.text= it.author
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}