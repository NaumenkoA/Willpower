package com.droid.alex.willtrip.model.story

import com.droid.alex.willtrip.model.will.WillPower
import com.droid.alex.willtrip.object_box.DoDBHelper
import com.droid.alex.willtrip.object_box.SceneDBHelper

class ObstacleLoader {

    private val sceneDBHelper = SceneDBHelper ()
    private val doDBHelper = DoDBHelper()

    fun findObstacle(obstacleId: Int): Obstacle {
        val obstacle = sceneDBHelper.findObstacle(obstacleId) ?: throw Exception ()
        if (obstacle.value == null) {
            when (obstacle.type) {
                Obstacle.WP -> {
                    if (WillPower.power() + obstacle.addValue < obstacle.minValue) obstacle.value = obstacle.minValue
                    else obstacle.value = WillPower.power() + obstacle.addValue
                }

                Obstacle.CHAIN -> {
                    val maxChain = doDBHelper.getMaxChain()
                    if (maxChain + obstacle.addValue < obstacle.minValue) obstacle.value = obstacle.minValue
                    else obstacle.value = maxChain + obstacle.addValue
                }

                Obstacle.COMP -> {
                    val maxComp = doDBHelper.getMaxComplexity()
                    if (maxComp + obstacle.addValue < obstacle.minValue) obstacle.value = obstacle.minValue
                    else obstacle.value = maxComp + obstacle.addValue
                }
            }
            sceneDBHelper.saveObstacle (obstacle)
            return obstacle
        } else
            return obstacle
    }
}