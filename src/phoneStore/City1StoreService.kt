package phoneStore

import phoneStore.model.Phone
import phoneStore.service.RepairService
import phoneStore.service.StoreService

class City1StoreService : StoreService(), RepairService {
    override val city: String = "Москва"
    override val phones: List<Phone> = listOf(
        Phone("iPhone", 999.0),
        Phone("Samsung", 899.0),
        Phone("Pixel", 799.0),
        Phone("OnePlus", 899.0),
        Phone("Sony", 1199.0)
    )
    override val sales: MutableMap<String, Int> = mutableMapOf()

    override fun repairPhone(model: String) {
        val phone = phones.find { it.model.equals(model, ignoreCase = true) }
        if (phone != null) {
            println("Телефон ${phone.model} отремонтирован в городе $city.")
        } else {
            println("Телефон $model не найден в городе $city.")
        }
    }
}
