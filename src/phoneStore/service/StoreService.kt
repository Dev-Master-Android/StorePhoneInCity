package phoneStore.service

import phoneStore.model.Phone
import phoneStore.util.InputReader

abstract class StoreService {
    abstract val city: String
    abstract val phones: List<Phone>
    abstract val sales: MutableMap<String, Int>
    var repairOffered: Boolean = false

    fun buyPhone(model: String) {
        val phone = phones.find { it.model.equals(model, ignoreCase = true) }
        if (phone != null) {
            sales[model] = sales.getOrDefault(model, 0) + 1
            println("Вы купили телефон: ${phone.model} за ${phone.price} в городе $city")
        } else {
            println("Телефон не найден.")
        }
    }

    fun showStatistics() {
        println("Статистика продаж в городе $city:")
        sales.forEach { (model, count) ->
            println("Модель: $model, Количество: $count")
        }
        val total = sales.entries.sumOf { (model, count) ->
            phones.find { it.model.equals(model, ignoreCase = true) }?.price?.times(count) ?: 0.0
        }
        println("Общая сумма покупок: $total")
    }

    fun offerRepair() {
        if (this is RepairService && !repairOffered) {
            println("Хотите отремонтировать сломанный телефон? (да/нет)")
            val response = InputReader.readString()
            if (response.equals("да", ignoreCase = true)) {
                println("Введите модель телефона для ремонта:")
                val model = InputReader.readString()
                (this as RepairService).repairPhone(model)
            } else {
                println("Ремонт не требуется.")
            }
            repairOffered = true
        } else if (repairOffered) {
            println("Ремонт уже был предложен при этом посещении.")
        } else {
            println("Ремонтная мастерская отсутствует в этом городе.")
        }
    }
}
