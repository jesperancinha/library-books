package org.jesperancinha.books

import io.ktor.client.request.*
import io.ktor.client.statement.*
import io.ktor.http.*
import io.ktor.serialization.gson.*
import io.ktor.server.application.*
import io.ktor.server.plugins.contentnegotiation.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.server.testing.*
import kotlinx.coroutines.delay
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.BeforeAll
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.parallel.Execution
import org.junit.jupiter.api.parallel.ExecutionMode
import kotlin.time.Duration.Companion.seconds

class ApplicationTest3 {

    private fun testApp(): Application.() -> Unit = {
        install(ContentNegotiation) { gson() }
        routing {
            get("/hello") { call.respondText("Hello, Ktor!") }
        }
    }

    @Test
    @Execution(ExecutionMode.CONCURRENT)
    fun testHelloEndpoint1() = testApplication {
        println(Thread.currentThread())
        application(testApp())
        client.get("/hello").apply {
            assertEquals(HttpStatusCode.OK, status)
            assertEquals("Hello, Ktor!", bodyAsText())
            delay(5.seconds)
        }
    }

    @Test
    @Execution(ExecutionMode.CONCURRENT)
    fun testHelloEndpoint2() = testApplication {
        println(Thread.currentThread())
        application(testApp())
        client.get("/hello").apply {
            assertEquals(HttpStatusCode.OK, status)
            assertEquals("Hello, Ktor!", bodyAsText())
            delay(5.seconds)
        }
        println(Thread.currentThread())
    }
    @Test
    @Execution(ExecutionMode.CONCURRENT)
    fun testHelloEndpoint3() = testApplication {
        println(Thread.currentThread())
        application(testApp())
        client.get("/hello").apply {
            assertEquals(HttpStatusCode.OK, status)
            assertEquals("Hello, Ktor!", bodyAsText())
            delay(5.seconds)
        }
        println(Thread.currentThread())
    }
    @Test
    @Execution(ExecutionMode.CONCURRENT)
    fun testHelloEndpoint4() = testApplication {
        println(Thread.currentThread())
        application(testApp())
        client.get("/hello").apply {
            assertEquals(HttpStatusCode.OK, status)
            assertEquals("Hello, Ktor!", bodyAsText())
            delay(5.seconds)
        }
        println(Thread.currentThread())
    }
    @Test
    @Execution(ExecutionMode.CONCURRENT)
    fun testHelloEndpoint5() = testApplication {
        println(Thread.currentThread())
        application(testApp())
        client.get("/hello").apply {
            assertEquals(HttpStatusCode.OK, status)
            assertEquals("Hello, Ktor!", bodyAsText())
            delay(5.seconds)
        }
        println(Thread.currentThread())
    }

    companion object {
        @BeforeAll
        @JvmStatic
        fun setup() {
            println("All tests started")
        }
    }
}
