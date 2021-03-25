package com.example.navigation_architecture_component

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.navigation_architecture_component.databinding.FragmentHomeBinding


class HomeFragment : Fragment() {
    private lateinit var binding : FragmentHomeBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_home, container, false)

        binding.button.setOnClickListener {
            //공백 확인
            if (!TextUtils.isEmpty(binding.editTextTextPersonName.text.toString()))
            {
                //데이터 전달
                //대상간에 데이터를 전달하지 않는 것이 좋습니다. 가장 좋은 방법은 뷰 모델을 사용
                val bundle = bundleOf("user_input" to binding.editTextTextPersonName.text.toString())
                it.findNavController().navigate(R.id.action_homeFragment_to_secondFragment, bundle)
            }else{
                Toast.makeText(activity,"널값은 허용하지 않아요!",Toast.LENGTH_SHORT).show()
            }

        }
        //바인딩.root 반환
        return binding.root
    }
}