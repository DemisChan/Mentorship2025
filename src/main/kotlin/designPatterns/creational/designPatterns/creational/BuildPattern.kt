package org.mentorship2025.designPatterns.creational.designPatterns.creational

/*
*  Implement the Builder for the Mail class. The to field is mandatory, but cc, title, and body are optional.
* The build() method should create and return a configured Mail object.*/

class Mail private constructor(val to: String, val cc: String?, val title: String?, val body: String?) {

    data class Builder(
        var to: String,
        var cc: String? = null,
        var title: String? = null,
        var body: String? = null
    ) {
        fun to(to: String): Builder {
            this.to = to
            return this
        }

        fun cc(cc: String): Builder {
            this.cc = cc
            return this
        }
        fun title(title: String) = apply { this.title = title }

        fun body(body: String) = apply { this.body = body }


        fun build() = Mail(to, cc, title, body)
    }
}

fun main() {
    val simpleMail = Mail.Builder("demis@gmail.com")
        .title("Project Update")
        .build()

    val fullMail = Mail.Builder("boss@example.com")
        .cc("hr@example.com")
        .title("Project Update")
        .body("Here is the latest update on the project...")
        .build()

    println("Simple Mail To: ${simpleMail.to}, Title: ${simpleMail.title}")
    println("Full Mail To: ${fullMail.to}, CC: ${fullMail.cc}, Title: ${fullMail.title}, Body: ${fullMail.body}")
}