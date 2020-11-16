package com.example.broadcastbestpractice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        LoginButton.setOnClickListener {
            val id:CharSequence=UserID.text.trim().toString()
            val pwd:String=UserPwd.text.trim().toString()
            if (id=="1621853164"&&pwd=="123456"){
                val intent= Intent(this,MainActivity::class.java)
                startActivity(intent)
                finish()
            }else{
                Toast.makeText(this,"QQ号码或密码错误,请重试",Toast.LENGTH_LONG).show()
            }
        }
    }
}