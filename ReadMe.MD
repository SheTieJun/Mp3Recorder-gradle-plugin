## Mp3Recoder-Plugin

这是给仓库：**[Mp3Recorder](https://github.com/SheTieJun/Mp3Recorder)** 使用的插件方式集成



```
buildscript {
   
    repositories {
     ...
        maven { url "https://jitpack.io" }
    }
    dependencies {
        classpath 'com.github.SheTieJun:Mp3Recorder-gradle-plugin:1.0.0' // Add this line
        
    }
}

allprojects {
    repositories {
        ...
        maven { url "https://jitpack.io" }
    }
}
```

APP module 中

```
plugins {
    id 'me.shetj.plugin.recorderplugin'
}

```

可选项配置（可以不写有默认配置）

```
recorder {
    needUI = true  //是否集成UIKit 默认 false
    needSim = true// 是否集成simRecorder 默认false
    needMix = true // 是否集成mixRecorder 默认true
    libVersion = "1.3.0"// lib版本 :默认1.3.0
}
```

### 版本

`Mp3Recorder-gradle-plugin `:1.0.0 对应  `Mp3Recorder`:1.3.0 



### TIP:😂

这同时是一个 **Gradlle 插件**锻炼项目: **插件添加依赖库**