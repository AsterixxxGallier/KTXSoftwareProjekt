package com.libgdx.example.view

import com.libgdx.example.Controller
import com.libgdx.example.Screen
import com.libgdx.example.view.screens.GameSelectionScreen
import com.libgdx.example.view.screens.StartScreen
import com.libgdx.example.view.screens.TicTacToeScreen

/**
 * View class for the MVC architecture.
 */
class View(val controller: Controller) {
    val game = Game(controller)

    /**
     * Registers all screens of the game.
     */
    fun addScreens() {
        game.addScreen(StartScreen(controller))
        game.addScreen(GameSelectionScreen(controller))
        game.addScreen(TicTacToeScreen(controller))
    }

    /**
     * Shows the specified screen.
     */
    fun showScreen(nextScreen: Screen) {
        when (nextScreen) {
            Screen.Start -> game.setScreen<StartScreen>()
            Screen.GameSelection -> game.setScreen<GameSelectionScreen>()
            Screen.TicTacToe -> game.setScreen<TicTacToeScreen>()
        }
    }
}
