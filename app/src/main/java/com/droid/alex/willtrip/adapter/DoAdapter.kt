package com.droid.alex.willtrip.adapter

import android.content.Context
import android.graphics.Rect
import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.droid.alex.willtrip.R
import com.droid.alex.willtrip.model.core.Do
import com.droid.alex.willtrip.model.period.PeriodDays
import com.droid.alex.willtrip.model.period.PeriodNumWeek
import com.droid.alex.willtrip.model.period.PeriodRepeat
import kotlinx.android.synthetic.main.do_list_item.view.*
import java.text.SimpleDateFormat
import java.util.*


class DoAdapter(private val items: MutableList<Do>, private val context: Context?, val listener: OnDoEditClickListener): RecyclerView.Adapter<DoAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.do_list_item, parent, false))

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(items[position], context)

    interface OnDoEditClickListener {
        fun onEditClicked (position: Int, rect: Rect)
    }

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), View.OnLongClickListener {

        init {
            itemView.setOnLongClickListener (this)
        }

        override fun onLongClick(v: View?): Boolean {
            val rect = Rect()
            v?.getGlobalVisibleRect(rect)
            listener.onEditClicked(adapterPosition, rect)
            return true
        }

        private val title = itemView.titleTextView
        private val kind = itemView.kindTextView
        private val complexity = itemView.complexityTextView
        private val daysType = itemView.daysTitleTextView
        private val days = itemView.daysTextView
        private val specialDays = itemView.specialDaysTextView
        private val startDate = itemView.startDateTextView
        private val expireDate = itemView.expireDateTextView
        private val description = itemView.descriptionTextView
        private val expandArrow = itemView.expandDescImageButton
        private var isDescriptionExpanded = false
        private var lineCount: Int = 0

        private val dateFormatter = SimpleDateFormat("d MMM yyyy", Locale.US)

        fun bind(item: Do, context: Context?) {

            title.text = item.name

            when (item.isPositive) {
                true -> setKindTextAndColor(R.string.do_it_excl, R.color.colorGreen, context!!)
                false -> setKindTextAndColor(R.string.don_t_do_it_excl, R.color.colorRed, context!!)
            }

            when (item.complexity) {
                1 -> setCompTextAndColor(R.string.very_easy, R.color.colorGreen, context)
                2 -> setCompTextAndColor(R.string.easy, R.color.colorBlue, context)
                3 -> setCompTextAndColor(R.string.medium, R.color.colorDarkYellow, context)
                4 -> setCompTextAndColor(R.string.hard, R.color.colorOrange, context)
                5 -> setCompTextAndColor(R.string.very_hard, R.color.colorRed, context)
            }

            val dayPeriod = item.period
            when (dayPeriod) {
                is PeriodDays -> {
                    daysType.text = context.resources.getString(R.string.days_of_week)
                    if (dayPeriod.daysOfWeek.size == 7) {
                        days.text = context.resources.getText(R.string.every_day)
                    } else {
                        var daysString = ""
                        val daysArray = context.resources.getStringArray(R.array.days_of_week)
                        for (it in dayPeriod.daysOfWeek) {
                            daysString += ", ${daysArray[it.id - 1]}"
                        }
                        days.text = daysString.substring(1, daysString.length)
                    }
                }
                is PeriodNumWeek -> {
                    daysType.text = context.resources.getString(R.string.number_of_days)
                    days.text = dayPeriod.numWeek.toString()
                }
                is PeriodRepeat -> {
                    daysType.text = context.getString(R.string.do_every_n_days, dayPeriod.repeatNum.toString())
                    days.visibility = View.INVISIBLE
                }
            }
            
            when (item.isSpecialDayEnabled) {
                true -> specialDays.text = context.getString(R.string.yes)
                false -> specialDays.text = context.getString(R.string.no)
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

            description.viewTreeObserver.addOnDrawListener {
                lineCount = description.layout.lineCount
                when (lineCount <2) {
                    true -> expandArrow.visibility = View.INVISIBLE
                    false -> expandArrow.visibility = View.VISIBLE
                }
            }

            expandArrow.setOnClickListener {
                if (!isDescriptionExpanded) {
                    description.maxLines = lineCount
                    expandArrow.setImageResource(R.drawable.ic_expand_less_black_24dp)
                    isDescriptionExpanded = true
                } else {
                    description.maxLines = 1
                    expandArrow.setImageResource(R.drawable.ic_expand_more_black_24dp)
                    isDescriptionExpanded = false
                }
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