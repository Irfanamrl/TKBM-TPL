package id.ac.ui.cs.mobileprogramming.muhammadirfanamrullah.lab

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import id.ac.ui.cs.mobileprogramming.muhammadirfanamrullah.lab.R

class MainActivity : AppCompatActivity() {
    private val mangaListFragment : MangaListFragment = MangaListFragment()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        supportFragmentManager.beginTransaction()
            .add(R.id.container, mangaListFragment)
            .addToBackStack("manga_list")
            .commit()
    }
}