package com.example.tallerintel

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main2.*
import kotlinx.android.synthetic.main.activity_main2.btnRegresar
import kotlinx.android.synthetic.main.activity_main2.txtTexto
import kotlinx.android.synthetic.main.activity_main4.*
import kotlinx.android.synthetic.main.activity_main5.*
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity5 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main5)

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

        btnDividir.setOnClickListener {
            try {
                val Expresion =
                    ExpressionBuilder(txtDiv1.text.toString() + "/" + txtDiv2.text.toString()).build()
                val Resultado = Expresion.evaluate()
                val resultadoLargo = Resultado.toLong()
                if (Resultado == resultadoLargo.toDouble())
                    txtResultadoDiv.text = resultadoLargo.toString()
                else
                    txtResultadoDiv.text = Resultado.toString()
            } catch (e: Exception) {
                Log.d("Excepcion", "mensaje: " + e.message)
                txtResultadoDiv.text = "Error!"
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