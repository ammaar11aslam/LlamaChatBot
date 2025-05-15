package com.demo.llamachat

import android.os.Bundle
import android.view.Gravity
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import kotlinx.coroutines.*

class ChatActivity : AppCompatActivity() {
    private lateinit var chatLayout: LinearLayout
    private lateinit var inputEditText: EditText
    private lateinit var sendButton: Button
    private lateinit var scrollView: ScrollView
    private val coroutineScope = CoroutineScope(Dispatchers.Main)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_chat)

        val name = intent.getStringExtra("name") ?: "User"

        chatLayout = findViewById(R.id.chatLayout)
        inputEditText = findViewById(R.id.inputEditText)
        sendButton = findViewById(R.id.sendButton)
        scrollView = findViewById(R.id.scrollView)

        addBotMessage("Hi $name!")

        sendButton.setOnClickListener {
            val message = inputEditText.text.toString().trim()
            if (message.isNotEmpty()) {
                addUserMessage(message)
                inputEditText.text.clear()

                coroutineScope.launch {
                    val response = ApiService.sendMessage(message)
                    addBotMessage(response)
                }
            }
        }
    }

    private fun addUserMessage(text: String) {
        val messageView = TextView(this)
        messageView.text = text
        messageView.setBackgroundResource(R.drawable.user_message_bg)
        messageView.setPadding(24, 16, 24, 16)
        messageView.setTextColor(resources.getColor(android.R.color.white))

        val params = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.WRAP_CONTENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )
        params.gravity = Gravity.END
        params.setMargins(32, 8, 8, 8)
        messageView.layoutParams = params

        chatLayout.addView(messageView)
        scrollView.post { scrollView.fullScroll(ScrollView.FOCUS_DOWN) }
    }

    private fun addBotMessage(text: String) {
        val messageView = TextView(this)
        messageView.text = text
        messageView.setBackgroundResource(R.drawable.bot_message_bg)
        messageView.setPadding(24, 16, 24, 16)
        messageView.setTextColor(resources.getColor(android.R.color.black))

        val params = LinearLayout.LayoutParams(
            LinearLayout.LayoutParams.WRAP_CONTENT,
            LinearLayout.LayoutParams.WRAP_CONTENT
        )
        params.gravity = Gravity.START
        params.setMargins(8, 8, 32, 8)
        messageView.layoutParams = params

        chatLayout.addView(messageView)
        scrollView.post { scrollView.fullScroll(ScrollView.FOCUS_DOWN) }
    }

}
