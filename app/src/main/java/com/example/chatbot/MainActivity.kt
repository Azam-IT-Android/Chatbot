package com.example.chatbot

import android.Manifest.permission.RECEIVE_SMS
import android.content.IntentFilter
import android.content.pm.PackageManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.chatbot.SmsReceiver.Companion.SMS_RECEIVED
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        chat_list.adapter = ChatsAdapter()
        chat_list.layoutManager = LinearLayoutManager(this)

        send.setOnClickListener {
            val text = message.text.toString()
            if (text.isNotEmpty()) {
                chats.add(UserItem(text))
                chat_list.adapter?.notifyDataSetChanged()
            }
        }

        if (ContextCompat.checkSelfPermission(this, RECEIVE_SMS) == PackageManager.PERMISSION_DENIED) {
            ActivityCompat.requestPermissions(this, arrayOf(RECEIVE_SMS), 10)
        } else{
            registerSmsReceiver()
        }

    }

    override fun onRequestPermissionsResult(requestCode: Int, permissions: Array<out String>, grantResults: IntArray) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults)

        if (permissions.isNotEmpty()
                && permissions[0] == RECEIVE_SMS
                && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
            registerSmsReceiver()
        }

    }

    fun registerSmsReceiver() {
        val intentFilter = IntentFilter()
        intentFilter.addAction(SMS_RECEIVED)
        registerReceiver(SmsReceiver(), intentFilter)
    }
}