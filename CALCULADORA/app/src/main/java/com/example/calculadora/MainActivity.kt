package com.example.calculadora

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.calculadora.ui.theme.CalculadoraTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {

        }



    }
}

@Composable
fun Calculadora(){


    var operador = readLine()!!.trim().toString()
    var numero1: Double = readLine()!!.trim().toDouble()
    var numero2: Double = readLine()!!.trim().toDouble()



    var resultat = when (operador){

        "+" -> Sumar(numero1, numero2)
        "-" -> Restar(numero1,numero2)
        "*" -> Multiplicar(numero1,numero2)
        "/" -> Dividir(numero1,numero2)
        else -> MostrarError()
    }

}


fun Sumar(numero1: Double, numero2: Double): Double{
    return numero1 + numero2
}
fun Restar(numero1: Double, numero2: Double): Double{
    return  numero1 + numero2
}
fun Multiplicar(numero1: Double, numero2: Double): Double{
    return  numero1 * numero2
}
fun Dividir(numero1: Double, numero2: Double): Double{
    return numero1/numero2
}
@Composable
fun MostrarError(){
    Column (
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Center
    ){
        Text(text = "Error de la calculadora")
    }
}




/*
@Composable
fun Hola(){
    Column (
        modifier = Modifier.fillMaxSize().padding(16.dp),
        verticalArrangement = Arrangement.Top

    ){
        Text(text = "hola")
    }
}
*/

/*
@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    CalculadoraTheme {
        Greeting("Android")
    }
}*/