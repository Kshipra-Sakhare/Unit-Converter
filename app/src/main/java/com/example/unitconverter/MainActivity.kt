package com.example.unitconverter

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.Spinner
import android.widget.TextView
import androidx.core.widget.doAfterTextChanged

class MainActivity : AppCompatActivity() {

    val input = findViewById<EditText>(R.id.input)
    val unit = findViewById<Spinner>(R.id.unit)
    val km = findViewById<TextView>(R.id.km)
    val m = findViewById<TextView>(R.id.m)
    val cm = findViewById<TextView>(R.id.cm)
    val mm = findViewById<TextView>(R.id.mm)
    val microm = findViewById<TextView>(R.id.microm)
    val nm = findViewById<TextView>(R.id.nm)
    val mile = findViewById<TextView>(R.id.mile)
    val yard = findViewById<TextView>(R.id.yard)
    val foot = findViewById<TextView>(R.id.foot)
    val inch = findViewById<TextView>(R.id.inch)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val arr= arrayOf("km", "m", "cm", "mm", "microm", "nm", "mile", "yard", "foot", "inch")
        unit.adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, arr)

        unit.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                adapterView: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                update()
            }

            override fun onNothingSelected(adapterView: AdapterView<*>?) {
                // Your implementation for nothing selected
            }
        }

        input.doAfterTextChanged {
            update()
        }
    }

    private fun update() {
        if (!input.text.toString().equals("") && !unit.selectedItem.toString().equals("")) {
            val inputValue = input.text.toString().toDouble()
            when (unit.selectedItem.toString()) {
                "km" -> setKm(inputValue)
                "m" -> setKm(inputValue / 1000)
                "cm" -> setKm(inputValue / 100000)
                "mm" -> setKm(inputValue / 1000000)
                "microm" -> setKm(inputValue / 1000000000)
                "nm" -> setKm(inputValue / (1000000 * 1000000))
                "mile" -> setKm(inputValue * 1.609)
                "yard" -> setKm(inputValue / 1094)
                "foot" -> setKm(inputValue / 3281)
                "inch" -> setKm(inputValue / 39370)
            }
        }
    }

    private fun setKm(km_in: Double) {
        km.text = km_in.toString()
        m.text = (km_in * 1000).toString()
        cm.text = (km_in * 100000).toString()
        mm.text = (km_in * 1000000).toString()
        microm.text = (km_in * 1000000000).toString()
        nm.text = (km_in * 1000000 * 1000000).toString()
        mile.text = (km_in / 1.609).toString()
        yard.text = (km_in * 1094).toString()
        foot.text = (km_in * 3281).toString()
        inch.text = (km_in * 39370).toString()
    }

}