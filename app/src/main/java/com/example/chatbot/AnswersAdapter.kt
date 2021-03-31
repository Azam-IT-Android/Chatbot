package com.example.chatbot

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.answer_item_layout.view.*

class AnswersAdapter(val answers: Array<String>, val onAnswerClick:(String)->Unit): RecyclerView.Adapter<AnswersAdapter.AnswerItemViewHolder>() {

    class AnswerItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AnswerItemViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.answer_item_layout, parent, false)
        return AnswerItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: AnswerItemViewHolder, position: Int) {
        holder.itemView.answer_option_button.text = answers[position]
        holder.itemView.answer_option_button.setOnClickListener {
            onAnswerClick(answers[position])
        }
    }

    override fun getItemCount(): Int {
        return answers.size
    }
}