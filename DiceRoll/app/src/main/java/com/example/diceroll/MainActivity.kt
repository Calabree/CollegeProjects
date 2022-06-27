package com.example.diceroll

import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val rollButton: Button = findViewById(R.id.roll)

        rollButton.setOnClickListener {
            rollDice()
        }
    }

    fun rollDice() {
        val rollImage: ImageView = findViewById(R.id.diceImage)
        val myDiceRoll = Dice().roll()
        Toast.makeText(this, "Dice Has Been Rolled!", Toast.LENGTH_SHORT).show()
        val myDrawable = when (myDiceRoll) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> R.drawable.dice_6
        }
        rollImage.setImageResource(myDrawable)
    }
}