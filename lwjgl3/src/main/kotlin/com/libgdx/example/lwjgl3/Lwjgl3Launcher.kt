@file:JvmName("Lwjgl3Launcher")

package com.libgdx.example.lwjgl3

import com.badlogic.gdx.backends.lwjgl3.Lwjgl3Application
import com.badlogic.gdx.backends.lwjgl3.Lwjgl3ApplicationConfiguration
import com.libgdx.example.Controller

/** Launches the desktop (LWJGL3) application. */
fun main() {
    // This handles macOS support and helps on Windows.
    if (StartupHelper.startNewJvmIfRequired())
      return
    val controller = Controller()
    Lwjgl3Application(controller.view.game, Lwjgl3ApplicationConfiguration().apply {
        setTitle("Seismic Arcade")
        setWindowedMode(640, 480)
        setWindowIcon(*(arrayOf(128, 64, 32, 16).map { "libgdx$it.png" }.toTypedArray()))
    })
}
