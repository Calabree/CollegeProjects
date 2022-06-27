package com.example.agetominutes

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val datePicker = findViewById<Button>(R.id.btnSelectDate)
        val dateUserSelected = findViewById<TextView>(R.id.selectedDate)
        val dateToMinutes = findViewById<TextView>(R.id.ageInMinutes)
        datePicker.setOnClickListener{view ->
            SetDatePicker(view, dateUserSelected, dateToMinutes)

        }

    }

    fun SetDatePicker(view: View, selectedDateTextView: TextView, userDateToMinutes:TextView){

        val myCalendar = Calendar.getInstance()
        val year = myCalendar.get(Calendar.YEAR)
        val month = myCalendar.get(Calendar.MONTH)
        val day = myCalendar.get(Calendar.DAY_OF_MONTH)

        DatePickerDialog(this, DatePickerDialog.OnDateSetListener{view, selectedYear, selectedMonth, selectedDayOfMonth ->
            val dateSelectedByUser = "$selectedDayOfMonth/${selectedMonth +1}/$selectedYear"
            selectedDateTextView.setText(dateSelectedByUser)
            val sdf = SimpleDateFormat("dd/MM/yyyy",Locale.ENGLISH)
            val selectedDateSDF = sdf.parse(dateSelectedByUser)
            val dateToMinutes = (selectedDateSDF!!.time / 60000)
            // !! throws nullpointerexception if null. .time returns ms /1000 for sec /60000 for minutes
            val currentDateToMinutes = sdf.parse(sdf.format(System.currentTimeMillis())).time / 60000
            val userAgeInMinutes = currentDateToMinutes - dateToMinutes
            userDateToMinutes.setText(userAgeInMinutes.toString())

        }
            ,year
            ,month
            ,day).show()

    }

}