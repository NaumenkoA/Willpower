package com.droid.alex.willtrip.ui


import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.droid.alex.willtrip.R
import android.graphics.ColorMatrixColorFilter
import android.graphics.ColorMatrix
import android.widget.Button
import com.droid.alex.willtrip.presenter.TalePresenter
import kotlinx.android.synthetic.main.fragment_tale.*


class TaleFragment : Fragment(), TalePresenter.TaleView {

    private lateinit var presenter: TalePresenter

    override fun showTitle(title: String) {
       titleTextView.text = title
    }

    override fun showMainText(text: String) {
        stageTextView.text = text
    }

    override fun showObstacleText(text: String?) {
        if (text == null) {
            obstacleTextView.text = ""
        } else {
            obstacleTextView.text = text
        }
    }

    override fun showBackground(drawableId: Int) {
       scenePicture.setImageResource(drawableId)
    }

    override fun showOption1(optionText: String?, isEnabled: Boolean) {
        setButtonState(optionButton1, optionText, isEnabled)
    }

    override fun showOption2(optionText: String?, isEnabled: Boolean) {
        setButtonState(optionButton2, optionText, isEnabled)
    }

    override fun showOption3(optionText: String?, isEnabled: Boolean) {
        setButtonState(optionButton3, optionText, isEnabled)
    }


    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {

        return inflater!!.inflate(R.layout.fragment_tale, container, false)
    }

    override fun onViewCreated(view: View?, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val imageView = scenePicture
        val matrix = ColorMatrix()
        matrix.setSaturation(0f)

        val filter = ColorMatrixColorFilter(matrix)
        imageView.setColorFilter(filter)

        optionButton1.setOnClickListener {
            presenter.onOptionSelected(1)
        }
        optionButton2.setOnClickListener {
            presenter.onOptionSelected(2)
        }
        optionButton3.setOnClickListener {
            presenter.onOptionSelected(3)
        }

    }

    private fun setButtonState (button: Button, text: String?, isEnabled: Boolean) {
        if (text==null) button.visibility = View.INVISIBLE
        else {
            button.visibility = View.VISIBLE
            button.isEnabled = isEnabled
            button.text = text
        }
    }

    override fun onResume() {
        super.onResume()
        presenter = TalePresenter(this, context)
        presenter.onResume()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }
}
