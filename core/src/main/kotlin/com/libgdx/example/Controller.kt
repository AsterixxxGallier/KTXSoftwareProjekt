package com.libgdx.example

import com.libgdx.example.view.View

class Controller {
    val model = Model()
    val view = View(this)

    private fun changeScreen(nextScreen: Screen) {
        model.currentScreen = nextScreen
        view.showScreen(nextScreen)
    }

    fun started() {
//        changeScreen(Screen.Start)
        changeScreen(Screen.GameSelection)
    }

    fun playButtonPressed() {
        changeScreen(Screen.GameSelection)
    }
}
