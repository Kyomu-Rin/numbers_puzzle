package com.kyomurin.android.numberspuzzle

import android.app.AlertDialog
import android.app.Dialog
import android.content.DialogInterface
import android.os.Bundle
import androidx.fragment.app.DialogFragment

class ResultDialogFragment : DialogFragment() {
    override fun onCreateDialog(savedInstanceState: Bundle?): Dialog {
        val dialog = activity?.let {
            val builder = AlertDialog.Builder(it)

            builder.setTitle(R.string.dialog_title)

            builder.setMessage(R.string.dialog_massage)

            builder.setPositiveButton(R.string.return_button_text, DialogButtonClickListener())

            builder.create()
        }

        return dialog ?: throw IllegalStateException("アクティビティがnullです")
    }

    private inner class DialogButtonClickListener : DialogInterface.OnClickListener {
        override fun onClick(dialog: DialogInterface?, which: Int) {

        }
    }
}