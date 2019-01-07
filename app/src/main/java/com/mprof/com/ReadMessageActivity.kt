package com.mprof.com

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class ReadMessageActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_read_message)
        val repButton = findViewById(R.id.repButton) as Button
        repButton.setOnClickListener() {
            goToSendMessage()
        }

    }
    fun goToSendMessage(){
        val sendMessageIntent = Intent(this@ReadMessageActivity, SendMessageActivity::class.java)
        startActivity(sendMessageIntent);
//        finish();
    }
}
