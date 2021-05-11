package com.example.tallerintel

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnOpen.setOnClickListener {
            val intent: Intent = Intent(this, MainActivity2::class.java)
            intent.putExtra("valor","Hola Mundo")
            intent.putExtra("valor2", "Prueba")
            intent.putExtra("valor3", "jaja")
            //startActivity(intent)
            //finish()

            startActivityForResult(intent, 1)
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if(resultCode == RESULT_OK) {
            if(requestCode == 1) {
                val bundle = data?.extras
                if(bundle!=null){
                    val resultado = bundle.getString("resultado1")
                    Toast.makeText(this,resultado,Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}