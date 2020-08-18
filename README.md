# ExCloud

## Install
1. Add it in project's build.gradle
   ```
    allprojects {
        repositories {
            ...
            maven { url 'https://jitpack.io' }
        }
    }
   ```
2. Add the dependency
   ```
    dependencies {
        implementation 'com.github.cylin17:ExCloud:Tag'
    }
   ```

## How to use?
```
ExCloud.host = {YOUR_HOST_URL}

// 上傳圖片
ExCloud.uploadImage(File("/sdcard/gift.png"))

// 上傳影片
ExCloud.uploadVideo(File"/sdcard/video.mpg"))

```