package com.droid.alex.willtrip.views

import android.content.Context
import android.content.res.TypedArray
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.support.v4.content.ContextCompat
import android.util.AttributeSet
import android.widget.Button
import com.droid.alex.willtrip.R

class RoundButton : Button {

    private val paint = Paint()
    private val circlePaint = Paint()

    private var selectedState = false
    private var selectedColor = Color.GRAY
    private var mainColor = Color.LTGRAY
    private var strokeColor = Color.BLACK
    private var strokeWidth = 0

    init {
        this.setBackgroundColor(Color.TRANSPARENT)
        paint.flags = Paint.ANTI_ALIAS_FLAG
        circlePaint.flags = Paint.ANTI_ALIAS_FLAG
    }

    constructor(context: Context) : super(context) {
        getAttributes(null)
    }


    constructor(context: Context, attrs: AttributeSet) : super(context, attrs) {
        getAttributes(attrs)
    }
    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        getAttributes(attrs)
    }

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        val size = Math.max(measuredWidth, measuredHeight)
        setMeasuredDimension(size, size)
    }

    override fun onDraw(canvas: Canvas?) {
        if (!selectedState) {
            paint.color = mainColor
            strokeWidth = 0
        } else {
            paint.color = selectedColor
            strokeWidth = 4
        }
        circlePaint.color = strokeColor

        val radius = (this.width/2).toFloat()

        canvas?.drawCircle(radius, radius, radius, circlePaint)
        canvas?.drawCircle(radius, radius, radius - strokeWidth, paint)
        super.onDraw(canvas)
    }

    fun setSelectedState (selected: Boolean) {
        if (selectedState != selected) {
            selectedState = selected
            postInvalidate()
            requestLayout()
        }
    }

    fun swap () {
        setSelectedState(!selectedState)
        postInvalidate()
        requestLayout()
    }

    private fun getAttributes (attrs: AttributeSet?) {
        val ta: TypedArray = context.theme.obtainStyledAttributes(attrs, R.styleable.RoundButton, 0, 0)
        if (attrs == null) return
            try {
                selectedState = ta.getBoolean(R.styleable.RoundButton_selected, false)
                mainColor = ta.getColor(R.styleable.RoundButton_main_color, ContextCompat.getColor(context, R.color.colorLightGrey))
                selectedColor = ta.getColor(R.styleable.RoundButton_selected_color, ContextCompat.getColor(context, R.color.colorGrey))
                strokeColor = ta.getColor(R.styleable.RoundButton_stroke_color, ContextCompat.getColor(context, R.color.colorBlue))
            } finally {
                ta.recycle()
            }
    }
}


