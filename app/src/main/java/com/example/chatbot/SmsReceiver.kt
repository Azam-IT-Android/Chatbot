package com.example.chatbot

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.provider.Telephony
import android.telephony.SmsMessage
import android.util.Log
import android.widget.Toast


class SmsReceiver: BroadcastReceiver() {

    companion object{
        const val SMS_RECEIVED = "android.provider.Telephony.SMS_RECEIVED"
    }

    override fun onReceive(context: Context?, intent: Intent?) {
        if(intent?.action == SMS_RECEIVED){
            val msgs: Array<SmsMessage> = Telephony.Sms.Intents.getMessagesFromIntent(intent)
            val smsMessage: SmsMessage = msgs[0]
            Log.d("AirplaneModeReceiver", "SMS : ${smsMessage.displayMessageBody}")
        }
    }
}