package com.droid.alex.willtrip.views.round_button

import android.widget.Button


class RoundButtonGroup (val buttonList: ArrayList <RoundButton>, private var isMultichoiceEnabled: Boolean ) {

    private var singleSelectedButton: RoundButton? = null

    init {
        setOnClickListener()
        }

    private fun setOnClickListener() {
        for (button in buttonList) {
            button.setOnClickListener {
                if (isMultichoiceEnabled) button.swap()
                else {
                    if (button != singleSelectedButton) {
                        singleSelectedButton?.swap()
                        singleSelectedButton = button
                        singleSelectedButton?.swap()
                    }
                }
            }
        }
    }

    fun setMultichoiceEnabled (enabled: Boolean) {
        isMultichoiceEnabled = enabled
        singleSelectedButton = null
        setOnClickListener()
    }

    fun getSelectedButtons (): ArrayList <Button> {
        val selectedList: ArrayList <Button> = arrayListOf()

        buttonList.filterTo(selectedList) { it.isSelectedState }
        return selectedList
    }

    fun clearSelection () {
        for (button in buttonList) {
            button.isSelectedState = false
        }
    }

    fun selectAll () {
        if (isMultichoiceEnabled) {
            for (button in buttonList) {
                if (!button.isSelectedState) button.swap()
            }
        }
    }
}

