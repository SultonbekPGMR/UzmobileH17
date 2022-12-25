package com.codialstudent.uzmobileh17.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import com.codialstudent.uzmobileh17.R
import com.codialstudent.uzmobileh17.adapters.RvAdapter
import com.codialstudent.uzmobileh17.databinding.FragmentSecondBinding
import com.codialstudent.uzmobileh17.databinding.FragmentThirdBinding
import com.codialstudent.uzmobileh17.db.MyData
import com.codialstudent.uzmobileh17.models.InfoData

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ThirdFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ThirdFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }
    }

    private lateinit var binding:FragmentThirdBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding =  FragmentThirdBinding.inflate(inflater, container, false)

        val infoData = arguments?.getSerializable("keyInfo") as InfoData
        val keyItem = arguments?.getInt("keyItem")

        when (keyItem) {
            0 -> {
                binding.label.text = infoData.name
                binding.tvInfo.text = "Tarif nomi: ${infoData.name}\n${infoData.secondName}"
            ;}
            1 -> {
                binding.label.text = "Xizmat"
                binding.tvInfo.text ="Bu xizmat orqali siz:${infoData.secondName}${infoData.price}"
            }
            2 -> {
                binding.label.text = "Daqiqa To'plami"
                binding.tvInfo.text ="Daqiqalar miqdori: ${infoData.name}\nnarxi: ${infoData.price}\namal qilish muddati: 30 kun"
            }
            3 -> {
                binding.label.text = "Internet To'plami"
                binding.tvInfo.text = "Trafik miqdori: ${infoData.name} MB\nNarxi: ${infoData.price}"
            }
            4 -> {
                binding.label.text = "SMS To'plami"
                binding.tvInfo.text = "SMS miqdori: ${infoData.name} ta\nNarxi: ${infoData.price}"
            }
            5 -> {
                binding.label.text ="USSD KOD"
                binding.tvInfo.text ="Bu USSD kod orqali ${infoData.secondName}"
            }

        }


        binding.btnBack.setOnClickListener {
            activity?.onBackPressed()
        }
        return binding.root

    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ThirdFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ThirdFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}