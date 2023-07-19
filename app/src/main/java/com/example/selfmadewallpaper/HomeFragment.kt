package com.example.selfmadewallpaper

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.selfmadewallpaper.adapters.adapter_colortone
import com.example.selfmadewallpaper.databinding.FragmentHomeBinding
import com.example.selfmadewallpaper.model.model_colortone
import com.google.firebase.firestore.FirebaseFirestore


class HomeFragment : Fragment() {
    lateinit var binding: FragmentHomeBinding
    lateinit var db:FirebaseFirestore

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
      binding= FragmentHomeBinding.inflate(layoutInflater, container, false)

        db = FirebaseFirestore.getInstance()
        db.collection("bestofthemonth").addSnapshotListener { value, error ->

            val list_bom = arrayListOf<model_bom>()
            val data = value?.toObjects(model_bom::class.java)

            list_bom.addAll(data!!)


            binding.rcvBom.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, true)
            binding.rcvBom.adapter = adapter_bom(requireContext(), list_bom)

        }
        db.collection("colortone").addSnapshotListener { value, error ->
            val list_colortone = arrayListOf<model_colortone>()
            val data = value?.toObjects(model_colortone::class.java)
            list_colortone.addAll(data!!)

            binding.rcvColortone.layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, true)
            binding.rcvColortone.adapter = adapter_colortone(requireContext(), list_colortone)

        }




        return binding.root






    }

    }
