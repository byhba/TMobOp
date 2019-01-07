package com.mprof.com

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class UserHomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user_home)
    }
    fun deconnexion() {
        // clear local storage
        val LoginIntent = Intent(this@UserHomeActivity, LoginActivity::class.java)
        startActivity(LoginIntent)
        finish()
    }
    fun goToMessageList() {
        val MessageIntent = Intent(this@UserHomeActivity, ListMessageActivity::class.java)
        startActivity(MessageIntent)
    }
}
