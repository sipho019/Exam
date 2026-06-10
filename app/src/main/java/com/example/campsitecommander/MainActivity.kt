package com.example.campsitecommander

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun setContentView(layoutResID: Int) {
        super.setContentView(layoutResID)
    }

    private val itemNames = arrayOf(
        "Tent",
        "Marshmallows",
        "Flashlight"
    )

    private val categories = arrayOf(
        "Shelter",
        "Food",
        "Safety"
    )

    private val quantities = arrayOf(
        1,
        3,
        2
    )

    private val comments = arrayOf(
        "4-person waterproof",
        "For S'mores",
        "Check batteries"
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val txtTotal = findViewById<TextView>(R.id.txtTotal)
        val btnView = findViewById<Button>(R.id.btnView)

        var totalItems = 0

        // Loop used to calculate total items
        for (quantity in quantities) {
            totalItems += quantity
        }

        txtTotal.text = "Total Items Packed: $totalItems"

        btnView.setOnClickListener {

            val intent = Intent(
                this,
                DetailedViewActivity::class.java
            )

            intent.putExtra("items", itemNames)
            intent.putExtra("categories", categories)
            intent.putExtra("quantities", quantities)
            intent.putExtra("comments", comments)

            startActivity(intent)
        }
    }
}