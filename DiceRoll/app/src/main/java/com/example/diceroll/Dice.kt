package com.example.diceroll

class Dice() {
    fun roll(): Int {
        return (1..6).random()
    }
}