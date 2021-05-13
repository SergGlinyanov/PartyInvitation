package com.glinyanov.partyinvitation.sal

import com.google.gson.FieldNamingPolicy
import com.google.gson.GsonBuilder
import com.glinyanov.partyinvitation.sal.adapters.ByteArrayAdapter
import com.glinyanov.partyinvitation.sal.adapters.UnixDateAdapter
import java.lang.reflect.Type
import java.util.*
import kotlin.reflect.full.createType


open class BaseConverter {
	companion object {
		private fun createSerializer() = GsonBuilder()
			.registerTypeAdapter(Date::class.java, UnixDateAdapter())
			.registerTypeAdapter(Date::class.createType(nullable = true).javaClass, UnixDateAdapter())
			.registerTypeAdapter(ByteArray::class.java, ByteArrayAdapter())
			.registerTypeAdapter(ByteArray::class.createType(nullable = true).javaClass, ByteArrayAdapter())
			.setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE)
			.create()

		fun <T> serialize(value: T, type: Type): String = createSerializer().toJson(value, type)
		fun <T> deserialize(s: String, type: Type): T = createSerializer().fromJson(s, type)
	}

	protected fun <TResponse> createResponse(response: String, responseType: Type): TResponse {
		return deserialize(response, responseType)
	}

}
