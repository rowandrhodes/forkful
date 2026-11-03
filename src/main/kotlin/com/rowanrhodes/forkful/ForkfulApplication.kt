package com.rowanrhodes.forkful

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import java.net.http.HttpResponse

fun badlyFormatted() {
    val x = 1
}

@SpringBootApplication
@RestController
class ForkfulApplication {
    @GetMapping("/hello")
    fun hello(
        @RequestParam(defaultValue = "World") name: String,
    ): ResponseEntity<String> = ResponseEntity("Hello $name}", HttpStatus.OK)
}

fun main(args: Array<String>) {
    runApplication<ForkfulApplication>(*args)
}
