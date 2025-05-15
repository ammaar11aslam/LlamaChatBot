package com.demo.llamachat

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.net.HttpURLConnection
import java.net.URL

object ApiService {
    private const val BASE_URL = "http://192.168.1.5:5000/chat"

    suspend fun sendMessage(message: String): String = withContext(Dispatchers.IO) {
        try {
            val url = URL(BASE_URL)
            val connection = url.openConnection() as HttpURLConnection
            connection.requestMethod = "POST"
            connection.setRequestProperty("Content-Type", "application/json")
            connection.doOutput = true

            val json = "{\"message\":\"$message\"}"
            connection.outputStream.write(json.toByteArray())

            val response = connection.inputStream.bufferedReader().readText()

            // Handle plain string response from server
            response.trim('"')  // strips surrounding double quotes
        } catch (e: Exception) {
            "Error: ${e.message}"
        }
    }
}
