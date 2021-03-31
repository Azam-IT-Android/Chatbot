package com.example.chatbot

class ChatbotApi {


    val queryMap = hashMapOf<String, String>(
            "Write code to check a String is palindrome or not?" to "A palindrome is those String whose reverse is equal to the original. This can be done by using either StringBuffer reverse() method or by technique demonstrated in the solution here.",
            "Write a method which will remove any given character from a String?" to "you can remove a given character from String by converting it into a character array and then using substring() method for removing them from output string.",
            "How do you find middle element of a linked list in a single pass?" to "To answer this programming question I would say you start with a simple solution on which you traverse the LinkedList until you find the tail of linked list where it points to null to find the length of the linked list and then reiterating till middle.\n" +
                    "\n" +
                    "After this answer interviewer will ask you to find the middle element in single pass and there you can explain that by doing space-time trade-off you can use two pointers one incrementing one step at a time and other incrementing two-step a time, so when the first pointer reaches end of linked second pointer will point to the middle element.\n"

    )

    fun processOption(selectedOption: String): String {
        return queryMap[selectedOption]?:"Sorry I don't understand your quesion"
    }

}