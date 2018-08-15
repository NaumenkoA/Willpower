package com.droid.alex.willtrip.ui

import android.animation.*
import android.content.res.ColorStateList
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup

import com.droid.alex.willtrip.R
import android.graphics.ColorMatrixColorFilter
import android.graphics.ColorMatrix
import android.media.MediaPlayer
import android.support.v4.content.ContextCompat
import android.support.v7.graphics.Palette
import android.widget.Button
import com.droid.alex.willtrip.presenter.TalePresenter
import kotlinx.android.synthetic.main.fragment_tale.*
import android.graphics.BitmapFactory
import android.graphics.Bitmap
import android.widget.Toast


class TaleFragment : Fragment(), TalePresenter.TaleView {

    private lateinit var presenter: TalePresenter
    private val matrix = ColorMatrix()
    private var mediaPlayer: MediaPlayer? = null
    private lateinit var buttonArray: ArrayList <Button>

    interface OnSettingsSelectedListener {
       fun onSettingsSelected()
    }

    override fun emptyScreen() {
        hidingImageView.alpha = 0f
        titleTextView.visibility = View.INVISIBLE
        stageTextView.visibility = View.INVISIBLE
        obstacleTextView.visibility = View.INVISIBLE
        optionButton1.visibility = View.INVISIBLE
        optionButton2.visibility = View.INVISIBLE
        optionButton3.visibility = View.INVISIBLE
    }

    override fun showBackground(drawableId: Int, titleTextId: Int, titleTintColor: Int, isAnimated: Boolean) {
        scenePicture.setImageResource(drawableId)
        setFragmentBackgroundColor(drawableId)
        matrix.setSaturation(1f)
        scenePicture.colorFilter = ColorMatrixColorFilter (matrix)

        titleTextView.visibility = View.VISIBLE
        titleTextView.text = context?.getString(titleTextId)
        titleTextView.background.setTint(ContextCompat.getColor(context!!, titleTintColor))

                hidingImageView.bringToFront()
        hidingImageView.setOnClickListener {
            presenter.onPictureClicked()
        }

        titleTextView.setOnClickListener {
            presenter.onPictureClicked()
        }

        if (isAnimated) {
            val titleFadeInAnimator = ObjectAnimator.ofFloat(titleTextView, "alpha", 0f, 1f)
            titleFadeInAnimator.duration = 2000
            val imageFadeInAnimator = ObjectAnimator.ofFloat(scenePicture, "alpha", 0f, 1f)
            imageFadeInAnimator.duration = 2000
            val animatorSet = AnimatorSet()
            animatorSet.play(titleFadeInAnimator).with(imageFadeInAnimator)
            animatorSet.start()
        }
    }

    private fun setFragmentBackgroundColor(drawableId: Int) {
        val bitmap = BitmapFactory.decodeResource(context!!.resources, drawableId)
        val palette = Palette.from(bitmap).generate()
        val color = palette.getLightVibrantColor(ContextCompat.getColor(context!!, R.color.colorGrey));
        this.view!!.setBackgroundColor(color)
    }

    override fun prepareForeground(isAnimated: Boolean) {

        titleTextView.setOnClickListener {  }
        hidingImageView.setOnClickListener {  }
        titleTextView.bringToFront()
        settingsLayout.bringToFront()

        if (isAnimated) {
            val saturationAnimator = ObjectAnimator.ofFloat(matrix, "saturation", 1f, 0f)
            saturationAnimator.duration = 1000
            saturationAnimator.addUpdateListener {
                val filter = ColorMatrixColorFilter(matrix)
                scenePicture.colorFilter = filter
            }
            val backgroundAnimator = ObjectAnimator.ofFloat(hidingImageView, "alpha", 0f, 1f)
            backgroundAnimator.duration = 1000
            backgroundAnimator.addListener(object : Animator.AnimatorListener {
                override fun onAnimationStart(animation: Animator) {}

                override fun onAnimationEnd(animation: Animator) {
                   presenter.onBackgroundReady()
                }
                override fun onAnimationCancel(animation: Animator) {}

                override fun onAnimationRepeat(animation: Animator) {}
            })

            val animatorSet = AnimatorSet()
            animatorSet.playTogether(saturationAnimator, backgroundAnimator)
            animatorSet.start()
        } else {
            matrix.setSaturation(0f)
            scenePicture.colorFilter = ColorMatrixColorFilter (matrix)
            hidingImageView.alpha = 1f
        }
    }


    override fun playSound(soundId: Int) {
        mediaPlayer = MediaPlayer.create(context, soundId)
        mediaPlayer?.start()
    }

    override fun showSceneContent(mainText: String, obstacleList: ArrayList<String>?, optionList: ArrayList<String>, isOptionEnabled: Boolean, isAnimated: Boolean) {
        contentLayout.invalidate()
        stageTextView.visibility = View.VISIBLE
        scrollView.bringToFront()
        buttonArray.forEachIndexed { index, button ->
            val i = optionList.size - 1 - index
            setButtonState(button, optionList.getOrNull(i), isOptionEnabled)
        }

        stageTextView.text = mainText
        var obstacleText = ""
            obstacleList?.forEach { it ->
                obstacleText += it +"\n"
            }
        if (obstacleText == "") obstacleTextView.visibility = View.GONE
        else{
            obstacleTextView.visibility = View.VISIBLE
            obstacleTextView.text = obstacleText
        }

        if (isAnimated) {
            val stageTextFadeInAnimator = ObjectAnimator.ofFloat(stageTextView, "alpha", 0f, 1f)
            stageTextFadeInAnimator.duration = 1000
            val obstacleTextFadeInAnimator = ObjectAnimator.ofFloat(obstacleTextView, "alpha", 0f, 1f)
            obstacleTextFadeInAnimator.duration = 1000
            val button1FadeInAnimator = ObjectAnimator.ofFloat(optionButton1, "alpha", 0f, 1f)
            button1FadeInAnimator.duration = 1000
            val button2FadeInAnimator = ObjectAnimator.ofFloat(optionButton2, "alpha", 0f, 1f)
            button2FadeInAnimator.duration = 1000
            val button3FadeInAnimator = ObjectAnimator.ofFloat(optionButton3, "alpha", 0f, 1f)
            button3FadeInAnimator.duration = 1000

            val animatorSet = AnimatorSet()
            animatorSet.playTogether(stageTextFadeInAnimator, obstacleTextFadeInAnimator, button1FadeInAnimator, button2FadeInAnimator, button3FadeInAnimator)
            animatorSet.start()
        }
    }

    override fun stopSound() {
       mediaPlayer?.stop()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.fragment_tale, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        // options are reversed on buttons for better perception
        optionButton1.setOnClickListener {
            presenter.onOptionSelected(1)
        }
        optionButton2.setOnClickListener {
            presenter.onOptionSelected(2)
        }
        optionButton3.setOnClickListener {
            presenter.onOptionSelected(3)
        }

        backButton.setOnClickListener {
            presenter.onBackButtonPressed()
        }

        buttonArray = arrayListOf(optionButton1, optionButton2, optionButton3)

        matrix.setSaturation(1f)

        settingsButton.setOnClickListener { (activity as OnSettingsSelectedListener).onSettingsSelected() }
    }

    private fun setButtonState (button: Button, text: String?, isEnabled: Boolean) {
        if (text==null) button.visibility = View.GONE
        else {
            button.visibility = View.VISIBLE
            button.isEnabled = isEnabled
            button.text = text
        }
    }

    override fun onResume() {
        super.onResume()
        presenter = TalePresenter(this, context!!)
        presenter.onResume()
    }

    override fun onDestroy() {
        super.onDestroy()
        presenter.onDestroy()
    }

    override fun onPause() {
        super.onPause()
        presenter.onPause()
        mediaPlayer?.release()
        mediaPlayer = null
    }
}
