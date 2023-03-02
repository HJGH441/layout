package com.example.linearlayoutactivity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.google.android.material.snackbar.Snackbar

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private var bnSuma : Button? = null
    private var bnResta : Button? = null
    private var bnDividir : Button? = null
    private var bnMultiplicar : Button? = null
    private var etNumeroPrimero : EditText? = null
    private var etNumeroSegundo : EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        inivistas()
        asignareventos()
    }
    private fun inivistas(){
        bnSuma = findViewById(R.id.bnSuma)
        bnResta = findViewById(R.id.bnResta)
        etNumeroPrimero = findViewById(R.id.etNumeroPrimero)
        etNumeroSegundo = findViewById(R.id.etNumeroSegundo)
        bnMultiplicar = findViewById(R.id.bnMultiplicar)
        bnDividir = findViewById(R.id.bnDividir)
    }
    private fun asignareventos(){
        bnSuma?.setOnClickListener(this)
        bnResta?.setOnClickListener(this)
        bnMultiplicar?.setOnClickListener(this)
        bnDividir?.setOnClickListener(this)

    }

    override fun onClick(p0: View?) {
        //Clicks de las vistas :)
        val nymeroUno = etNumeroPrimero?.text.toString().toFloatOrNull()
        val nymeroDos = etNumeroSegundo?.text.toString().toFloatOrNull()


        val aritmetica = Aritmetica()

        when(p0?.id){
            R.id.bnSuma -> {
                if (nymeroUno != null && nymeroDos != null) {
                    val suma = aritmetica.suma(nymeroUno, nymeroDos)
                    val mensajes = Mensajes("La sumateria fue: $suma", this)
                    mensajes.mostrarToast()
                }
            }

            R.id.bnResta -> {
                if (nymeroUno != null && nymeroDos != null) {
                    val resta = aritmetica.resta(nymeroUno, nymeroDos)
                    Snackbar.make(p0, "La resta es: $resta", Snackbar.LENGTH_LONG).show()
                    val mensajes = Mensajes("El resultado es : $resta", this)
                    mensajes.mostarSnackbar(p0)
                }

            }
            R.id.bnMultiplicar -> {
                if (nymeroUno != null && nymeroDos != null) {
                    val multi = aritmetica.multiplicacion(nymeroUno, nymeroDos)
                    val mensajes = Mensajes("La multiplicacion fue: $multi", this)
                    mensajes.mostrarToast()
                }
            }
            R.id.bnDividir -> {
                if (nymeroUno != null && nymeroDos != null) {
                    val divi = aritmetica.division(nymeroUno, nymeroDos)
                    val mensajes = Mensajes("La division fue: $divi", this)
                    mensajes.mostrarToast()
                }
            }
        }
    }
}