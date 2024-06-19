@file:Suppress("SpellCheckingInspection")

package com.libgdx.example.view

import com.libgdx.example.Controller
import com.libgdx.example.view.screens.GameSelectionScreen
import com.libgdx.example.view.screens.StartScreen
import ktx.app.KtxGame
import ktx.app.KtxScreen


class Game(val controller: Controller) : KtxGame<KtxScreen>() {
    override fun create() {
        addScreen(StartScreen(controller))
        addScreen(GameSelectionScreen(controller))
    }
}
