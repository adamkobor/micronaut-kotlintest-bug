package com.example.micronaut

import io.kotlintest.shouldBe
import io.kotlintest.specs.BehaviorSpec
import io.micronaut.context.ApplicationContext
import io.micronaut.http.HttpStatus
import io.micronaut.http.client.RxHttpClient
import io.micronaut.runtime.server.EmbeddedServer
import io.micronaut.test.annotation.MicronautTest

@MicronautTest
class ExcludedExampleControllerSpec : BehaviorSpec() {

    private val client = startTestApplication().getLowLevelClient()

    init {
        given("the index endpoint") {
            `when`("called") {
                val resp = client.toBlocking().exchange<Any>("/")
                then("the response should be OK") {
                    resp.status.shouldBe(HttpStatus.OK)
                }
            }
        }
    }
}

fun startTestApplication(): EmbeddedServer =
    ApplicationContext
        .build()
        .build()
        .start()
        .getBean(EmbeddedServer::class.java)
        .start()

fun EmbeddedServer.getLowLevelClient(): RxHttpClient =
    this.applicationContext.createBean(RxHttpClient::class.java, this.url)
