package com.example.tp_entrega

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.*
import com.example.tp_entrega.Modelos.Mascota

lateinit var diagnostico:EditText
lateinit var causas:EditText
lateinit var medicamentos:EditText
lateinit var tratamiento:EditText
lateinit var reposo:EditText
lateinit var spinnermedico:Spinner
lateinit var ingresodiagnostico:Button
var ListaRecuperada:ArrayList<Mascota> = ArrayList<Mascota>()

var contadorPedro:Int =0

class DiagnosticoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_diagnostico)
        inicializar()
        ingresodiagnostico.setOnClickListener(View.OnClickListener {

            if(contadorPedro<3){
                if(spinnermedico.equals("Pedro"))
                {
                    contadorPedro++
                }


            }
            else
            {
                Toast.makeText(this, "Pedro excedio su limite", Toast.LENGTH_SHORT).show()
            }
            Toast.makeText(this, "Diagnostico Cargado", Toast.LENGTH_SHORT).show()
            limpiarregistros()




        })
    }

    fun inicializar()
    {
        diagnostico=findViewById(R.id.e_d_diagnostico)
        causas=findViewById(R.id.e_d_causa)
        medicamentos=findViewById(R.id.e_d_medicamento)
        tratamiento=findViewById(R.id.e_d_tratamiento)
        reposo=findViewById(R.id.e_d_reposo)
        spinnermedico=findViewById(R.id.s_d_spinnermedico)
        ingresodiagnostico=findViewById(R.id.b_d_ingresodiagnostico)
        spinertipo()
        //ListaRecuperada=intent.getSerializableExtra("objMascota") as ArrayList<Mascota>
    }
    fun spinertipo()
    {
        var listaMedicos= arrayOf("Pedro","Juan")
        var adaptador= ArrayAdapter(this,android.R.layout.simple_spinner_item,listaMedicos)
        spinnermedico.adapter=adaptador
    }
    fun limpiarregistros()
    {
        diagnostico.setText("")
        causa.setText("")
        medicamentos.setText("")
        tratamiento.setText("")
        reposo.setText("")
    }
}