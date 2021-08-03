package com.kuldeep.sharedataviewmodeldemo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider

class SecondFragment : Fragment() {
    private lateinit var username_txt: TextView
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_second, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val viewModel=ViewModelProvider(requireActivity()).get(MainViewModel::class.java)
        username_txt=view.findViewById<TextView>(R.id.username_txt)

        viewModel.userName.observe(viewLifecycleOwner, Observer {
            username_txt.text = "Welcome User ".plus(it)
        })

    }
}