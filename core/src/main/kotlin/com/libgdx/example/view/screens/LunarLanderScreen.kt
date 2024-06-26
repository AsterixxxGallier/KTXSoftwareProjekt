package com.libgdx.example.view.screens

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.Input
import com.badlogic.gdx.graphics.Camera
import com.badlogic.gdx.graphics.Color
import com.badlogic.gdx.graphics.PerspectiveCamera
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.graphics.glutils.ShapeRenderer
import com.badlogic.gdx.scenes.scene2d.Actor
import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.scenes.scene2d.ui.Button
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable
import com.badlogic.gdx.utils.Align
import com.badlogic.gdx.utils.viewport.FitViewport
import com.badlogic.gdx.utils.viewport.Viewport
import com.libgdx.example.Controller
import ktx.app.KtxScreen
import ktx.app.clearScreen
import ktx.assets.disposeSafely
import ktx.assets.toInternalFile
import ktx.graphics.use

class LunarLanderScreen(val controller: Controller) : KtxScreen {
    private var camera: Camera = PerspectiveCamera()
    private var viewport: Viewport = FitViewport(800f, 480f, camera)
    private val shape = ShapeRenderer()

    override fun show() {

    }

    override fun resize(width: Int, height: Int) {
        viewport.update(width, height)
    }


    override fun render(delta: Float) {
        clearScreen(red = 1f, green = 1f, blue = 1f)

        shape.begin(ShapeRenderer.ShapeType.Filled)
        shape.setColor(69f / 255, 69f / 255, 69f / 255, 1f)
        shape.rect(200f, 0f, 150f, 20f)
        shape.end()

        shape.begin(ShapeRenderer.ShapeType.Filled)
        shape.setColor(Color.RED)
        shape.circle(200f,200f,100f)
        shape.end()

        if (Gdx.input.isKeyPressed(Input.Keys.LEFT)) {

        }
    }

    override fun dispose() {
    }
}
