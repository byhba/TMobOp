package com.mprof.com

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import com.mprof.com.Model.Role
import com.mprof.com.Utils.doAsync

class DatabaseOpenHelper (context: Context):
SQLiteOpenHelper(context, DB_NAME, null, DB_VERSION)  {
    override fun onCreate(db: SQLiteDatabase?) {
    // Create tables role
        doAsync {
            db?.execSQL(DB_CREATE_TABLE_ROLE)
        }.execute()
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        doAsync {
            db?.execSQL(DB_DELETE_ROLE_ENTRIES)
            onCreate(db)
        }.execute()
        }

    //Inserting (Creating) data
    fun addUser(role: Role): Boolean {
        //Create and/or open a database that will be used for reading and writing.
        val db = this.writableDatabase
        val values = ContentValues()
        values.put(RoleTable.COLUMN_NAME, role.role_name)
        values.put(RoleTable.COLUMN_DESC, role.description)
        val _success = db.insert(RoleTable.TABLE_NAME, null, values)
        db.close()
        Log.v("InsertedID", "$_success")
        return (Integer.parseInt("$_success") != -1)
    }

    companion object {
        val DB_VERSION = 1
        val DB_NAME = "MProf.db"
        //private val TABLE_USER = "users"
        //private val TABLE_ROLE = "role"
        //private val TABLE_ADDRESS = "address"
        //private val TABLE__DISCIPLINE = "discipline"

        private val DB_CREATE_TABLE_ROLE = "CREATE TABLE " + RoleTable.TABLE_NAME + "("+
                RoleTable.COLUMN_ID + " INTEGER PRIMARY KEY," +
                RoleTable.COLUMN_NAME +" TEXT NOT NULL," +
                RoleTable.COLUMN_DESC +" TEXT);"

        private val DB_DELETE_ROLE_ENTRIES = "DROP TABLE IF EXISTS" + RoleTable.TABLE_NAME
    }
}