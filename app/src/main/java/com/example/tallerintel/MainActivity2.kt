package com.example.tallerintel

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main2.*
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        val bundle = intent.extras

        if(bundle != null){
            val texto = bundle.getString("valor")
            txtTexto.text = texto

            val valor2 =bundle.getString("valor2")
            Toast.makeText(this,valor2,Toast.LENGTH_SHORT).show()

            /*val valor3 =bundle.getString("valor3")

            if(valor3 != null) {
                Toast.makeText(this,valor3,Toast.LENGTH_SHORT).show()
            } */

            val valor3 =bundle.getString("valor3", "no hay valor")
            Toast.makeText(this,valor3,Toast.LENGTH_SHORT).show()
        }

        btnSumar.setOnClickListener {
            try {
                val Expresion = ExpressionBuilder(txtSuma1.text.toString() + "+" + txtSuma2.text.toString()).build()
                val Resultado = Expresion.evaluate()
                val resultadoLargo = Resultado.toLong()
                if(Resultado==resultadoLargo.toDouble())
                    txtResultadoSum.text = resultadoLargo.toString()
                else
                    txtResultadoSum.text = Resultado.toString()
            } catch (e:Exception) {
                Log.d("Excepcion", "mensaje: " + e.message)
                txtResultadoSum.text = "Error!"
                //txtSuma1.text = ""
            }

        }

        btnRegresar.setOnClickListener{
            val intent: Intent = Intent()
            intent.putExtra("resultado1", "pagina de inicio")
            setResult(RESULT_OK, intent)
            finish()
        }
    }
}