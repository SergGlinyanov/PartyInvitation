package com.glinyanov.partyinvitation.extensions

import android.content.Context
import androidx.annotation.RawRes

fun Context.readRaw(@RawRes resourceId: Int): String {
    return resources.openRawResource(resourceId).bufferedReader(Charsets.UTF_8).use { it.readText() }
}