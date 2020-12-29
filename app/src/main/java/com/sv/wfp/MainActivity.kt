package com.sv.wfp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.Spinner
import android.widget.Toast
import com.sv.wfp.views.UserActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainActivity : AppCompatActivity() {

    internal lateinit var sp: Spinner

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //val goUser = findViewById<ImageView>(R.id.goWorker)
        goWorker.setOnClickListener { v -> showWorker() }

        val sites = arrayOf("ASI-Bobst Grenchen","BSA-Bobst Mex", "FKG-Bobst Bielefeld", "SAM-Bobst Lyon", "GEN-Bobst Manchester", "BAM-Bobst Afric Midel", "BBN-Bobst Benelex", "BBR-Bobst Brazil", "BCL-Bobst China", "BEE-Bobst Estern Europ", "BES-Bobst Spain", "BFA-Bobst France", "BFL-Bobst Firenze")
        val adapter = ArrayAdapter(this, android.R.layout.simple_list_item_1, sites)
        spinner.adapter = adapter
    }

    private fun showWorker() {
        var siteValue: String = spinner.selectedItem.toString().substring(0,3)
        Toast.makeText(this, "Activation " + siteValue, Toast.LENGTH_SHORT).show()
        val intent = Intent(this, UserActivity::class.java)
        //var value: String = edtSite.text.toString()
        intent.putExtra("site", siteValue)
        startActivity(intent)
    }

}




