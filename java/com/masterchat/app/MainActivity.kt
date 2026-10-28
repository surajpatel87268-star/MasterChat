package com.masterchat.app

import android.app.Activity
import android.os.Bundle
import android.graphics.Color
import android.view.Gravity
import android.widget.LinearLayout
import android.widget.TextView
import android.widget.EditText
import android.widget.Button
import android.widget.ScrollView

class MainActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val layout = LinearLayout(this)
        layout.orientation = LinearLayout.VERTICAL
        layout.setPadding(24, 24, 24, 24)
        layout.setBackgroundColor(Color.rgb(18, 18, 30))

        val title = TextView(this)
        title.text = "Master Chat"
        title.textSize = 28f
        title.setTextColor(Color.WHITE)
        title.gravity = Gravity.CENTER
        title.setPadding(0, 20, 0, 24)
        layout.addView(title)

        val messages = TextView(this)
        messages.text = "नमस्ते दोस्त! 👋\nमैं Master Chat हूँ।\n\nमुझसे बात शुरू करो!"
        messages.textSize = 18f
        messages.setTextColor(Color.WHITE)
        messages.setPadding(12, 12, 12, 12)

        val scroll = ScrollView(this)
        scroll.addView(messages)

        layout.addView(
            scroll,
            LinearLayout.LayoutParams(
                LinearLayout.LayoutParams.MATCH_PARENT,
                0,
                1f
            )
        )

        val input = EditText(this)
        input.hint = "अपना संदेश लिखें..."
        input.setTextColor(Color.WHITE)
        input.setHintTextColor(Color.LTGRAY)
        layout.addView(input)

        val send = Button(this)
        send.text = "भेजें"
        layout.addView(send)

        send.setOnClickListener {
            val message = input.text.toString().trim()

            if (message.isNotEmpty()) {
                messages.append("\n\nआप: $message")
                messages.append(
                    "\nMaster Chat: नमस्ते दोस्त! तुम्हारा संदेश मिल गया।"
                )
                input.text.clear()
                scroll.post {
                    scroll.fullScroll(ScrollView.FOCUS_DOWN)
                }
            }
        }

        setContentView(layout)
    }
}
