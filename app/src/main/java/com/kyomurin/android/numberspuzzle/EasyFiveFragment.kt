package com.kyomurin.android.numberspuzzle

import android.os.Build.*
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.preference.PreferenceManager
import com.kyomurin.android.numberspuzzle.databinding.FragmentEasyFiveBinding
import java.util.*

class EasyFiveFragment : Fragment() {

    private var _binding: FragmentEasyFiveBinding? = null
    private val binding get() = _binding!!

    var startTime = 0L

    var ans = 1
    var mistakesCount = 0



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View? {

        Log.i("check", "EasyFiveFragment onCreateView() called")

        _binding =FragmentEasyFiveBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Log.i("check", "EasyFiveFragment onViewCreated() called")


        val buttonsList = listOf(binding.button1, binding.button2, binding.button3, binding.button4, binding.button5,
            binding.button6, binding.button7, binding.button8, binding.button9, binding.button10,
            binding.button11, binding.button12, binding.button13, binding.button14, binding.button15,
            binding.button16, binding.button17, binding.button18, binding.button19, binding.button20,
            binding.button21, binding.button22, binding.button23, binding.button24, binding.button25,
        )

        val temp = createButtonList(buttonsList)

        Log.i("numbersList", "${temp}")

        startTime = System.currentTimeMillis()


        binding.button1.setOnClickListener { onButtonClick(it, temp) }
        binding.button2.setOnClickListener { onButtonClick(it, temp) }
        binding.button3.setOnClickListener { onButtonClick(it, temp) }
        binding.button4.setOnClickListener { onButtonClick(it, temp) }
        binding.button5.setOnClickListener { onButtonClick(it, temp) }

        binding.button6.setOnClickListener { onButtonClick(it, temp) }
        binding.button7.setOnClickListener { onButtonClick(it, temp) }
        binding.button8.setOnClickListener { onButtonClick(it, temp) }
        binding.button9.setOnClickListener { onButtonClick(it, temp) }
        binding.button10.setOnClickListener { onButtonClick(it, temp) }

        binding.button11.setOnClickListener { onButtonClick(it, temp) }
        binding.button12.setOnClickListener { onButtonClick(it, temp) }
        binding.button13.setOnClickListener { onButtonClick(it, temp) }
        binding.button14.setOnClickListener { onButtonClick(it, temp) }
        binding.button15.setOnClickListener { onButtonClick(it, temp) }

        binding.button16.setOnClickListener { onButtonClick(it, temp) }
        binding.button17.setOnClickListener { onButtonClick(it, temp) }
        binding.button18.setOnClickListener { onButtonClick(it, temp) }
        binding.button19.setOnClickListener { onButtonClick(it, temp) }
        binding.button20.setOnClickListener { onButtonClick(it, temp) }

        binding.button21.setOnClickListener { onButtonClick(it, temp) }
        binding.button22.setOnClickListener { onButtonClick(it, temp) }
        binding.button23.setOnClickListener { onButtonClick(it, temp) }
        binding.button24.setOnClickListener { onButtonClick(it, temp) }
        binding.button25.setOnClickListener { onButtonClick(it, temp) }

    }

    private fun createButtonList(buttonsList : List<Button>) : List<Int> {

        Log.i("check", "EasyFiveFragment createButtonList() called")

        val nums : List<Int> = listOf<Int>(1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
        11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25)
        val numbersList = nums.shuffled()


        for (i in 0..24) {
            buttonsList[i].text = numbersList[i].toString()
        }
        return numbersList
    }

    private fun onButtonClick(view: View, numbersList: List<Int>) {

        Log.i("check", "EasyFiveFragment onButtonClick() called")

        val buttonsList = listOf(binding.button1, binding.button2, binding.button3, binding.button4, binding.button5,
            binding.button6, binding.button7, binding.button8, binding.button9, binding.button10,
            binding.button11, binding.button12, binding.button13, binding.button14, binding.button15,
            binding.button16, binding.button17, binding.button18, binding.button19, binding.button20,
            binding.button21, binding.button22, binding.button23, binding.button24, binding.button25,
        )

        val buttonIds = listOf(
            R.id.button1, R.id.button2, R.id.button3, R.id.button4, R.id.button5,
            R.id.button6, R.id.button7, R.id.button8, R.id.button9, R.id.button10,
            R.id.button11, R.id.button12, R.id.button13, R.id.button14, R.id.button15,
            R.id.button16, R.id.button17, R.id.button18, R.id.button19, R.id.button20,
            R.id.button21, R.id.button22, R.id.button23, R.id.button24, R.id.button25,
            )

        for (i in 0..24) {
            if (view.id == buttonIds[i]){
                if (numbersList[i] == ans) {
                    buttonsList[i].visibility = View.INVISIBLE
                    ans += 1
                } else {
                    mistakesCount += 1
                }

                if (ans == 26) {
                    val finishedTime = System.currentTimeMillis()
                    var diff = finishedTime - startTime

                    saveData(mistakesCount, diff.toInt())

                    findNavController().navigate(R.id.action_easyFiveFragment_to_resultFragment)
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

        Log.i("check", "EasyFiveFragment onDestroyView() called")

        _binding = null
    }
}