package com.droid.alex.willtrip.model.story

import com.droid.alex.willtrip.R
import com.droid.alex.willtrip.extension_func.getRandomLink

class Story {

    private val themePalace = SceneTheme (link = 1, drawableId = R.drawable.palace, titleTextId = R.string.title_1, titleTintColorId = R.color.colorBlue, soundId = R.raw.king_tube)
    private val themeKing = SceneTheme (link = 2, drawableId = R.drawable.king, titleTextId = R.string.title_2, titleTintColorId = R.color.colorRed, soundId = R.raw.king)
    private val themeTrip = SceneTheme (link = 3, drawableId = R.drawable.trip, titleTextId = R.string.title_3, titleTintColorId = R.color.colorGreen, soundId = R.raw.chinease)
    private val themeGuard = SceneTheme (link = 4, drawableId = R.drawable.guard, titleTextId = R.string.title_4, titleTintColorId = R.color.colorBlue, soundId = R.raw.soldier)
    private val themeValley = SceneTheme (link = 5, drawableId = R.drawable.valley, titleTextId = R.string.title_5, titleTintColorId = R.color.colorGreen, soundId = R.raw.valley)
    private val themeForest = SceneTheme (link = 6, drawableId = R.drawable.forest, titleTextId = R.string.title_6, titleTintColorId = R.color.colorGreen, soundId = R.raw.forest)
    private val themeForestNight = SceneTheme (link = 7, drawableId = R.drawable.forest_night, titleTextId = R.string.title_7, titleTintColorId = R.color.colorBlue, soundId = R.raw.forest_night)
    private val themeDream = SceneTheme (link = 8, drawableId = R.drawable.dream, titleTextId = R.string.title_8, titleTintColorId = R.color.colorBlue, soundId = R.raw.horror)
    private val themeWolf = SceneTheme (link = 9, drawableId = R.drawable.wolf, titleTextId = R.string.title_9, titleTintColorId = R.color.colorDarkGrey, soundId = R.raw.wolf)
    private val themeTree = SceneTheme (link = 10, drawableId = R.drawable.tree, titleTextId = R.string.title_10, titleTintColorId = R.color.colorGreen, soundId = R.raw.wood_scratch)
    private val themeRiver = SceneTheme (link = 11, drawableId = R.drawable.river, titleTextId = R.string.title_11, titleTintColorId = R.color.colorLightBlue, soundId = R.raw.river)
    private val themeCroc = SceneTheme (link = 12, drawableId = R.drawable.crocodile, titleTextId = R.string.title_12, titleTintColorId = R.color.colorGreen, soundId = R.raw.alligator )
    private val themeDryLand = SceneTheme (link = 13, drawableId = R.drawable.dry_land, titleTextId = R.string.title_14, titleTintColorId = R.color.colorOrange, soundId = R.raw.wind)
    private val themeSkull = SceneTheme (link = 14, drawableId = R.drawable.skull, titleTextId = R.string.title_15, titleTintColorId = R.color.colorDarkGrey, soundId = R.raw.cautious)
    private val themeEagle = SceneTheme (link = 15, drawableId = R.drawable.eagle, titleTextId = R.string.title_16, titleTintColorId = R.color.colorOrange, soundId = R.raw.eagle)
    private val themeMountain = SceneTheme (link = 16, drawableId = R.drawable.mountain, titleTextId = R.string.title_17, titleTintColorId = R.color.colorDarkGrey, soundId = R.raw.mountain_wind)
    private val themeRedLand = SceneTheme (link = 17, drawableId = R.drawable.red_land, titleTextId = R.string.title_18, titleTintColorId = R.color.colorRed, soundId = R.raw.dragon_land)
    private val themeChest = SceneTheme (link = 18, drawableId = R.drawable.chest, titleTextId = R.string.title_13, titleTintColorId = R.color.colorBrown, soundId = R.raw.mystery )
    private val themeDragon = SceneTheme (link = 19, drawableId = R.drawable.dragon, titleTextId = R.string.title_19, titleTintColorId = R.color.colorRed, soundId = R.raw.dragon)
    private val themeWizardLand = SceneTheme (link = 20, drawableId = R.drawable.wizard_land, titleTextId = R.string.title_20, titleTintColorId = R.color.colorPurple, soundId = R.raw.beatiful)
    private val themeWizard = SceneTheme (link = 21, drawableId = R.drawable.wizard, titleTextId = R.string.title_21, titleTintColorId = R.color.colorBlue, soundId = R.raw.magic_spell)
    private val themeSword = SceneTheme (link = 22, drawableId = R.drawable.sword, titleTextId = R.string.title_22, titleTintColorId = R.color.colorBlue, soundId = R.raw.sword)
    private val themeFinal = SceneTheme (link = 23, drawableId = R.drawable.fist, titleTextId = R.string.title_23, titleTintColorId = R.color.colorBlue, soundId = R.raw.final_music)

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
    private val scene14 = Scene (link = 14, themeLink = 9, mainTextId = R.string.story_14, optionLinkArray = arrayListOf(141), obstacleLinkArray = arrayListOf())
    private val scene15 = Scene (link = 15, themeLink = 9, mainTextId = R.string.story_15, optionLinkArray = arrayListOf(151), obstacleLinkArray = arrayListOf(4))
    private val scene16 = Scene (link = 16, themeLink = 9, mainTextId = R.string.story_16, optionLinkArray = arrayListOf(161,162), obstacleLinkArray = arrayListOf())
    private val scene17 = Scene (link = 17, themeLink = 9, mainTextId = R.string.story_17, optionLinkArray = arrayListOf(171), obstacleLinkArray = arrayListOf())
    private val scene18 = Scene (link = 18, themeLink = 9, mainTextId = R.string.story_18, optionLinkArray = arrayListOf(171), obstacleLinkArray = arrayListOf())
    private val scene19 = Scene (link = 19, themeLink = 10, mainTextId = R.string.story_19, optionLinkArray = arrayListOf(191,192), obstacleLinkArray = arrayListOf())
    private val scene20 = Scene (link = 20, themeLink = 10, mainTextId = R.string.story_20, optionLinkArray = arrayListOf(201), obstacleLinkArray = arrayListOf())
    private val scene21 = Scene (link = 21, themeLink = 11, mainTextId = R.string.story_21, optionLinkArray = arrayListOf(211), obstacleLinkArray = arrayListOf())
    private val scene22 = Scene (link = 22, themeLink = 11, mainTextId = R.string.story_22, optionLinkArray = arrayListOf(221), obstacleLinkArray = arrayListOf())
    private val scene23 = Scene (link = 23, themeLink = 12, mainTextId = R.string.story_23, optionLinkArray = arrayListOf(231), obstacleLinkArray = arrayListOf(5))
    private val scene24 = Scene (link = 24, themeLink = 13, mainTextId = R.string.story_24, optionLinkArray = arrayListOf(241), obstacleLinkArray = arrayListOf())
    private val scene25 = Scene (link = 25, themeLink = 13, mainTextId = R.string.story_25, optionLinkArray = arrayListOf(251), obstacleLinkArray = arrayListOf(6))
    private val scene26 = Scene (link = 26, themeLink = 14, mainTextId = R.string.story_26, optionLinkArray = arrayListOf(261,262), obstacleLinkArray = arrayListOf())
    private val scene27 = Scene (link = 27, themeLink = 14, mainTextId = R.string.story_27, optionLinkArray = arrayListOf(271), obstacleLinkArray = arrayListOf(8))
    private val scene28 = Scene (link = 28, themeLink = 14, mainTextId = R.string.story_28, optionLinkArray = arrayListOf(281), obstacleLinkArray = arrayListOf(7))
    private val scene29 = Scene (link = 29, themeLink = 15, mainTextId = R.string.story_29, optionLinkArray = arrayListOf(291), obstacleLinkArray = arrayListOf())
    private val scene30= Scene (link = 30, themeLink = 15, mainTextId = R.string.story_30, optionLinkArray = arrayListOf(301), obstacleLinkArray = arrayListOf())
    private val scene31= Scene (link = 31, themeLink = 15, mainTextId = R.string.story_31, optionLinkArray = arrayListOf(311), obstacleLinkArray = arrayListOf(9))
    private val scene32= Scene (link = 32, themeLink = 15, mainTextId = R.string.story_32, optionLinkArray = arrayListOf(321), obstacleLinkArray = arrayListOf())
    private val scene33= Scene (link = 33, themeLink = 15, mainTextId = R.string.story_33, optionLinkArray = arrayListOf(331), obstacleLinkArray = arrayListOf())
    private val scene34= Scene (link = 34, themeLink = 15, mainTextId = R.string.story_34, optionLinkArray = arrayListOf(341), obstacleLinkArray = arrayListOf())
    private val scene35= Scene (link = 35, themeLink = 16, mainTextId = R.string.story_35, optionLinkArray = arrayListOf(351), obstacleLinkArray = arrayListOf())
    private val scene36= Scene (link = 36, themeLink = 16, mainTextId = R.string.story_36, optionLinkArray = arrayListOf(361), obstacleLinkArray = arrayListOf(10))
    private val scene37= Scene (link = 37, themeLink = 16, mainTextId = R.string.story_37, optionLinkArray = arrayListOf(371), obstacleLinkArray = arrayListOf())
    private val scene38= Scene (link = 38, themeLink = 17, mainTextId = R.string.story_38, optionLinkArray = arrayListOf(381), obstacleLinkArray = arrayListOf())
    private val scene39= Scene (link = 39, themeLink = 17, mainTextId = R.string.story_39, optionLinkArray = arrayListOf(391), obstacleLinkArray = arrayListOf())
    private val scene40= Scene (link = 40, themeLink = 17, mainTextId = R.string.story_40, optionLinkArray = arrayListOf(401), obstacleLinkArray = arrayListOf(11))
    private val scene41= Scene (link = 41, themeLink = 19, mainTextId = R.string.story_41, optionLinkArray = arrayListOf(411), obstacleLinkArray = arrayListOf())
    private val scene42= Scene (link = 42, themeLink = 19, mainTextId = R.string.story_42, optionLinkArray = arrayListOf(421), obstacleLinkArray = arrayListOf())
    private val scene43= Scene (link = 43, themeLink = 19, mainTextId = R.string.story_43, optionLinkArray = arrayListOf(431), obstacleLinkArray = arrayListOf(12,13))
    private val scene44= Scene (link = 44, themeLink = 19, mainTextId = R.string.story_44, optionLinkArray = arrayListOf(441), obstacleLinkArray = arrayListOf())
    private val scene45= Scene (link = 45, themeLink = 20, mainTextId = R.string.story_45, optionLinkArray = arrayListOf(451), obstacleLinkArray = arrayListOf())
    private val scene46= Scene (link = 46, themeLink = 21, mainTextId = R.string.story_46, optionLinkArray = arrayListOf(461), obstacleLinkArray = arrayListOf())
    private val scene47= Scene (link = 47, themeLink = 21, mainTextId = R.string.story_47, optionLinkArray = arrayListOf(471), obstacleLinkArray = arrayListOf())
    private val scene48= Scene (link = 48, themeLink = 21, mainTextId = R.string.story_48, optionLinkArray = arrayListOf(481), obstacleLinkArray = arrayListOf(14))
    private val scene49= Scene (link = 49, themeLink = 21, mainTextId = R.string.story_49, optionLinkArray = arrayListOf(491,492,493), obstacleLinkArray = arrayListOf())
    private val scene50= Scene (link = 50, themeLink = 21, mainTextId = R.string.story_50, optionLinkArray = arrayListOf(501), obstacleLinkArray = arrayListOf())
    private val scene51= Scene (link = 51, themeLink = 22, mainTextId = R.string.story_51, optionLinkArray = arrayListOf(511), obstacleLinkArray = arrayListOf())
    private val scene52= Scene (link = 52, themeLink = 22, mainTextId = R.string.story_52, optionLinkArray = arrayListOf(521), obstacleLinkArray = arrayListOf(15))
    private val scene53= Scene (link = 53, themeLink = 23, mainTextId = R.string.story_53, optionLinkArray = arrayListOf(531), obstacleLinkArray = arrayListOf())
    private val scene54= Scene (link = 54, themeLink = 18, mainTextId = R.string.story_54, optionLinkArray = arrayListOf(541,542), obstacleLinkArray = arrayListOf())
    private val scene55= Scene (link = 55, themeLink = 18, mainTextId = R.string.story_55, optionLinkArray = arrayListOf(551), obstacleLinkArray = arrayListOf())


    private val option1 = Option (link = 11, nextSceneLink = 2, textId =R.string.option_1)
    private val option2_1 = Option (link = 21, nextSceneLink = 3, textId = R.string.option_2_1)
    private val option2_2 = Option (link = 22, nextSceneLink = 3, textId =R.string.option_2_2)
    private val option2_3 = Option (link = 23, nextSceneLink = 3, textId =R.string.option_2_3)
    private val option3_1 = Option (link = 31, nextSceneLink = 4, textId = R.string.option_3_1)
    private val option3_2 = Option (link = 32, nextSceneLink = 4, textId =R.string.option_3_2)
    private val option4 = Option (link = 41, nextSceneLink = 5, textId = R.string.option_4)
    private val option5_1 = Option (link = 51, nextSceneLink = 8, textId = R.string.option_5_1)
    private val option5_2 = Option (link = 52, nextSceneLink = 6, textId = R.string.option_5_2)
    private val option6_1 = Option (link = 61, nextSceneLink = 8, textId = R.string.option_6_1)
    private val option6_2 = Option (link = 62, nextSceneLink = 7, textId = R.string.option_6_2)
    private val option7 = Option (link = 71, nextSceneLink = 8, textId = R.string.option_7_1)
    private val option8 = Option (link = 81, nextSceneLink = 9, textId = R.string.option_8_1)
    private val option9 = Option (link = 91, nextSceneLink = 10, textId = R.string.option_9)
    private val option10 = Option (link = 101, nextSceneLink = 11, textId = R.string.option_10)
    private val option11 = Option (link = 111, nextSceneLink = 12, textId = R.string.option_11)
    private val option12 = Option (link = 121, nextSceneLink = 13, textId = R.string.option_12)
    private val option13_1 = Option (link = 131, nextSceneLink = 14, textId = R.string.option_13_1)
    private val option13_2 = Option (link = 132, nextSceneLink = 14, textId = R.string.option_13_2)
    private val option14 = Option (link = 141, nextSceneLink = 15, textId = R.string.option_14)
    private val option15 = Option (link = 151, nextSceneLink = 16, textId = R.string.option_15)
    private val option16_1 = Option (link = 161, nextSceneLink = 17, textId = R.string.option_16_1)
    private val option16_2 = Option (link = 162, nextSceneLink = 18, textId = R.string.option_16_2)
    private val option17 = Option (link = 171, nextSceneLink = 19, textId = R.string.option_17)
    private val option19_1 = Option (link = 191, nextSceneLink = 20, textId = R.string.option_19_1)
    private val option19_2 = Option (link = 192, nextSceneLink = 21, textId = R.string.option_19_2)
    private val option20 = Option (link = 201, nextSceneLink = 21, textId = R.string.option_20)
    private val option21 = Option (link = 211, nextSceneLink = 22, textId = R.string.option_21)
    private val option22 = Option (link = 221, nextSceneLink = 23, textId = R.string.option_22)
    private val option23 = Option (link = 231, nextSceneLink = 24, textId = R.string.option_23)
    private val option24 = Option (link = 241, nextSceneLink = 25, textId = R.string.option_24)
    private val option25 = Option (link = 251, nextSceneLink = 26, textId = R.string.option_25)
    private val option26_1 = Option (link = 261, nextSceneLink = getRandomLink(27, 28), textId = R.string.option_26_1)
    private val option26_2 = Option (link = 262, nextSceneLink = 29, textId = R.string.option_26_2)
    private val option27 = Option (link = 271, nextSceneLink = 29, textId = R.string.option_27)
    private val option28 = Option (link = 281, nextSceneLink = 29, textId = R.string.option_28)
    private val option29 = Option (link = 291, nextSceneLink = 30, textId = R.string.option_29)
    private val option30 = Option (link = 301, nextSceneLink = 31, textId = R.string.option_30)
    private val option31 = Option (link = 311, nextSceneLink = 32, textId = R.string.option_31)
    private val option32 = Option (link = 321, nextSceneLink = 33, textId = R.string.option_32)
    private val option33 = Option (link = 331, nextSceneLink = 34, textId = R.string.option_33)
    private val option34 = Option (link = 341, nextSceneLink = 35, textId = R.string.option_34)
    private val option35 = Option (link = 351, nextSceneLink = 36, textId = R.string.option_35)
    private val option36 = Option (link = 361, nextSceneLink = 37, textId = R.string.option_36)
    private val option37 = Option (link = 371, nextSceneLink = 38, textId = R.string.option_37)
    private val option38 = Option (link = 381, nextSceneLink = 39, textId = R.string.option_38)
    private val option39 = Option (link = 391, nextSceneLink = 40, textId = R.string.option_39)
    private val option40 = Option (link = 401, nextSceneLink = 41, textId = R.string.option_40)
    private val option41 = Option (link = 411, nextSceneLink = 42, textId = R.string.option_41)
    private val option42 = Option (link = 421, nextSceneLink = 43, textId = R.string.option_42)
    private val option43 = Option (link = 431, nextSceneLink = 44, textId = R.string.option_43)
    private val option44 = Option (link = 441, nextSceneLink = 45, textId = R.string.option_44)
    private val option45 = Option (link = 451, nextSceneLink = 54, textId = R.string.option_45)
    private val option46 = Option (link = 461, nextSceneLink = 47, textId = R.string.option_46)
    private val option47 = Option (link = 471, nextSceneLink = 48, textId = R.string.option_47)
    private val option48 = Option (link = 481, nextSceneLink = 49, textId = R.string.option_48)
    private val option49_1 = Option (link = 491, nextSceneLink = 50, textId = R.string.option_49_1)
    private val option49_2 = Option (link = 492, nextSceneLink = 50, textId = R.string.option_49_2)
    private val option49_3 = Option (link = 493, nextSceneLink = 50, textId = R.string.option_49_3)
    private val option50 = Option (link = 501, nextSceneLink = 51, textId = R.string.option_50)
    private val option51 = Option (link = 511, nextSceneLink = 52, textId = R.string.option_51)
    private val option52 = Option (link = 521, nextSceneLink = 53, textId = R.string.option_52)
    private val option53 = Option (link = 531, nextSceneLink = 1, textId = R.string.option_53)
    private val option54_1 = Option (link = 541, nextSceneLink = 55, textId = R.string.option_54_1)
    private val option54_2 = Option (link = 542, nextSceneLink = 46, textId = R.string.option_54_2)
    private val option55 = Option (link = 551, nextSceneLink = 46, textId = R.string.option_55)

    //scene 4
    private val obstacle1 = Obstacle (link = 1, textId = R.string.obstacle_1, type = Obstacle.WP, value = 1)
    //scene 9
    private val obstacle2 = Obstacle (link = 2, textId = R.string.obstacle_2, type = Obstacle.WP, minValue = 15, addValue = 15)
    //scene 12
    private val obstacle3 = Obstacle (link = 3, textId = R.string.obstacle_3, type = Obstacle.WP, minValue = 35, addValue = 20)
    //scene 16
    private val obstacle4 = Obstacle (link = 4, textId = R.string.obstacle_4, type = Obstacle.WP, minValue = 60, addValue = 25)
    //scene 23
    private val obstacle5 = Obstacle (link = 5, textId = R.string.obstacle_5, type = Obstacle.WP, minValue = 90, addValue = 30)
    //scene 25
    private val obstacle6 = Obstacle (link = 6, textId = R.string.obstacle_6, type = Obstacle.CHAIN, minValue = 5, addValue = 3)
    //scene 27
    private val obstacle7 = Obstacle (link = 7, textId = R.string.obstacle_7, type = Obstacle.BONUS, minValue = 5, addValue = 0)
    //scene 28
    private val obstacle8 = Obstacle (link = 8, textId = R.string.obstacle_8, type = Obstacle.COUNT, minValue = 1, addValue = 1)
    //scene 31
    private val obstacle9 = Obstacle (link = 9, textId = R.string.obstacle_9, type = Obstacle.WP, minValue = 140, addValue = 40)
    //scene 36
    private val obstacle10 = Obstacle (link = 10, textId = R.string.obstacle_10, type = Obstacle.CHAIN, minValue = 10, addValue = 5)
    //scene 40
    private val obstacle11 = Obstacle (link = 11, textId = R.string.obstacle_11, type = Obstacle.WP, minValue = 200, addValue = 60)
    //scene 43
    private val obstacle12 = Obstacle (link = 12, textId = R.string.obstacle_12, type = Obstacle.COMP, minValue = 5, addValue = 0)
    private val obstacle13 = Obstacle (link = 13, textId = R.string.obstacle_13, type = Obstacle.WP, minValue = 270, addValue = 70)
    //scene 48
    private val obstacle14 = Obstacle (link = 14, textId = R.string.obstacle_14, type = Obstacle.WP, minValue = 350, addValue = 80)
    //scene 52
    private val obstacle15 = Obstacle (link = 15, textId = R.string.obstacle_15, type = Obstacle.WP, minValue = 450, addValue = 100)

        val themeList = listOf(themePalace, themeKing, themeTrip, themeGuard, themeValley, themeForest, themeForestNight, themeDream, themeWolf, themeTree, themeRiver, themeCroc,
                themeDryLand, themeSkull, themeEagle, themeMountain, themeRedLand, themeChest, themeDragon, themeWizardLand, themeWizard, themeSword, themeFinal)
        val sceneList = listOf(scene1, scene2, scene3, scene4, scene5, scene6, scene7, scene8, scene9, scene10, scene11, scene12, scene13, scene14, scene15, scene16, scene17,
                scene18, scene19, scene20, scene21, scene22, scene23, scene24, scene25, scene26, scene27, scene28, scene29, scene30, scene31, scene32, scene33, scene33,
                scene34, scene35, scene36, scene37, scene38, scene39, scene40, scene41, scene42, scene43, scene44, scene45, scene46, scene47, scene48, scene49, scene50,
                scene51, scene52, scene53, scene54, scene55)
        val optionList = listOf(option1, option2_1, option2_2, option2_3, option3_1, option3_2, option4, option5_1, option5_2, option6_1, option6_2, option7, option8
        , option9, option10, option11, option12, option13_1, option13_2, option14, option15, option16_1, option16_2, option17, option19_2, option19_1, option20, option21, option22,
                option23, option24, option25, option26_1, option26_2, option27, option28, option29, option30, option31, option32, option33, option34, option35, option36,
                option37, option38, option39, option40, option41, option42, option43, option44, option45, option46, option47, option48, option49_1, option49_2, option49_3,
                option50, option51,option52, option53, option54_1, option54_2, option55)
        val obstacleList = listOf(obstacle1, obstacle2, obstacle3, obstacle4, obstacle5, obstacle6, obstacle7, obstacle8, obstacle9, obstacle10, obstacle11, obstacle12, obstacle13,
                obstacle14, obstacle15)
}