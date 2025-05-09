plugins {
    kotlin("jvm") version "2.1.10"
}

allprojects {
    repositories {
        mavenCentral()
    }
}

dependencies {
    implementation(kotlin("stdlib"))

    // Add testing dependencies if needed
    testImplementation(kotlin("test"))
    testImplementation(kotlin("test-junit"))
}
tasks.test {
    useJUnit()
}

kotlin {
    jvmToolchain(21) // Set this to match your Java version
}
