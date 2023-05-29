package com.gkm.techconn.Modelo

import java.sql.Connection
import java.sql.DriverManager
import java.sql.SQLException

class ConeccionSqlServer {
    private val database:String="wcortes"
    private val user:String="nexo"
    private val password:String="Sh1ppud3n"
    private val url:String="jdbc:sqlserver://BODEGA-PC:1433;" +
            "databaseName=" + database + ";encrypt=true;trustServerCertificate=true;"
    private var con:Connection?=null

    fun establecerConeccion():Connection?{
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver")
            con = DriverManager.getConnection(url,user,password)
        }catch (e:ClassNotFoundException){
            e.printStackTrace()
        }catch (e:SQLException){
            e.printStackTrace()
        }
        return con
    }
}