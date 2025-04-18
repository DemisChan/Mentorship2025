package shoppingCart

data class Product(val name: String, val price: Double, val category: String)

class ShoppingCart {

    private val products = mutableListOf<Product>()

    fun addProduct(product: Product) {
        products.add(product)
    }

    fun removeProduct(product: Product) {
        products.remove(product)
    }

    fun calculateTotal(): Double {
        return products.sumOf { it.price }
    }

}

fun main() {
    // Shopping Cart
    val productOne = Product(name = "Rice", price = 6.0, category = "Grains")
    val productTwo = Product(name = "Spaghetti", price = 8.0, category = "Pasta")
    val productThree = Product(name = "Onion", price = 9.0, category = "Vegetables")
    val shoppingCart = ShoppingCart().apply {
        addProduct(productOne)
        addProduct(productTwo)
        addProduct(productThree)
    }
    shoppingCart.calculateTotal().apply { println(this) }
}



