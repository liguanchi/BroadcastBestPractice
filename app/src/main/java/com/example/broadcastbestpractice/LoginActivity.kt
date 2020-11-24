package com.example.broadcastbestpractice

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.PersistableBundle
import android.widget.Toast
import androidx.core.content.edit
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : BaseActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val sp =  getSharedPreferences("sp_pwd", Context.MODE_PRIVATE)
        val isRemember = sp.getBoolean("remember_pwd",false)
        if (isRemember){
            val id = sp.getString("user_id","")
            val pwd = sp.getString("user_pwd","")
            UserID.setText(id)
            UserPwd.setText(pwd)
            RememberPwd.isChecked = true
        }


        LoginButton.setOnClickListener {
            val id:CharSequence=UserID.text.trim().toString()
            val pwd:String=UserPwd.text.trim().toString()
            if (id=="1621853164"&&pwd=="123456"){
                val sp = getSharedPreferences("sp_pwd", Context.MODE_PRIVATE).edit()
                if (RememberPwd.isChecked){
                    getSharedPreferences("sp_pwd", Context.MODE_PRIVATE)
                        sp.putBoolean("remember_pwd",true)
                        sp.putString("user_id", id.toString())
                        sp.putString("user_pwd", pwd)
                }else{
                    sp.clear()
                }
                sp.apply()
                val intent= Intent(this,MainActivity::class.java)
                startActivity(intent)
                finish()
            }else{
                Toast.makeText(this,"QQ号码或密码错误,请重试",Toast.LENGTH_LONG).show()
            }
        }







    }
}