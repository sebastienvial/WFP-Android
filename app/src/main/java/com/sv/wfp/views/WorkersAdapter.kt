package com.sv.wfp.views

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sv.wfp.R
import com.sv.wfp.models.Worker
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.worker_row.view.*

class WorkersAdapter(val workers: List<Worker>): RecyclerView.Adapter<CustomViewHolder>() {


    override  fun getItemCount(): Int {
        return workers.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val layoutInflater = LayoutInflater.from(parent?.context)
        val cellForRow = layoutInflater.inflate(R.layout.worker_row, parent, false)
        return CustomViewHolder(cellForRow)

    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
        holder?.view?.textView_firstName?.text = workers.get(position).firstName
        holder?.view?.textView_lastName?.text = workers.get(position).lastName
        holder?.view?.textView_email?.text = workers.get(position).email

        holder?.worker = workers.get(position)

    }
}

class CustomViewHolder(val view: View, var worker: Worker? = null): RecyclerView.ViewHolder(view){

    companion object {
        val WORKER_NAME_KEY = "WORKER_NAME"
        val WORKER_LNAME_KEY = "WORKER_LNAME"
        val WORKER_EMAIL_KEY = "WORKER_EMAIL"
        val WORKER_PRIMARY_KEY = "WORKER_PRIMARY"
        val WORKER_IMGURL_KEY = "WORKER_IMGURL"
        val WORKER_ROLE_KEY = "WORKER_ROLE"
        val WORKER_TITLE_KEY = "WORKER_TITLE"
        val WORKER_EXPERTISE_KEY = "WORKER_EXPERTISE"
        val WORKER_CL_KEY = "WORKER_CL"
    }

    init {

        view.setOnClickListener {
            val intent = Intent(view.context, WorkerDetailActivity::class.java)

            intent.putExtra(WORKER_NAME_KEY, worker?.firstName)
            intent.putExtra(WORKER_LNAME_KEY, worker?.lastName)
            intent.putExtra(WORKER_EMAIL_KEY, worker?.email)
            intent.putExtra(WORKER_PRIMARY_KEY, worker?.primaryPl)
            intent.putExtra(WORKER_IMGURL_KEY, worker?.imageUrl)
            intent.putExtra(WORKER_ROLE_KEY, worker?.role)
            intent.putExtra(WORKER_TITLE_KEY, worker?.title)
            intent.putExtra(WORKER_EXPERTISE_KEY, worker?.expertise)
            intent.putExtra(WORKER_CL_KEY, worker?.cl)

            view.context.startActivity(intent)

        }
    }

}