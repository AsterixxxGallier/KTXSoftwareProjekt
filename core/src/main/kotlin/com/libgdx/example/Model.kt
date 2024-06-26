package com.libgdx.example

/**
 * Model class for the MVC architecture.
 */
class Model {
    var currentScreen = Screen.Start
}

// enumeration = Aufzählung
enum class Screen {
    Start,
    GameSelection,
    TicTacToe,
    LunarLander,
}
