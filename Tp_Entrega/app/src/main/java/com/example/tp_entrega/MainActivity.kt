package com.example.tp_entrega

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.example.tp_entrega.Modelos.Mascota

lateinit var nombre:EditText
lateinit var tipo:Spinner
lateinit var raza:EditText
lateinit var edad:EditText
lateinit var causa:EditText
lateinit var ingresar:Button
lateinit var bdiagnostico:Button
var contador: Int =0
var ListaAnimal:ArrayList<Mascota> = ArrayList<Mascota>()

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        inicializar()
        ingresar.setOnClickListener(View.OnClickListener {
            if(contador<5) {

                contador++
                ListaAnimal.add(Mascota(nombre = nombre.toString(),tipo = tipo.toString(),raza = raza.toString(),edad = edad.toString(),causa = causa.toString()))
                Toast.makeText(this, "Mascota ingresada", Toast.LENGTH_SHORT).show()
                limpiarregistros()
            }
            else
                Toast.makeText(this, "Se excedio el limite diario, cargar diagnostico", Toast.LENGTH_SHORT).show()

            
        })

        bdiagnostico.setOnClickListener(View.OnClickListener {
            val intento: Intent = Intent(this, DiagnosticoActivity::class.java)
            startActivity(intento)
            intento.putExtra("objMascota", ListaAnimal)
        })


    }

    fun inicializar()
    {
        nombre=findViewById(R.id.e_m_nombre)
        tipo=findViewById(R.id.e_m_tipospinner)
        raza=findViewById(R.id.e_m_raza)
        edad=findViewById(R.id.e_m_edad)
        causa=findViewById(R.id.e_m_causa)
        ingresar=findViewById(R.id.e_m_ingresarMascota)
        bdiagnostico=findViewById(R.id.b_m_diagnostico)
        spinertipo()
    }
    fun spinertipo()
    {
        var listaMascotas= arrayOf("Conejo","Perro","Gato")
        var adaptador=ArrayAdapter(this,android.R.layout.simple_spinner_item,listaMascotas)
        tipo.adapter=adaptador
    }
    fun limpiarregistros()
    {
        nombre.setText("")
        raza.setText("")
        edad.setText("")
        causa.setText("")

    }
}