package com.droid.alex.willtrip.object_box

import com.droid.alex.willtrip.App
import com.droid.alex.willtrip.model.story.*

class SceneDBHelper {
     val sceneBox  = App.instance.getBoxStore().boxFor(Scene::class.java)
     val optionBox  = App.instance.getBoxStore().boxFor(Option::class.java)
     val obstacleBox  = App.instance.getBoxStore().boxFor(Obstacle::class.java)

    fun findScene (id: Long): Scene {
        return sceneBox.get(id)
    }


    fun findOption (id: Long): Option {
        return optionBox.get(id)
    }

    fun findObstacle (id: Long): Obstacle {
        return obstacleBox.get(id)
    }

    fun saveStory (story: Story) {
        sceneBox.put(story.sceneList)
        optionBox.put(story.optionList)
        obstacleBox.put(story.obstacleList)
    }
}