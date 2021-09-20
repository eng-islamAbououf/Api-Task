package com.apiTask.AppsSquare.ui.Activity

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
import com.apiTask.AppsSquare.MyInter
import com.apiTask.AppsSquare.R
import com.apiTask.AppsSquare.show
import com.apiTask.AppsSquare.ui.Fragments.ProductFragment
import retrofit2.Call
import retrofit2.Response
import retrofit2.Retrofit
import javax.security.auth.callback.Callback

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        //initView()
//        supportFragmentManager
//            .beginTransaction()
//            .replace(R.id.container,ProductFragment(this))
//            .commitNow()
/*

      //  initView()
        val conn =  Conn.calls
        val call = conn.getData()

        call.enqueue(object : retrofit2.Callback<DataModel> {
            override fun onResponse(call: Call<DataModel>?, response: Response<DataModel>?) {
                if (response?.isSuccessful!!) {
                    data = response.body()
    //                install()
                    constraintLayout.visibility = View.VISIBLE
                    progressBar.visibility = View.GONE
                }
                else {

                }
            }

            override fun onFailure(call: Call<DataModel>?, t: Throwable?) {
                show(t.toString(),1)
            }


        })

 */
    }

//    override fun changeLayout(status: Boolean) {
////        if(status){
////            constraintLayout.visibility = View.VISIBLE
////            progressBar.visibility = View.GONE
////        }else {
////            constraintLayout.visibility = View.GONE
////            progressBar.visibility = View.VISIBLE
////        }
//    }



//    fun initView(){
//        progressBar = findViewById(R.id.progress)
//        constraintLayout = findViewById(R.id.layout)
//    }
/*
    fun install(){

        layoutManager = GridLayoutManager(this,2)
        myRecycler.layoutManager = layoutManager
        dataAdapter = DataAdapter(data,this)
        myRecycler.adapter = dataAdapter
    }

 */
}