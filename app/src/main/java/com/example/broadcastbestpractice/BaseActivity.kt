package com.example.broadcastbestpractice

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.os.Bundle
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity

open class BaseActivity : AppCompatActivity() {
    lateinit var receiver: BroadcastReceiver

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //凡是继承本类的Activity均会被加入Activity管理器中
        ActivityCollector.addActivity(this)
    }

    /**
     * 处于栈项时，注册广播
     */
    override fun onResume() {
        super.onResume()
        val intentFilter = IntentFilter("com.example.broadcastbestpractice.FORCS_OFFLINE")
        receiver = ForceOfflineReceiver()
        registerReceiver(receiver, intentFilter)
    }

    /**
     * 离开栈项则取消广播注册
     */
    override fun onPause() {
        super.onPause()
        unregisterReceiver(receiver)
    }

    override fun onDestroy() {
        super.onDestroy()
        ActivityCollector.removeActivity(this)
    }

    inner class ForceOfflineReceiver : BroadcastReceiver() {
        override fun onReceive(context: Context, intent: Intent) {
            AlertDialog.Builder(context).apply {
                setTitle("强制下线通知")
                setMessage("您已被下线，如果非本人操作，请尽快更改密码")
                setCancelable(false)
                setPositiveButton("确定") { _, _ ->
                    //重新开启登录界面
                    ActivityCollector.finishAll()
                    val i = Intent(context, LoginActivity::class.java)
                    context.startActivity(i)
                }
                show()
            }

//            val a = AlertDialog.Builder(context)
//            a. setTitle("强制下线通知")
//            a. setMessage("您已被下线，如果非本人操作，请尽快更改密码")
//            a.setCancelable(false)
//            a. setPositiveButton("确定") { _, _ ->
//                //重新开启登录界面
//                ActivityCollector.finishAll()
//                val i = Intent(context, LoginActivity::class.java)
//                context.startActivity(i)
//            }
//            a.show()
        }
    }


}