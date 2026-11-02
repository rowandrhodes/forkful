package com.rowanrhodes.forkful

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication

@SpringBootApplication
class ForkfulApplication

fun main(args: Array<String>) {
	runApplication<ForkfulApplication>(*args)
}
