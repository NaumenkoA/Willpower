package com.droid.alex.willtrip.presenter

import android.content.Context
import com.droid.alex.willtrip.model.story.CurrentScene
import com.droid.alex.willtrip.model.story.SceneManager

class TalePresenter (private val taleView: TaleView, val context: Context): Presenter {

    private val sceneManager = SceneManager(context)
    private lateinit var currentScene: CurrentScene
    private var isNewThemePlayed: Boolean = true

    override fun onCreate() {

    }

    override fun onPause() {

    }

    override fun onResume() {
        showScene(true)
    }

    override fun onDestroy() {
        sceneManager.saveState(isNewThemePlayed)
    }

    fun onOptionSelected (buttonNumber: Int) {
        sceneManager.optionSelected(currentScene.optionTextArray.size - buttonNumber + 1)
        showScene(false)
    }

    fun onBackButtonPressed (){
        sceneManager.rollBack()
        showScene(true)
    }

    fun onPictureClicked() {
         taleView.prepareForeground(true)
         isNewThemePlayed = true
       }

    private fun showScene (isSceneLoaded: Boolean) {
        currentScene = sceneManager.getCurrentScene()
        val theme = currentScene.sceneTheme

        when {

            (isSceneLoaded && (!currentScene.isNewTheme||sceneManager.isNewThemePlayed)) -> {
                taleView.emptyScreen()
                taleView.showBackground(theme.drawableId, theme.titleTextId, theme.titleTintColorId, false)
                taleView.prepareForeground(false)
                showSceneContent(true)
            }

            (isSceneLoaded && currentScene.isNewTheme) -> {
                taleView.emptyScreen()
                taleView.playSound(theme.soundId)
                taleView.showBackground(theme.drawableId, theme.titleTextId, theme.titleTintColorId, true)
                isNewThemePlayed = false
            }

            currentScene.isNewTheme -> {
                taleView.emptyScreen()
                taleView.stopSound()
                taleView.showBackground(theme.drawableId, theme.titleTextId, theme.titleTintColorId, true)
                taleView.playSound(theme.soundId)
                isNewThemePlayed = false
            }
            else -> showSceneContent(true)
        }
    }

    fun onBackgroundReady() {
        showSceneContent(true)
    }

    private fun showSceneContent(isAnimated: Boolean) {
        taleView.showSceneContent(currentScene.mainText, currentScene.obstacleTextArray, currentScene.optionTextArray, currentScene.isObstacleResolved, isAnimated)
    }

    interface TaleView {
        fun emptyScreen()
        fun showBackground (drawableId: Int, titleTextId: Int, titleTintColor: Int, isAnimated: Boolean)
        fun prepareForeground (isAnimated: Boolean)
        fun showSceneContent (mainText: String, obstacleList: ArrayList <String>?, optionList: ArrayList <String>, isOptionEnabled: Boolean = true, isAnimated: Boolean)
        fun playSound (soundId: Int)
        fun stopSound ()
    }
}