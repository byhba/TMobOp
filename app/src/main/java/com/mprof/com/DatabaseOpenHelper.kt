package com.mprof.com

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import android.util.Log
import com.example.miharisoa.mobileproject.Model.Address
import com.mprof.com.Model.Role
import com.mprof.com.Model.User
import com.mprof.com.Utils.doAsync

class DatabaseOpenHelper (context: Context):
SQLiteOpenHelper(context, DB_NAME, null, DB_VERSION)  {
    override fun onCreate(db: SQLiteDatabase?) {
    // Create tables user

            db!!.execSQL(DB_CREATE_TABLE_USER)
           // db!!.execSQL(DB_CREATE_TABLE_ADDRESS)


    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {

            db?.execSQL(DB_DELETE_USER_ENTRIES)
           // db?.execSQL(DB_DELETE_ADRESS_ENTRIES)
            onCreate(db)

        }

    //Inserting (Creating) a user
    fun addUser(user: User): Boolean {
        //Create and/or open a database that will be used for reading and writing.
        val db = this.writableDatabase
        val values = ContentValues()
        values.put(UserTable.COLUMN_NAME, user.name)
        values.put(UserTable.COLUMN_FNAME, user.fname)
        values.put(UserTable.COLUMN_EMAIL, user.email)
        values.put(UserTable.COLUMN_STREETNAME, user.street_name)
        values.put(UserTable.COLUMN_NUMBER, user.street_nb)
        values.put(UserTable.COLUMN_ZIP, user.zip_code)
        values.put(UserTable.COLUMN_CITY, user.city)
        values.put(UserTable.COLUMN_NAME, user.fname)
        values.put(UserTable.COLUMN_TEL, user.tel)
        values.put(UserTable.COLUMN_PASS, user.pass)
        values.put(UserTable.COLUMN_ROLE, user.role)

        val _success = db.insert(UserTable.TABLE_NAME, null, values)
        db.close()
        Log.v("InsertedID", "$_success")
        return (Integer.parseInt("$_success") != -1)
    }

    /*Insert address
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
    }*/

    companion object {
        val DB_VERSION = 1
        val DB_NAME = "MProf.db"

        //Pour la creation de la table user
        private val DB_CREATE_TABLE_USER = "CREATE TABLE " + UserTable.TABLE_NAME + "("+
                UserTable.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                UserTable.COLUMN_NAME +" TEXT NOT NULL," +
                UserTable.COLUMN_FNAME +" TEXT NOT NULL," +
                UserTable.COLUMN_EMAIL +" TEXT NOT NULL," +
                UserTable.COLUMN_STREETNAME +" TEXT NOT NULL," +
                UserTable.COLUMN_NUMBER +" TEXT NOT NULL," +
                UserTable.COLUMN_ZIP +" TEXT NOT NULL," +
                UserTable.COLUMN_CITY+" TEXT NOT NULL," +
                UserTable.COLUMN_TEL +" TEXT NOT NULL," +
                UserTable.COLUMN_PASS+" TEXT NOT NULL," +
                UserTable.COLUMN_ROLE+" TEXT NOT NULL);"

        private val DB_DELETE_USER_ENTRIES = "DROP TABLE IF EXISTS" + UserTable.TABLE_NAME

        /*Pour la creation de la table Address
        private val DB_CREATE_TABLE_ADDRESS = "CREATE TABLE " + AddressTable.TABLE_NAME + "("+
                AddressTable.COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                AddressTable.COLUMN_NAME +" TEXT NOT NULL," +
                AddressTable.COLUMN_NUMBER +" TEXT NOT NULL,"+
                AddressTable.COLUMN_CITY + " TEXT NOT NULL,"+
                AddressTable.COLUMN_ZIP + " TEXT NOT NULL," +
                AddressTable.COLUMN_CANTON + " TEXT ," +
                AddressTable.COLUMN_COUNTRY + " TEXT);"


        private val DB_DELETE_ADRESS_ENTRIES = "DROP TABLE IF EXISTS" + AddressTable.TABLE_NAME*/


    }
}