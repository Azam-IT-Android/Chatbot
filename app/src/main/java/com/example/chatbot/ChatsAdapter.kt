package com.example.chatbot

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.chatbot_chat_item.view.*
import kotlinx.android.synthetic.main.user_chat_item.view.*

class ChatsAdapter: RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    class UserChatViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)
    class ChatbotChatViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return if(viewType == USER_TYPE){
            val view = layoutInflater.inflate(R.layout.user_chat_item, parent, false)
            UserChatViewHolder(view)
        } else{
            val view = layoutInflater.inflate(R.layout.chatbot_chat_item, parent, false)
            ChatbotChatViewHolder(view)
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        val chatItem = chats[position]
        if(chatItem is UserItem){
            holder.itemView.message_text.text = chatItem.text
        } else if(chatItem is ChatbotItem){
            holder.itemView.chatbot_text.text = chatItem.text
        }
    }

    override fun getItemCount(): Int {
        return chats.size
    }

    companion object{
        const val USER_TYPE = 1
        const val CHATBOT_TYPE = 2
    }

    override fun getItemViewType(position: Int): Int {
        val chatItem = chats[position]
        if(chatItem is UserItem){
            return USER_TYPE
        }
        return CHATBOT_TYPE
    }
}