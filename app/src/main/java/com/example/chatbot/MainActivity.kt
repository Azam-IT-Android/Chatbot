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

class MainActivity : AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        chat_list.adapter = ChatsAdapter{
            val chatbotApi = ChatbotApi()
            val response = chatbotApi.processOption(it)
            chats.add(ChatbotItem(response))
            chat_list.adapter?.notifyDataSetChanged()
        }
        chat_list.layoutManager = LinearLayoutManager(this)

        send.setOnClickListener {
            val text = message.text.toString()
            if (text.isNotEmpty()) {
                chats.add(UserItem(text))
                chat_list.adapter?.notifyDataSetChanged()
            }
        }

    }

}