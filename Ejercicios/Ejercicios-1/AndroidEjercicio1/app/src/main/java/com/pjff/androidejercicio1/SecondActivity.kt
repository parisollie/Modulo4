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

        //Recibimos,usando la forma corta
        val name = intent.getStringExtra("EXTRA_NAME")
        val lastName = intent.getStringExtra("EXTRA_LASTNAME")
        val age = intent.getIntExtra("EXTRA_AGE", 0)
        val dir = intent.getStringExtra("EXTRA_DIR")
        val tel = intent.getIntExtra("EXTRA_TEL", 0)
        val sex = intent.getStringExtra("EXTRA_SEX")

        //Despliegamos la información
        val tvName = findViewById<TextView>(R.id.tvName)
        val tvLastname = findViewById<TextView>(R.id.tvLastname)
        val tvAge = findViewById<TextView>(R.id.tvAge)
        val tvDir = findViewById<TextView>(R.id.tvDir)
        val tvTel = findViewById<TextView>(R.id.tvTel)
        val tvSex = findViewById<TextView>(R.id.tvSexo)

        //Asignamos los valores
        tvName.text = name
        tvLastname.text = lastName
        //Concatenamos los valores para que los tóme
        //tvAge.text = "${age}"
        tvAge.text = age.toString()
        tvDir.text = dir
        tvTel.text = tel.toString()
        tvSex.text = sex

        val btBack = findViewById<Button>(R.id.btBack)

        btBack.setOnClickListener {
            val returnIntent = Intent().apply {
                putExtra("EXTRA_IS_OK", true)
            }
            //Set result regresar información
            setResult(RESULT_OK, returnIntent)
            finish()
        }

    }
}