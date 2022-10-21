fun printBinarySquare(count : Int) {
    var isStart = false
    var arrString: String

    for (i in 1..count){
        if (isStart){
            isStart = false
            arrString = "1"
        }else{
            isStart = true
            arrString = "0"
        }

        for(j in 1..count){
            print(arrString.last())

            arrString += if(arrString.last() == '0'){
                "1"
            }else{
                "0"
            }
        }
        println("")
    }
}

fun fizzBuzz(count : Int){
    for (i in 1..count){
        if(((i % 3) == 0) && ((i % 5) == 0)){
            println("FizzBuzz")
        }else if ((i % 3) == 0){
            println("Fizz")
        }else if((i % 5) == 0){
            println("Buzz")
        }else{
            println(i)
        }

    }
}
fun ArrayChallenge(strArr: Array<String>): String {
    var tempInt : Int
    var strTemp = ""
    var hasE = false

    for(item in strArr.indices){
        try {
            tempInt = strArr[item].toInt()
            strTemp += ("$tempInt,")
            hasE = false
        } catch (e: NumberFormatException) {
            // for exception log
            if (hasE){
                break
            }
            hasE = true
        }
    }
    return strTemp.dropLast(1)

}

fun MathChallenge(num: Int): Int {
    var bil: Int
    var count = 0
    var tempLoop = 1
    var lastTimeLoop = 0

    while (count < num){
        var primaTemp = 0
        for (i in 1..tempLoop) {
            bil = 0
            for (j in 1..i) {
                if (i % j == 0) {
                    bil += 1
                }
            }
            if (bil == 2) {
                primaTemp += 1
            }
            lastTimeLoop = tempLoop
        }
        tempLoop++
        count = primaTemp
    }
    return lastTimeLoop
}

//Math Challenge
//Have the function MathChallenge(str) take the str parameter being passed and
// determine if there is some substring K that can be repeated N > 1 times to
// produce the input string exactly as it appears. Your program should return
// the longest substring K, and if there is none it should return the string -1.

//For example: if str is "abcababcababcab" then your program should return abcab
// because that is the longest substring that is repeated 3 times to create the
// final string. Another example: if str is "abababababab" then your program should
// return ababab because it is the longest substring. If the input string contains
// only a single character, your program should return the string -1.

//Examples
//Input: "abcxabc"
//Output: -1
//Input: "affedaaffed"
//Output: -1

fun findDuplicate(string: String) : String {

    var value = ""
    var strTemp = string
    val strSize = strTemp.length
    val strSplit = strSize/2

    for (a in 2..strSplit){
        val tempSize = strSize % a
        if (tempSize == 0){
            val subStr : ArrayList<String> = ArrayList()
            val sizeSplit = strSize / a
            for (z in 1 .. a){
                subStr.add(strTemp.substring(0, sizeSplit))
                strTemp = strTemp.drop(sizeSplit)
            }
            var isSame = true
            var isCountSame = 1

            for (x in 0 until subStr.size){
                for (w in 0 until subStr.size){
                    if (subStr[x] != subStr[w]) {
                        isCountSame++
                        isSame = false
                        break
                    }
                }
            }
            if (!isSame){
                if (a > strSplit){
                    value = "-1"
                    break
                }else{
                    strTemp = string
                }
            }else{
                println(subStr[0])
                value = subStr[0]
                break
            }

        }else{
            if (a > strSplit){
                value = "-1"
                break
            }else{
                if (a == strSplit){
                    value = "-1"
                }
            }
        }
    }
    return value
}

//Have the function StringChallenge(str) take the str parameter being passed which
// will be an average rating between 0.00 and 5.00, and convert this rating
// into a list of 5 image names to be displayed in a user interface to
// represent the rating as a list of stars and half stars.
// Ratings should be rounded to the nearest half.
// There are 3 image file names available: "full.jpg", "half.jpg", "empty.jpg".
// The output will be the name of the 5 images (without the extension),
// from left to right, separated by spaces. For example: if str is "2.36"
// then this should be displayed by the following image:
fun StringChallenge(str: String): String {
    val strTemp: String = str.replace(".",",")
    val namesList = strTemp.split(",")
    var tempStr = ""
    var isFull = false
    var isHalf = false
    var forLoop = 1
    val starLimit = 5
    for (z in forLoop..starLimit){
        if (namesList.isNotEmpty()){
            if (!isFull){
                if (namesList[0].isNotEmpty()){
                    for (i in 1..namesList[0].toDouble().toInt()){
                        tempStr += "full "
                    }
                    forLoop += namesList[0].toDouble().toInt()
                    isFull = true
                }
            }
            if (namesList.size > 1){
                if (!isHalf){
                    if (namesList[1].isNotEmpty()){
                        tempStr += "half "
                        isHalf = true
                    }
                    forLoop += 1
                }else{
                    if (forLoop > starLimit){
                        break
                    }else{
                        tempStr += "empty "
                        forLoop += 1
                    }
                }
            }else{
                if (forLoop > starLimit){
                    break
                }else{
                    tempStr += "empty "
                    forLoop += 1
                }
            }
        }
    }
    return tempStr
}

fun main(args: Array<String>) {
    //printBinarySquare(10)
    //fizzBuzz(15)
    //println(ArrayChallenge(arrayOf("4","E","1","E","2","E","3","E")))
    //println(MathChallenge(100))
    println(findDuplicate("abcxabc"))
    println(findDuplicate("affedaaffed"))
    println(findDuplicate("abcdabcdabcdabcd"))
    //println(StringChallenge("4.5"))
}