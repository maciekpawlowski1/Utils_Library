# Utils_Library

[![](https://jitpack.io/v/maciekpawlowski1/Utils_Library.svg)](https://jitpack.io/#maciekpawlowski1/Utils_Library)

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
- UiText
```kotlin
val nonTranslatableText: UiText = UiText.NonTranslatable("Non translatable text")
val translatableText: UiText = UiText.Translatable(resId = R.string.app_name)

//In composable function
val textAsString: String = nonTranslatableText.asString()
//Outside composable function
val textAsString2: String = translatableText.asString(context = context)
```

- Resource
```kotlin
val result: Resource<Int> = Resource.Success(data = 10)
val errorResult: Resource<Int> = Resource.Error(message = UiText.NonTranslatable("Error text"))

result.onSuccess { data ->
    //Do something if success
}.onError { errorUiText, dataOrNull ->
    //Do something if error
}

val dataOrNull = result.dataOrNull()

val errorMessageOrNull: UiText? = result.messageOrNull()

val resultWithoutData: Resource<Unit> = result.asUnitResource()
```
- UiData
```kotlin
val loadingData: UiData<Int> = UiData.Loading()
val successData: UiData<Int> = UiData.Success(data = 5, isFresh = true)
val errorData: UiData<Int> = UiData.Error(message = UiText.NonTranslatable("Connection error"))

successData.onSuccess { 
    //Show some data
}.onError { 
    //Show some error text
}.onLoading { 
    //Display some loading indicator
}

val dataOrNull = successData.dataOrNull()
```
- UiDate
```kotlin
val uiDate: UiDate = UiDate(offsetDateTimeDate = OffsetDateTime.now())

val dayText: String = uiDate.asLocalDateString()
val dateTimeText: String = uiDate.asLocalDateTimeString()
```
