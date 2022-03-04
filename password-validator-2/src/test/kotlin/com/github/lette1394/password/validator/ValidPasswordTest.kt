package com.github.lette1394.password.validator

import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe

class ValidPasswordTest : FreeSpec({
    "Password must be at least 8 characters" - {
        "input: 1234578" {
            ValidPassword("12345678").valid() shouldBe true
            ValidPassword("12345678").violation() shouldBe ""
        }

        "input: 123456789" {
            ValidPassword("123456789").valid() shouldBe true
            ValidPassword("123456789").violation() shouldBe ""
        }

        "input: 123456789abcd" {
            ValidPassword("123456789abcd").valid() shouldBe true
            ValidPassword("123456789abcd").violation() shouldBe "123456789abcd"
        }

        "input: (empty)" {
            ValidPassword("").valid() shouldBe false
            ValidPassword("").violation() shouldBe "Password must be at least 8 characters"
        }

        "input: 1234567" {
            ValidPassword("1234567").valid() shouldBe false
            ValidPassword("1234567").violation() shouldBe "Password must be at least 8 characters"
        }
    }
})