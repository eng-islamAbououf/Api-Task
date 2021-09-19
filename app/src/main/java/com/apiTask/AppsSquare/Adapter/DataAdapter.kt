package com.apiTask.AppsSquare.Adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.apiTask.AppsSquare.ClickItem
import com.apiTask.AppsSquare.Model.DataModel
import com.apiTask.AppsSquare.R
import com.bumptech.glide.Glide
import de.hdodenhof.circleimageview.CircleImageView

class DataAdapter(var myData: DataModel, var context: Context?) : RecyclerView.Adapter<DataAdapter.MyViewHolder>() {


    var pos : Int = 0
    class MyViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView){
        var myName : TextView = itemView.findViewById(R.id.my_name)
        var myPrice : TextView = itemView.findViewById(R.id.my_des)
        var myImage : CircleImageView = itemView.findViewById(R.id.my_image)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view : View = LayoutInflater.from(parent.context).inflate(R.layout.item_view,parent,false)
        return MyViewHolder(view)
    }

    override fun getItemId(position: Int): Long {
        pos = position
        return super.getItemId(position)
    }

    override fun onBindViewHolder(myHolder: MyViewHolder, position: Int) {
        val dataModel = myData.get(position)
        Glide.with(View(context)).load(dataModel.image_url).placeholder(R.drawable.ic_launcher_background).into(myHolder.myImage)
        myHolder.myName.text = dataModel.name
        myHolder.myPrice.text = dataModel.description
    }

    override fun getItemCount(): Int {
        return myData.size
    }
}