package com.kyomurin.android.numberspuzzle

import android.os.Bundle
import android.provider.MediaStore
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.kyomurin.android.numberspuzzle.databinding.FragmentTitleBinding

class TitleFragment : Fragment() {
    private var _binding: FragmentTitleBinding? = null
    private val binding get() = _binding!!

    var selectedGame = 4
    var diff = 1

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        Log.i("check", "TitleFragment onCreateView() called")

        _binding = FragmentTitleBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Log.i("check", "TitleFragment onViewCreated() called")

        val gameGroup: RadioGroup = view.findViewById(R.id.radioGroupGame)
        gameGroup.setOnCheckedChangeListener {_, checkedId: Int ->
            when (checkedId) {
                R.id.rbFour -> selectedGame = 4
                R.id.rbFive -> selectedGame = 5
                R.id.rbSix -> selectedGame = 6
                else -> selectedGame = 4
            }
        }

        // 難易度NORMALが1、HARDが2
        val diffGroup: RadioGroup = view.findViewById(R.id.radioGroupDiff)
        diffGroup.setOnCheckedChangeListener{_, checkedId: Int ->
            when (checkedId) {
                R.id.rbEasy -> diff = 1
                else -> diff = 2
            }
        }

        binding.btStart.setOnClickListener {
            if (selectedGame == 5) {
                if (diff == 1) {
                    findNavController().navigate(R.id.action_titleFragment_to_easyFiveFragment)
                } else {
                    findNavController().navigate(R.id.action_titleFragment_to_hardFiveFragment)
                }
            } else if (selectedGame == 6){
                if (diff == 1) {
                    findNavController().navigate(R.id.action_titleFragment_to_easySixFragment)
                } else {
                    findNavController().navigate(R.id.action_titleFragment_to_hardSixFragment)
                }
            } else {
                if (diff == 1) {
                    findNavController().navigate(R.id.action_titleFragment_to_easyFourFragment)
                } else {
                    findNavController().navigate(R.id.action_titleFragment_to_hardFourFragment)
                }
            }
        }

        binding.btHowToPlay.setOnClickListener {
            findNavController().navigate(R.id.action_titleFragment_to_howToPlayFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()

        Log.i("check", "TitleFragment onDestroyView() called")

        _binding = null
    }
}