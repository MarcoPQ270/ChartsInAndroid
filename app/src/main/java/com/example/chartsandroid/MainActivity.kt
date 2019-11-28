package com.example.chartsandroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
    fun guardarClic(v: View){
        if(etNom.text.isEmpty()||etVtas.text.isEmpty()){
            Toast.makeText(this, "Faltan campos por llenar", Toast.LENGTH_SHORT).show();
            etNom.requestFocus()
        }else{
            val admin = adminBD(this)
            val nom=etNom.text.toString()
            val vta=etVtas.text.toString().toFloat()
            val sentencia="INSERT INTO Empleado(NomEmp, Ventas)VALUES('${nom}',${vta});"
            if(admin.Ejecuta(sentencia)==1){
                Toast.makeText(this, "Empleado guardado", Toast.LENGTH_SHORT).show();
                etNom.setText("")
                etVtas.setText("0")
                etNom.requestFocus()
            }else{
                Toast.makeText(this, "Error de capa 8 no guardo", Toast.LENGTH_SHORT).show();
            }

        }
    }

    fun btngraficar(v: View){
        val intgraf= Intent(this, ChartsActivity::class.java)
        startActivity(intgraf)
    }
}
