# Utils_Library

### Gradle

Add the dependency below into your **module**'s `build.gradle` file:

```gradle
dependencies {
    implementation "com.github.maciekpawlowski1:Utils_Library:1.0"
}
```

If you didn't do it before, add **jitpack.io** to repositories in `settings.gradle` file:
```gradle
dependencyResolutionManagement {
    ..
    repositories {
        ..
        maven { url 'https://jitpack.io' }
    }
}
```
