package id.ac.ui.cs.mobileprogramming.MuhammadIrfanAmrullah.helloworld

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import id.ac.ui.cs.mobileprogramming.MuhammadIrfanAmrullah.helloworld.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    companion object {
        init {
            System.loadLibrary("native-lib")
        }
    }


    private lateinit var input1: EditText
    private lateinit var input2: EditText
    private lateinit var add_button: Button
    private lateinit var hasil: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        input1 = findViewById(R.id.first_num)
        input2 = findViewById(R.id.second_num)
        add_button = findViewById(R.id.add_Button)
        hasil = findViewById(R.id.hasil)

        add_button.setOnClickListener(object: View.OnClickListener {
            override fun onClick(v: View?) {
                if (isInteger(input1.text.toString()) != false && isInteger(input2.text.toString()) != false ) {
                    var x = input1.text.toString().toInt()
                    var y = input2.text.toString().toInt()
                    var temp = add(x, y)
                    Toast.makeText(this@MainActivity, "Menambahkan angka...", Toast.LENGTH_SHORT).show()
                    hasil.setText(temp.toString())
                }
                else {
                    Toast.makeText(this@MainActivity, "Tolong masukkan angka...", Toast.LENGTH_SHORT).show()
                }

            }

        })




    }

    fun isInteger(str: String?) = str?.toIntOrNull()?.let { true } ?: false

    external fun add(x: Int, y: Int): Int


}
