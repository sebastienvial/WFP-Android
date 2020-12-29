package com.sv.wfp.views

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.LinearLayout
import androidx.recyclerview.widget.LinearLayoutManager
import com.sv.wfp.R
import com.sv.wfp.api.ApiInterface
import com.sv.wfp.models.Worker
import kotlinx.android.synthetic.main.activity_user.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class UserActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_user)

        setSupportActionBar(toolbar_Workers)

        val site: String? = intent.getStringExtra("site")
        toolbar_Workers.title = "List of Technicians for " + site

        //Retrofit builder
        val retrofit = Retrofit.Builder()
            .addConverterFactory(GsonConverterFactory.create())
            .baseUrl("http://10.0.2.2:8080/")
            .build()

        //Call method
        val apiInterface = retrofit.create(ApiInterface::class.java)

        Log.i("InfoDEBUG", "début req")
        var workers:List<Worker>? = null
        val myReq: Call<List<Worker>> = apiInterface.getWorkers(site!!)
        myReq.enqueue((object : Callback<List<Worker>>{
            override fun onFailure(call: Call<List<Worker>>, t: Throwable) {
                Log.e("error",t.message.toString())
            }

            override fun onResponse(call: Call<List<Worker>>, response: Response<List<Worker>>) {
                //val workers:List<Worker> = response.body()!!
                workers = response.body()!!
                var cptTechnicians = 0
                var productLine=  listOf<String>()

                for(worker in workers!!) {
                    if ( (worker.role.equals("FST")) || (worker.role.equals("TSS")) ) {
                        cptTechnicians++
                    }
                    if (!productLine.contains(worker.primaryPl)) {
                        productLine += worker.primaryPl

                    }

                }

                textViewNbrWorkers.text = workers!!.size.toString()
                textViewNbrTechnicians.text = cptTechnicians.toString()
                textViewNbrPL.text = productLine!!.size.toString()

                showWorkers(workers!!)
                //textView4.text = stringBuilder
            }
        }))


    }

    fun showWorkers(workers: List<Worker>) {
        recyclerViewWorkers.layoutManager = LinearLayoutManager(this)
        recyclerViewWorkers.adapter = workers?.let { WorkersAdapter(workers = it) }

    }


}