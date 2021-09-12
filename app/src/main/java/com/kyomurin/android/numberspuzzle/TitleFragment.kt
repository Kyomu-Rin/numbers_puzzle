package com.kyomurin.android.numberspuzzle

import android.os.Bundle
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

    var selectedGame = 5

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
                R.id.rbFive -> selectedGame = 5
                R.id.rbSix -> selectedGame = 6
                R.id.rbSeven -> selectedGame = 7
                else -> selectedGame = 5
            }
        }

        binding.btStart.setOnClickListener {
            if (selectedGame == 5) {
                findNavController().navigate(R.id.action_titleFragment_to_easyFiveFragment)
            } else {
                Toast.makeText(activity, "others", Toast.LENGTH_LONG).show()
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