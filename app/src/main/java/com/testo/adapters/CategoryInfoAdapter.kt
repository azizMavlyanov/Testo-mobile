package com.testo.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.testo.R
import com.testo.pojo.CategoryResponse
import kotlinx.android.synthetic.main.category_item.view.*

class CategoryInfoAdapter() : RecyclerView.Adapter<CategoryInfoAdapter.CategoryInfoViewHolder>() {

    var categoriesInfoList: List<CategoryResponse> = listOf(
        CategoryResponse(
            1,
            "Bread",
            "bread image"
        ),
        CategoryResponse(
            2,
            "Drink",
            "Drink image"
        ),
        CategoryResponse(
            3,
            "Meat",
            "Meat image"
        ),
        CategoryResponse(
            4,
            "Salad",
            "Salad image"
        )
    )

        set(value) {
            field = value
            notifyDataSetChanged()
        }

    var onCategoryClickListener: OnCategoryClickListener? = null

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryInfoViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.category_item, parent, false)

        return CategoryInfoViewHolder(view)
    }

    override fun onBindViewHolder(holder: CategoryInfoViewHolder, position: Int) {
        val category = categoriesInfoList[position]
        with(holder) {
            with(category) {
                tvCategory.text = categoryName
                ivCategory.setImageResource(R.drawable.buy)
                itemView.setOnClickListener {
                    onCategoryClickListener?.onCategoryClick(category)
                }
            }
        }
    }

    override fun getItemCount(): Int = categoriesInfoList.size

    inner class CategoryInfoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val ivCategory = itemView.ivCategory
        val tvCategory = itemView.tvCategory
    }

    interface OnCategoryClickListener {
        fun onCategoryClick(categoryResponse: CategoryResponse)
    }
}