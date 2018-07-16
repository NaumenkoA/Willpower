package com.droid.alex.willtrip.model.story

import com.droid.alex.willtrip.R

class Story {

    private val themePalace = SceneTheme (link = 1, drawableId = R.drawable.palace, titleTextId = R.string.title_1, titleTintColorId = R.color.colorBlue, soundId = R.raw.king_tube)
    private val themeKing = SceneTheme (link = 2, drawableId = R.drawable.king, titleTextId = R.string.title_2, titleTintColorId = R.color.colorRed, soundId = R.raw.king)
    private val themeTrip = SceneTheme (link = 3, drawableId = R.drawable.trip, titleTextId = R.string.title_3, titleTintColorId = R.color.colorGreen, soundId = R.raw.chinease)
    private val themeGuard = SceneTheme (link = 4, drawableId = R.drawable.guard, titleTextId = R.string.title_4, titleTintColorId = R.color.colorBlue, soundId = R.raw.soldier)
    private val themeValley = SceneTheme (link = 5, drawableId = R.drawable.valley, titleTextId = R.string.title_5, titleTintColorId = R.color.colorGreen, soundId = R.raw.valley)
    private val themeForest = SceneTheme (link = 6, drawableId = R.drawable.forest, titleTextId = R.string.title_6, titleTintColorId = R.color.colorGreen, soundId = R.raw.forest)
    private val themeForestNight = SceneTheme (link = 7, drawableId = R.drawable.forest_night, titleTextId = R.string.title_7, titleTintColorId = R.color.colorBlue, soundId = R.raw.forest_night)
    private val themeDream = SceneTheme (link = 8, drawableId = R.drawable.dream, titleTextId = R.string.title_8, titleTintColorId = R.color.colorBlue, soundId = R.raw.horror)
    private val themeWolf = SceneTheme (link = 9, drawableId = R.drawable.wolf, titleTextId = R.string.title_9, titleTintColorId = R.color.colorGrey, soundId = R.raw.wolf)
    private val themeTree = SceneTheme (link = 10, drawableId = R.drawable.tree, titleTextId = R.string.title_10, titleTintColorId = R.color.colorGreen, soundId = R.raw.wood_scratch)
    private val themeRiver = SceneTheme (link = 11, drawableId = R.drawable.river, titleTextId = R.string.title_11, titleTintColorId = R.color.colorLightBlue, soundId = R.raw.river)
    private val themeCroc = SceneTheme (link = 12, drawableId = R.drawable.crocodile, titleTextId = R.string.title_12, titleTintColorId = R.color.colorGrey, soundId = R.raw.alligator )
    private val themeDryLand = SceneTheme (link = 13, drawableId = R.drawable.dry_land, titleTextId = R.string.title_14, titleTintColorId = R.color.colorDarkYellow, soundId = R.raw.wind)
    private val themeSkull = SceneTheme (link = 14, drawableId = R.drawable.skull, titleTextId = R.string.title_15, titleTintColorId = R.color.colorGrey, soundId = R.raw.cautious)
    private val themeEagle = SceneTheme (link = 15, drawableId = R.drawable.eagle, titleTextId = R.string.title_16, titleTintColorId = R.color.colorGrey, soundId = R.raw.eagle)
    private val themeMountain = SceneTheme (link = 16, drawableId = R.drawable.mountain, titleTextId = R.string.title_17, titleTintColorId = R.color.colorGrey, soundId = R.raw.mountain_wind)
    private val themeRedLand = SceneTheme (link = 17, drawableId = R.drawable.red_land, titleTextId = R.string.title_18, titleTintColorId = R.color.colorRed, soundId = R.raw.dragon_land)
    private val themeChest = SceneTheme (link = 18, drawableId = R.drawable.chest, titleTextId = R.string.title_13, titleTintColorId = R.color.colorBlue, soundId = R.raw.mystery )
    private val themeDragon = SceneTheme (link = 19, drawableId = R.drawable.dragon, titleTextId = R.string.title_19, titleTintColorId = R.color.colorRed, soundId = R.raw.dragon)
    private val themeWizardLand = SceneTheme (link = 20, drawableId = R.drawable.wizard_land, titleTextId = R.string.title_20, titleTintColorId = R.color.colorGreen, soundId = R.raw.beatiful)
    private val themeWizard = SceneTheme (link = 21, drawableId = R.drawable.wizard, titleTextId = R.string.title_21, titleTintColorId = R.color.colorBlue, soundId = R.raw.magic_spell)

    private val scene1 = Scene (link=1, themeLink = 1,  mainTextId = R.string.story_1, optionLinkArray = arrayListOf(11), obstacleLinkArray = arrayListOf())
    private val scene2 = Scene (link=2, themeLink = 2, mainTextId = R.string.story_2, optionLinkArray = arrayListOf(21,22,23), obstacleLinkArray = arrayListOf())
    private val scene3 = Scene (link=3, themeLink = 2, mainTextId = R.string.story_3, optionLinkArray = arrayListOf(31,32), obstacleLinkArray = arrayListOf())
    private val scene4 = Scene (link=4, themeLink = 3, mainTextId = R.string.story_4, optionLinkArray = arrayListOf(41), obstacleLinkArray =arrayListOf(1))
    private val scene5 = Scene (link=5, themeLink = 4, mainTextId = R.string.story_5, optionLinkArray = arrayListOf(51,52), obstacleLinkArray =arrayListOf())
    private val scene6 = Scene (link=6, themeLink = 4, mainTextId = R.string.story_6, optionLinkArray = arrayListOf(61,62), obstacleLinkArray =arrayListOf())
    private val scene7 = Scene (link=7, themeLink = 4, mainTextId = R.string.story_7, optionLinkArray = arrayListOf(71), obstacleLinkArray =arrayListOf())
    private val scene8 = Scene (link=8, themeLink = 5, mainTextId = R.string.story_8, optionLinkArray = arrayListOf(81), obstacleLinkArray =arrayListOf())
    private val scene9 = Scene (link=9, themeLink = 5, mainTextId = R.string.story_9, optionLinkArray = arrayListOf(91), obstacleLinkArray =arrayListOf(2))
    private val scene10 = Scene (link=10, themeLink = 6, mainTextId = R.string.story_10, optionLinkArray = arrayListOf(101), obstacleLinkArray =arrayListOf())
    private val scene11 = Scene (link=11, themeLink = 7, mainTextId = R.string.story_11, optionLinkArray = arrayListOf(111), obstacleLinkArray =arrayListOf())
    private val scene12 = Scene (link=12, themeLink = 7, mainTextId = R.string.story_12, optionLinkArray = arrayListOf(121), obstacleLinkArray =arrayListOf(3))
    private val scene13 = Scene (link=13, themeLink = 8, mainTextId = R.string.story_13, optionLinkArray = arrayListOf(131,132), obstacleLinkArray =arrayListOf())
    //private val scene14 = Scene (link = 14, themeLink = 9, mainTextId = R.string.story_14, optionLinkArray = arrayListOf(141), obstacleLinkArray = )

    private val option1 = Option (link = 11, nextSceneLink = 2, textId =R.string.option_1)
    private val option_2_1 = Option (link = 21, nextSceneLink = 3, textId = R.string.option_2_1)
    private val option_2_2 = Option (link = 22, nextSceneLink = 3, textId =R.string.option_2_2)
    private val option_2_3 = Option (link = 23, nextSceneLink = 3, textId =R.string.option_2_3)
    private val option_3_1 = Option (link = 31, nextSceneLink = 4, textId = R.string.option_3_1)
    private val option_3_2 = Option (link = 32, nextSceneLink = 4, textId =R.string.option_3_2)
    private val option_4 = Option (link = 41, nextSceneLink = 5, textId = R.string.option_4)
    private val option_5_1 = Option (link = 51, nextSceneLink = 8, textId = R.string.option_5_1)
    private val option_5_2 = Option (link = 52, nextSceneLink = 6, textId = R.string.option_5_2)
    private val option_6_1 = Option (link = 61, nextSceneLink = 8, textId = R.string.option_6_1)
    private val option_6_2 = Option (link = 62, nextSceneLink = 7, textId = R.string.option_6_2)
    private val option_7 = Option (link = 71, nextSceneLink = 8, textId = R.string.option_7_1)
    private val option_8 = Option (link = 81, nextSceneLink = 9, textId = R.string.option_8_1)
    private val option_9 = Option (link = 91, nextSceneLink = 10, textId = R.string.option_9)
    private val option_10 = Option (link = 101, nextSceneLink = 11, textId = R.string.option_10)
    private val option_11 = Option (link = 111, nextSceneLink = 12, textId = R.string.option_11)
    private val option_12 = Option (link = 121, nextSceneLink = 13, textId = R.string.option_12)
    private val option_13_1 = Option (link = 131, nextSceneLink = 14, textId = R.string.option_13_1)
    private val option_13_2 = Option (link = 132, nextSceneLink = 14, textId = R.string.option_13_2)

    //scene 4
    private val obstacle1 = Obstacle (link = 1, textId = R.string.obstacle_1, type = Obstacle.WP, value = 1)
    //scene 9
    private val obstacle2 = Obstacle (link = 2, textId = R.string.obstacle_2, type = Obstacle.WP, minValue = 15, addValue = 15)
    //scene 12
    private val obstacle3 = Obstacle (link = 3, textId = R.string.obstacle_3, type = Obstacle.WP, minValue = 45, addValue = 30)

        val themeList = listOf(themePalace, themeKing, themeTrip, themeGuard, themeValley, themeForest, themeForestNight, themeDream, themeWolf, themeTree, themeRiver, themeCroc,
                themeDryLand, themeSkull, themeEagle, themeMountain, themeRedLand, themeChest, themeDragon, themeWizardLand, themeWizard)
        val sceneList = listOf(scene1, scene2, scene3, scene4, scene5, scene6, scene7, scene8, scene9, scene10, scene11, scene12, scene13)
        val optionList = listOf(option1, option_2_1, option_2_2, option_2_3, option_3_1, option_3_2, option_4, option_5_1, option_5_2, option_6_1, option_6_2, option_7, option_8
        , option_9, option_10, option_11, option_12, option_13_1, option_13_2)
        val obstacleList = listOf(obstacle1, obstacle2, obstacle3)
}