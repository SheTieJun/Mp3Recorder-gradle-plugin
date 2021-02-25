package me.shetj.mp3recorder.plugin

import org.gradle.api.Project

/**
 *
 * <b>@author：</b> shetj<br>
 * <b>@createTime：</b> 2021/2/25 0025<br>
 * <b>@email：</b> 375105540@qq.com<br>
 * <b>@describe</b>  录音配置<br>
 */
open class RecorderConfig @JvmOverloads constructor(
        var needUI: Boolean = false, //是否集成UIKit
        var needSim: Boolean = false,// 是否集成simRecorder
        var needMix: Boolean = true, // 是否集成mixRecorder
        var libVersion: String = "1.3.0", // lib版本
        var appModule: Boolean = true
) {

    companion object {

        fun getConfig(project: Project): RecorderConfig {
            var extension: RecorderConfig? =
                    project.extensions.findByType(RecorderConfig::class.java)
            if (extension == null) {
                extension = RecorderConfig()
            }
            return extension
        }
    }
}