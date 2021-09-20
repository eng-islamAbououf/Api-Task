package com.apiTask.AppsSquare.ui.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.OnItemTouchListener
import com.apiTask.AppsSquare.Adapter.DataAdapter
import com.apiTask.AppsSquare.ClickItem
import com.apiTask.AppsSquare.Model.Data
import com.apiTask.AppsSquare.Model.DataModel
import com.apiTask.AppsSquare.R
import com.apiTask.AppsSquare.MyInter as MyInter

class ProductFragment() : Fragment(),ClickItem  {

    lateinit var myRecyclerView: RecyclerView
    lateinit var myAdapter: DataAdapter
    lateinit var myViewModel : MyViewModel
    lateinit var myView: View
    lateinit var progressBar: ProgressBar
    lateinit var layout: ConstraintLayout
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
        }
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initView(view)
        myViewModel = ViewModelProvider(this).get(MyViewModel::class.java)
        myViewModel.getProductFromDatabase()

        myViewModel.productData.observe(viewLifecycleOwner, Observer {
            //dataModel = it
            install(it)
            progressBar.visibility = View.GONE
            layout.visibility = View.VISIBLE
        })

        myViewModel.errors.observe(viewLifecycleOwner, Observer {
            Toast.makeText(view.context,it, Toast.LENGTH_SHORT).show()
            progressBar.visibility = View.VISIBLE
            layout.visibility = View.GONE
        })

//        xName.setOnClickListener {
//            val action = ProductFragmentDirections.productToDetail(dataDes = myAdapter.myData.get(0).description,
//                    dataImage = myAdapter.myData.get(0).image_url,
//                    dataName = myAdapter.myData.get(0).name)
//            Navigation.findNavController(view).navigate(action)
//        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        myView = inflater.inflate(R.layout.fragment_product, container, false)
        return myView
    }

    fun initView(view: View){
        myRecyclerView = view.findViewById(R.id.my_recycler)
        progressBar = view.findViewById(R.id.product_progress)
        layout=view.findViewById(R.id.product_layout)
    }

    fun install(dataModel: DataModel){
        myAdapter = DataAdapter(dataModel,context,this)
        myRecyclerView.adapter = myAdapter
    }

    override fun getData(pos: Int) {
        val action = ProductFragmentDirections.productToDetail(
                dataDes = myAdapter.myData.get(0).description,
                dataImage = myAdapter.myData.get(pos).image_url,
                dataName = myAdapter.myData.get(pos).name)
        Navigation.findNavController(myView).navigate(action)
    }

//    override fun getData(pos: Int) {
//        d = myAdapter.myData.get(pos)
//
//    }

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