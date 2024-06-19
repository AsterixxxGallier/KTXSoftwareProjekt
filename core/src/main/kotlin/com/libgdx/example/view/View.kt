package com.libgdx.example.view

import com.libgdx.example.Controller
import com.libgdx.example.Screen
import com.libgdx.example.view.screens.GameSelectionScreen
import com.libgdx.example.view.screens.StartScreen
import com.libgdx.example.view.screens.TicTacToeScreen

class View(val controller: Controller) {
    val game = Game(controller)

    fun showScreen(nextScreen: Screen) {
        when (nextScreen) {
            Screen.Start -> game.setScreen<StartScreen>()
            Screen.GameSelection -> game.setScreen<GameSelectionScreen>()
            Screen.TicTacToe -> game.setScreen<TicTacToeScreen>()
        }
    }
}
