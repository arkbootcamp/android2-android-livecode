package com.erdin.arkaandroidtwo.dialog

import android.app.AlertDialog
import android.app.DatePickerDialog
import android.app.Dialog
import android.content.DialogInterface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.erdin.arkaandroidtwo.R
import com.erdin.arkaandroidtwo.databinding.ActivityDialogBinding
import com.erdin.arkaandroidtwo.databinding.LayoutDialogThreeBinding

class DialogActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDialogBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_dialog)

        binding.btnShowDialogOne.setOnClickListener {
            showDialogOne()
        }

        binding.btnShowDialogTwo.setOnClickListener {
            showDialogTwo()
        }

        binding.btnShowDialogThree.setOnClickListener {
            showDialogThree()
        }

        binding.btnShowDialogFour.setOnClickListener {
            showDialogFour()
        }

        binding.btnShowDialogFive.setOnClickListener {
            showDialogFive()
        }

    }

    private fun showDialogOne() {
        val dialog = AlertDialog.Builder(this)
                .setTitle("Test Dialog One")
                .setMessage("Ini dialog satu")
                .create()
        dialog.show()
    }

    private fun showDialogTwo() {
        val dialog = AlertDialog.Builder(this)
                .setTitle("Konfirmasi User")
                .setMessage("Tolong konfirmasi")
                .setPositiveButton("Show Toast") { dialog:DialogInterface?, which: Int ->
                    Toast.makeText(this, "Show Dialog 2", Toast.LENGTH_SHORT).show()
                }
                .setNegativeButton("Dismiss") { dialogInterface, i ->
                    dialogInterface.dismiss()
                }
        dialog.show()
    }

    private fun showDialogThree() {
        val rootView = DataBindingUtil.inflate<LayoutDialogThreeBinding>(layoutInflater, R.layout.layout_dialog_three, null, false)

        val dialog = AlertDialog.Builder(this)
                .setView(rootView.root)
                .setCancelable(false)
                .create()
        dialog.show()
        rootView.btnOk.setOnClickListener {
            dialog.dismiss()
        }
    }

    private fun showDialogFour() {
        try {
            val dialogFragment = supportFragmentManager.findFragmentByTag(TestDialogFragment.TAG)
            if (dialogFragment != null) {
                supportFragmentManager.beginTransaction().remove(dialogFragment).commit()
            }

            TestDialogFragment().show(supportFragmentManager, TestDialogFragment.TAG)
        } catch (e: Throwable) {
            e.printStackTrace()
        }
    }

    private fun showDialogFive() {
        DatePickerDialog(this, { view, year, month, dayOfMonth ->
            // Action ketika di pilih tanggalnya

        }, 2020, 12, 12).show()
    }
}