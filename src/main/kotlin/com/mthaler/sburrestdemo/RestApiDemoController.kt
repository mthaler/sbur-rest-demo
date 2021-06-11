package com.mthaler.sburrestdemo

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/coffees")
class RestApiDemoController {

    private val coffees = arrayListOf(Coffee("Café Cereza"), Coffee("Café Ganador"), Coffee("Café Lareño"), Coffee("Café Três Pontas"))

    @GetMapping
    fun getCoffees(): Iterable<Coffee> = coffees

    @GetMapping("/{id}")
    fun getCoffeeById(@PathVariable id: String): Coffee? = coffees.find { it.id == id }

    @PostMapping
    fun postCoffee(@RequestBody coffee: Coffee): Coffee {
        coffees.add(coffee)
        return coffee
    }

    @PutMapping("/{id}")
    fun putCoffee(@PathVariable id: String, @RequestBody coffee: Coffee): ResponseEntity<Coffee> {
        val index = coffees.indexOfFirst { it.id == id }
        if (index >= 0) {
            coffees.set(index, coffee)
            return ResponseEntity(coffee, HttpStatus.OK)
        } else {
            return ResponseEntity(postCoffee(coffee), HttpStatus.CREATED)
        }
    }

    @DeleteMapping("/{id}")
    fun deleteCoffee(@PathVariable id: String) {
        coffees.removeIf { it.id == id }
    }
}