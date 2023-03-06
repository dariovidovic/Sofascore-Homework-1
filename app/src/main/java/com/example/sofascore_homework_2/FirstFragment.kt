package com.example.sofascore_homework_2

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.sofascore_homework_2.databinding.FragmentFirstBinding



class FirstFragment : Fragment() {
    private var _binding: FragmentFirstBinding? = null
    private val binding get() = _binding!!
    private val viewModel: PageViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {


        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        val view = binding.root

        binding.run {
            button.setOnClickListener {
                viewModel.addPerson(
                    enterFirstName.text.toString(),
                    enterSecondName.text.toString(),
                    enterAge.text.toString().toIntOrNull() ?: 0,
                    enterOib.text.toString().toIntOrNull() ?: 0,
                    enterBirthplace.text.toString(),
                    enterCurrOccupation.text.toString(),
                    enterFavMovie.text.toString(),
                    enterFavTvShow.text.toString(),
                    enterFavFood.text.toString(),
                    enterFavSong.text.toString()
                )
                enterFirstName.text.clear()
                enterSecondName.text.clear()
                enterAge.text.clear()
                enterOib.text.clear()
                enterBirthplace.text.clear()
                enterCurrOccupation.text.clear()
                enterFavMovie.text.clear()
                enterFavTvShow.text.clear()
                enterFavFood.text.clear()
                enterFavSong.text.clear()
            }
        }


        return view


    }

    companion object {
        fun newInstance() = FirstFragment()
    }
}
