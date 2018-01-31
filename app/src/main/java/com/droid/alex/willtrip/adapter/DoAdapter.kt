package com.droid.alex.willtrip.adapter

import android.content.Context
import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.droid.alex.willtrip.R
import com.droid.alex.willtrip.model.do_class.Do
import com.droid.alex.willtrip.model.do_class.DoDays
import com.droid.alex.willtrip.model.do_class.DoNum
import com.droid.alex.willtrip.model.do_class.DoPeriodic
import kotlinx.android.synthetic.main.do_list_item.view.*
import java.text.SimpleDateFormat
import java.util.*


class DoAdapter(private val items: ArrayList<Do>, private val context: Context): RecyclerView.Adapter<DoAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.do_list_item, parent, false))

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(items[position], context)

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val title = itemView.titleTextView
        private val kind = itemView.kindTextView
        private val complexity = itemView.complexityTextView
        private val daysType = itemView.daysTitleTextView
        private val days = itemView.daysTextView
        private val startDate = itemView.startDateTextView
        private val expireDate = itemView.expireDateTextView
        private val description = itemView.descriptionTextView

        private val dateFormatter = SimpleDateFormat("d MMM yyyy", Locale.US)

        fun bind(item: Do, context: Context)  {

            title.text = item.name

            when (item.isPositive)  {
            true ->  setKindTextAndColor(R.string.do_it_excl, R.color.colorGreen, context)
            false -> setKindTextAndColor(R.string.don_t_do_it_excl, R.color.colorRed, context)
        }

            when (item.complexity) {
                1 -> setCompTextAndColor(R.string.very_easy, R.color.colorGreen, context)
                2 -> setCompTextAndColor(R.string.easy, R.color.colorBlue, context)
                3 -> setCompTextAndColor(R.string.medium, R.color.colorDarkYellow, context)
                4 -> setCompTextAndColor(R.string.hard, R.color.colorOrange, context)
                5 -> setCompTextAndColor(R.string.very_hard, R.color.colorRed, context)
        }
            when (item) {
                is DoDays -> {
                    daysType.text = context.resources.getString(R.string.days_of_week)
                    if (item.numberOfDays.size == 7) {
                        days.text = context.resources.getText(R.string.every_day)
                    } else {
                        var daysString = ""
                        val daysArray = context.resources.getStringArray(R.array.days_of_week)
                        for (it in item.numberOfDays) {
                            daysString += ", ${daysArray[it]}"
                        }
                        days.text = daysString.substring(1, daysString.length)
                    }
                }
                is DoNum -> {
                    daysType.text = context.resources.getString(R.string.number_of_days)
                    days.text = item.numberOfDays.toString()
                }
                is DoPeriodic -> {
                    daysType.text = context.getString(R.string.do_every_n_days, item.period)
                    days.visibility = View.INVISIBLE
                }
            }

            startDate.text = dateFormatter.format(item.startDate)

            expireDate.text = when (item.expireDate) {
                null -> context.resources.getString(R.string.infinite)
                else -> dateFormatter.format(item.expireDate)
                }

            description.text = when (item.note) {
                null -> context.getString(R.string.description_placeholder, "-")
                else -> context.getString(R.string.description_placeholder, item.note)
            }
        }


        private fun setKindTextAndColor (text: Int, color: Int, context: Context) {
            kind.text = context.resources.getString(text)
            kind.setTextColor(ContextCompat.getColor(context, color))
        }

        private fun setCompTextAndColor (text: Int, color: Int, context: Context) {
            complexity.text = context.resources.getString(text)
            complexity.setTextColor(ContextCompat.getColor(context, color))
        }
    }
}