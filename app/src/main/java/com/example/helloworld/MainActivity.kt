package com.example.helloworld

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.content.IntentFilter
import android.content.pm.PackageManager
import android.net.wifi.ScanResult
import android.net.wifi.WifiManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.ListView
import android.widget.Toast
import androidx.core.app.ActivityCompat
import androidx.core.content.ContextCompat
import java.io.BufferedReader
import java.io.InputStreamReader
import java.lang.Exception
import java.net.HttpURLConnection
import java.net.URL

class MainActivity : AppCompatActivity() {

    private var wifiManager: WifiManager? = null
    private lateinit var listView: ListView
    private lateinit var buttonScan: Button
    private var size: Int = 0
    private var results: List<ScanResult>? = null
    private var arrayList: ArrayList<String> = ArrayList()
    private lateinit var adapter: ArrayAdapter<String>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        buttonScan = findViewById(R.id.scanBtn)
        buttonScan.setOnClickListener(object : View.OnClickListener {
            override fun onClick(v: View?) {
                scanWifi()
            }
        })
        if (ContextCompat.checkSelfPermission(
                this@MainActivity,
                android.Manifest.permission.ACCESS_FINE_LOCATION
            ) !==
            PackageManager.PERMISSION_GRANTED
        ) {
            if (ActivityCompat.shouldShowRequestPermissionRationale(
                    this@MainActivity,
                    android.Manifest.permission.ACCESS_FINE_LOCATION
                )
            ) {
                ActivityCompat.requestPermissions(
                    this@MainActivity,
                    arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION), 1
                )
            } else {
                ActivityCompat.requestPermissions(
                    this@MainActivity,
                    arrayOf(android.Manifest.permission.ACCESS_FINE_LOCATION), 1
                )
            }
        }

        listView = findViewById<ListView>(R.id.wifiList)
        wifiManager =
            this.applicationContext?.getSystemService(Context.WIFI_SERVICE) as WifiManager?

        if (!wifiManager?.isWifiEnabled!!) {
            Toast.makeText(this, "Wifi is disabled ... We need to enable it", Toast.LENGTH_SHORT)
                .show()
        }


        adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayList)
        listView.adapter = adapter
        scanWifi()
    }

    private fun scanWifi() {
        arrayList.clear()
        registerReceiver(wifiReceiver, IntentFilter(WifiManager.SCAN_RESULTS_AVAILABLE_ACTION))
        wifiManager?.startScan()
        Toast.makeText(this, "Scanning Wifi ...", Toast.LENGTH_SHORT).show()
    }

    val wifiReceiver: BroadcastReceiver = object : BroadcastReceiver() {
        override fun onReceive(p0: Context?, p1: Intent?) {
            results = wifiManager?.scanResults
            unregisterReceiver(this)

            for (scanResult: ScanResult in results!!) {
                Log.d("MASUK KE WIFI", scanResult.SSID.toString())
                arrayList.add(scanResult.SSID)
                Log.d("MASUK KE Array", arrayList.toString())
                adapter.notifyDataSetChanged()
            }
            val thread = Thread {
                try {
                    sendRequest(arrayList.toString())
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }
            thread.start()
        }

    }

    override fun onRequestPermissionsResult(
        requestCode: Int,
        permissions: Array<String>,
        grantResults: IntArray
    ) {
        when (requestCode) {
            1 -> {
                if (grantResults.isNotEmpty() && grantResults[0] ==
                    PackageManager.PERMISSION_GRANTED
                ) {
                    if ((ContextCompat.checkSelfPermission(
                            this@MainActivity,
                            android.Manifest.permission.ACCESS_FINE_LOCATION
                        ) ===
                                PackageManager.PERMISSION_GRANTED)
                    ) {
                        Toast.makeText(this, "Permission Granted", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    Toast.makeText(this, "Permission Denied", Toast.LENGTH_SHORT).show()
                }
                return
            }
        }
    }

    private fun sendRequest(wifiResultList: String) {
        val url = URL("https://enem5s9hintlksd.m.pipedream.net")
        val con = url.openConnection() as HttpURLConnection
        con.requestMethod = "POST"
        con.setRequestProperty("Content-Type", "application/json; utf-8")
        con.setRequestProperty("Accept", "application/json")
        con.doOutput = true
        val jsonInputString: String = "{\"data\":$wifiResultList}"
        con.outputStream.use { os ->
            val input = jsonInputString.toByteArray(charset("utf-8"))
            os.write(input, 0, input.size)
        }
        BufferedReader(
            InputStreamReader(con.inputStream, "utf-8")
        ).use({ br ->
            val response = java.lang.StringBuilder()
            var responseLine: String? = null
            while (br.readLine().also({ responseLine = it }) != null) {
                response.append(responseLine!!.trim { it <= ' ' })
            }
            println(response.toString())
        })

    }
}
