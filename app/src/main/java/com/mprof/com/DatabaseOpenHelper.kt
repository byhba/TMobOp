package com.mprof.com

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import com.example.miharisoa.mobileproject.Model.Address
import com.mprof.com.Model.Role
import com.mprof.com.Utils.doAsync

class DatabaseOpenHelper (context: Context):
SQLiteOpenHelper(context, DB_NAME, null, DB_VERSION)  {
    override fun onCreate(db: SQLiteDatabase?) {
    // Create tables role

            db!!.execSQL(DB_CREATE_TABLE_ROLE)
            db!!.execSQL(DB_CREATE_TABLE_ADDRESS)


    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

            db?.execSQL(DB_DELETE_ROLE_ENTRIES)
            db?.execSQL(DB_DELETE_ADRESS_ENTRIES)
            onCreate(db)

        }

    //Inserting (Creating) a role
    fun addRole(role: Role): Boolean {
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

    //Insert address
    fun addAddress(adr: Address): Boolean {
        //Create and/or open a database that will be used for reading and writing.
        val db = this.writableDatabase
        val values = ContentValues()
        values.put(AddressTable.COLUMN_NAME, adr.street_name)
        values.put(AddressTable.COLUMN_NUMBER, adr.street_nb)
        values.put(AddressTable.COLUMN_CITY,adr.city)
        values.put(AddressTable.COLUMN_ZIP,adr.zip_code)
        values.put(AddressTable.COLUMN_CANTON,adr.canton)
        values.put(AddressTable.COLUMN_COUNTRY,adr.country)
        val _success = db.insert(AddressTable.TABLE_NAME, null, values)
        //db.close()
        Log.v("InsertedID", "$_success")
        return (Integer.parseInt("$_success") != -1)
    }

    companion object {
        val DB_VERSION = 1
        val DB_NAME = "MProf.db"

        //Pour la creation de la table role
        private val DB_CREATE_TABLE_ROLE = "CREATE TABLE " + RoleTable.TABLE_NAME + "("+
                RoleTable.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                RoleTable.COLUMN_NAME +" TEXT NOT NULL," +
                RoleTable.COLUMN_DESC +" TEXT);"

        private val DB_DELETE_ROLE_ENTRIES = "DROP TABLE IF EXISTS" + RoleTable.TABLE_NAME

        //Pour la creation de la table Address
        private val DB_CREATE_TABLE_ADDRESS = "CREATE TABLE " + AddressTable.TABLE_NAME + "("+
                AddressTable.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                AddressTable.COLUMN_NAME +" TEXT NOT NULL," +
                AddressTable.COLUMN_NUMBER +" TEXT NOT NULL,"+
                AddressTable.COLUMN_CITY + " TEXT NOT NULL,"+
                AddressTable.COLUMN_ZIP + " TEXT NOT NULL," +
                AddressTable.COLUMN_CANTON + " TEXT ," +
                AddressTable.COLUMN_COUNTRY + " TEXT);"


        private val DB_DELETE_ADRESS_ENTRIES = "DROP TABLE IF EXISTS" + AddressTable.TABLE_NAME


    }
}