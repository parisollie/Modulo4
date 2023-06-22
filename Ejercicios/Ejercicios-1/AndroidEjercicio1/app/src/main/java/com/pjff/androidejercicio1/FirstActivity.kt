package com.pjff.androidejercicio1

import android.app.Instrumentation.ActivityResult
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts

class FirstActivity : AppCompatActivity() {

    private val register = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){ result ->
        if (result.resultCode == RESULT_OK){
            Toast.makeText(this, "resultCode = ${result.resultCode} EXTRA_IS_OK = ${result.data?.getBooleanExtra("EXTRA_IS_OK", false)}", Toast.LENGTH_LONG).show()
        }else{
            Toast.makeText(this, "CANCELLED", Toast.LENGTH_LONG).show()
        }
    }



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_first)

        //Instancia de nuestro botón
        val btCall = findViewById<Button>(R.id.btCall)

        btCall.setOnClickListener{
            val secondIntent = Intent(this,SecondActivity::class.java).apply {
                putExtra("EXTRA_NAME","Paul")
                putExtra("EXTRA_LASTNAME","Felix Flores")
                putExtra("EXTRA_AGE",33)
                putExtra("EXTRA_DIR","Aldea de la arena")
                putExtra("EXTRA_TEL",12345678)
                putExtra("EXTRA_SEX","M")
            }
            // startActivity(secondIntent)
            register.launch(secondIntent)
        }
    }
}