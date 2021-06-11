package com.mthaler.sburrestdemo

import org.springframework.web.bind.annotation.*

@RestController
class RestApiDemoController {

    private val coffees = arrayListOf(Coffee("Café Cereza"), Coffee("Café Ganador"), Coffee("Café Lareño"), Coffee("Café Três Pontas"))

    @GetMapping("/coffees")
    fun getCoffees(): Iterable<Coffee> = coffees

    @GetMapping("/coffees/{id}")
    fun getCoffeeById(@PathVariable id: String): Coffee? = coffees.find { it.id == id }

    @PostMapping("/coffees")
    fun postCoffee(@RequestBody coffee: Coffee): Coffee {
        coffees.add(coffee)
        return coffee
    }

    @PutMapping("/coffees/{id}")
    fun putCoffee(@PathVariable id: String, @RequestBody coffee: Coffee): Coffee {
        val index = coffees.indexOfFirst { it.id == id }
        if (index >= 0) {
            coffees.set(index, coffee)
        } else {
            coffees.add(coffee)
        }
        return coffee
    }

    @DeleteMapping("/coffees/{id}")
    fun deleteCoffee(@PathVariable id: String) {
        coffees.removeIf { it.id == id }
    }
}