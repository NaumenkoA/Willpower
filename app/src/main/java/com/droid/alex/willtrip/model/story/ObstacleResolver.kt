package com.droid.alex.willtrip.model.story

import com.droid.alex.willtrip.model.will.WillPower
import com.droid.alex.willtrip.object_box.DoDBHelper
import com.droid.alex.willtrip.object_box.SceneDBHelper
import java.util.*

class ObstacleResolver {
    private val doDBHelper = DoDBHelper()
    private val sceneDBHelper = SceneDBHelper ()
    private val obstacleLoader = ObstacleLoader()

    fun resolved (obstacleId: Int):Boolean {
        val obstacle = obstacleLoader.findObstacle(obstacleId)

        when (obstacle.type) {
            Obstacle.WP -> return (WillPower.power()>=obstacle.value?:1)

            Obstacle.COMP -> {
                return (doDBHelper.getMaxComplexity() >= obstacle.value?:1)
                }

            Obstacle.CHAIN -> {
                return (doDBHelper.getMaxChain() >= obstacle.value?:1)
                }

            Obstacle.COUNT -> {
                return (doDBHelper.count() >= obstacle.value?:1)
            }

            Obstacle.BONUS -> {
                WillPower.increase(obstacle.value as Int)
                obstacle.type = Obstacle.BONUS_GRANTED
                sceneDBHelper.saveObstacle(obstacle)
                return true
            }

            Obstacle.BONUS_GRANTED -> {
                return true
            }

            else -> return false
        }
    }
}
