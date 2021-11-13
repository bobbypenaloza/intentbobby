package com.example.intentbobby

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var btnMoveActivity: Button
    private lateinit var btnMoveWithData: Button
    private lateinit var btnDialNumber: Button
    private lateinit var btnResult: Button
    private lateinit var tvResult: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        btnMoveActivity = findViewById(R.id.btn_move_activity)
        btnMoveActivity.setOnClickListener(this)

        btnMoveWithData = findViewById(R.id.btn_move_with_data)
        btnMoveWithData.setOnClickListener(this)

        btnDialNumber = findViewById(R.id.btn_dial)
        btnDialNumber.setOnClickListener(this)

        btnResult = findViewById(R.id.btn_result)
        btnResult.setOnClickListener(this)

        tvResult = findViewById(R.id.tv_result)
        RoleUtama()
    }
    private fun RoleUtama() {
        val bundle = intent.extras
        val role = bundle?.getString("Role")
        tvResult.text = role

    }

    override fun onClick(v: View?) {
        if (v != null){
            when(v.id){
                R.id.btn_move_activity -> run {
                    val intent = Intent(this, MoveActivity::class.java)
                    startActivity(intent)
                }
                R.id.btn_move_with_data -> run {
                    val intent = Intent(this, MoveWithActivity::class.java )
                    val bundle = Bundle()
                    bundle.putString("Nama", "Bobby")
                    bundle.putString("Hobby", "tinju")
                    intent.putExtras(bundle)
                    startActivity(intent)
                }
                R.id.btn_dial -> run {
                    var dialNumber = "08887085140"
                    val intent = Intent(Intent.ACTION_DIAL, Uri.parse( "tel:" + dialNumber))
                    startActivity(intent)
                }
                R.id.btn_result -> run {
                    val intent = Intent(this, ResultActivity::class.java)
                    startActivity(intent)
                }

        }
    }
}