package com.droid.alex.willtrip.presenter

import android.content.Context
import com.droid.alex.willtrip.model.story.CurrentScene
import com.droid.alex.willtrip.model.story.SceneManager

class TalePresenter (val taleView: TaleView, val context: Context): Presenter {

    private val sceneManager = SceneManager(context)
    private lateinit var currentScene: CurrentScene


    override fun onCreate() {

    }

    override fun onPause() {

    }

    override fun onResume() {
        showScene()
    }

    override fun onDestroy() {
        sceneManager.saveState()
    }

    fun onOptionSelected (buttonNumber: Int) {
        sceneManager.optionSelected(buttonNumber)
        showScene()
    }

    private fun showScene () {
        currentScene = sceneManager.getCurrentScene()
        taleView.showTitle(currentScene.titleText)
        taleView.showBackground(currentScene.drawableId)
        taleView.showMainText(currentScene.mainText)

        currentScene.optionTextArray.forEachIndexed { index, s ->
            when (index) {
                0 -> taleView.showOption1(s, currentScene.isObstacleResolved)
                1 -> taleView.showOption2(s, currentScene.isObstacleResolved)
                2 -> taleView.showOption3(s, currentScene.isObstacleResolved)
            }
        }

        val optionNumber = currentScene.optionTextArray.size
        for (i in 3 downTo optionNumber + 1 step 1) {
            when (i)  {
                3 -> taleView.showOption3(null)
                2 -> taleView.showOption2(null)
                1 -> taleView.showOption1(null)
            }
        }

        var obstacleString = ""
        currentScene.obstacleTextArray.forEach {
            obstacleString += it
            obstacleString += System.getProperty("line.separator")
        }

        if (obstacleString == "") taleView.showObstacleText(null)
        else taleView.showObstacleText(obstacleString)
    }

    interface TaleView {
        fun showTitle (title: String)
        fun showMainText (text:String)
        fun showObstacleText (text:String?)
        fun showBackground (drawableId: Int)
        fun showOption1 (optionText: String?, isEnabled: Boolean = true)
        fun showOption2 (optionText: String?, isEnabled: Boolean = true)
        fun showOption3 (optionText: String?, isEnabled: Boolean = true)
    }
}