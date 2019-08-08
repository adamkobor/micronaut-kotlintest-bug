package com.example.micronaut

import io.kotlintest.shouldBe
import io.kotlintest.specs.BehaviorSpec
import io.micronaut.http.HttpStatus
import io.micronaut.http.client.RxHttpClient
import io.micronaut.http.client.annotation.Client
import io.micronaut.test.annotation.MicronautTest

@MicronautTest
class IncludedExampleControllerSpec(@Client("/") private val client: RxHttpClient) : BehaviorSpec() {

    init {
        given("an index endpoint") {
            `when`("called") {
                val resp = client.toBlocking().exchange<Any>("/")
                then("the response should be OK") {
                    resp.status.shouldBe(HttpStatus.OK)
                }
            }
        }
    }
}
