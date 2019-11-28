package com.example.chartsandroid

import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import java.lang.Exception

class adminBD (context: Context):SQLiteOpenHelper(context,DATABASE,null,1){
    companion object{
        val DATABASE="Ventas"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        db?.execSQL(
            "Create Table Empleado(" +
                    "_id integer primary key, " +
                    "NomEmp text, " +
                    "Ventas float)"
        )
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {

    }

    fun Ejecuta(sentencia: String):Int{
        try {
            val db=this.writableDatabase //se abre la base de datos en modo de escritura y lectura
            db.execSQL(sentencia)
            db.close()
            return 1
        }
        catch (ex: Exception){
            return 0
        }
    }

    fun Consulta(select: String): Cursor?{
        try {
            val db=this.readableDatabase
            return db.rawQuery(select,null)
        }
        catch (ex: Exception){
            return null
        }
    }
}