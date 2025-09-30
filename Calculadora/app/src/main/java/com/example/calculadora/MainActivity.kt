package com.example.calculadora

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity

class  MainActivity : AppCompatActivity() {
///
    private lateinit var textoPantalla: TextView
    private var numero1: Double = 0.0
    private var numero2: Double = 0.0
    private var operador: String = ""
    private var nuevoNumero: Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        textoPantalla = findViewById(R.id.textoPantalla)


        // EL BOTON PULSADO SE MOSTRARA POR LA PANTALLA

        var botonesNumeros = listOf(R.id.boton0, R.id.boton1, R.id.boton2, R.id.boton3,
                    R.id.boton4, R.id.boton5, R.id.boton6, R.id.boton7, R.id.boton8, R.id.boton9)

        // Escribimos todos los numeros pulsados por pantalla
        for (id in botonesNumeros) {
            var boton: Button = findViewById(id)
            boton.setOnClickListener {
                escribirNumero(boton.text.toString())
            }
        }

        // Encontramos los botones por su ID y lo guardamos en cada variable (los de calcular).
        var botonSumar: Button = findViewById(R.id.botonSumar)
        var botonRestar: Button = findViewById(R.id.botonRestar)
        var botonMultiplicar: Button = findViewById(R.id.botonMultiplicar)
        var botonIgual: Button = findViewById(R.id.botonIgual)
        var botonDividir: Button = findViewById(R.id.botonDividir)
        var botonBorrar: Button = findViewById(R.id.botonBorrar)


        // Listeners de cada operación, pone todos los valores en sus variables generales
        botonSumar.setOnClickListener { guardarNumeroPantalla("+") }
        botonRestar.setOnClickListener { guardarNumeroPantalla("-") }
        botonMultiplicar.setOnClickListener { guardarNumeroPantalla("*") }
        botonDividir.setOnClickListener { guardarNumeroPantalla("/") }
        // Calculamos con lo que hay en numero1 y numero 2(este es lo ultimo que tenemos en pantalla)
        botonIgual.setOnClickListener { calcular() }

        // Resete de todo
        botonBorrar.setOnClickListener {
            textoPantalla.text = "0"
            numero1 = 0.0
            numero2 = 0.0
            operador = ""
            nuevoNumero = true
        }
    }


    // Solo falta que pueda sumar varios numero no solo dos si es posible sino no.
    private fun escribirNumero(numero: String) {
        if (nuevoNumero) {
            textoPantalla.text = numero
            nuevoNumero = false
        } else textoPantalla.text = textoPantalla.text.toString() + numero // Si no es un numero nuevo se concatena con lo que hay

    }

    // GUARDA EL NUMERO QUE HABÍA POR PANTALLA PARA HACER LA OPERACION CON EL SIGUIENTE NUMERO
    private fun guardarNumeroPantalla(op: String) {
        numero1 = textoPantalla.text.toString().toDouble()
        operador = op
        nuevoNumero = true
    }

    private fun calcular() {
        numero2 = textoPantalla.text.toString().toDouble() // sera lo ultimo que se muestra en la pantalla
        val resultado = when (operador) {
            "+" -> numero1 + numero2
            "-" -> numero1 - numero2
            "*" -> numero1 * numero2
            "/" -> numero1 / numero2
            else -> 0.0
        }
        textoPantalla.text = resultado.toString() // Mostramos
        nuevoNumero = true
    }
}
