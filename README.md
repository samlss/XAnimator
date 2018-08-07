# XAnimator 

### [中文](https://github.com/samlss/XAnimator/blob/master/README-ZH.md)

### An animation framework that sets the animation effect of the corresponding child view according to the scrolling distance in the ScrollView or HorizontalScrollView.

<br/>

[![Api reqeust](https://img.shields.io/badge/api-11+-green.svg)](https://github.com/samlss/XAnimator)  [![Apache License 2.0](https://img.shields.io/hexpm/l/plug.svg)](https://github.com/samlss/XAnimator/blob/master/LICENSE) [![Blog](https://img.shields.io/badge/samlss-blog-orange.svg)](https://blog.csdn.net/Samlss)


![gif1](https://github.com/samlss/XAnimator/blob/master/screenshots/screenshot1.gif)

<br/>

![gif2](https://github.com/samlss/XAnimator/blob/master/screenshots/screenshot2.gif)



## Use<br>
Add it in your root build.gradle at the end of repositories：
```
allprojects {
    repositories {
        //...
        maven { url 'https://jitpack.io' }
    }
}
```

Add it in your app build.gradle at the end of repositories:
```
dependencies {
    implementation 'com.github.samlss:XAnimator:1.0'
}
```

## Attributes description：

| attr        | description           |
| ------------- |:-------------:|
| x_alpha      | Whether to perform a alpha value change animation (range 0-1) |
| x_scaleX | Whether to perform x-axis scaling animation (range 0-1) |
| x_scaleY | Whether to perform y-axis scaling animation (range 0-1) |
| x_startBgColor | The start color value of the background color gradient animation  |
| x_endBgColor | The end color value of the background color gradient animation |
| from_direction | The direction appear, top, bottom, left, right, appear from the top, bottom, left, right|

<br/>

## note:
You can use the custome layout `XAnimatorScrollView/XAnimatorHorizontalScrollView` and `XAnimatorLinearLayout` (orientation property should also be specified), like when you use the ScrollView/HorizontalScrollView and the LinearLayout.


## in layout.xml
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

## Used in the code， for example in an Activity:
```
  setContentView(XAnimator.initLayout(this, R.layout.activity_scrollview));
```


# License

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
