package com.mthaler.sburrestdemo

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class RestApiDemoController {

    private val coffees = listOf(Coffee("Café Cereza"), Coffee("Café Ganador"), Coffee("Café Lareño"), Coffee("Café Três Pontas"))

    @GetMapping("/coffees")
    fun getCoffees(): Iterable<Coffee> = coffees

    @GetMapping("/coffees/{id}")
    fun getCoffeeById(@PathVariable id: String): Coffee? = coffees.find { it.id == id }

}