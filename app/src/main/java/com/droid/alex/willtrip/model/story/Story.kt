package com.droid.alex.willtrip.model.story

import com.droid.alex.willtrip.R

class Story () {

    private val scene1 = Scene (id=1, drawableId = R.drawable.palace, titleTextId = R.string.text_1, mainTextId = R.string.text_2, optionIdArray = arrayListOf(1), obstacleIdArray = arrayListOf())
    private val scene2 = Scene (id=2, drawableId = R.drawable.king, titleTextId = R.string.text_9, mainTextId = R.string.text_4, optionIdArray = arrayListOf(2,3,4), obstacleIdArray = arrayListOf())
    private val scene3 = Scene (id=3, drawableId = R.drawable.king, titleTextId = R.string.text_9, mainTextId = R.string.text_8, optionIdArray = arrayListOf(5,6), obstacleIdArray = arrayListOf())
    private val scene4 = Scene (id=4, drawableId = R.drawable.trip, titleTextId = R.string.text_12, mainTextId = R.string.text_9, optionIdArray = arrayListOf(7), obstacleIdArray = arrayListOf(1))

    //scene 1
    private val option1 = Option (1, 2, R.string.text_3)
    //scene 2
    private val option2 = Option (2, 3, R.string.text_5)
    private val option3 = Option (3, 3, R.string.text_6)
    private val option4 = Option (4, 3, R.string.text_7)
    //scene 3
    private val option5 = Option (5, 4, R.string.text_10)
    private val option6 = Option (6, 4, R.string.text_11)
    //scene 4
    private val option7 = Option (7, nextSceneId = 5, textId = R.string.text_14)

    //scene 4
    private val obstacle1 = Obstacle (1, R.string.text_15, Obstacle.WP, 1)

        val sceneList = listOf<Scene>(scene1, scene2, scene3, scene4)
        val optionList = listOf<Option>(option1, option2, option3, option4, option5, option6, option7)
        val obstacleList = listOf<Obstacle>(obstacle1)
}