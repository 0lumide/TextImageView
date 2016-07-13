# TextImageView
This is a library that functions similarly to [dummyimage.com](http://dummyimage.com/) with a lot less features, which is more like [placehold.it](http://placehold.it/).

## Usage
Include the jitpack repository to your project. See [jitpack.io](https://jitpack.io/) for help.

Include the library in your project via Gradle:
```
dependencies {
    compile 'com.github.0lumide:TextImageView:v0.0.3-alpha'
}
```

or Maven, if you're into that sort of thing
```
<dependency>
    <groupId>com.github.0lumide</groupId>
    <artifactId>TextImageView</artifactId>
    <version>v0.0.3-alpha</version>
</dependency>
```

### Sample
You can instantiate a `TextImageView` either via xml
```
<co.mide.textimageview.TextImageView
    android:layout_width="300dp"
    android:layout_height="300dp"
    app:backgroundColor="#121212"
    app:textColor="#dddddd"
    app:textSize="300sp"
    app:text="Hi" />
```
or programatically

```
new TextImageView(Context).setWidth(900).setHeight(900)
    .setImageBackgroundColor(0xff121212)
    .setTextColor(0xdddddd).setTextSize(600)
    .setText("Hi");
```
Note that the int values that `setHeight(int)`, `setWidth(int)`, `setTextSize(int)` accept are in pixels not "dp" or "sp".

This should be the resulting `TextImageView`

![TextImageView](/img/sample_image.png)

### Development
Feel free to submit a PR, and open new issues if you find a bug.

### License
Released under MIT license.
