package com.droid.alex.willtrip.model.story

import android.content.Context
import com.droid.alex.willtrip.App
import com.droid.alex.willtrip.object_box.IntValue

class SceneManager (val context: Context) {

    private val intBox= App.instance.getBoxStore().boxFor(IntValue::class.java)
    private val sceneLoader = SceneLoader()
    private val obstacleResolver = ObstacleResolver()

    private var currentSceneId: Int = 0

    init {
        if (intBox.get(2) != null) currentSceneId = intBox.get(2).value
        else currentSceneId = 1

        sceneLoader.loadScene(currentSceneId.toLong())
    }

    fun optionSelected (optionNumber: Int) {
        if (checkObstaclesResolved()) {
            val option = sceneLoader.optionArray.get(optionNumber - 1)
            currentSceneId = option.nextSceneId
            sceneLoader.loadScene(currentSceneId.toLong())
        }
    }

    fun getCurrentScene (): CurrentScene {
        val title = context.resources.getString(sceneLoader.currentScene.titleTextId)
        val mainText = context.resources.getString(sceneLoader.currentScene.mainTextId)

        val optionTextArray = arrayListOf<String>()
        sceneLoader.optionArray.forEach {
           optionTextArray.add(context.resources.getString (it.textId))
        }

        val obstacleTextArray = arrayListOf<String>()
        sceneLoader.obstacleArray.forEach {
            obstacleTextArray.add (context.resources.getString (it.textId))
        }

        return CurrentScene(sceneLoader.currentScene.drawableId, title, mainText,
                optionTextArray, obstacleTextArray, checkObstaclesResolved())
    }

    fun checkObstaclesResolved (): Boolean {
        var allObstacleResolved = true
        sceneLoader.currentScene.obstacleIdArray.forEach {
            if (!obstacleResolver.resolved(it.toLong())) allObstacleResolved = false
        }
        return allObstacleResolved
    }

    fun saveState () {
        intBox.put(IntValue(2, currentSceneId))
    }

}