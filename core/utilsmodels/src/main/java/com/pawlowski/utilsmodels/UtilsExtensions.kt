package com.pawlowski.utilsmodels

inline fun <T>Resource<T>.onSuccess(
    action: (T?) -> Unit
): Resource<T> = apply {
    if(this is Resource.Success) {
        action(this.data)
    }
}

fun <T> Resource<T>.asUnitResource(): Resource<Unit> {
    return when(this) {
        is Resource.Success -> Resource.Success(Unit)
        is Resource.Error -> Resource.Error(this.message)
    }
}


inline fun <T>onAnyResourceHasError(vararg resources: Resource<T>, action: () -> Unit) {
    if(resources.any { it is Resource.Error })
        action()
}

inline fun <T>Resource<T>.onError(
    action: (UiText, T?) -> Unit
): Resource<T> = apply {
    if(this is Resource.Error) {
        action(this.message, this.data)
    }
}

fun <T>Resource<T>.dataOrNull(): T? {
    return when(this) {
        is Resource.Success -> data
        is Resource.Error -> data
    }
}

fun <T>Resource<T>.messageOrNull(): UiText? {
    return when(this) {
        is Resource.Success -> null
        is Resource.Error -> message
    }
}

fun <T>UiData<T>.dataOrNull(): T? {
    return when(this) {
        is UiData.Success -> data
        is UiData.Error -> cachedData
        is UiData.Loading -> null
    }
}

fun <T>UiData<T>.isLoading(): Boolean {
    return this is UiData.Loading
}

inline fun <T>UiData<T>.onSuccess(
    action: (UiData.Success<T>) -> Unit
): UiData<T> = apply {
    if(this is UiData.Success)
    {
        action(this)
    }
}

inline fun <T>UiData<T>.onError(
    action: (UiData.Error<T>) -> Unit
): UiData<T> = apply {
    if(this is UiData.Error)
    {
        action(this)
    }
}

inline fun <T>UiData<T>.onLoading(
    action: (UiData.Loading<T>) -> Unit
): UiData<T> = apply {
    if(this is UiData.Loading)
    {
        action(this)
    }
}

inline fun <T>UiData<List<T>>.filteredIfDataExists(
    predicate: (T) -> Boolean
): UiData<List<T>> {
    return when (this) {
        is UiData.Success -> {
            this.copy(data = this.data.filter { predicate(it) })
        }
        is UiData.Error -> {
            this.copy(cachedData = this.cachedData?.filter { predicate(it) })
        }
        else -> this
    }
}