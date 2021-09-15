package com.kyomurin.android.numberspuzzle

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import androidx.preference.PreferenceManager
import com.kyomurin.android.numberspuzzle.databinding.FragmentEasyFourBinding

class EasyFourFragment : Fragment() {

    private var _binding: FragmentEasyFourBinding? = null
    private val binding get() = _binding!!

    var startTime = 0L

    var ans = 1
    var mistakesCount = 0



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

        Log.i("check", "EasyFourFragment onCreateView() called")

        _binding = FragmentEasyFourBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Log.i("check", "EasyFourFragment onViewCreated() called")


        val buttonsList = listOf(
            binding.bt1, binding.bt2, binding.bt3, binding.bt4,
            binding.bt5, binding.bt6, binding.bt7, binding.bt8,
            binding.bt9, binding.bt10, binding.bt11, binding.bt12,
            binding.bt13, binding.bt14, binding.bt15, binding.bt16,
        )

        val temp = createButtonList(buttonsList)

        Log.i("numbersList", "${temp}")

        startTime = System.currentTimeMillis()


        binding.bt1.setOnClickListener { onButtonClick(it, temp) }
        binding.bt2.setOnClickListener { onButtonClick(it, temp) }
        binding.bt3.setOnClickListener { onButtonClick(it, temp) }
        binding.bt4.setOnClickListener { onButtonClick(it, temp) }

        binding.bt5.setOnClickListener { onButtonClick(it, temp) }
        binding.bt6.setOnClickListener { onButtonClick(it, temp) }
        binding.bt7.setOnClickListener { onButtonClick(it, temp) }
        binding.bt8.setOnClickListener { onButtonClick(it, temp) }

        binding.bt9.setOnClickListener { onButtonClick(it, temp) }
        binding.bt10.setOnClickListener { onButtonClick(it, temp) }
        binding.bt11.setOnClickListener { onButtonClick(it, temp) }
        binding.bt12.setOnClickListener { onButtonClick(it, temp) }

        binding.bt13.setOnClickListener { onButtonClick(it, temp) }
        binding.bt14.setOnClickListener { onButtonClick(it, temp) }
        binding.bt15.setOnClickListener { onButtonClick(it, temp) }
        binding.bt16.setOnClickListener { onButtonClick(it, temp) }

    }

    private fun createButtonList(buttonsList : List<Button>) : List<Int> {

        Log.i("check", "EasyFourFragment createButtonList() called")

        val nums : List<Int> = listOf<Int>(1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
            11, 12, 13, 14, 15, 16)
        val numbersList = nums.shuffled()


        for (i in 0..15) {
            buttonsList[i].text = numbersList[i].toString()
        }
        return numbersList
    }

    private fun onButtonClick(view: View, numbersList: List<Int>) {

        Log.i("check", "EasyFourFragment onButtonClick() called")

        val buttonsList = listOf(
            binding.bt1, binding.bt2, binding.bt3, binding.bt4,
            binding.bt5, binding.bt6, binding.bt7, binding.bt8,
            binding.bt9, binding.bt10, binding.bt11, binding.bt12,
            binding.bt13, binding.bt14, binding.bt15, binding.bt16,
        )

        val buttonIds = listOf(
            R.id.bt1, R.id.bt2, R.id.bt3, R.id.bt4,
            R.id.bt5, R.id.bt6, R.id.bt7, R.id.bt8,
            R.id.bt9, R.id.bt10, R.id.bt11, R.id.bt12,
            R.id.bt13, R.id.bt14, R.id.bt15, R.id.bt16,
        )

        for (i in 0..15) {
            if (view.id == buttonIds[i]){
                if (numbersList[i] == ans) {
                    buttonsList[i].visibility = View.INVISIBLE
                    ans += 1
                } else {
                    mistakesCount += 1
                }

                if (ans == 17) {
                    val finishedTime = System.currentTimeMillis()
                    var diff = finishedTime - startTime

                    saveData(mistakesCount, diff.toInt())

                    findNavController().navigate(R.id.action_easyFourFragment_to_resultFragment)
                }

                break
            }
        }
    }

    private fun saveData(counts: Int, time: Int) {
        val pref = PreferenceManager.getDefaultSharedPreferences(activity)

        val editor = pref.edit()
        editor.putInt("COUNT", counts)
            .putInt("TIME", time)
            .apply()
    }

    override fun onDestroyView() {
        super.onDestroyView()

        Log.i("check", "EasyFourFragment onDestroyView() called")

        _binding = null
    }
}