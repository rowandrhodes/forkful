package com.rowanrhodes.forkful

import org.junit.jupiter.api.Test
import org.springframework.boot.test.context.SpringBootTest
import kotlin.test.assertEquals

@SpringBootTest
class ForkfulApplicationTests {

	@Test
	fun contextLoads() {
        assertEquals(1, 1)
	}
}
