package com.libgdx.example.view.screens

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Camera
import com.badlogic.gdx.graphics.PerspectiveCamera
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.SpriteBatch
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

class TicTacToeScreen(val controller: Controller) : KtxScreen {
    private val image = Texture("tictactoe.jpg".toInternalFile(), true) // .apply { setFilter(Linear, Linear) }
    private val batch = SpriteBatch()
    private var camera: Camera = PerspectiveCamera()
    private var viewport: Viewport = FitViewport(800f, 480f, camera)

    lateinit var stage: Stage
    lateinit var buttonStyle: Button.ButtonStyle
    lateinit var button: Button

    override fun show() {
        stage = Stage()
        Gdx.input.inputProcessor = stage

        val playButtonDrawable = TextureRegionDrawable(Texture("play_button.png".toInternalFile(), true))

        buttonStyle = Button.ButtonStyle()
        buttonStyle.up = playButtonDrawable
        button = Button(buttonStyle)
        stage.addActor(button)

        val aspectRatio = button.width / button.height
        button.height = 80f
        button.width = button.height * aspectRatio

        button.setPosition(300f,100f, Align.center)

        button.addListener(object : ChangeListener() {
            override fun changed(event: ChangeEvent?, actor: Actor?) {
                println("Button Pressed")

                controller.playButtonPressed()
            }
        })

    override fun resize(width: Int, height: Int) {
        viewport.update(width, height)
    }

    override fun render(delta: Float) {
        clearScreen(red = 1f, green = 1f, blue = 1f)
        batch.use { batch ->
            val aspectRatio = 474f / 613f
            val width = 390f
            val height = width / aspectRatio
            batch.draw(image, 130f, 5f, width, height)
        }
    }

    override fun dispose() {
        batch.disposeSafely()
    }
}
