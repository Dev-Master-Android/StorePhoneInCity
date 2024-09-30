package phoneStore.ui


import phoneStore.City1StoreService
import phoneStore.City2StoreService
import phoneStore.model.City
import phoneStore.util.InputReader

fun main() {
    val cities = listOf(
        City("Москва", City1StoreService()),
        City("Казань", City2StoreService())
    )

    while (true) {
        println("Добро пожаловать в интернет-магазин телефонов!")
        println("Выберите город:")
        cities.forEachIndexed { index, city -> println("${index + 1}. ${city.name}") }
        println("0. Выйти")

        when (val cityChoice = InputReader.readInt()) {
            0 -> break
            in 1..cities.size -> {
                val city = cities[cityChoice - 1]
                MenuM.showCityMenu(city)
            }
            else -> println("Невер1ный выбор, попробуйте снова.")
        }
    }
}
