package com.mprof.com

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val homeButton = findViewById(R.id.homeButton) as Button
        val profilButton = findViewById(R.id.profilButton) as Button
        val infoButton = findViewById(R.id.infoButton) as Button
        val sendMessageButton = findViewById(R.id.sendMessageButton) as Button
        val readMessageButton = findViewById(R.id.readMessageButton) as Button
        val goButton = findViewById(R.id.goButton) as Button
        goButton.setOnClickListener() {
            goToLogin()
        }
        homeButton.setOnClickListener() {
            goToUserHome()
        }
        profilButton.setOnClickListener() {
            goToUserProfil()
        }
        infoButton.setOnClickListener() {
            goToUserInfo()
        }
        sendMessageButton.setOnClickListener() {
            goToSendMessage()
        }
        readMessageButton.setOnClickListener() {
            goToReadMessage()
        }

    }
    fun goToLogin(){
        val loginIntent = Intent(this@MainActivity, LoginActivity::class.java)
        startActivity(loginIntent);
        finish();
    }
    fun goToUserHome(){
        val userHomeIntent = Intent(this@MainActivity, UserHomeActivity::class.java)
        startActivity(userHomeIntent);
//        finish();
    }
    fun goToUserProfil(){
        val userProfilIntent = Intent(this@MainActivity, UserProfilActivity::class.java)
        startActivity(userProfilIntent);
//        finish();
    }
    fun goToUserInfo(){
        val userInfoIntent = Intent(this@MainActivity, UserInfoActivity::class.java)
        startActivity(userInfoIntent);
//        finish();
    }
    fun goToSendMessage(){
        val sendMessageIntent = Intent(this@MainActivity, SendMessageActivity::class.java)
        startActivity(sendMessageIntent);
//        finish();
    }
    fun goToReadMessage(){
        val readMessageIntent = Intent(this@MainActivity, ReadMessageActivity::class.java)
        startActivity(readMessageIntent);
//        finish();
    }
}
