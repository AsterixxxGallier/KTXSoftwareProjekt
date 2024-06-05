package com.libgdx.example

import com.badlogic.gdx.Gdx
import com.badlogic.gdx.graphics.Camera
import com.badlogic.gdx.graphics.PerspectiveCamera
import com.badlogic.gdx.graphics.Texture
import com.badlogic.gdx.graphics.g2d.BitmapFont
import com.badlogic.gdx.graphics.g2d.SpriteBatch
import com.badlogic.gdx.graphics.g2d.TextureRegion
import com.badlogic.gdx.scenes.scene2d.Actor
import com.badlogic.gdx.scenes.scene2d.Stage
import com.badlogic.gdx.scenes.scene2d.ui.TextButton
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle
import com.badlogic.gdx.scenes.scene2d.utils.ChangeListener
import com.badlogic.gdx.scenes.scene2d.utils.TextureRegionDrawable
import com.badlogic.gdx.utils.viewport.FitViewport
import com.badlogic.gdx.utils.viewport.Viewport
import ktx.app.KtxGame
import ktx.app.KtxScreen
import ktx.app.clearScreen
import ktx.assets.disposeSafely
import ktx.assets.toInternalFile
import ktx.graphics.use


class Main : KtxGame<KtxScreen>() {
    lateinit var stage: Stage
    lateinit var font: BitmapFont
    lateinit var textButtonStyle: TextButtonStyle
    lateinit var button: TextButton

    override fun create() {
        stage = Stage().also {
            Gdx.input.inputProcessor = it
        }
        font = BitmapFont()
//        val logoDrawable = TextureRegionDrawable(TextureRegion(Texture("logo.png".toInternalFile(), true)))
        val playButtonDrawable = TextureRegionDrawable(TextureRegion(Texture("play_button.png".toInternalFile(), true)))

        textButtonStyle = TextButtonStyle().also {
            it.font = font
            it.up = playButtonDrawable
            // it.up = skin.getDrawable("up-button")
            // it.down = skin.getDrawable("down-button")
            // it.checked = skin.getDrawable("checked-button")
        }
        button = TextButton("Button1", textButtonStyle).also {
            stage.addActor(it)
        }
        button.addListener(object : ChangeListener() {
            override fun changed(event: ChangeEvent?, actor: Actor?) {
                println("Button Pressed")
            }
        })


        addScreen(FirstScreen())
        setScreen<FirstScreen>()
    }

    override fun render() {
        super.render()
        stage.draw()
    }
}

class FirstScreen : KtxScreen {
    private val image = Texture("logo.png".toInternalFile(), true) // .apply { setFilter(Linear, Linear) }
    private val batch = SpriteBatch()
    private var camera: Camera = PerspectiveCamera()
    private var viewport: Viewport = FitViewport(800f, 480f, camera)

    override fun resize(width: Int, height: Int) {
        viewport.update(width, height)
    }

    override fun render(delta: Float) {
        clearScreen(red = 0.9f, green = 0.9f, blue = 0.5f)
        batch.use { batch ->
            batch.draw(image, 100f, 160f)
        }
    }

    override fun dispose() {
        image.disposeSafely()
        batch.disposeSafely()
    }
}
