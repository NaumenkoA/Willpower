package com.droid.alex.willtrip.model.story

import android.content.Context
import com.droid.alex.willtrip.object_box.IntDBHelper
import java.util.*

class SceneManager (val context: Context) {

    private val intDBHelper= IntDBHelper()
    private val sceneLoader = SceneLoader()
    private val obstacleResolver = ObstacleResolver()
    private val sceneLinkStack = Stack <Int> ()

    private var currentSceneLink: Int = 0
    private var previousSceneThemeLink: Int = 0
    var isNewThemePlayed: Boolean = false

    init {
        currentSceneLink = if (intDBHelper.getIntOrZero(2) != 0) intDBHelper.getIntOrZero(2)
        else 1
        previousSceneThemeLink = intDBHelper.getIntOrZero(3)
        isNewThemePlayed = (intDBHelper.getIntOrZero(4) == 1)

        sceneLoader.loadScene(currentSceneLink)
        }

    fun optionSelected (optionNumber: Int) {
        if (checkObstaclesResolved()) {
            val option = sceneLoader.optionArray[optionNumber - 1]
            sceneLinkStack.add(currentSceneLink)
            currentSceneLink = option.nextSceneLink
            previousSceneThemeLink = sceneLoader.currentScene.themeLink
            sceneLoader.loadScene(currentSceneLink)
        }
    }

    fun rollBack () {
        if (!sceneLinkStack.empty()) {
            currentSceneLink = sceneLinkStack.pop()
            sceneLoader.loadScene(currentSceneLink)
        }
    }

    fun getCurrentScene (): CurrentScene {
        val sceneTheme = sceneLoader.sceneTheme
        val mainText = context.resources.getString(sceneLoader.currentScene.mainTextId)

        val optionTextArray = arrayListOf<String>()
        sceneLoader.optionArray.forEach {
           optionTextArray.add(context.resources.getString (it.textId))
        }

        val obstacleTextArray = arrayListOf<String>()
        sceneLoader.obstacleArray.forEach {
            obstacleTextArray.add (context.resources.getString (it.textId, it.value.toString()))
        }

        val isNewTheme = (previousSceneThemeLink == 0 || sceneTheme.link != previousSceneThemeLink)

        return CurrentScene(sceneTheme, isNewTheme, mainText, optionTextArray, obstacleTextArray, checkObstaclesResolved())
    }

    private fun checkObstaclesResolved (): Boolean {
        var allObstacleResolved = true
        sceneLoader.currentScene.obstacleLinkArray.forEach {
            if (!obstacleResolver.resolved(it)) allObstacleResolved = false
        }
        return allObstacleResolved
    }

    fun saveState (isNewThemePlayed: Boolean) {
        intDBHelper.saveInt(2, currentSceneLink)
        intDBHelper.saveInt(3, previousSceneThemeLink)
        intDBHelper.saveInt(4, if (isNewThemePlayed) 1 else 0)
    }

}