package id.ac.ui.cs.mobileprogramming.muhammadirfanamrullah.lab

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Button

class MainActivity : AppCompatActivity() {

    var number = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<Button>(R.id.bt)
        button.setOnClickListener()
        {
            buttonAdd()
        }
    }

    fun buttonAdd() {
        var counter: TextView = findViewById(R.id.tx)
        number = addOne(number)
        counter.text = number.toString()
    }

    fun addOne(a: Int): Int{
        var res = a + 1
        return res
    }





}
