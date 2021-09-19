package com.apiTask.AppsSquare.ui.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.navigation.fragment.navArgs
import com.apiTask.AppsSquare.Model.Data
import com.apiTask.AppsSquare.R
import com.bumptech.glide.Glide
import de.hdodenhof.circleimageview.CircleImageView


class DetailFragment : Fragment() {

    val args: DetailFragmentArgs by navArgs()
    lateinit var image : CircleImageView
    lateinit var name : TextView
    lateinit var des : TextView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_detail, container, false)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        image = view.findViewById(R.id.detail_image)
        name = view.findViewById(R.id.detail_name)
        des = view.findViewById(R.id.detail_des)
        Glide.with(View(context)).load(args.dataImage).placeholder(R.drawable.ic_launcher_background).into(image)
        name.text = args.dataName
        des.text = args.dataDes

    }
}

