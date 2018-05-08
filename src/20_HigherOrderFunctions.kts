/**
 * 파라메터가 없을 경우
 **/
//fun print(message: () -> String) {
//    println(message() + "!!");
//}


/**
 * 파라메터가 1개인 경우
 **/
//fun print(message: (String) -> String) {
//    println(message("print"));
//}

/**
 * 파라메터가 2개 이상인 경우
 **/
//fun print(message: (String, String) -> String) {
//    print(message("first", "second"));
//}

/**
 * 응용
 */
var getFunction: (Int, Int) -> Double = { one, two ->
    ((one * two) + 1).toDouble();
}

fun print(string: String, funA: () -> String, funB: (Int) -> Int, funC: (Int, Int) -> Double) {
    print("$string\n"
            + "${funA()}\n"
            + "${funB(10)}\n"
            + "${funC(25, 43)}"
    );
}

//print({
//    "return message"
//})

//print({
//    "$it return message";
//});

//print { one, two ->
//    "$one, $two return message"
//};

print("HigherOrderFunction", {
    "non parameter function"
}, {
    it * 10
}, getFunction);

