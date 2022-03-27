package com.ubaya.a160419094_ubayakuliner.view.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ubaya.a160419094_ubayakuliner.R
import androidx.recyclerview.widget.RecyclerView
import com.ubaya.a160419094_ubayakuliner.model.Category
import kotlinx.android.synthetic.main.card_resto_category.view.*

class RestoCategoryAdapter(val restoCategoryList: ArrayList<Category>): RecyclerView.Adapter<RestoCategoryAdapter.RestoCategoryViewHolder>() {
    class RestoCategoryViewHolder(val view : View):RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestoCategoryViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.card_resto_category, parent, false)
        return RestoCategoryViewHolder(view)
    }

    override fun onBindViewHolder(holder: RestoCategoryViewHolder, position: Int) {
        val restoCategory = restoCategoryList[position]
        with(holder.view){
            chipRestoCategory.text = restoCategory.name
        }
    }

    override fun getItemCount() = restoCategoryList.size

    fun updateRestoCategory(newCategoryList: ArrayList<Category>) {
        restoCategoryList.clear()
        restoCategoryList.addAll(newCategoryList)
        notifyDataSetChanged()
    }
}