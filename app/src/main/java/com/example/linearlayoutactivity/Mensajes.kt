package com.example.linearlayoutactivity

import android.content.Context
import android.view.View
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar

class Mensajes(var mensajes: String, var contexto: Context) {

    fun mostrarToast(){
        Toast.makeText(contexto, mensajes, Toast.LENGTH_LONG).show()
    }

    fun mostarSnackbar(miVista: View){
        Snackbar.make(miVista, mensajes, Snackbar.LENGTH_LONG).show()
    }
}