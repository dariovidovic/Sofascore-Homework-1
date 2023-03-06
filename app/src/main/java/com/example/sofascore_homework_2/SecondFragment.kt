package com.example.sofascore_homework_2

import android.graphics.Color
import androidx.fragment.app.Fragment
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.activityViewModels
import com.example.sofascore_homework_2.databinding.FragmentSecondBinding


class SecondFragment : Fragment() {

    private var _binding: FragmentSecondBinding? = null
    private val binding get() = _binding!!

    private val viewModel: PageViewModel by activityViewModels()


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentSecondBinding.inflate(inflater, container, false)
        val view = binding.root

        viewModel.getLiveData().observe(viewLifecycleOwner) {
            buildList(it)
        }
        return view
    }

    companion object {
        fun newInstance() = SecondFragment()
    }

    private fun buildList(people: List<Person>) {
        binding.linearLayout2.removeAllViews()
        for (person in people) {
            val personTextView = TextView(requireContext())
            personTextView.text = person.toString()
            personTextView.setTextColor(Color.BLACK)
            binding.linearLayout2.addView(personTextView)
        }
    }


    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}