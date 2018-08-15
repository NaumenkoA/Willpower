package com.droid.alex.willtrip.extension_func

import com.droid.alex.willtrip.model.story.Story
import java.util.*

fun Story.getRandomLink (firstLink: Int, secondLink: Int):Int {
    val random = Random()
    val int = random.nextInt(2)
    when (int) {
        0 -> return firstLink
        1 -> return secondLink
        else -> return firstLink
    }
}