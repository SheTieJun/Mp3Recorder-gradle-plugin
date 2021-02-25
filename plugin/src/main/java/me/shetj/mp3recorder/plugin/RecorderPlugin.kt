package me.shetj.mp3recorder.plugin

import org.gradle.api.Plugin
import org.gradle.api.Project


/**
 * implementation 'com.github.SheTieJun.Mp3Recorder:recorder-ui:+'
implementation 'com.github.SheTieJun.Mp3Recorder:recorder-mix:+'
implementation 'com.github.SheTieJun.Mp3Recorder:recorder-core:+'
 */
class RecorderPlugin : Plugin<Project> {

    companion object {
        const val PLUGIN_EXTENSION_NAME = "recorder"
    }

    override fun apply(project: Project) {
        val config: RecorderConfig = project.extensions.create(
                PLUGIN_EXTENSION_NAME, RecorderConfig::class.java
        )

        project.afterEvaluate {
            project.dependencies.apply {
                println("recorderConfig:")
                println("       needMix:${config.needMix}")
                println("       needUI:${config.needUI}")
                println("       needSim:${config.needSim}")
                println("       libVersion:${config.libVersion}")
                val type = project.gradle.gradleVersion.let {
                    if (  it.split(".")[0].toInt() >=3) {
                        if (config.appModule) {
                            "implementation"
                        } else {
                            "api"
                        }
                    } else {
                        "compile"
                    }
                }
                add(type, "com.github.SheTieJun.Mp3Recorder:recorder-core:${config.libVersion}")
                if (config.needMix) {
                    add(type, "com.github.SheTieJun.Mp3Recorder:recorder-mix:${config.libVersion}")
                }
                if (config.needUI) {
                    add(type, "com.github.SheTieJun.Mp3Recorder:recorder-ui:${config.libVersion}")
                }
                if (config.needSim) {
                    add(type, "com.github.SheTieJun.Mp3Recorder:recorder-sim:${config.libVersion}")
                }
            }
        }


    }
}