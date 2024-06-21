@file:Suppress("SpellCheckingInspection")

package com.libgdx.example.view

import com.libgdx.example.Controller
import ktx.app.KtxGame
import ktx.app.KtxScreen

class Game(val controller: Controller) : KtxGame<KtxScreen>() {
    override fun create() {
        controller.gameCreated()
    }
}
