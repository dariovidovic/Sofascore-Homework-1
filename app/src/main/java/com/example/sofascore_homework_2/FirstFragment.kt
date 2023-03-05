package com.example.sofascore_homework_2

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels


class FirstFragment : Fragment() {

    private val viewModel: PageViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        viewModel.addPerson(
            "dario",
            "vidovic",
            22,
            12345,
            "nova gradiska",
            "student",
            "shutter island",
            "chernobyl",
            "pizza",
            "never gonna give you up"
        )

        return inflater.inflate(R.layout.fragment_first, container, false)


    }

    companion object {
        @JvmStatic
        fun newInstance() = FirstFragment()
            }
    }
