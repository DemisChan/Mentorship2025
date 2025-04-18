package nullSafety

// Task 1: Safe Property Access
// Create a function that safely returns the length of a nullable string
// Return 0 if the string is null
fun getStringLength(str: String?): Int {
    return if (str == null) {
        0
    } else {
        str.length
    }
}

// Task 2: Elvis Operator Practice
// Create a function that returns the input string if it's not null and not empty,
// otherwise return "Default Value"
fun getStringOrDefault(input: String?): String {
    return input ?: "Default Value"
}

// Task 3: Non-null Assertion
// Create a function that converts a nullable string to uppercase
// Throw an IllegalArgumentException if the string is null
fun convertToUppercase(str: String?): String {
    return str!!.uppercase()
}

// Task 4: Nullable List Processing
// Create a function that takes a list of nullable strings and returns
// a list of non-null strings
fun processStringList(list: List<String?>): List<String> {
    return list.filterNotNull()
}

// Task 5: Safe Chain Calls
class User(val name: String?, val address: Address?)
class Address(val street: String?, val city: String?)

// Create a function that safely returns a user's city
// Return "Unknown City" if any part of the chain is null
fun getUserCity(user: User?): String {
    return user?.address?.city.let {
        it ?: "Unknown City"
    }

}

// Task 6: Multiple Nullable Properties
class Profile(val userId: String?, val name: String?, val email: String?)

// Create a function that generates a profile summary string using these rules:
// - If userId is null, return "Invalid Profile"
// - If name is null, use "Anonymous" as name
// - If email is null, don't include it in the summary
// Format: "User: {name} (ID: {userId}) [Email: {email}]"
fun createProfileSummary(profile: Profile): String {
    val id = profile.userId
    val name = profile.name ?: "Anonymous"
    val email = if (profile.email != null) " [Email: ${profile.email}]" else ""
    if (id == null) {
        return "Invalid Profile"
    }

    return "User: $name, (ID: $id)$email."

}

// Test cases to verify your implementations
fun main() {
    // Task 1 Test
    println(getStringLength(null)) // Should print: 0
    println(getStringLength("Hello")) // Should print: 5

    // Task 2 Test
    println(getStringOrDefault(null)) // Should print: Default Value
    println(getStringOrDefault("")) // Should print: Default Value
    println(getStringOrDefault("Hello")) // Should print: Hello

    // Task 3 Test
    try {
        println(convertToUppercase("hello")) // Should print: HELLO
        println(convertToUppercase(null)) // Should throw exception
    } catch (e: NullPointerException) {
        println("Exception caught as expected")
    }

    // Task 4 Test
    val nullableList = listOf("Hello", null, "World", null)
    println(processStringList(nullableList)) // Should print: [HELLO, WORLD]

    // Task 5 Test
    val address = Address("123 Main St", "Boston")
    val user = User("John", address)
    println(getUserCity(user)) // Should print: Boston
    println(getUserCity(null)) // Should print: Unknown City

    // Task 6 Test
    val profile1 = Profile("123", "John", "john@email.com")
    val profile2 = Profile("456", null, null)
    val profile3 = Profile(null, "Jane", "jane@email.com")

    println(createProfileSummary(profile1)) // Should print: User: John (ID: 123) [Email: john@email.com]
    println(createProfileSummary(profile2)) // Should print: User: Anonymous (ID: 456)
    println(createProfileSummary(profile3)) // Should print: Invalid Profile
}
