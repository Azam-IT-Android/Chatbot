package com.example.chatbot

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        chat_list.adapter = ChatsAdapter()
        chat_list.layoutManager = LinearLayoutManager(this)

        send.setOnClickListener {
            val text = message.text.toString()
            if(text.isNotEmpty()){
                chats.add(UserItem(text))
                chat_list.adapter?.notifyDataSetChanged()
            }
        }
    }
}