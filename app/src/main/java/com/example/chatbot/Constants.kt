package com.example.chatbot

class UserItem(val text: String)
class ChatbotItem(val text: String)

val chats = arrayListOf<Any>(
    ChatbotItem("Hi There!, Welcome"),
    ChatbotItem("How can I help you?"),
    UserItem("Can you tell me something about Italy")
)