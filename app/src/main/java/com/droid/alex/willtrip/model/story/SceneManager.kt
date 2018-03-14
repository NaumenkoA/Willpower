package com.droid.alex.willtrip.model.story

import com.droid.alex.willtrip.App
import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id

@Entity
class SceneManager (@Id (assignable = true) var id: Long = 1, var currentSceneId: Int = 0, var currentFragmentId: Int = 0){

    var currentScene = App.instance.getBoxStore().boxFor(Scene::class.java)

    fun optionSelected (option: Option) {

    }

}