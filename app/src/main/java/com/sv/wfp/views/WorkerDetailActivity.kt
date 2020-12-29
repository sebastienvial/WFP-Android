package com.sv.wfp.views

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Picasso
import com.sv.wfp.R
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_user.*
import kotlinx.android.synthetic.main.activity_worker_detail.*

class WorkerDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_worker_detail)

        setSupportActionBar(toolbar_WorkerDetail)
        toolbar_WorkerDetail.title = "Technician details"

        val name = intent.getStringExtra(CustomViewHolder.WORKER_NAME_KEY)
        textView_firstname.text = name
        textView_lastname.text = intent.getStringExtra(CustomViewHolder.WORKER_LNAME_KEY)
        textView_role.text = intent.getStringExtra(CustomViewHolder.WORKER_ROLE_KEY)
        textView_title.text = intent.getStringExtra(CustomViewHolder.WORKER_TITLE_KEY)
        textView_expertise.text = intent.getStringExtra(CustomViewHolder.WORKER_EXPERTISE_KEY)
        textView_primary.text = intent.getStringExtra(CustomViewHolder.WORKER_PRIMARY_KEY)
        textView_email1.text = intent.getStringExtra(CustomViewHolder.WORKER_EMAIL_KEY)

        val thumbnailImageView = profileImageView
        val imageUrl: String = intent.getStringExtra(CustomViewHolder.WORKER_IMGURL_KEY).toString()
        Picasso.with(this).load(imageUrl).into(thumbnailImageView)

        val rate = intent.getStringExtra(CustomViewHolder.WORKER_CL_KEY)
        if (!rate?.isEmpty()!!) {
                rating_cl.rating = (rate.last().toInt() + 2).toFloat()
        }

    }
}