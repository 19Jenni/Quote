package com.example.quote.presentation.view

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import com.example.quote.databinding.FragmentSlideshowBinding
import com.example.quote.domain.model.QuoteModel
import com.example.quote.presentation.view.ui.slideshow.SlideshowViewModel
import com.example.quote.presentation.viewmodel.AddViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class AddQuoteFragment : Fragment() {

    private var _binding: FragmentSlideshowBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!
    private lateinit var viewModelAdd: AddViewModel

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        //   val galleryViewModel = ViewModelProvider(this).get(AddViewModel::class.java)

        _binding = FragmentSlideshowBinding.inflate(inflater, container, false)
        val root: View = binding.root
        viewModelAdd = ViewModelProvider(this)[AddViewModel::class.java]


        binding.btnAddQuote.setOnClickListener { observerAdd() }
        return binding.root
    }

    private fun getQuoteModel(): QuoteModel {
        return QuoteModel(
            id = binding.tvAddId.text.toString().toInt(),
            quote = binding.tvAddQuote.text.toString(),
            author = binding.tvAddAuthor.text.toString()
        )
    }



    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun observerAdd() {
        lifecycleScope.launch {
            when {
                isValidData() -> {
                    viewModelAdd.let {
                        it.addQuote(getQuoteModel())
                        showMessage("Quote added")
                        clearData()
                    }
                }
                else -> showMessage("Please fill all fields")
            }
        }
    }

    private fun isValidData() = binding.tvAddId.text.toString().isNotEmpty() &&
            binding.tvAddQuote.text.toString().isNotEmpty() &&
            binding.tvAddAuthor.text.toString().isNotEmpty()



    private fun clearData() {
        binding.tvAddId.text.clear()
        binding.tvAddQuote.text.clear()
        binding.tvAddAuthor.text.clear()
    }

    private fun showMessage(message: String) = Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
}