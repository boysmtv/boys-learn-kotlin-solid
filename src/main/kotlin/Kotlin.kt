

fun test() {
    val mood = "I am sad"
    val moods = "I am sad"

    run {
        val mood = "I am happy"
        println(mood) // I am happy
        println(moods) // I am sad
    }
    println(mood)  // I am sad
}

fun tWithNtRun(){

    data class User (var name : String?, var status : String?)
    val user : User? = User("boys", null)

    with(user){
        this?.name = "william"
        this?.status = "single"
    }
    println(user)

    user?.run {
        println("not null")
    }
}

fun tRunNtLet(){
    val stringVariable : String? = "boys"

    stringVariable?.run {
        println("The length of this String is $length")
    }
    // Similarly.
    stringVariable?.let {
        println("The length of this String is ${it.length}")
    }
    // Similarly.
    stringVariable?.let {
        nonNullString ->
        println("The non null string is $nonNullString")
    }
}

fun tLetNtAlso(){

//    T Run null check with send argument ?
//    T Let null check with send argument ?
//    T Also check with send argument ?

    println()
    val original = "abc"
    // Evolve the value and send to the next chain
    original.let {
        println("The original String is $it") // "abc"
        it.reversed() // evolve it as parameter to send to next let
    }.let {
        println("The reverse String is $it") // "cba"
        it.length  // can be evolve to other type
    }.let {
        println("The length of the String is $it") // 3
    }

    println()
    // Wrong
    // Same value is sent in the chain (printed answer is wrong)
    original.also {
        println("The original String is $it") // "abc"
        it.reversed() // even if we evolve it, it is useless
    }.also {
        println("The reverse String is ${it}") // "abc"
        it.length  // even if we evolve it, it is useless
    }.also {
        println("The length of the String is ${it}") // "abc"
    }

    println()
    // Corrected for also (i.e. manipulate as original string
    // Same value is sent in the chain
    original.also {
        println("The original String is $it") // "abc"
    }.also {
        println("The reverse String is ${it.reversed()}") // "cba"
    }.also {
        println("The length of the String is ${it.length}") // 3
    }
}

//Looking at all attributes

fun tApply(){

}

// Improved approach, chaining
//fun createIntent(intentData: String, intentAction: String) =
//        Intent().apply { action = intentAction }
//                .apply { data = Uri.parse(intentData) }

// Normal approach
//fun createIntent(intentData: String, intentAction: String): Intent {
//    val intent = Intent()
//    intent.action = intentAction
//    intent.data=Uri.parse(intentData)
//    return intent
//}


fun letArgs(){
    // Chaining let functions
    var a = 1
    val b = 2

    a = a.let {
        it + 2
    }.let {
        val i = it + b
        i
    }
    println(a) //5
    println("--------------------> Chaining let functions")
    println()

    // Nesting let
    var x = "Anupam"
    x = x.let { outer ->
        outer.let { inner ->
            println("Inner is $inner and outer is $outer")
            "Kotlin Tutorials Inner let"
        }
    }
    println(x) //prints Kotlin Tutorials Outer let
    println("--------------------> Nesting let")
    println()

    // let for null checks
//    var name : String? = "Kotlin let null check"
//    name?.let { println(it) } //prints Kotlin let null check
//    name = null
//    name?.let { println(it) } //nothing happens

    // Kotlin run
    var tutorial = "This is Kotlin Tutorial"
    println(tutorial) //This is Kotlin Tutorial
    tutorial = run {
        val tutorial = "This is run function"
        tutorial
    }
    println(tutorial) //This is run function
    println("--------------------> Kotlin run")
    println()

    // let and run
    var p : String? = null
    p?.let {
        println("p is $p") } ?: run {
            println("p was null. Setting default value to: ")
            p = "Kotlin"
    }
    println(p)
    println("--------------------> let and run")
    println()

    // Kotlin also
    var m = 1
    m = m.also { it + 1 }.also { it + 1 }
    println(m) //prints 1
    println("--------------------> Kotlin also")
    println()

    // Kotlin let vs also
    data class Person(var name: String, var tutorial : String)
    var person = Person("Anupam", "Kotlin")

    var l = person.let { it.tutorial = "Android" }
    var al = person.also { it.tutorial = "IOS" }

    println(l)
    println(al)
    println(person)
    println("--------------------> Kotlin let vs also")
    println()

    // Kotlin apply
    person.apply { this.tutorial = "Swift" }
    println(person)
    println("--------------------> Kotlin apply")
    println()

    // apply vs also
    data class Personss(var n: String, var t : String)
    var personss = Personss("Anupam", "Kotlin")

    personss.apply { t = "Swift" }
    println(personss)
    personss.also { it.t = "Kotlin" }
    println(personss)
    println("--------------------> apply vs also")
    println()

    // Kotlin with
    with(person)
    {
        name = "No Name"
        tutorial = "Kotlin tutorials"
    }
    println(person)
    println("--------------------> Kotlin with")
    println()

    // Kotlin apply vs with
    var xyz = with(person)
    {
        name = "No Name"
        tutorial = "Kotlin tutorials"
        val xyz = "End of tutorial"
        xyz
    }
    println(person) //End of tutorial
    println(xyz) //End of tutorial
    println("--------------------> Kotlin apply vs with")
    println()
}


fun main(){
//    test()
//    tWithNtRun()
//    tRunNtLet()
//    tLetNtAlso()

    letArgs()
}