package com.mprof.com

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.content.Intent
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.miharisoa.mobileproject.Model.Address
import com.mprof.com.Model.Role
import com.mprof.com.Model.User
import com.mprof.com.Utils.doAsync


class SignupActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_signup)
        //val role = findViewById(R.id.role) as EditText
        val nom = findViewById(R.id.nom) as EditText
        val prenom = findViewById(R.id.prenom) as EditText
        val email = findViewById(R.id.email) as EditText
        val password = findViewById(R.id.password) as EditText
        val confirmPassword = findViewById(R.id.confirmPassword) as EditText
        val rue = findViewById(R.id.rue) as EditText
        val rue_num=findViewById(R.id.rue_num) as EditText
        val localite = findViewById(R.id.localite) as EditText
        val cp = findViewById(R.id.cp) as EditText
        val tel = findViewById(R.id.tel) as EditText
        //val birthdate = findViewById(R.id.birthdate) as EditText
        //val level = findViewById(R.id.level) as EditText
        val signupButton = findViewById(R.id.signupButton) as Button
        val cancelButton = findViewById(R.id.cancelButton) as Button
        cancelButton.setOnClickListener {goToLogin()}
        signupButton.setOnClickListener {
           // var srole = role.text.toString()
            var snom = nom.text.toString()
            var sprenom = prenom.text.toString()
            var semail = email.text.toString()
            var spassword = password.text.toString()
            var sconfirmPassword = confirmPassword.text.toString()
            var slocalite = localite.text.toString()
            var scp = cp.inputType
            var srue = rue.text.toString()
            var numrue = rue_num.inputType
            var stel = tel.inputType
            //var sbirthdate = birthdate.text.toString()
            //var slevel = level.text.toString()

            if( stel!= null &&    scp!= null && snom.isNotEmpty() && sprenom.isNotEmpty() && semail.isNotEmpty()
                && spassword.isNotEmpty() && sconfirmPassword.isNotEmpty() && slocalite.isNotEmpty() && srue.isNotEmpty()) {
                if (!spassword.equals(sconfirmPassword)) {
                    Toast.makeText(baseContext, "Password not matched", Toast.LENGTH_LONG).show()
                }else {
                    if(isEmailValid(semail)){
                        userSignUp( snom, sprenom, semail, spassword, sconfirmPassword, slocalite, scp, srue, stel,"")
                    }else{
                        Toast.makeText(baseContext, "invalid email!", Toast.LENGTH_LONG).show()
                    }
                }
            }else{
                Toast.makeText(baseContext, "Field requried!", Toast.LENGTH_LONG).show()
            }

            // Ininitalise the helper

            val mySQLiteHelper = DatabaseOpenHelper(this)
            //val role = Role(srole,"")
            val user = User(0,snom,sprenom, semail, srue,numrue,scp,slocalite,stel,"","")
            //mySQLiteHelper.addRole(role)
            doAsync {

                mySQLiteHelper.addUser(user)
            }.execute()

            Toast.makeText(baseContext, "process", Toast.LENGTH_LONG).show()
        }
    }
    fun goToLogin(){
        // val loginIntent = Intent(this@SingupActivity, LoginActivity::class.java)
        val loginIntent = Intent(this@SignupActivity, LoginActivity::class.java)
        startActivity(loginIntent);
        finish();
    }
//    fun goToList(){
//        val loginIntent = Intent(this@SingupActivity, UserHome::class.java)
//        startActivity(loginIntent);
//        finish();
//    }
    fun isEmailValid(email: String): Boolean {
        return email.contains("@")
    }
//    fun goHome() {
//        val loginIntent = Intent(this@SingupActivity, UserHome::class.java)
//        startActivity(loginIntent);
//        finish();
//    }
    fun userSignUp( snom: String, sprenom: String, semail: String,
                   spassword: String, sconfirmPassword: String, slocalite: String, scp: Int,
                   srue: String, stel: Int, slevel: String){
//        Toast("userSignUp")
        var isSuccessSignup : Boolean = false

        if(isSuccessSignup){
            goToLogin()
        } else {
//            Toast("Signup error. Try again.")
        }
    }
}
