package com.droid.alex.willtrip.model

enum class DayOfWeek() {

    DEFAULT (0),
    MONDAY (1),
    TUESDAY (2),
    WEDNESDAY (3),
    THURSDAY (4),
    FRIDAY (5),
    SATURDAY (6),
    SUNDAY (7);

    var id: Int = 0;

    constructor(id: Int) {
        this.id = id;
    }
}