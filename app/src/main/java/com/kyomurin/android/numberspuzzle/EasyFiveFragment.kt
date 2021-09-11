package com.kyomurin.android.numberspuzzle

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.kyomurin.android.numberspuzzle.databinding.FragmentEasyFiveBinding

class EasyFiveFragment : Fragment() {

    private var _binding: FragmentEasyFiveBinding? = null
    private val binding get() = _binding!!

    var ans = 1
    var mistakesCount = 0
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding =FragmentEasyFiveBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val temp = createButtonList()

        Log.i("numbersList", "${temp}")

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

    private fun createButtonList() : List<Int> {

        val nums : List<Int> = listOf<Int>(1, 2, 3, 4, 5, 6, 7, 8, 9, 10,
        11, 12, 13, 14, 15, 16, 17, 18, 19, 20, 21, 22, 23, 24, 25)
        val numbersList = nums.shuffled()

        binding.button1.text = numbersList[0].toString()
        binding.button2.text = numbersList[1].toString()
        binding.button3.text = numbersList[2].toString()
        binding.button4.text = numbersList[3].toString()
        binding.button5.text = numbersList[4].toString()

        binding.button6.text = numbersList[5].toString()
        binding.button7.text = numbersList[6].toString()
        binding.button8.text = numbersList[7].toString()
        binding.button9.text = numbersList[8].toString()
        binding.button10.text = numbersList[9].toString()

        binding.button11.text = numbersList[10].toString()
        binding.button12.text = numbersList[11].toString()
        binding.button13.text = numbersList[12].toString()
        binding.button14.text = numbersList[13].toString()
        binding.button15.text = numbersList[14].toString()

        binding.button16.text = numbersList[15].toString()
        binding.button17.text = numbersList[16].toString()
        binding.button18.text = numbersList[17].toString()
        binding.button19.text = numbersList[18].toString()
        binding.button20.text = numbersList[19].toString()

        binding.button21.text = numbersList[20].toString()
        binding.button22.text = numbersList[21].toString()
        binding.button23.text = numbersList[22].toString()
        binding.button24.text = numbersList[23].toString()
        binding.button25.text = numbersList[24].toString()

        return numbersList
    }

    private fun onButtonClick(view: View, numbersList: List<Int>) {
        var text = binding.txMistaksCount

        when (view.id) {
            R.id.button1 -> {
                if (numbersList[0] == ans) {
                    // 正解だったら見えなくする & ansを次の数に変更
                    binding.button1.visibility = View.INVISIBLE
                    ans += 1
                } else {
                    mistakesCount += 1
                }
                text.text = mistakesCount.toString()
            }
            R.id.button2 -> {
                if (numbersList[1] == ans) {
                    // 正解だったら見えなくする & ansを次の数に変更
                    binding.button2.visibility = View.INVISIBLE
                    ans += 1
                } else {
                    mistakesCount += 1
                }
                text.text = mistakesCount.toString()
            }
            R.id.button3 -> {
                if (numbersList[2] == ans) {
                    // 正解だったら見えなくする & ansを次の数に変更
                    binding.button3.visibility = View.INVISIBLE
                    ans += 1
                } else {
                    mistakesCount += 1
                }
                text.text = mistakesCount.toString()
            }
            R.id.button4 -> {
                if (numbersList[3] == ans) {
                    // 正解だったら見えなくする & ansを次の数に変更
                    binding.button4.visibility = View.INVISIBLE
                    ans += 1
                } else {
                    mistakesCount += 1
                }
                text.text = mistakesCount.toString()
            }
            R.id.button5 -> {
                if (numbersList[4] == ans) {
                    // 正解だったら見えなくする & ansを次の数に変更
                    binding.button5.visibility = View.INVISIBLE
                    ans += 1
                } else {
                    mistakesCount += 1
                }
                text.text = mistakesCount.toString()
            }

            R.id.button6 -> {
                if (numbersList[5] == ans) {
                    // 正解だったら見えなくする & ansを次の数に変更
                    binding.button6.visibility = View.INVISIBLE
                    ans += 1
                } else {
                    mistakesCount += 1
                }
                text.text = mistakesCount.toString()
            }
            R.id.button7 -> {
                if (numbersList[6] == ans) {
                    // 正解だったら見えなくする & ansを次の数に変更
                    binding.button7.visibility = View.INVISIBLE
                    ans += 1
                } else {
                    mistakesCount += 1
                }
                text.text = mistakesCount.toString()
            }
            R.id.button8 -> {
                if (numbersList[7] == ans) {
                    // 正解だったら見えなくする & ansを次の数に変更
                    binding.button8.visibility = View.INVISIBLE
                    ans += 1
                } else {
                    mistakesCount += 1
                }
                text.text = mistakesCount.toString()
            }
            R.id.button9 -> {
                if (numbersList[8] == ans) {
                    // 正解だったら見えなくする & ansを次の数に変更
                    binding.button9.visibility = View.INVISIBLE
                    ans += 1
                } else {
                    mistakesCount += 1
                }
                text.text = mistakesCount.toString()
            }
            R.id.button10 -> {
                if (numbersList[9] == ans) {
                    // 正解だったら見えなくする & ansを次の数に変更
                    binding.button10.visibility = View.INVISIBLE
                    ans += 1
                } else {
                    mistakesCount += 1
                }
                text.text = mistakesCount.toString()
            }

            R.id.button11 -> {
                if (numbersList[10] == ans) {
                    // 正解だったら見えなくする & ansを次の数に変更
                    binding.button11.visibility = View.INVISIBLE
                    ans += 1
                } else {
                    mistakesCount += 1
                }
                text.text = mistakesCount.toString()
            }
            R.id.button12 -> {
                if (numbersList[11] == ans) {
                    // 正解だったら見えなくする & ansを次の数に変更
                    binding.button12.visibility = View.INVISIBLE
                    ans += 1
                } else {
                    mistakesCount += 1
                }
                text.text = mistakesCount.toString()
            }
            R.id.button13 -> {
                if (numbersList[12] == ans) {
                    // 正解だったら見えなくする & ansを次の数に変更
                    binding.button13.visibility = View.INVISIBLE
                    ans += 1
                } else {
                    mistakesCount += 1
                }
                text.text = mistakesCount.toString()
            }
            R.id.button14 -> {
                if (numbersList[13] == ans) {
                    // 正解だったら見えなくする & ansを次の数に変更
                    binding.button14.visibility = View.INVISIBLE
                    ans += 1
                } else {
                    mistakesCount += 1
                }
                text.text = mistakesCount.toString()
            }
            R.id.button15 -> {
                if (numbersList[14] == ans) {
                    // 正解だったら見えなくする & ansを次の数に変更
                    binding.button15.visibility = View.INVISIBLE
                    ans += 1
                } else {
                    mistakesCount += 1
                }
                text.text = mistakesCount.toString()
            }

            R.id.button16 -> {
                if (numbersList[15] == ans) {
                    // 正解だったら見えなくする & ansを次の数に変更
                    binding.button16.visibility = View.INVISIBLE
                    ans += 1
                } else {
                    mistakesCount += 1
                }
                text.text = mistakesCount.toString()
            }
            R.id.button17 -> {
                if (numbersList[16] == ans) {
                    // 正解だったら見えなくする & ansを次の数に変更
                    binding.button17.visibility = View.INVISIBLE
                    ans += 1
                } else {
                    mistakesCount += 1
                }
                text.text = mistakesCount.toString()
            }
            R.id.button18 -> {
                if (numbersList[17] == ans) {
                    // 正解だったら見えなくする & ansを次の数に変更
                    binding.button18.visibility = View.INVISIBLE
                    ans += 1
                } else {
                    mistakesCount += 1
                }
                text.text = mistakesCount.toString()
            }
            R.id.button19 -> {
                if (numbersList[18] == ans) {
                    // 正解だったら見えなくする & ansを次の数に変更
                    binding.button19.visibility = View.INVISIBLE
                    ans += 1
                } else {
                    mistakesCount += 1
                }
                text.text = mistakesCount.toString()
            }
            R.id.button20 -> {
                if (numbersList[19] == ans) {
                    // 正解だったら見えなくする & ansを次の数に変更
                    binding.button20.visibility = View.INVISIBLE
                    ans += 1
                } else {
                    mistakesCount += 1
                }
                text.text = mistakesCount.toString()
            }

            R.id.button21 -> {
                if (numbersList[20] == ans) {
                    // 正解だったら見えなくする & ansを次の数に変更
                    binding.button21.visibility = View.INVISIBLE
                    ans += 1
                } else {
                    mistakesCount += 1
                }
                text.text = mistakesCount.toString()
            }
            R.id.button22 -> {
                if (numbersList[21] == ans) {
                    // 正解だったら見えなくする & ansを次の数に変更
                    binding.button22.visibility = View.INVISIBLE
                    ans += 1
                } else {
                    mistakesCount += 1
                }
                text.text = mistakesCount.toString()
            }
            R.id.button23 -> {
                if (numbersList[22] == ans) {
                    // 正解だったら見えなくする & ansを次の数に変更
                    binding.button23.visibility = View.INVISIBLE
                    ans += 1
                } else {
                    mistakesCount += 1
                }
                text.text = mistakesCount.toString()
            }
            R.id.button24 -> {
                if (numbersList[23] == ans) {
                    // 正解だったら見えなくする & ansを次の数に変更
                    binding.button24.visibility = View.INVISIBLE
                    ans += 1
                } else {
                    mistakesCount += 1
                }
                text.text = mistakesCount.toString()
            }
            R.id.button25 -> {
                if (numbersList[24] == ans) {
                    // 正解だったら見えなくする & ansを次の数に変更
                    binding.button25.visibility = View.INVISIBLE
                    ans += 1
                } else {
                    mistakesCount += 1
                }
                text.text = mistakesCount.toString()
            }
        }

        if (ans == 26) {
            binding.txTemp.text = "FINISH!!"
//            val dialogFragment = ResultDialogFragment()
//
//            dialogFragment.show(, "ResultDialogFragment")
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}