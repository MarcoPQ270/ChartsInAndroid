package com.example.chartsandroid

import android.database.Cursor
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.github.mikephil.charting.data.BarData
import com.github.mikephil.charting.data.BarDataSet
import com.github.mikephil.charting.data.BarEntry

import kotlinx.android.synthetic.main.activity_charts.*

class ChartsActivity : AppCompatActivity() {

    val entries = ArrayList<BarEntry>()//variable para los datos a graficar
    val labels = ArrayList<String>()//estas son las etiquetas de los meses, se podria decir que es lo que se va graficar
    var cursor: Cursor? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_charts)
        cargarDatos()
        setBarChart()
    }
    fun cargarDatos(){
        val admin= adminBD(this)
        cursor=admin.Consulta("SELECT * FROM Empleado order by NomEmp")

    }
    fun setBarChart() {
        var i=0
        if(cursor!!.
                moveToFirst()){
            do {
                val nom = cursor!!.getString(1)
                val vtas = cursor!!.getFloat(2)
                entries.add(BarEntry(vtas, i))
                labels.add(nom)
                i++
            }while (cursor!!.moveToNext())
            val barDataSet = BarDataSet(entries, "Votos")
            val data = BarData(labels, barDataSet)
            barChart.data = data
            barChart.setDescription("Votos por candidato")
            barDataSet.color = resources.getColor(R.color.colorAccent)
            barChart.animateY(5000)
        }
    }
}
