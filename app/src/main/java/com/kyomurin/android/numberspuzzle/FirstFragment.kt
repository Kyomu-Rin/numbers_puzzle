package com.kyomurin.android.numberspuzzle

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RadioGroup
import android.widget.Toast
import androidx.navigation.fragment.findNavController
import com.kyomurin.android.numberspuzzle.databinding.FragmentFirstBinding

/**
 * A simple [Fragment] subclass as the default destination in the navigation.
 */
class FirstFragment : Fragment() {

    private var _binding: FragmentFirstBinding? = null

    // This property is only valid between onCreateView and
    // onDestroyView.
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentFirstBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

//        val colorGroup: RadioGroup = findViewById(R.id.color_group)
//        colorGroup.setOnCheckedChangeListener { _, checkedId: Int ->
//            when (checkedId) {
//                R.id.red_button -> Toast.makeText(this, "赤色が選ばれています", Toast.LENGTH_SHORT).show()
//                R.id.yellow_button -> Toast.makeText(this, "黄色が選ばれています", Toast.LENGTH_SHORT).show()
//                R.id.blue_button -> Toast.makeText(this, "青色が選ばれています", Toast.LENGTH_SHORT).show()
//                else -> throw IllegalArgumentException("not supported")
//            }
//        }

        binding.buttonFirst.setOnClickListener {
            findNavController().navigate(R.id.action_FirstFragment_to_SecondFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}