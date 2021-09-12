package com.kyomurin.android.numberspuzzle

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.preference.PreferenceManager
import com.kyomurin.android.numberspuzzle.databinding.FragmentResultBinding

class ResultFragment : Fragment() {

    private var _binding: FragmentResultBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {

        Log.i("check", "ResultFragment onCreateView() called")

        _binding = FragmentResultBinding.inflate(inflater, container, false)
        return binding.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Log.i("check", "ResultFragment onViewCreated() called")
        val count = getCounts()

        val counts = count.first
        val time = count.second

        val minute = (time / 60).toString()
        val tmp = time % 60

        val second = if (tmp < 10) {
            "0$tmp"
        } else {
            tmp.toString()
        }

        binding.txResultCounts.text = counts.toString()
        binding.txResultTotal.text = "${minute}:${second}"

        setResultComment(counts)

        binding.btReturnTitleResult.setOnClickListener {
            findNavController().navigate(R.id.action_resultFragment_to_titleFragment)
        }
    }

    private fun getCounts(): Pair<Int, Int> {
        val pref = PreferenceManager.getDefaultSharedPreferences(activity)

        return Pair(pref.getInt("COUNT", 0), pref.getInt("TIME", 0))
    }

    private fun setResultComment(counts: Int) {
        var text = "GOOD"

        if (counts == 0) {
            text = "PERFECT"
        } else if (counts <= 5) {
            text = "GREAT"
        }

        binding.txResultComment.text = text
    }

    override fun onDestroyView() {
        super.onDestroyView()

        Log.i("check", "ResultFragment onDestroyView() called")

        _binding = null
    }
}