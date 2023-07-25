package com.vtopacademy.schools

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.vtopacademy.R

/** Recycler view's adapter class for showing list of categories. */
class SchoolAdapter(
    private val schools: MutableList<School>,
    private val onItemClick: (school: School) -> Unit
) : RecyclerView.Adapter<SchoolAdapter.ViewHolder>() {

    /** Hold's each item view. */
    class ViewHolder(
        view: View, private val onItemClick: (school: School) -> Unit
    ) : RecyclerView.ViewHolder(view) {
        private val textView: TextView
        private lateinit var school: School

        init {
            view.setOnClickListener { onItemClick(school) }
            textView = itemView.findViewById(R.id.text_view)
        }

        fun bind(school: School){
            this.school = school
            textView.text = school.name
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int
    ): ViewHolder {
        val view: View = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_school, parent, false)
        return ViewHolder(view, onItemClick)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(schools[position])
    }

    override fun getItemCount(): Int {
        return schools.size
    }
}