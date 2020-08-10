package com.`fun`.testmvvmproject.utils

import android.content.Context
import android.content.ContextWrapper
import androidx.lifecycle.LifecycleOwner


const val USER_EMAIL = "email"

fun Context.lifecycleOwner(): LifecycleOwner? {
    var curContext = this
    var maxDepth = 20
    while (maxDepth-- > 0 && curContext !is LifecycleOwner) {
        curContext = (curContext as ContextWrapper).baseContext
    }
    return if (curContext is LifecycleOwner) {
        curContext as LifecycleOwner
    } else {
        null
    }
}