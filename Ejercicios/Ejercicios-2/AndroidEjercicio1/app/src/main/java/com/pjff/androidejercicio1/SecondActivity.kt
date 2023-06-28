package com.pjff.androidejercicio1

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)
        //Recibimos,usando forma corta

        val name = intent.getStringExtra("EXTRA_NAME")
        val lastName = intent.getStringExtra("EXTRA_LASTNAME")
        val age = intent.getIntExtra("EXTRA_AGE", 0)

        //Despliegamos la informacion

        val tvName = findViewById<TextView>(R.id.tvName)
        val tvLastname = findViewById<TextView>(R.id.tvLastname)
        val tvAge = findViewById<TextView>(R.id.tvAge)

        //Asiganamos los valores

        tvName.text = name
        tvLastname.text = lastName
        //Concatenamos los valores para que los tome
        //tvAge.text = "${age}"
        tvAge.text = age.toString()

        val btBack = findViewById<Button>(R.id.btBack)

        btBack.setOnClickListener {
            val returnIntent = Intent().apply {
                putExtra("EXTRA_IS_OK", true)
            }
            //Set result regresar informacion
            setResult(RESULT_OK, returnIntent)
            finish()
        }

    }
}