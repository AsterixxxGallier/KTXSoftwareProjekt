package com.libgdx.example

import com.libgdx.example.view.View

/**
 * Controller class for the MVC architecture.
 */
class Controller {
    // The controller manages both the model and the view.

    private val model = Model()
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
//         showScreen(Screen.Start)
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
}
