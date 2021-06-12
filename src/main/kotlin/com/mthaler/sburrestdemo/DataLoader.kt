package com.mthaler.sburrestdemo

import org.springframework.stereotype.Component
import javax.annotation.PostConstruct

@Component
class DataLoader(private val coffeeRepository: CoffeeRepository) {
    @PostConstruct
    private fun loadData() = coffeeRepository.saveAll(
        listOf(
            Coffee("Café Cereza"),
            Coffee("Café Ganador"),
            Coffee("Café Lareño"),
            Coffee("Café Três Pontas")
        )
    )
}