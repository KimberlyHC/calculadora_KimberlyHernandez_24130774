package mx.itson.edu.calculadora

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        val cero = findViewById<Button>(R.id.btn0)
        val uno = findViewById<Button>(R.id.btn1)
        val dos = findViewById<Button>(R.id.btn2)
        val tres = findViewById<Button>(R.id.btn3)
        val cuatro = findViewById<Button>(R.id.btn4)
        val cinco = findViewById<Button>(R.id.btn5)
        val seis = findViewById<Button>(R.id.btn6)
        val siete = findViewById<Button>(R.id.btn7)
        val ocho = findViewById<Button>(R.id.btn8)
        val nueve = findViewById<Button>(R.id.btn9)
        val div = findViewById<Button>(R.id.btnDiv)
        val multi = findViewById<Button>(R.id.btnMult)
        val suma = findViewById<Button>(R.id.btnSuma)
        val resta = findViewById<Button>(R.id.btnResta)
        val result = findViewById<Button>(R.id.btnResult)
        val borrar = findViewById<Button>(R.id.btnBorrar)
        val mostrar = findViewById<TextView>(R.id.textView2)
        val mostrar2 = findViewById<TextView>(R.id.textView)


        cero.setOnClickListener {
            val num = mostrar.text.toString()
            val ant = fCero(num, "0")
            mostrar.setText(ant).toString()
        }

        uno.setOnClickListener {
            val num = mostrar.text.toString()
            val ant = fCero(num, "1")
            mostrar.setText(ant).toString()
        }

        dos.setOnClickListener {
            val num = mostrar.text.toString()
            val ant = fCero(num, "2")
            mostrar.setText(ant).toString()
        }

        tres.setOnClickListener {
            val num = mostrar.text.toString()
            val ant = fCero(num, "3")
            mostrar.setText(ant).toString()
        }

        cuatro.setOnClickListener {
            val num = mostrar.text.toString()
            val ant = fCero(num, "4")
            mostrar.setText(ant).toString()
        }

        cinco.setOnClickListener {
            val num = mostrar.text.toString()
            val ant = fCero(num, "5")
            mostrar.setText(ant).toString()
        }

        seis.setOnClickListener {
            val num = mostrar.text.toString()
            val ant = fCero(num, "6")
            mostrar.setText(ant).toString()
        }

        siete.setOnClickListener {
            val num = mostrar.text.toString()
            val ant = fCero(num, "7")
            mostrar.setText(ant).toString()
        }

        ocho.setOnClickListener {
            val num = mostrar.text.toString()
            val ant = fCero(num, "8")
            mostrar.setText(ant).toString()
        }

        nueve.setOnClickListener {
            val num = mostrar.text.toString()
            val ant = fCero(num, "9")
            mostrar.setText(ant).toString()
        }

        div.setOnClickListener {
            val num = mostrar.text.toString()
            val res = operacion(num,"/")
            mostrar2.setText(res).toString()
            mostrar.setText("0").toString()
        }

        multi.setOnClickListener {
            var num = mostrar.text.toString()
            val res = operacion(num,"*")
            mostrar2.setText(res).toString()
            mostrar.setText("0").toString()
        }

        suma.setOnClickListener {
            val num = mostrar.text.toString()
            val res = operacion(num,"+")
            mostrar2.setText(res).toString()
            mostrar.setText("0").toString()
        }

        resta.setOnClickListener {
            val num = mostrar.text.toString()
            val res = operacion(num,"-")
            mostrar2.setText(res).toString()
            mostrar.setText("0").toString()
        }

        result.setOnClickListener {
            val expresion = mostrar2.text.toString() + mostrar.text.toString()
            val resultado = calcularResultado(expresion)

            mostrar2.text = resultado.toString()
            mostrar.text = "0"

        }

        borrar.setOnClickListener {
            mostrar.setText("0").toString()
            mostrar2.setText("").toString()
        }
    }

    fun fCero(num:String, num1:String):String{
        if(num.toIntOrNull() == 0){
            return num1
        }else {
            return num + num1
        }
    }

    fun operacion(num:String, operador:String):String{

        return num+operador
    }

    fun calcularResultado(expresion: String): Double {
        return try {
            val elementos = expresion.split("(?<=[-+*/])|(?=[-+*/])".toRegex())
            var resultado = elementos[0].toDouble()

            var i = 1
            while (i < elementos.size) {
                val operador = elementos[i]
                val numero = elementos[i + 1].toDouble()

                resultado = when (operador) {
                    "+" -> resultado + numero
                    "-" -> resultado - numero
                    "*" -> resultado * numero
                    "/" -> resultado / numero
                    else -> resultado
                }
                i += 2
            }

            resultado
        } catch (e: Exception) {
            0.0
        }
    }


}