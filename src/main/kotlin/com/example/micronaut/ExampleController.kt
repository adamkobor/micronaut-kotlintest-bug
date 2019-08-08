package com.example.micronaut

import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.HttpStatus

@Controller("/")
class ExampleController {

    @Get("/")
    fun index(): HttpStatus {
        return HttpStatus.OK
    }
}
