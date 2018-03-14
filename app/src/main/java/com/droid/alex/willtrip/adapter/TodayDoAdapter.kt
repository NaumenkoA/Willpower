package com.droid.alex.willtrip.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.support.constraint.ConstraintLayout
import android.support.v4.content.ContextCompat
import android.support.v7.widget.RecyclerView
import android.text.InputFilter
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.RelativeLayout
import com.droid.alex.willtrip.R
import com.droid.alex.willtrip.model.core.TodayDo
import kotlinx.android.synthetic.main.today_do_item.view.*
import kotlin.collections.ArrayList

class TodayDoAdapter(private val items: ArrayList<TodayDo>, private val context: Context): RecyclerView.Adapter<TodayDoAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) = ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.today_do_item, parent, false))

    override fun getItemCount() = items.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) = holder.bind(items[position], context)

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

        private val title = itemView.titleTextView
        private val complexity = itemView.complexityTextView
        private val chainLength = itemView.chainLengthTextView
        private val chainWP = itemView.chainWPTextView
        private val wp = itemView.wpTextView
        private val commentButton = itemView.addCommentButton
        private val button1 = itemView.barButton1
        private val button2 = itemView.barButton2
        private val button3 = itemView.barButton3

        fun bind(item: TodayDo, context: Context) {
            title.text = item.todayDo.name
            val complexity = item.todayDo.complexity
            this.complexity.text = complexity.toString()
            val chain = item.todayDo.chain.target
            var chainLength: Int = 0
            if (chain != null) chainLength = chain.length
            this.chainLength.text = chainLength.toString()
            val totalWP = complexity + chainLength
            chainWP.text = chainLength.toString()
            wp.text = context.getString(R.string.wp_points, totalWP)

            if (!item.todayDo.isPositive) {
                button1.setColorFilter(ContextCompat.getColor(context, R.color.colorRed),  android.graphics.PorterDuff.Mode.SRC_IN)
                button2.setColorFilter(ContextCompat.getColor(context, R.color.colorGreen),  android.graphics.PorterDuff.Mode.SRC_IN)
            }

            if (!item.isObligatory) {
                    wp.background = context.getDrawable(R.drawable.circle_grey)
                    button3.text = context.getString(R.string.skip)
                    val skipDrawable = context.getDrawable(R.drawable.ic_arrow_forward_black_36dp)
                    button3.setCompoundDrawablesRelativeWithIntrinsicBounds(null, null, skipDrawable, null)
            } else {
                    wp.background = context.getDrawable(R.drawable.circle_blue)
                }

            if (item.isObligatory && item.todayDo.isSpecialDayEnabled) {
                   button3.text = context.getString(R.string.special_day)
                }

            if (item.isObligatory && !item.todayDo.isSpecialDayEnabled) {
                    button3.visibility = View.GONE
                }

            commentButton.setOnClickListener {

            }
        }
        }
}