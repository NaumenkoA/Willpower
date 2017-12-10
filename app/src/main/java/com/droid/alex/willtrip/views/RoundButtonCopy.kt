package com.droid.alex.willtrip.views

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.widget.Button

class RoundButtonCopy : Button {

    private val paint = Paint()
    private val circlePaint = Paint()
    private var color = Color.parseColor("#eaeaea")
    private var stroke = 0

    init {
        this.setBackgroundColor(Color.TRANSPARENT)
    }

    constructor(context: Context) : super(context)
    constructor(context: Context, attrs: AttributeSet) : super(context, attrs)
    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr)

    override fun onMeasure(widthMeasureSpec: Int, heightMeasureSpec: Int) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec)
        val size = Math.max(measuredWidth, measuredHeight)
        setMeasuredDimension(size, size)
    }

    override fun onDraw(canvas: Canvas?) {
        paint.color = color
        circlePaint.color = Color.BLACK
        paint.flags = Paint.ANTI_ALIAS_FLAG
        circlePaint.flags = Paint.ANTI_ALIAS_FLAG

        val radius = (this.width/2).toFloat()

        canvas?.drawCircle(radius, radius, radius, circlePaint)
        canvas?.drawCircle(radius, radius, radius - stroke, paint)
        super.onDraw(canvas)
    }

    fun setColor (color: Int) {
        this.color = color
        invalidate()
    }

    fun setStrokeWidth (strokeWidth: Int) {
        stroke = strokeWidth
        invalidate()
    }
}