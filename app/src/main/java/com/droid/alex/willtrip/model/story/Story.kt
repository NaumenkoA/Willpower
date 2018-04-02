package com.droid.alex.willtrip.model.story

import com.droid.alex.willtrip.R

class Story () {

    private val theme1 = SceneTheme (link = 1, drawableId = R.drawable.palace, titleTextId = R.string.text_1, titleTintColorId = R.color.colorBlue, soundId = R.raw.fanfary)
    private val theme2 = SceneTheme (link = 2, drawableId = R.drawable.king, titleTextId = R.string.text_9, titleTintColorId = R.color.colorRed, soundId = R.raw.claps)
    private val theme3 = SceneTheme (link = 3, drawableId = R.drawable.trip, titleTextId = R.string.text_12, titleTintColorId = R.color.colorYellow, soundId = R.raw.city)

    private val scene1 = Scene (link=1, themeLink = 1,  mainTextId = R.string.text_2, optionLinkArray = arrayListOf(1), obstacleLinkArray = arrayListOf())
    private val scene2 = Scene (link=2, themeLink = 2, mainTextId = R.string.text_4, optionLinkArray = arrayListOf(2,3,4), obstacleLinkArray = arrayListOf())
    private val scene3 = Scene (link=3, themeLink = 2, mainTextId = R.string.text_8, optionLinkArray = arrayListOf(5,6), obstacleLinkArray = arrayListOf())
    private val scene4 = Scene (link=4, themeLink = 3, mainTextId = R.string.text_9, optionLinkArray = arrayListOf(7), obstacleLinkArray =arrayListOf(1))

    //scene 1
    private val option1 = Option (link = 1, nextSceneLink = 2, textId =R.string.text_3)
    //scene 2
    private val option2 = Option (link = 2, nextSceneLink = 3, textId = R.string.text_5)
    private val option3 = Option (link = 3, nextSceneLink = 3, textId =R.string.text_6)
    private val option4 = Option (link = 4, nextSceneLink = 3, textId =R.string.text_7)
    //scene 3
    private val option5 = Option (link = 5, nextSceneLink = 4, textId = R.string.text_10)
    private val option6 = Option (link = 6, nextSceneLink = 4, textId =R.string.text_11)
    //scene 4
    private val option7 = Option (link = 7, nextSceneLink = 1, textId = R.string.text_14)

    //scene 4
    private val obstacle1 = Obstacle (link = 1, textId = R.string.text_15, type = Obstacle.WP, value = 1)

        val themeList = listOf(theme1, theme2, theme3)
        val sceneList = listOf(scene1, scene2, scene3, scene4)
        val optionList = listOf(option1, option2, option3, option4, option5, option6, option7)
        val obstacleList = listOf(obstacle1)
}