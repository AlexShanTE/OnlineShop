package com.alex.sid.shante.onlineshop.presentation.ui.home.profilescreen

import android.content.Context
import android.widget.Toast
import androidx.lifecycle.ViewModel

class ProfileScreenViewModel: ViewModel() {

    fun makeToast(context: Context, message: String) {
        Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
    }

}