package com.libgdx.example

import com.libgdx.example.view.View

/**
 * Controller class for the MVC architecture.
 */
class Controller {
    // The controller manages both the model and the view.

    val model = Model()
    val view = View(this)

    private fun showScreen(nextScreen: Screen) {
        model.currentScreen = nextScreen
        view.showScreen(nextScreen)
    }

    /**
     * Called when the game has been created.
     *
     * Shows the start screen.
     */
    fun gameCreated() {
        view.addScreens()

        // Until the game selection screen is implemented, show the TicTacToe screen immediately.
        // showScreen(Screen.Start)
        showScreen(Screen.TicTacToe)
    }

    /**
     * Called when the play button has been pressed.
     *
     * Shows the game selection screen.
     */
    fun playButtonPressed() {
        showScreen(Screen.GameSelection)
    }

    fun symbolButtonPressed() {
        if (model.symbol == "x.jpg")
            model.symbol = "o.jpg"
        else if (model.symbol == "o.jpg")
            model.symbol = "x.jpg"

        println(model.symbol)
    }
}
