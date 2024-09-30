package phoneStore


import phoneStore.model.Phone
import phoneStore.service.StoreService

class City2StoreService : StoreService() {
    override val city: String = "Казань"
    override val phones: List<Phone> = listOf(
        Phone("iPhone", 999.0),
        Phone("Samsung", 899.0),
        Phone("Pixel", 799.0),
        Phone("OnePlus", 899.0),
        Phone("Sony", 1199.0)
    )
    override val sales: MutableMap<String, Int> = mutableMapOf()
}