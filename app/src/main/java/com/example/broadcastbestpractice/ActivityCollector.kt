package com.example.broadcastbestpractice

import android.app.Activity
import java.util.ArrayList

/**
 * Activity管理器
 */
object ActivityCollector {
    //object数据类
    private val activities = ArrayList<Activity>()

    /**
     * 添加指定的Activity
     */
    fun addActivity(activity: Activity) {
        activities.add(activity)
    }

    /**
     * 移除指定的Activity
     */
    fun removeActivity(activity: Activity) {
        activities.remove(activity)
    }

    /**
     * 销毁所有的Activity
     */
    fun finishAll(activity: Activity) {
        for (activity in activities) {
            if (!activity.isFinishing) {
                activity.finish()
            }
        }
        activities.clear()
    }

}