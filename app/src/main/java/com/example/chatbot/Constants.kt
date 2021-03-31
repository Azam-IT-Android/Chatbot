package com.example.chatbot

class UserItem(val text: String)
class ChatbotItem(val text: String)
class QuestionItem(val question: String,
                   val options: Array<String>)

val chats = arrayListOf<Any>(
        QuestionItem(
                "Hi, Welcome to Fundraiser",
                arrayOf(
                        "Write code to check a String is palindrome or not?",
                        "Write a method which will remove any given character from a String?",
                        "How do you find middle element of a linked list in a single pass?"
                )
        )
)
