# Kotlin

<a name="index"></a>
## Index
1. [문법](#syntax)
    1. [간단한 특징](#summary)
    2. 변수, 상수
        1. [타입](#variable-type)
        2. [선언](#variable-define)
        2. [Null](#variable-null)
        2. [초기화](#variable-init)
    3. 조건문
        1. [If-Else](#if-else)
        2. [When](#when)
    4. 반복문
        1. [For](#for)
        2. [While](#while)
    5. [Try-Catch](#try-catch)        
    6. [Method](#method)
    7. Class
        1. [Class](#class)
        2. [Inner Class](#inner-class)
        3. [Object](#object)
        4. [Companion-Object](#companion-object)
        5. [Data Class](#data-class)
        6. [Abstract Class](#abstract-class)
    8. [Interface](#intface)
    9. [Generic](#generic)
    

<a name="syntax"></a>
## 문법

<a name="summary"></a>
### 간단한 특징

- 변수 선언시 타입 생략이 가능하다.
- 세미콜론`;` 생략이 가능하다
- 기본적으로 모든 변수, 상수는 `non-null` 타입이다.
- 람다 함수의 기본 변수로 `it`을 사용한다.
- 메소드를 `일급 객체`로 취급한다.
- `==`는 값을 비교하며, `===`는 객체 메모리 주소를 비교한다.

<a name="variable-type"></a>
### 자료형
- `String`: 문자열 타입.
- `Int`: 정수 타입.
- `Long`: 정수 타입. `Int의 2배`
- `Float`: 실수 타입.
- `Double`: 실수 타입. `Float의 2배`
- `Boolean`: 논리타입. `true/false`
- `Any`: 모든 타입을 허용.
- `Nothing`: 모든 타입을 허용하지 않음. `(void)`
- `Unit`: return 타입 없음.

```kotlin
val string: String = "string"
val int: String = 100
val long: String = 100L
val float: String = 10.0f
val double: String = 10.0
val boolean: Boolean = true 
``` 

<a name="variable-define"></a>
### 변수 선언
- `var`: 변수
- `val`: 상수
- `const`: `object`나 `companion object` 내에서 `const val`과 같이 사용한다. Java에서 `클래스명.변수명`으로 접근이 가능하다.

```kotlin
val intValue = 100
val strValue: String = "string"

var intVariable = 10
var strVariable: String = "string"

object ObjectClass {
    const var SINGLETON_STRING: Int = 100           // error.
    const val SINGLETON_STRING: String = "STRING"   // success.
}

intValue = 10;          // error
intVariable = 100       // success

strValue = "hello"      // error.
strVariable = "hello"   // success. 
```

<a name="variable-null"></a>
### Null
- `Kotlin`은 기본적으로 모든 변수, 상수에 대해서 `non-null` 타입이다.
- `?`: 변수 타입 뒤에 사용하며, `null`을 허용하거나 `nullable` 객체에 안전하게 접근할 수 있다.
- `!!`: 객체에 접근할 때 사용하며, `non-null`임을 명시한다.

```kotlin
var strVariable1: String = null     // error.
var strVariable2: String? = null    // succes.

strVariable2.toString()    // warning.
strVariable2?.toString()   // success. -> .toString()을 실행하지 않는다.

strVariable = "string"
strVariable2.toString()    // warning. -> 변수를 할당해도 warning이 나타난다.
strVariable2!!.toString()  // success.
```

<a name="variable-init"></a>
### 변수 초기화
- 변수에 접근시 초기화 하는 `늦은 초기화`를 제공한다.
- `lateinit`: `var`와 함께 사용한다.
- `by lazy`: `val`과 함께 사용한다.
- `var`, `val`에서 각각 사용한다는 차이점 외에 동작 방식에는 차이가 없다.

```kotlin
lateinit var a: Int = 10

val b: String by lazy {
    "string"
}
```

<a name="compare"></a>
### 비교
- `==`: 값 자체를 비교한다.
- `===`: 메모리 주소를 비교한다.
- `is`: 객체 타입을 비교한다.
- `in`: 해당 값이 범위에 포함되었는지 비교한다.

```kotlin
var i = 10;
var s1 = "string"
var s2 = "string"

println(i == 10)        // true
println(s1 == "string") // true

println(s1 == s2)       // true
println(s1 === s2)      // false

println(i in 0..9)      // false
println(s1 is String)   // true
``` 

<a name="if-else"></a>
 ### If-Else
 - `Java`와 사용법이 같다.
 - `Kotlin`에는 3항 연산자가 없기 때문에 `if-else`를 한줄로 쓰는 방법을 사용한다.
 - 블록의 마지막 라인이 `return`으로 작용한다. 
 
 ```kotlin
 if ( ... ) {
     ...
     
 } else if ( ... ) {
     ...
     
 } else {
     ...
 }
 
 var variable: Boolean = if ( ... ) {
     true
     
 } else {
     false
 }
 
 val value: String = if (true) "true" else "false"

 ```


<a name="when"></a>
 ### When
 - `Java`의 `switch-case`와 비슷하다.
 - `if-else`와 같이 블록의 마지막 라인은 `return`이다.
 - 비교 조건이 유연하다.
 
 ```kotlin
 when( ... ) {
    1 -> {
        ...
    }
    1, 10 -> {
        ...
    }
    "string" -> {
        ...
    }
    is String -> {
        ...
    }
    !in 1..10 -> {
        ...
    }
    else -> {
        ...  
    }
 }
 ```
 
<a name="for"></a>
### for
- 일반적인 모던 언어의 `for-each`문
```kotlin
// Int Range.
for (i in 0..10 step 2) {
    ...
}


// String (array와 같다.)
for (s in "string") {
    ...
}

for (i in strValue.indices) {
    ...
}

for ((i, s) in strValue.withIndex()) {
    ...
}


// Map.
val map: MutableMap<Int, String> = mutableMapOf(
        1 to "first",
        2 to "second",
        3 to "third"
);

for (key in map.keys) {
    ...
}

for (value in map.values) {
    ...
}

for (item in map) {
    item.key
    item.value
    ...
}

for ((key, value) in map) {
    ...
}
```

<a name="while"></a>
### While
- `Java`와 같다.
```kotlin
while( ... ) {
    ...
}
```


<a name="try-catch"></a>
### Try-Catch
- 블록의 마지막 라인을 `return`한다.
- 그 외에는 `Java`와 같다.

```kotlin
try {
    ...
    
} catch(e: Exception) {
    ...
    
} finally {
    ...
}
```


<a name="method"></a>
### Method
- 매개변수에 `default value`를 설정할 수 있으며, 함수 호출시 해당 인자를 생략할 수 있다..
- 함수 호출 시 `매개변수명=값`을 통해 명시할 수 있다.
- 리턴 타입이 `Unit`인 경우 생략한다.
- 메소드 블록이 한줄인 경우 `{ }` 생략하고 `=`를 사용한다.
- `일급 객체`이므로 변수에 할당할 수 있다.
- `override` 키워드를 통해 확장할 수 있다.

```kotlin
fun getInt(): Int {
    return 10
}

plus(b = 10) // return = 20
fun plus(a: Int = 10, b: Int = 20) = a + b

fun getString(): String = "return String";

val functionValue: (Int, String) -> String = { int, str ->
    str + int.toString()
}
```


<a name="class"></a>
### Class
- 클래스와 메소드, 변수  기본적으로 `final`이다.
- `open` 키워드를 통해 `final` 속성을 제거할 수 있다.
- `init { ... }` 구문을 통해 초기화 작업을 할 수 있다.
- `constructor`는 생략할 수 있다.
- `constructor`를 통해 받는 매개변수는 전역변수로써 사용할 수 있다.
- 생성자 `overload`시 리턴 타입으로 `this()`로 최상위 생성자를 호출해야 한다.
- 다만 생성자 오버로드 없이 최상위 생성자에 `default value`를 설정하는 방법이 좋다.
- 클래스 상속을 위해 `:`을 사용한다.
- `open` 변수를 `override` 할 수 있다.
- 추가로 Implements 할 Interface는 상속 클래스 옆 `,`으로 연속해서 정의한다.

```kotlin
open class KotlinClass constructor(val intValue: Int = 10): SuperClass(), Interface {
    
    init {
        ...
    }
    
    override fun overrideMethod() {
        ...
    }

}  
```


<a name="inner-class"></a>
### Inner Class
- 클래스 내부에 클래스 정의를 통해 정의한다.
- 이때 `inner class`를 통해 정의하면 일반적인 `inner class`가 생성된다.
- `inner` 없이 `class`만 사용하여 정의한 경우 `static inner class`가 생성된다.

```kotlin
class OuterClass {
    
    init {
        ...
    }
    
    class StaticInnerClass {
        ...
    }
    
    inner class InnerClass {
        ...
    }
    
}
```


<a name="object"></a>
### Object
- `Singleton`을 쉽게 생성해주는 클래스다.
- 블록 내에 선언된 객체는 `Singleton`으로 생성된다.
- `클래스명.변수명`으로 접근한다.

```kotlin
object ObjectClass {
    const var SINGLETON_STRING: Int = 100           // error.
    const val SINGLETON_STRING: String = "STRING"   // success.
}
```


<a name="companion-object"></a>
### Companion-Object
- `static` 변수 또는 메소드를 정의한다.
- `클래스명.변수명`으로 접근한다.
- `object`와 차이접은 `Singleton`과 `static`의 차이다.

```kotlin
class CompanionObject {
    
    init {
        ...
    }
    
    companion object {
        const val intValue: Int = 100;
        fun getValue(): Int = intValue;
    }
    
}
```

<a name="data-class"></a>
### Data Class
- `POJO` 클래스다.
- `.equals()`, `.hashCode()`, `.toString()` 함수가 미리 정의되어있다.

```kotlin
data class DataClass(
  val intVal: Int,  
  val strVal: String  
  ...
)
```


<a name="abstract-class"></a>
### Abstract Class
- 기본적인 사용법은 `Java`와 같다.
- `abstract`는 `open`을 포함하고 있다.
    - 따라서 `open`을 명시하지 않아도 상속 및 변수, 함수 오버라이드가 가능하다.

```kotlin
abstract class AbstractClass {
    
    abstract val abstractValue: String;
    
    abstract fun abstractFunction(): String;
}

class ChildClass : AbstractClass() {

    override val abstractValue: String = "abstract value"

    override fun abstractFunction() = this.abstractValue;
}
```


<a name="interface"></a>
### Interface
- 기본적인 사용법은 `Java`와 같다.
- `open`을 명시하지 않아도 상속 및 변수와 메소드를 오버라이드 할 수 있다.
- 익명 클래스로써 사용할 경우 `object` 키워드와 같이 사용한다.
- 단 `callback`의 경우 [Higher-Order-Function](#higher-order-function)을 사용하는것이 좋다.

```kotlin
class Button {

    private var onClickListener: OnClickListener? = null;
    
    fun onClick() {
        this.onClickListener?.onClick()
    }
    
    fun setOnClickListener(listener: OnClickListener) {
        this.onClickListener = listener;
    }
    
    interface OnClickListener {
        fun onClick();
    }

}


val button: Button = Button();

button.setOnClickListener(object: Button.OnClickListener {
    
    override fun onClick() {
        ...
    }
    
})

button.onClick();
```


<a name="generic"></a>
### Generic
- 기본적인 사용법은 `Java`와 같다.
- `<>` 사이에 사용할 타입을 입력한다.
- `<T>`: `getter/setter` 제한이 없는 제너릭이다.
- `<in T>`: Input`(setter)` 전용 제너릭이다. `<? super T>`로 사용할 수 있다.
- `<out T>`: Output`(getter)` 전용 제너릭이다. `<? extends T>`로 사용할 수 있다.
- `<*>`: 모든 타입을 혀용한다는 점에서 `<Any>`와 비슷하나 전자는 타입을 추론한다는 의미이며, 후자는 `<Object>`라는 의미다.
- Java와 달리 제너릭을 생략할 수 없으며, 반드시 명시해야 한다. 단 매개변수를 통해 타입 추론이 가능한 경우에만 생략 가능.

```kotlin
interface Generic<out T> {
    fun getItem(): T;       // success.
    fun setItem(item: T);   // error.
}

class Sample : Generic<String> {
    
    init {
        ...
    }
    
    override fun getValue(): String {
        ...
    }
    
    fun <E> genericFunction(): E {
        ...
    }
    
    fun genericFunction(list: List<*>) {
        ...
    }
    
}

val sample: Sample = Sample()

val getItem1: Any = sample.getValue()
if (getItem1 is String) // true

val getItem2: Int = sample.genericFunction<Int>()
val getItem3: String = sample.genericFunction<String>()

genericFunction(mutableList<Int>())
genericFunction(mutableList<String>())
``` 

















