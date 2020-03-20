package com.example.kotlinexamples

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity


class MainActivity : AppCompatActivity()  {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
var Imagenes = findViewById(R.id.Icono) as ImageView
        var spanishButton = findViewById(R.id.espaniolButton) as Button;
        var englishButton = findViewById(R.id.englishButton) as Button;
        var frenchButton = findViewById(R.id.frenchButton)as Button;
        var chineseButton = findViewById(R.id.chineseButton) as Button;
        var italianButton = findViewById(R.id.italianButton)as Button;


//OnClickListeners de los botones

        Imagenes.setImageResource(R.drawable.icono)

        spanishButton.setOnClickListener(View.OnClickListener {
            MoverEntreActivities()
            mensaje()


        })

        frenchButton.setOnClickListener{
            MoverEntreActivities()
            mensaje()
        }

        englishButton.setOnClickListener{
            MoverEntreActivities()
            mensaje()
        }

        italianButton.setOnClickListener{
            MoverEntreActivities()
            mensaje()
        }

        chineseButton.setOnClickListener{
            MoverEntreActivities()
            mensaje()
        }


    }

    private fun MoverEntreActivities() {
        val moverDeActivity = Intent(this, intentoMapa::class.java)
        startActivity(moverDeActivity)
    }

    private fun mensaje() {
        Toast.makeText(this, resources.getString(R.string.Saludo), Toast.LENGTH_LONG).show()
    }






}
