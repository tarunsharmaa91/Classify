package com.app.classify

import org.junit.Test
import java.io.BufferedReader
import java.io.InputStreamReader
import java.net.URL
import java.nio.charset.Charset

class APIAvailabilityTest {
    @Test
    @Throws(Exception::class)
    fun testAvailability() {
        val connection =
            URL("https://ey3f2y0nre.execute-api.us-east-1.amazonaws.com/default/dynamodb-writer").openConnection()
        val response = connection.getInputStream()
        val buffer = StringBuffer()
        BufferedReader(InputStreamReader(response, Charset.defaultCharset())).use { reader ->
            var line: String?
            while (reader.readLine().also { line = it } != null) {
                buffer.append(line)
            }
        }
        assert(buffer.length > 0)
    }
}