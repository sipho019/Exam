package com.example.campsitecommander

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class DetailedViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detailed_view)

        val txtGear = findViewById<TextView>(R.id.txtGear)
        val btnBack = findViewById<Button>(R.id.btnBack)

        val itemNames =
            intent.getStringArrayExtra("items") ?: arrayOf()

        val categories =
            intent.getStringArrayExtra("categories") ?: arrayOf()

        val quantities =
            intent.getIntArrayExtra("quantities") ?: intArrayOf()

        val comments =
            intent.getStringArrayExtra("comments") ?: arrayOf()

        var gearInfo = ""

        for (i in itemNames.indices) {

            gearInfo +=
                "Item: ${itemNames[i]}\n" +
                        "Category: ${categories[i]}\n" +
                        "Quantity: ${quantities[i]}\n" +
                        "Comment: ${comments[i]}\n\n"
        }

        txtGear.text = gearInfo

        btnBack.setOnClickListener {
            finish()
        }
    }
}