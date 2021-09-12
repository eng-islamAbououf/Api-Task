package com.apiTask.AppsSquare.ui.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ProgressBar
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.apiTask.AppsSquare.Adapter.DataAdapter
import com.apiTask.AppsSquare.Model.DataModel
import com.apiTask.AppsSquare.R
import com.apiTask.AppsSquare.MyInter as MyInter

class ProductFragment(var m : MyInter) : Fragment() {

    lateinit var myRecyclerView: RecyclerView
    lateinit var myAdapter: DataAdapter
    lateinit var myViewModel : MyViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {

        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        myViewModel = ViewModelProvider(this).get(MyViewModel::class.java)
        myViewModel.getProductFromDatabase()
        myViewModel.productData.observe(viewLifecycleOwner, Observer {
            //dataModel = it
            install(view,it)
            m.changeLayout(true)
        })
        myViewModel.errors.observe(viewLifecycleOwner, Observer {
            Toast.makeText(view.context,it, Toast.LENGTH_SHORT).show()
            m.changeLayout(false)
        })

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_product, container, false)
    }

    fun install(view: View,dataModel: DataModel){
        myRecyclerView = view.findViewById(R.id.my_recycler)
        myAdapter = DataAdapter(dataModel,view.context)
        val layoutManager = GridLayoutManager(view.context,2)
        myRecyclerView.layoutManager = layoutManager
        myRecyclerView.adapter = myAdapter
    }

//    fun addFAKE(){
//        val dat1 : ArrayList<Data> = ArrayList()
//
//        dat1.add(Data(
//            1,
//            "gg",
//            "ISlam",
//            200,
//            3
//        ))
//
//        dataModel = DataModel(
//            4,dat1,"HAAAA",true
//        )
//    }

}