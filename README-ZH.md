# XAnimator
## 一个动画框架，根据ScrollView或者HorizontalScrollView中的滑动距离设置对应子view的动画效果.

[![Api reqeust](https://img.shields.io/badge/api-11+-green.svg)](https://github.com/samlss/XAnimator)  [![Apache License 2.0](https://img.shields.io/hexpm/l/plug.svg)](https://github.com/samlss/DayNightLoadingView/blob/master/LICENSE) [![Blog](https://img.shields.io/badge/samlss-blog-orange.svg)](https://blog.csdn.net/Samlss)


![gif1](https://github.com/samlss/XAnimator/blob/master/screenshots/screenshot1.gif)

<br/>

![gif2](https://github.com/samlss/XAnimator/blob/master/screenshots/screenshot2.gif)



## 使用<br>
在根目录的build.gradle添加这一句代码：
```
allprojects {
    repositories {
        //...
        maven { url 'https://jitpack.io' }
    }
}
```

在app目录下的build.gradle添加依赖使用：
```
dependencies {
    implementation 'com.github.samlss:XAnimator:1.0'
}
```

## 属性说明：

| 属性        | 说明           |
| ------------- |:-------------:|
| x_alpha      | 是否执行透明值变化动画(范围为0-1) |
| x_scaleX | 是否执行x轴缩放动画(范围为0-1) |
| x_scaleY | 是否执行y轴缩放动画(范围为0-1) |
| x_startBgColor | 背景颜色渐变动画起始颜色值 |
| x_endBgColor | 背景颜色渐变动画结束颜色值 |
| from_direction | 出现方向，top, bottom, left, right，分别为从顶部，底部，左边，右边出现|

<br/>

## 注意
你可以像正常使用ScrollView和HorizontalScrollView一样，只不过这里要使用自定义的XAnimatorScrollView/XAnimatorHorizontalScrollView
以及XAnimatorLinearLayout(orientation属性也要指定哦)

## 布局中使用：
```
<com.iigo.library.XAnimatorScrollView
        android:layout_width="match_parent"
        android:layout_height="match_parent">

        <com.iigo.library.XAnimatorLinearLayout
            android:orientation="vertical"
            android:layout_width="match_parent"
            android:layout_height="match_parent">

            <ImageView
                android:layout_width="match_parent"
                android:layout_height="match_parent"
                android:src="@mipmap/duola_big" />

            <ImageView
                android:layout_width="match_parent"
                android:layout_height="200dp"
                android:src="@mipmap/duola1"
                app:x_alpha="true"
                app:x_scaleX="true"
                app:x_scaleY="true"
                app:from_direction="left"/>

            <ImageView
                android:layout_width="match_parent"
                android:layout_height="200dp"
                android:src="@mipmap/duola2"
                app:from_direction="right"
                app:x_alpha="true"
                app:x_scaleX="true"
                app:x_scaleY="true" />

            <ImageView
                android:layout_width="match_parent"
                android:layout_height="200dp"
                android:src="@mipmap/duola3"
                app:from_direction="left"
                app:x_alpha="true" />

            <ImageView
                android:layout_width="match_parent"
                android:layout_height="200dp"
                android:src="@mipmap/duola4"
                app:from_direction="right"
                app:x_alpha="true" />


            <ImageView
                android:layout_width="match_parent"
                android:layout_height="200dp"
                android:src="@mipmap/duola5"
                app:x_endBgColor="@android:color/holo_red_light"
                app:x_startBgColor="@android:color/holo_green_light" />

            <LinearLayout
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                app:x_endBgColor="@android:color/holo_orange_light"
                app:x_startBgColor="@android:color/holo_green_light">

                <ImageView
                    android:layout_width="match_parent"
                    android:layout_height="200dp"
                    android:src="@mipmap/duola6" />
            </LinearLayout>

        </com.iigo.library.XAnimatorLinearLayout>
    </com.iigo.library.XAnimatorScrollView>
```

## 代码中使用，以在Activity中使用为例：
```
  setContentView(XAnimator.initLayout(this, R.layout.activity_scrollview));
```


## License
```
Copyright 2018 samlss

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
