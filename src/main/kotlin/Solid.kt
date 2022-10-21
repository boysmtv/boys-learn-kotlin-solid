import java.util.*

open class Animal{
    fun walk(){
        println("${javaClass.simpleName} walk!")
    }
}

open class Carnivore: Animal(){
    fun eat(){
        println("${javaClass.simpleName} eat!")
    }
}

class Cat: Carnivore()

interface Ovipar {
    fun walk()
}

interface Vivipar {
    fun eat()
}

interface Ovovivipar: Ovipar, Vivipar

class Snake: Ovovivipar {

    override fun walk() {
        println("${javaClass.simpleName} walk!")
    }

    override fun eat() {
        println("${javaClass.simpleName} eat!")
    }

}

//Menggunakan Encapsulation

class DataRepository {
    private val data = mutableListOf<Any>()

    fun setData(){
        val response = /* tons of logical code to retrieve data */
        data.clear()
        data.add(response)
    }

    fun getData() = data
}

//Compile time polymorphism
class ArithmeticInh {
    fun add(valueA: Int, valueB: Int) = valueA + valueB
    fun add(valueA: Long, valueB: Long) = valueA + valueB
    fun add(valueA: Int, valueB: Long) = valueA + valueB
    fun add(valueA: Long, valueB: Int) = valueA + valueB
}

open class Arithmetic {
    open fun add(valueA: Int, valueB: Int) = valueA + valueB
    open fun add(valueA: Long, valueB: Long) = valueA + valueB
    open fun add(valueA: Int, valueB: Long) = valueA + valueB
    open fun add(valueA: Long, valueB: Int) = valueA + valueB
}

class Add: Arithmetic() {

    override fun add(valueA: Int, valueB: Int): Int {
        println("Calculate!")
        return super.add(valueA, valueB)
    }

}

//Runtime Polymorphism

open class AnimalPol {
    open fun walk() {
        println("${javaClass.simpleName} walk!")
    }
}

class CatPol : AnimalPol(){

    override fun walk() {
        super.walk()
        println("Yeay! ${javaClass.simpleName} walked!")
    }

}

//Aggregation
class Shop(
        private val id: String,
        private val name: String
) {
    var seller: Seller
        set(value) {
            seller = value
        }
        get() {
            return seller
        }
}

class Seller(
        private val id: String,
        private val name: String
)

class User(
        private val id: String,
        private val name: String,
        private val address: Address
)

class Address(
        private val id: String,
        private val location: String
)

//Dependensi

class ShopService {

    fun changeProductPrice(price: String, product: Product) {
        product.changePrice(price)
    }

}

class Product(
        private var id: String,
        private var name: String,
        private var price: String
) {
    fun changePrice(value: String) {
        this.price = value
    }
}


abstract class Products(
        private var id: String,
        private var name: String,
        private var price: String
)

class ElectronicProduct(
        private var id: String,
        private var name: String,
        private var price: String,
        private var productionDate: String
) : Products(id, name, price)

class ConsumableProduct(
        private var id: String,
        private var name: String,
        private var price: String,
        private var expirationDate: String
) : Products(id, name, price)


interface ProductService {
    fun getProduct(id: String)
    fun calculateProductPrice()
}

class ProductServiceImpl() : ProductService {

    override fun getProduct(id: String) {
        // Implementation code
    }
    override fun calculateProductPrice() {
        // Implementation code
    }

}

//Open Close Principle - SOLID

abstract class Cinema(val price: Double) {
    abstract fun calculateAdminFee(): Double
}

class StandardCinema(price: Double) : Cinema(price) {
    override fun calculateAdminFee(): Double {
        return price * 10 / 100
    }
}

class DeluxeCinema(price: Double) : Cinema(price) {
    override fun calculateAdminFee(): Double {
        return price * 12 / 100
    }
}

class PremiumCinema(price: Double) : Cinema(price) {
    override fun calculateAdminFee(): Double {
        return price * 20 / 100
    }
}

class CoupleCinema(price: Double) : Cinema(price) {
    override fun calculateAdminFee(): Double {
        return price * 15 / 100
    }
}

interface Cinemas {
    fun calculateAdminFee(price: Double): Double
}

class CinemasInter : Cinemas {

    override fun calculateAdminFee(price: Double): Double {
        return price * 10 / 100
    }
}

//Liskov Substitution Principle (LSP)

abstract class Productss {

    abstract fun getName(): String

    /**
     * Function to get all of information about product
     */
    fun getProductInfo(){
        // some magic code
    }
}

abstract class FoodProduct: Productss() {
    abstract fun getExpiredDate(): Date
}

class Vegetable: FoodProduct() {

    override fun getExpiredDate(): Date {
        return Date()
    }

    override fun getName(): String {
        return  "Broccoli"
    }
}

class Smartphone : Productss() {

    override fun getName(): String {
        return "Samsung S10+ Limited Edition"
    }

}

//Interface Segregation Principle (ISP)

//interface VehicleInterface {
//    fun drive()
//    fun stop()
//    fun refuel()
//    fun openDoors()
//}
//
//
//class Motorcycle : VehicleInterface {
//    // Can be implemented
//    override fun drive() {}
//    override fun stop() {}
//    override fun refuel() {}
//
//
//    //Pain point
//    // Can not be implemented
//    override fun openDoors() {}
//}

//to

//interface VehicleInterface {
//    fun drive()
//    fun stop()
//    fun refuel()
//}
//
//interface DoorInterface {
//    fun openDoors()
//}
//
//class Motorcycle : VehicleInterface {
//    override fun drive() {}
//    override fun stop() {}
//    override fun refuel() {}
//}
//
//class Car : VehicleInterface, DoorInterface {
//    override fun drive() {}
//    override fun stop() {}
//    override fun refuel() {}
//    override fun openDoors() {}
//}


//Dependency Inversion Principle (DIP)

//class Car(private val engine: Engine) {
//    fun start() {
//        engine.start()
//    }
//}
//
//class Engine {
//    fun start() {}
//}
//
//class DieselEngine {
//    fun start() {}
//}

//to

//interface EngineInterface {
//    fun start()
//}
//
//class Car(private val engine: EngineInterface) {
//    fun start() {
//        engine.start()
//    }
//}
//
//class PetrolEngine : EngineInterface {
//    override fun start() {}
//}
//
//class HybridEngine: EngineInterface {
//    override fun start() {}
//}
//
//class DieselEngine : EngineInterface {
//    override fun start() {}
//}

//fun main() {
//    val petrolEngine = PetrolEngine()
//    val petrolCar = Car(petrolEngine)
//    val dieselEngine = DieselEngine()
//    val dieselCar = Car(dieselEngine)
//    val hybridEngine = HybridEngine()
//    val hybridCar = Car(hybridEngine)
//
//    //Boom boom
//    petrolCar.start()
//    dieselCar.start()
//    hybridCar.start()
//}

//Studi Kasus SOLID

interface Vehicle<T> {
    fun accelerate()
    fun brake()
    fun refill(source: T)
}

class Car<T>(private val engine: EngineInterface?, private val storage: StorageInterface<T>): Vehicle<T> {

    override fun accelerate() {
        engine?.move()
    }

    override fun brake() {

    }

    override fun refill(source: T) {
        storage.fill(source)
    }

}

interface EngineInterface {
    fun move()
}

interface StorageInterface<T> {
    fun fill(source: T)
    fun getSource(): T
}

class PetrolEngine(private val oilPipe: OilPipe, private val piston: Piston) : EngineInterface {
    override fun move() {
        val oil: Oil = oilPipe.suckOil()
        val energy: Energy = oil.burn()
        energy.push(piston)
    }
}

class Piston {
    fun move() {

    }
}

class OilPipe {
    fun suckOil(): Oil {
        return Oil()
    }
}

class Oil {
    fun burn(): Energy {
        //Do some combustion process here
        return Energy()
    }
}

class Energy {
    fun push(piston: Piston) {
        piston.move()
    }
}

class Tank(): StorageInterface<Oil> {
    private lateinit var oil: Oil
    override fun fill(source: Oil) {
        this.oil = source
    }

    override fun getSource(): Oil {
        return oil
    }

}

class ElectricEngine(
        private val speedController: SpeedController
) : EngineInterface {
    override fun move() {
        speedController.control()
    }
}

class SpeedController(
        private val bms: BatteryManagementSystem,
        private val motor: ElectricMotor
) {
    fun control() {
        val battery = bms.getBattery()
        motor.rotate(battery)
    }
}

class BatteryManagementSystem {
    fun getBattery(): Battery {
        return Battery(Electrons())
    }
}

class ElectricMotor {
    fun rotate(battery: Battery) {
        //Rotate the rotor using electric power from battery
    }
}

class Electrons {

}

class Battery(private var electrons: Electrons) : StorageInterface<Electrons> {
    override fun fill(source: Electrons) {
        this.electrons = source
    }

    override fun getSource(): Electrons {
        return electrons
    }

}

fun main(){
//    Cat().walk()
//    Cat().eat()
//    Snake().walk()
//    Snake().eat()
//    println(Arithmetic().add(10, 10))

    //Compile time polymorphism
//    println(Add().add(1, 1))
//    println(Add().add(1, 2147483649))
//    println(Add().add(2147483649, 1))
//    println(Add().add(2147483649, 2147483649))

    //Runtime Polymorphism
//    val cat = CatPol()
//    cat.walk()

//    println(StandardCinema(100.toDouble()).calculateAdminFee())
//    println(CinemasInter().calculateAdminFee(100.toDouble()))

    //Petrol car
    val tank = Tank()
    val oilPipe = OilPipe()
    val piston = Piston()
    val petrolEngine = PetrolEngine(oilPipe, piston)
    val petrolCar = Car(petrolEngine, tank)
    val oil = Oil()
    petrolCar.refill(oil)
    petrolCar.accelerate()
    petrolCar.brake()

    //Electric car
    val electrons = Electrons()
    val battery = Battery(electrons)
    val speedController = SpeedController(BatteryManagementSystem(), ElectricMotor())
    val electricEngine = ElectricEngine(speedController)
    val electricCar = Car<Electrons>(electricEngine, battery)
    electricCar.refill(electrons)
    electricCar.accelerate()
    electricCar.brake()
}