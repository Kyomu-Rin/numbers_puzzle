package com.kyomurin.android.numberspuzzle

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.preference.PreferenceManager
import com.kyomurin.android.numberspuzzle.databinding.FragmentHowToPlayBinding

class HowToPlayFragment : Fragment() {


    private var _binding: FragmentHowToPlayBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {

        Log.i("check", "ResultFragment onCreateView() called")

        _binding = FragmentHowToPlayBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Log.i("check", "ResultFragment onViewCreated() called")
    }

    override fun onDestroyView() {
        super.onDestroyView()

        Log.i("check", "ResultFragment onDestroyView() called")

        _binding = null
    }
}