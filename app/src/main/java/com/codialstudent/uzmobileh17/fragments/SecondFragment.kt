package com.codialstudent.uzmobileh17.fragments

import android.annotation.SuppressLint
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.codialstudent.uzmobileh17.R
import com.codialstudent.uzmobileh17.adapters.RvAdapter
import com.codialstudent.uzmobileh17.adapters.RvClicked
import com.codialstudent.uzmobileh17.databinding.FragmentSecondBinding
import com.codialstudent.uzmobileh17.db.MyData
import com.codialstudent.uzmobileh17.models.InfoData

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [SecondFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class SecondFragment : Fragment(), RvClicked {
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

    private lateinit var binding: FragmentSecondBinding
    private lateinit var adapter: RvAdapter

    @SuppressLint("SetTextI18n")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentSecondBinding.inflate(inflater, container, false)

        binding.btnBack.setOnClickListener {
            activity?.onBackPressed()
        }

        when (arguments?.getString("key")?.toInt()) {
            0 -> {
                binding.label.text = "Tariflar"
                adapter = RvAdapter(requireContext(), MyData.getData0(), 0, this)
            }
            1 -> {
                binding.label.text = "Xizmatlar"
                adapter = RvAdapter(requireContext(), MyData.getData1(), 1, this)
            }
            2 -> {
                binding.label.text = "Daqiqalar To'plamlar"
                adapter = RvAdapter(requireContext(), MyData.getData2(), 2, this)
            }
            3 -> {
                binding.label.text = "Internet To'plamlar"
                adapter = RvAdapter(requireContext(), MyData.getData3(), 3, this)
            }
            4 -> {
                binding.label.text = "SMS To'plamlar"
                adapter = RvAdapter(requireContext(), MyData.getData4(), 4, this)
            }
            5 -> {
                binding.label.text = "USSD To'plamlar"
                adapter = RvAdapter(requireContext(), MyData.getData5(), 5, this)
            }

        }
        binding.myRv.adapter = adapter


        return binding.root
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment SecondFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            SecondFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }

    override fun itemClicked(infoData: InfoData, keyItem: Int) {
        findNavController().navigate(
            R.id.thirdFragment, bundleOf("keyInfo" to infoData, "keyItem" to keyItem),
        )
    }
}