package com.kyomurin.android.numberspuzzle

import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import androidx.preference.PreferenceManager
import com.kyomurin.android.numberspuzzle.databinding.FragmentHardSixBinding

class HardSixFragment : Fragment() {


    private var _binding: FragmentHardSixBinding? = null
    private val binding get() = _binding!!

    var startTime = 0L

    var ans = 1
    var mistakesCount = 0

    var timer : CountDownTimer? = null

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?,
    ): View {

        Log.i("check", "HardSixFragment onCreateView() called")

        _binding = FragmentHardSixBinding.inflate(inflater, container, false)
        return binding.root
    }

    inner class CountDown(millisInFuture: Long, countDownIntarval: Long)
        : CountDownTimer(millisInFuture, countDownIntarval) {

        var isRunning = true

        val buttonsList = listOf(
            binding.bt1, binding.bt2, binding.bt3, binding.bt4, binding.bt5, binding.bt6,
            binding.bt7, binding.bt8, binding.bt9, binding.bt10, binding.bt11, binding.bt12,
            binding.bt13, binding.bt14, binding.bt15, binding.bt16, binding.bt17, binding.bt18,
            binding.bt19, binding.bt20, binding.bt21, binding.bt22, binding.bt23, binding.bt24,
            binding.bt25, binding.bt26, binding.bt27, binding.bt28, binding.bt29, binding.bt30,
            binding.bt31, binding.bt32, binding.bt33, binding.bt34, binding.bt35, binding.bt36,
        )

        val temp = createButtonList(buttonsList)

        override fun onTick(millisUntilFinished: Long) {
            val minute = millisUntilFinished / 1000L / 60L
            val second = millisUntilFinished / 1000L % 60L
            binding.txTimerSix.text = "%1d:%2$02d".format(minute, second)
        }

        override fun onFinish() {
            isRunning = false
            clearText(buttonsList)
            binding.txTimerSix.text = "0:00"

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
            binding.bt17.setOnClickListener { onButtonClick(it, temp) }
            binding.bt18.setOnClickListener { onButtonClick(it, temp) }

            binding.bt19.setOnClickListener { onButtonClick(it, temp) }
            binding.bt20.setOnClickListener { onButtonClick(it, temp) }
            binding.bt21.setOnClickListener { onButtonClick(it, temp) }
            binding.bt22.setOnClickListener { onButtonClick(it, temp) }
            binding.bt23.setOnClickListener { onButtonClick(it, temp) }
            binding.bt24.setOnClickListener { onButtonClick(it, temp) }

            binding.bt25.setOnClickListener { onButtonClick(it, temp) }
            binding.bt26.setOnClickListener { onButtonClick(it, temp) }
            binding.bt27.setOnClickListener { onButtonClick(it, temp) }
            binding.bt28.setOnClickListener { onButtonClick(it, temp) }
            binding.bt29.setOnClickListener { onButtonClick(it, temp) }
            binding.bt30.setOnClickListener { onButtonClick(it, temp) }

            binding.bt31.setOnClickListener { onButtonClick(it, temp) }
            binding.bt32.setOnClickListener { onButtonClick(it, temp) }
            binding.bt33.setOnClickListener { onButtonClick(it, temp) }
            binding.bt34.setOnClickListener { onButtonClick(it, temp) }
            binding.bt35.setOnClickListener { onButtonClick(it, temp) }
            binding.bt36.setOnClickListener { onButtonClick(it, temp) }
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        Log.i("check", "HardSixFragment onViewCreated() called")

        binding.txTimerSix.text = "1:00"

        timer = CountDown(60 * 1000, 100)
        timer?.start()
    }

    private fun clearText(buttonsList : List<Button>) {

        for (i in 0..35) {
            buttonsList[i].text = ""
        }

    }

    private fun createButtonList(buttonsList : List<Button>) : List<Int> {

        Log.i("check", "HardSixFragment createButtonList() called")

        val nums : List<Int> = listOf<Int>(1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
            11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30,
            31, 32, 33, 34, 35, 36
        )
        val numbersList = nums.shuffled()

        for (i in 0..35) {
            buttonsList[i].text = numbersList[i].toString()
        }

        return numbersList
    }

    private fun onButtonClick(view: View, numbersList: List<Int>) {

        Log.i("check", "HardSixFragment onButtonClick() called")

        val buttonsList = listOf(
            binding.bt1, binding.bt2, binding.bt3, binding.bt4, binding.bt5, binding.bt6,
            binding.bt7, binding.bt8, binding.bt9, binding.bt10, binding.bt11, binding.bt12,
            binding.bt13, binding.bt14, binding.bt15, binding.bt16, binding.bt17, binding.bt18,
            binding.bt19, binding.bt20, binding.bt21, binding.bt22, binding.bt23, binding.bt24,
            binding.bt25, binding.bt26, binding.bt27, binding.bt28, binding.bt29, binding.bt30,
            binding.bt31, binding.bt32, binding.bt33, binding.bt34, binding.bt35, binding.bt36,
        )

        val buttonIds = listOf(
            R.id.bt1, R.id.bt2, R.id.bt3, R.id.bt4, R.id.bt5, R.id.bt6,
            R.id.bt7, R.id.bt8, R.id.bt9, R.id.bt10, R.id.bt11, R.id.bt12,
            R.id.bt13, R.id.bt14, R.id.bt15, R.id.bt16, R.id.bt17, R.id.bt18,
            R.id.bt19, R.id.bt20, R.id.bt21, R.id.bt22, R.id.bt23, R.id.bt24,
            R.id.bt25, R.id.bt26, R.id.bt27, R.id.bt28, R.id.bt29, R.id.bt30,
            R.id.bt31, R.id.bt32, R.id.bt33, R.id.bt34, R.id.bt35, R.id.bt36,
        )

        for (i in 0..35) {
            if (view.id == buttonIds[i]){
                if (numbersList[i] == ans) {
                    buttonsList[i].visibility = View.INVISIBLE
                    ans += 1
                } else {
                    mistakesCount += 1
                }

                if (ans == 37) {
                    val finishedTime = System.currentTimeMillis()
                    var diff = finishedTime - startTime

                    saveData(mistakesCount, diff.toInt())

                    findNavController().navigate(R.id.action_hardSixFragment_to_resultFragment)
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

    override fun onResume() {
        super.onResume()
        Log.i("check", "HardSixFragment onResume() called")
    }

    override fun onPause() {
        super.onPause()

        Log.i("check", "HardSixFragment onPause() called")
    }

    override fun onStop() {
        super.onStop()

        Log.i("check", "HardSixFragment onStop() called")
    }

    override fun onDestroyView() {
        super.onDestroyView()

        Log.i("check", "HardSixFragment onDestroyView() called")

        timer?.cancel()

        _binding = null
    }
}