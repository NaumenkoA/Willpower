package com.droid.alex.willtrip.object_box

import com.droid.alex.willtrip.App
import com.droid.alex.willtrip.model.story.*



class SceneDBHelper {
     val sceneBox  by lazy {
         App.instance.getBoxStore().boxFor(Scene::class.java)
     }
     val optionBox by lazy {
         App.instance.getBoxStore().boxFor(Option::class.java)
     }
     val obstacleBox  by lazy {
         App.instance.getBoxStore().boxFor(Obstacle::class.java)
     }
     val themeBox  by lazy {
         App.instance.getBoxStore().boxFor(SceneTheme::class.java)
     }

    fun findScene (link: Int): Scene? {
        val sceneQueryBuilder =  sceneBox.query()
        return sceneQueryBuilder.equal(Scene_.link, link.toLong()).build().findUnique()
    }


    fun findSceneTheme(themeLink: Int): SceneTheme? {
        val themeQueryBuilder =  themeBox.query()
        return themeQueryBuilder.equal(SceneTheme_.link, themeLink.toLong()).build().findUnique()
    }

    fun findOption (link: Int): Option? {
        val optionQueryBuilder = optionBox.query()
        return optionQueryBuilder.equal(Option_.link, link.toLong()).build().findUnique()
    }

    fun findObstacle (link: Int): Obstacle? {
        val obstacleQueryBuilder = obstacleBox.query()
        return obstacleQueryBuilder.equal(Obstacle_.link, link.toLong()).build().findUnique()
    }

    fun saveStory (story: Story) {
        themeBox.removeAll()
        sceneBox.removeAll()
        optionBox.removeAll()
        obstacleBox.removeAll()

        themeBox.put(story.themeList)
        sceneBox.put(story.sceneList)
        optionBox.put(story.optionList)
        obstacleBox.put(story.obstacleList)
    }

    fun saveObstacle(obstacle: Obstacle?) {
        obstacleBox.put(obstacle)
    }
}