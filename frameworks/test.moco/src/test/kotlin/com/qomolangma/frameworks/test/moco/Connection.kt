package com.qomolangma.frameworks.test.moco

import java.io.BufferedReader
import java.io.IOException
import java.io.InputStreamReader
import java.net.HttpURLConnection
import java.net.URL

class Connection private constructor(url: String) {
    private val connection: HttpURLConnection

    init {
        connection = URL(url).openConnection() as HttpURLConnection
    }

    fun disconnect() {
        connection.disconnect()
    }

    @Throws(IOException::class)
    fun connect() {
        connection.connect()
    }

    @Throws(IOException::class)
    fun responseCode(): Int {
        return connection.responseCode
    }

    @Throws(IOException::class)
    fun responseBody(): String {
        val `in` = BufferedReader(InputStreamReader(connection.inputStream))
        var inputLine: String?
        val response = StringBuilder()
        while (`in`.readLine().also { inputLine = it } != null) {
            response.append(inputLine)
        }
        `in`.close()
        return response.toString()
    }

    companion object {
        @JvmStatic
        @Throws(IOException::class)
        fun by(url: String): Connection {
            return Connection(url)
        }
    }
}
