package com.kyomurin.android.numberspuzzle

import android.os.Bundle
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

        _binding = FragmentTitleBinding.inflate(inflater, container, false)
        return binding.root

    }

    /*

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonFirst.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }
    }
     */

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

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
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}