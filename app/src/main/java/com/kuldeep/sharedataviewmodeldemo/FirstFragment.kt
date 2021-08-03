package com.kuldeep.sharedataviewmodeldemo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment

class FirstFragment : Fragment(), View.OnClickListener {

    private var navController: NavController?=null
    lateinit var viewModel: MainViewModel
    private lateinit var username_edt: EditText
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_first, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = NavHostFragment.findNavController(this)
        view.findViewById<TextView>(R.id.send_btn).setOnClickListener(this)
        username_edt=view.findViewById<EditText>(R.id.username_edt)
        viewModel=ViewModelProvider(requireActivity()).get(MainViewModel::class.java)

    }

    override fun onClick(v: View?) {
        when(v!!.id){
            R.id.send_btn ->{
                if(username_edt.text.toString().trim().isNotEmpty()){
                    viewModel.setUserName(username_edt.text.toString().trim())
                    navController?.navigate(R.id.action_firstFragment_to_secondFragment2)
                }else{
                    Toast.makeText(requireContext(),"Please enter username", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}