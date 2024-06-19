package com.libgdx.example.view.screens

import com.badlogic.gdx.graphics.Camera
import com.badlogic.gdx.graphics.PerspectiveCamera
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.utils.viewport.FitViewport
import com.badlogic.gdx.utils.viewport.Viewport
import com.libgdx.example.Controller
import ktx.app.KtxScreen
import ktx.app.clearScreen
import ktx.assets.disposeSafely

class GameSelectionScreen(val controller: Controller) : KtxScreen {
    private val batch = SpriteBatch()
    private var camera: Camera = PerspectiveCamera()
    private var viewport: Viewport = FitViewport(800f, 480f, camera)

    override fun resize(width: Int, height: Int) {
        viewport.update(width, height)
    }

    override fun render(delta: Float) {
        clearScreen(red = 1f, green = 235f / 255f, blue = 205f / 255f)
    }

    override fun dispose() {
        batch.disposeSafely()
    }
}
