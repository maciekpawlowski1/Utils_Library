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

### What's inside?
- Resource
```kotlin
val result: Resource<Int> = Resource.Success(data = 10)
val errorResult: Resource<Int> = Resource.Error(message = UiText.NonTranslatable("Error text"))

result.onSuccess {
    //Do something
}.onError { errorUiText, data ->
    //Do something
}
```
- UiData
- UiText
- UiDate
