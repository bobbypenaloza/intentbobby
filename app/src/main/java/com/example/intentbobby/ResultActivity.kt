package com.example.intentbobby

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup

class ResultActivity : AppCompatActivity() {
    var rgGame: RadioGroup? = null
    lateinit var radioButton: RadioButton
    private lateinit var btnChoose: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        rgGame = findViewById(R.id.rg_role)
        btnChoose = findViewById(R.id.btn_chose)
        btnChoose.setOnClickListener {
            val selectOption: Int = rgGame!!.checkedRadioButtonId
            radioButton= findViewById(selectOption)

            val intent = Intent(this, MainActivity::class.java)
            val bundle = Bundle()
            bundle.putString("Role", radioButton.text as String)
            intent.putExtras(bundle)
            startActivity(intent)
        }
    }
}

