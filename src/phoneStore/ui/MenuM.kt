package phoneStore.ui

import phoneStore.model.City
import phoneStore.util.InputReader



object MenuM {
    fun showCityMenu(city: City) {
        while (true) {
            println("Добро пожаловать в ${city.name}!")
            println("1. Купить телефон")
            println("2. Показать статистику")
            println("3. Ремонт телефона")
            println("0. Вернуться назад")

            when (val choice = InputReader.readInt()) {
                0 -> {
                    city.store.repairOffered = false // Сброс предложения ремонта при выходе
                    break
                }
                1 -> {
                    println("Выберите модель телефона:")
                    city.store.phones.forEachIndexed { index, phone -> println("${index + 1}. ${phone.model} - ${phone.price}") }
                    val phoneChoice = InputReader.readInt()
                    if (phoneChoice in 1..city.store.phones.size) {
                        city.store.buyPhone(city.store.phones[phoneChoice - 1].model)
                    } else {
                        println("Неверный выбор, попробуйте снова.")
                    }
                }
                2 -> city.store.showStatistics()
                3 -> city.store.offerRepair()
                else -> println("Неверный выбор, попробуйте снова.")
            }
        }
    }
}

