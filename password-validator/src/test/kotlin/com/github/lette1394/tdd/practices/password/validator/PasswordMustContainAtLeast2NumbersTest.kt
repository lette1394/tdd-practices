package com.github.lette1394.tdd.practices.password.validator

import arrow.core.Either.Left
import arrow.core.Either.Right
import com.github.lette1394.password.validator.FailedReasons.Companion.reasons
import com.github.lette1394.password.validator.FailedReasons.Reason.PASSWORD_MUST_CONTAIN_AT_LEAST_2_NUMBERS
import io.kotest.core.spec.style.FreeSpec
import io.kotest.matchers.shouldBe
import org.junit.jupiter.api.assertAll

class PasswordMustContainAtLeast2NumbersTest : FreeSpec({
    val subject = PasswordMustContainAtLeast2Numbers()

    "pass" {
        val expected = Right(Unit)
        assertAll({
            subject.matches("00") shouldBe expected
            subject.matches("12") shouldBe expected
            subject.matches("12cdefgh") shouldBe expected
            subject.matches("58gvi13n") shouldBe expected
            subject.matches("00000000") shouldBe expected
            subject.matches("000000000") shouldBe expected
        })
    }

    "fail" {
        val expected = Left(reasons(PASSWORD_MUST_CONTAIN_AT_LEAST_2_NUMBERS))
        assertAll({
            subject.matches("") shouldBe expected
            subject.matches("1") shouldBe expected
            subject.matches("abc") shouldBe expected
            subject.matches("1abc") shouldBe expected
        })
    }
})
