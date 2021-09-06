package com.apiTask.AppsSquare.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.ProgressBar
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.apiTask.AppsSquare.Adapter.DataAdapter
import com.apiTask.AppsSquare.Api.Calls
import com.apiTask.AppsSquare.Api.Conn
import com.apiTask.AppsSquare.Model.DataModel
import com.apiTask.AppsSquare.R
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import javax.security.auth.callback.Callback

class MainActivity : AppCompatActivity() {
    lateinit var myRecycler : RecyclerView
    lateinit var layoutManager: GridLayoutManager
    lateinit var data : DataModel
    lateinit var dataAdapter : DataAdapter
    lateinit var constraintLayout : ConstraintLayout
    lateinit var progressBar: ProgressBar
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
        val conn =  Conn.calls
        val call = conn.getData()

        call.enqueue(object : retrofit2.Callback<DataModel> {
            override fun onResponse(call: Call<DataModel>?, response: Response<DataModel>?) {
                if (response?.isSuccessful == true) {
                    data = response.body()
                    install()
                    constraintLayout.visibility = View.VISIBLE
                    progressBar.visibility = View.GONE
                }
            }

            override fun onFailure(call: Call<DataModel>?, t: Throwable?) {
                Log.e("TAG", "onFailure: "+t.toString() )
            }

        })
    }



    fun initView(){
        myRecycler=findViewById(R.id.my_recycler)
        progressBar = findViewById(R.id.progress)
        constraintLayout = findViewById(R.id.layout)
    }

    fun install(){

        layoutManager = GridLayoutManager(this,2)
        myRecycler.layoutManager = layoutManager
        dataAdapter = DataAdapter(data,this)
        myRecycler.adapter = dataAdapter
    }
}