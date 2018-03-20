package com.droid.alex.willtrip.model.story

import com.droid.alex.willtrip.model.will.WillPower
import com.droid.alex.willtrip.object_box.DoDBHelper
import com.droid.alex.willtrip.object_box.SceneDBHelper
import java.util.*

class ObstacleResolver {
    private val doDBHelper = DoDBHelper()
    private val sceneDBHelper = SceneDBHelper()

    fun resolved (obstacleId: Long):Boolean {
        val obstacle = sceneDBHelper.findObstacle(obstacleId)

        when (obstacle.type) {
            Obstacle.COUNT -> return (doDBHelper.count()>=obstacle.value)
            Obstacle.WP -> return (WillPower.power()>=obstacle.value)
            Obstacle.COMP -> {
                var maxComp = 0
                doDBHelper.loadNotExpired(Calendar.getInstance().time).forEach {
                    if (it.complexity > maxComp) maxComp = it.complexity
                }
                return (maxComp >= obstacle.value)
            }
            Obstacle.CHAIN -> {
                doDBHelper.loadNotExpired(Calendar.getInstance().time).forEach {
                    if (it.chain.target.length >= obstacle.value) return true
                }
                return false
            }
            else -> return false
        }
    }
}
