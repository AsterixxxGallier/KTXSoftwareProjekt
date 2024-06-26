package com.libgdx.example

/**
 * Model class for the MVC architecture.
 */
class Model {
    var currentScreen = Screen.Start

    var symbol = "x.jpg"
}

// enumeration = Aufzählung
enum class Screen {
    Start,
    GameSelection,
    TicTacToe,
}
