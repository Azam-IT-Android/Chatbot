package com.example.chatbot

interface QuestionClickListener {

    fun onQuestionClick(question: QuestionItem, selectedOption: String)
}