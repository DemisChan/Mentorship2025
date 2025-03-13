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



