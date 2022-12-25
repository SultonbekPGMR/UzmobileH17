package com.codialstudent.uzmobileh17.adapters

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.codialstudent.uzmobileh17.databinding.ItemRvBinding
import com.codialstudent.uzmobileh17.models.InfoData

class RvAdapter(
    val context: Context,
    private val list: ArrayList<InfoData>,
    val key: Int,
    val rvClicked: RvClicked
) :
    RecyclerView.Adapter<RvAdapter.Vh>() {

    inner class Vh(private val itemRvBinding: ItemRvBinding) : ViewHolder(itemRvBinding.root) {
        @SuppressLint("SetTextI18n")
        fun onBind(infoData: InfoData) {
            itemRvBinding.description.textSize = 16F
            itemRvBinding.description.textAlignment = View.TEXT_ALIGNMENT_VIEW_START
            when (key) {
                0 -> {
                    itemRvBinding.secondName.text = ""
                    itemRvBinding.name.text = infoData.price
                    itemRvBinding.description.text = infoData.name
                    itemRvBinding.description.textSize = 25F
                    itemRvBinding.description.textAlignment = View.TEXT_ALIGNMENT_CENTER
                }
                1 -> {
                    itemRvBinding.description.textSize = 18F
                    itemRvBinding.name.text = infoData.name
                    itemRvBinding.secondName.text = ""
                    itemRvBinding.description.text = infoData.secondName
                }
                2 -> {
                    itemRvBinding.name.text = infoData.name
                    itemRvBinding.secondName.text = "${infoData.secondName} DAQIQA"
                    itemRvBinding.description.text = "To'plam narxi: ${infoData.price}\n" +
                            "Berilgan daqiqalar: ${infoData.name}"
                }
                3 -> {
                    itemRvBinding.name.text = "${infoData.name} MB"
                    itemRvBinding.secondName.text = "${infoData.secondName} GB"
                    itemRvBinding.description.text = "To'plam narxi: ${infoData.price} SO'M\n" +
                            "Berilgan Trafik: ${infoData.name} MB"
                }
                4 -> {
                    itemRvBinding.name.text = infoData.name
                    itemRvBinding.secondName.text = "${infoData.secondName} SMS"
                    itemRvBinding.description.text = "To'plam narxi: ${infoData.price}\n" +
                            "Berilgan SMS: ${infoData.name} ta"
                }
                5 -> {
                    itemRvBinding.name.text = infoData.name
                    itemRvBinding.secondName.text = ""
                    itemRvBinding.description.textAlignment = View.TEXT_ALIGNMENT_CENTER
                    itemRvBinding.description.textSize = 20F
                    itemRvBinding.description.text = infoData.price
                }

            }
            itemRvBinding.root.setOnClickListener {
                rvClicked.itemClicked(infoData, key)
            }

        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(ItemRvBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: Vh, position: Int) = holder.onBind(list[position])


    override fun getItemCount(): Int = list.size


}

interface RvClicked {
    fun itemClicked(infoData: InfoData,keyItem: Int)
}