# Kotlin

<a name="index"></a>
## Index
1. [문법](#syntax)
    1. [간단한 특징](#summary)
    2. 변수, 상수
        1. [자료형](#variable-type)
        2. [선언](#variable-define)
        3. [타입 캐스팅](#variable-type-cast)
        4. [Null](#variable-null)
        5. [초기화](#variable-init)
        6. [Getter/Setter](variable-getter-setter)
    3. 자료구조
        1. [Array](#array)
        2. [Map](#map)
        3. [Set](#set)
    4. 조건문
        1. [비교](#compare)
        2. [If-Else](#if-else)
        3. [When](#when)
    5. 반복문
        1. [For](#for)
        2. [While](#while)
    6. [Try-Catch](#try-catch)        
    7. [Method](#method)
    8. Class
        1. [Class](#class)
        2. [Inner Class](#inner-class)
        3. [Object](#object)
        4. [Companion-Object](#companion-object)
        5. [Data Class](#data-class)
        6. [Abstract Class](#abstract-class)
    9. [Interface](#interface)
    10. [Generic](#generic)
    11. [Elvis](#elvis)
    12. [Extension](#extension)
    13. [This](#this)
    14. [Expression](#expression)
    15. [Lambda](#lambda)
    16. [Higher Order Function](#higher-order-function)
    17. [Single Abstract Method (SAM)](#sam)
    18. Standard Library
        1. [let](#standard-library-let)
        2. [apply](#standard-library-apply)
        3. [run](#standard-library-run)
        4. [with](#standard-library-with)
        5. [also](#standard-library-also)
        6. [takeIf](#standard-library-takeif)
        7. [takeUnless](#standard-library-takeunless)
2. [코딩 가이드](#coding-guide)
3. [Reference](#reference)
    

<a name="syntax"></a>
## 문법

<a name="summary"></a>
### 간단한 특징

- 변수 선언시 `타입 생략`이 가능하다.
- 세미콜론`;` 생략이 가능하다
- 기본적으로 모든 변수, 상수는 `non-null` 타입이다.
- 람다 함수의 기본 변수로 `it`을 사용한다.
- 메소드를 `일급 객체`로 취급한다.
- `getter`, `setter` 메소드를 호출할때 `클래스명.변수명 = value`으로 축약할 수 있다.
- 객체의 함수나 프로퍼티를 임의로 `확장 정의`할 수 있다.
- `==`는 값을 비교하며, `===`는 객체 메모리 주소를 비교한다.
- Kotlin에서 `Abstract`와 `Interface`를 제외한 모든 `Class`는 기본적으로 `Final`이다.

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
val int: Int = 100
val long: Long = 100L
val float: Float = 10.0f
val double: Double = 10.0
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

intValue = 10          // error
intVariable = 100       // success

strValue = "hello"      // error.
strVariable = "hello"   // success. 
```

<a name="variable-type-cast"></a>
### 타입 캐스팅
- `as`: Kotlin에서 타입 캐스팅을 하기위한 예약어다.
- `as?`: `TypeCastException`에 안전하게 캐스팅한다.
- `?:`: [Elvis](#elvis)를 사용하면 실패시 `default value`를 설정할 수 있다.

```kotlin
"string" as Int                     // Exception
"string" as? Int                    // return null

"string" as? Int ?: "exception"    // return "exception
```

<a name="variable-null"></a>
### Null
- `Kotlin`은 기본적으로 모든 변수, 상수에 대해서 `non-null` 타입이다.
- `?`: 변수 타입 뒤에 사용하며, `null`을 허용하거나 `nullable` 객체에 안전하게 접근할 수 있다.
- `!!`: 객체에 접근할 때 사용하며, `non-null`임을 명시한다.
- `?:`: [Elvis](#elvis)를 사용하면 실패시 `default value`를 설정할 수 있다.

```kotlin
var strVariable1: String = null           // error.
var strVariable2: String? = null          // succes.

strVariable2.toString()                   // warning.
strVariable2?.toString()                  // .toString()을 실행하지 않는다.
strVariable2?.toString() ?: "exception"   // .toString()을 실행하지 않고 "exception"을 리턴한다.

strVariable = "string"
strVariable2.toString()                   // 변수를 할당해도 선언 타입이 String? 이므로 warning이 나타난다.
strVariable2!!.toString()                 // success.
```

<a name="variable-init"></a>
### 변수 초기화
- 변수에 접근시 초기화 하는 `늦은 초기화`를 제공한다.
- `lateinit`
    - `var`와 함께 사용한다.
    - `primitive-type`에는 사용할 수 없다.
    - `getter`, `setter`를 사용할 수 없다.
    - `::{name}.isInitialized`를 사용하여 초기화 체크를 할 수 있다.
    
- `by lazy`
    - `val`과 함께 사용한다.
    - `getter`를 사용할 수 없다.
    
- `var`, `val`에서 각각 사용한다는 차이점 외에 동작 방식에는 차이가 없다.

```kotlin
lateinit var a: String
a = "lateinit"

if(::a.isInitialized) // true

val b: String by lazy {
    "string"
}
```


<a name="variable-getter-setter"></a>
### Getter/Setter
- 따로 메소드를 정의하지 않아도 변수에 대한 `getter`,`setter`가 자동으로 생성된다.
- `get()`: `getter` 메소드이며, `var`, `val` 관계 없이 오버라이드 할 수 있다.
    - `클래스명.변수명`으로 접근할 수 있다.
- `set()`: `setter` 메소드이며, `var` 변수에서만 오버라이드 할 수 있다.
    - `클래스명.변수명 = setValue`로 값을 변경할 수 있다.
- `get()` 혹은 `set()` 메소드 내부에서 `field` 키워드를 통해 값에 접근할 수 있다.

```kotlin
Class Example {

val value: Int = 10
    get() = field * 100


var variable: Int = 10
    get() = field * 100

    set(value) {
        field = value * 100
    }

}

val example: Example = Example()

example.variable = 10   // 10을 저장했지만 set()을 통해 100배 한 값이 저장된다.
println(example.value)  // 실제 값은 10이지만 get()을 통해 100배한 값이 리턴된다.
```


### 자료구조

<a name="array"></a>
#### 1. Array, List
- 순서`(Index)`가 있는 자료구조.
- `.get(index)` 혹은 `[index]`로 접근할 수 있다.
- `.set(index, value)` 혹은 `[index] = value`로 변경할 수 있다.
- 정적 배열`(Array)`과, 동적 배열`(List)`이 있다.
- 동적 배열은 읽기 전용`(read only)`과 읽기, 쓰기`(mutable)` 모두 가능한 객체로 나누어 제공된다.

##### 1. Array
- 배열의 `size`가 고정적이다.
- 따라서 아이템의 추가, 삭제가 불가능하다.
- 해당 인덱스의 아이템에 접근해서 값을 가져오거나 변경할 수는 있다.
- 기본적인 생성 방법은 `arrayOf<T>( ... )`이다.
- `Primitive Type` 배열 생성자를 제공한다.
    - `intArrayOf( ... )` 
    - `charArrayOf( ... )` 
    - `BooleanArrayOf( ... )`
    - 기타 등등 

```kotlin
// 정적 배열 생성
val staticArray: Array<Int> = arrayOf(0, 1, 2)

// 아이템 접근
staticArray[0]
staticArray.get(0)

// 아이템 변경
staticArray[1] = 10
staticArray.set(1, 10)

// 배열의 사이즈 가져오기
staticArray.size
```

<a name="list"></a>
##### 2. Read Only List
- 아이템에 접근만 가능한 배열이다.
- 배열 초기화 이후 아이템의 추가, 삭제가 불가능하다.
    
```kotlin
// 읽기 전용 배열 생성
val readOnlyList: List<Int> = listOf(0, 1, 2);

// 아이템 접근
readOnlyList[0]
readOnlyList.get(0)

// 배열의 사이즈 가져오기
readOnlyList.size
```

##### 3. Mutable List
- 배열의 `size`가 동적이다.
- `Mutable Collection`은 `+`, `-` 연산자로 추가, 삭제가 가능하다.
    - `List`의 경우 우항에 `item`이 들어간다.
- 따라서 아이템의 `CRUD`가 가능하다.
    
```kotlin
// 읽기, 쓰기 전용 배열 생성
val mutableList: MutableList<Int> = mutableListOf(0, 1, 2);

// 아이템 접근
mutableList[0]
mutableList.get(0)

// 아이템 변경
mutableList[1] = 20
mutableList.set(1, 20)

// 아이템 추가
mutableList += 100
mutableList.add(100)

// 아이템 삭제
mutableList -= 100
mutableList.remove(100)

// 배열의 사이즈 가져오기
mutableList.size
```

<a name="map"></a>
#### 2. Map
- `key`와 `value`로 구성된 자료구조다.
- 순서가 정해져 있지 않다.
- `.get(key)` 또는 `[key]`로 접근할 수 있다.
- `.keys`로 `Set<KEY>`를 가져올 수 있다.
- `.values`로 `Set<VALUE>`를 가져올 수 있다.
- `.size`로 Map의 `size`를 가져올 수 있다.
- 특정 `key`에 접근시 등록된 값이 없을때 `default value`로 [Elvis](#elvis)나 제공되는 `method`를 사용하면 된다.
    - `getOrDefault(key, defaultValue)`: 기본값에 해당하는 매개변수 타입이 `<VALUE>`다.
    - `getOrElse(key, defaltValue)`: 기본값에 해당하는 매개변수 타입이 `<VALUE>`를 리턴하는 [함수](#higher-order-function)다
- `List`와 같이 `Read Only`와 `Mutable` 객체가 각각 제공된다.

##### 1. Read Only Map
- `Item`의 추가나 삭제 없이 접근만 가능한 `Map`이다.

```kotlin
// 읽기 전용 맵 생성
val readOnlyMap: Map<String, Int> = mapOf(
        "first" to 1,
        "second" to 2,
        "third" to 3
);

// 키 값에 해당하는 객체에 접근
readOnlyMap["first"]
readOnlyMap.get("two")


// 키 값에 해당하는 객체가 없을 경우 사용할 기본값을 설정
readOnlyMap["four"] ?: 10

readOnlyMap.getOrElse("five", {
    ...
    10
})

readOnlyMap.getOrDefault("six", 10)
```


##### 2. Mutable Map
- `Item`의 추가나 삭제가 가능한 `Map`이다.
- `Mutable`한 `Collection`은 `+`, `-`로 아이템을 변경할 수 있다.
    - `Map`의 경우 우항에 `Key`값이 들어간다.

```kotlin
// 읽기, 쓰기 전용 맵 생성
val mutableMap: MutableMap<String, Int> = mutableMapOf(
        "first" to 1,
        "second" to 2,
        "third" to 3
);

// 키 값에 해당하는 객체에 접근
mutableMap["first"]
mutableMap.get("two")


// 키 값에 해당하는 아이템 추가 및 변경
mutableMap += "key" to 100
mutableMap["key"] = 100
mutableMap.put("key", 100)


// 키 값에 해당하는 아이템 삭제
mutableMap -= key
mutableMap.remove("key")


// 키 값에 해당하는 객체가 없을 경우 사용할 기본값을 설정
mutableMap["four"] ?: 10

mutableMap.getOrElse("five", {
    ...
    10
})

mutableMap.getOrDefault("six", 10)
```


<a name="set"></a>
#### 3. Set
- `List`와 비슷하지만 아래와 같은 차이점이 있다.
    - 순서가 없다.
    - 중복을 허용하지 않는다.
- `List`와 같이 `Read Only`와 `Mutable` 객체가 각각 제공된다.
- 사용법은 [List](#list)와 비슷하므로 생략.


<a name="compare"></a>
### 비교
- `==`: 값 자체를 비교한다.
- `===`: 메모리 주소를 비교한다.
- `is`: 객체 타입을 비교한다.
- `in`: 해당 값이 범위에 포함되었는지 비교한다.

```kotlin 
var i = 10
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
- **array** `(String, array 등)`
    - 아이템을 인덱스 순서대로 하나씩 꺼내면서 순회한다.
    - `변수명.indices`로 인덱스에 접근할 수 있다.
    - `변수명.withIndex()`로 인덱스와 값에 동시에 접근할 수 있다.
- **map**
    - map의 아이템을 하나씩 꺼내면서 순회한다.
        - `item.key`:로 키에 접근할 수 있다.
        - `item.value`:로 값에 접근할 수 있다.
    - `변수명.keys`를 통해 키를 하나씩 꺼내면서 순회한다.
    - `변수명.values`를 통해 값을 하나씩 꺼내면서 순회한다.

#### 1. **기본**
```kotlin
for (i in 0..10) {
    ...
 }

for (i in 0..10 step 2) {
    ...
}
```


#### 2. **Array**

- `Item`을 하나씩 꺼내는 방법.
```kotlin
val array: Array<Int> = arrayOf(1, 2, 3);

for (item in array) {
    ...
}
```

- `Index`를 하나씩 꺼내는 방법.
```kotlin
val array: Array<Int> = arrayOf(1, 2, 3);

for (index in array.indices) {
    ...
}
```

- `Index`와 `Item`을 동시에 하나씩 꺼내는 방법.
```kotlin
val array: Array<Int> = arrayOf(1, 2, 3);

for ((index, item) in array.withIndex()) {
    ...
}
```


#### 2. **Map**

- `item`을 하나씩 꺼내는 방법. 
```kotlin
val map: MutableMap<Int, String> = mutableMapOf(
        1 to "first",
        2 to "second",
        3 to "third"
)

for (item in map) {
    item.key
    item.value
    ...
}

for ((key, value) in map) {
    ...
}
```

- `key`를 하나씩 꺼내는 방법.
```kotlin
val map: MutableMap<Int, String> = mutableMapOf(
        1 to "first",
        2 to "second",
        3 to "third"
)

for (key in map.keys) {
    ...
}
```


- `value`를 하나씩 꺼내는 방법.
```kotlin
val map: MutableMap<Int, String> = mutableMapOf(
        1 to "first",
        2 to "second",
        3 to "third"
)

for (value in map.values) {
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
// 기본형
fun getInt(): Int {
    return 10
}


// 축약형
fun getString(): String = "return String"


// 기본값 설정
fun plus(a: Int = 10, b: Int = 20) = a + b


// 매개변수 순서에 관계 없이 이름으로 직접 지정하기
plus(b = 10) // return = 20
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
        const val intValue: Int = 100
        fun getValue(): Int = intValue
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
    
    abstract val abstractValue: String
    
    abstract fun abstractFunction(): String
}

class ChildClass : AbstractClass() {

    override val abstractValue: String = "abstract value"

    override fun abstractFunction() = this.abstractValue
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

    private var onClickListener: OnClickListener? = null
    
    fun onClick() {
        this.onClickListener?.onClick()
    }
    
    fun setOnClickListener(listener: OnClickListener) {
        this.onClickListener = listener
    }
    
    interface OnClickListener {
        fun onClick()
    }

}


val button: Button = Button()

button.setOnClickListener(object: Button.OnClickListener {
    
    override fun onClick() {
        ...
    }
    
})

button.onClick()
```


<a name="generic"></a>
### Generic
- 기본적인 사용법은 `Java`와 같다.
- `<>` 사이에 사용할 타입을 입력한다.
- `<T>`: `getter/setter` 제한이 없는 제너릭이다.
- `<in T>`: Input`(setter)` 전용 제너릭이다. `<? super T>`로 사용할 수 있다.
- `<out T>`: Output`(getter)` 전용 제너릭이다. `<? extends T>`로 사용할 수 있다.
- `<*>`: 모든 타입을 혀용한다는 점에서 `<Any>`와 비슷하나 전자 타입을 추론한다는 의미이며, 후자는 `<Object>`라는 의미다.
- Java와 달리 제너릭을 생략할 수 없으며, 반드시 명시해야 한다. 단 타입 추론이 가능한 경우에는 생략 가능.

```kotlin
interface Generic<out T> {
    fun getItem(): T       // success.
    fun setItem(item: T)   // error.
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

val getItem2: Int = sample.genericFunction<Int>()         // Generic 생략 가능
val getItem3: String = sample.genericFunction<String>()   // Generic 생략 가능 

genericFunction(mutableList<Int>())
genericFunction(mutableList<String>())
```

<a name="elvis"></a>
### Elvis
- `Kotlin`에서는 `?`연산자를 통해 `Nullable`한 객체에 안전하게 접근할 수 있다. 접근에 실패했을 경우에 `instance?.length ?: value`로 `defalt value`를 설정할 수 있다.
- 같은 원리로 타입 캐스팅에 실패했을 경우에 대한 값을 지정할 수 있다.

```Kotlin
var strVariable:String? = null;

var length1: Int = strVariable?.length         // return null
var length2: Int = strVariable?.length ?: 0    // return 0

var test2: String = length2 as? String ?: "0"
```

<a name="extension"></a>
### Extension
- 특정 클래스를 임의로 `확장`할 수 있다.
- `this`: 값에 접근할 수 있다.
- `infix`: 확장 메소드의 매개변수가 하나인 경우에만 사용할 수 있다.
    - `object.method(value)`에서 아래와 같이 축약할 수 있다.
    - `object method value`
- `property`명이 겹치는 경우 기존에 정의한 값이 우선순위가 높다.

```kotlin
fun Int.increase(): Int = this + 1

infix fun Int.sum(value: Int): Int = this + value

var intValue1 = 10.increase()   // return 11
var intValue2 = 10 sum 5        // return 15
```


<a name="this"></a>
### This
- `this`: 호출된 시점 혹은 위치에 따라 this가 가르키는 객체가 달라질 수 있다.
- `메소드 내부`: 메소드를 가지고 있는 클래스의 인스턴스.
- `익명 클래스(인터페이스) 내부`: 익명 클래스의 인스턴스.
- `이너 클래스`: 이너 클래스의 인스턴스.
- `람다식 내부`: 람다식이 호출된 클래스의 인스턴스.
- [higher order function](#higher-order-function): 람다식이 호출된 클래스의 인스턴스. 

```kotlin
class ExampleA {

    val mSampleB: SampleB by lazy {
        SampleB()
    }

    inner class ExampleB {
    
        fun test(a: String) {
            println("d.hashcode = ${this.hashCode()}")
            
            a.foo()
        }

        fun Int.foo() {
            println("e.hashcode = ${this.hashCode()}")
        }
        
    }

    fun test() {
        println("a.hashcode = ${this.hashCode()}")
        
        val mutableList: MutableList<Int> = mutableListOf(1)
            mutableList.forEach {
            println("b.hashcode = ${this.hashCode()}")
        }
    
        object: Interface {
            override fun onStart() {
                println("c.hashcode = ${this.hashCode()}")
            }
        }.onStart()

        mSampleB.test("string")
    }
    
    interface Interface {
        fun onStart()
    }
        
}

val ExampleA: exampleA = ExampleA()
exampleA.test()

/**
    a.hashcode = 91062265       // @ExampleA
    b.hashcode = 91062265       // @ExampleA
    c.hashcode = 75874921       // Anonymous Class
    d.hashcode = 255746728      // @ExampleB
    e.hashcode = -891985903     // String Extension
**/
```


<a name="expression"></a>
### Expression
- `{name}@` 같이 명시할 수 있다.
    - 예) 내부 for문에서 외부 for문을 `break@outer-for`
- 클래스명, 함수명 등 직접 정의하지 않아도 `@{class-name}`으로 사용할 수 있다.
    - 예) 내부 클래스에서 `this@OuterClass`로 외부 클래스로 접근.

#### 1. **For문**에서 사용하는 경우
```kotlin
loopI@ for (i in 1..10) {
    loopJ@ for (j in 1..100) {
        if (j == 10) {
            println()
            break@loopI
               // loopI에 해당하는 for문이 종료된다.
        }
        print("$j ")
    }
}
```

#### 2. **Class**(this)에서 사용하는 경우
```kotlin
class ExampleA {

    val mSampleB: SampleB by lazy {
        SampleB()
    }

    inner class ExampleB {
    
        fun test() {
            val a = this@ExampleA
            val b = this@ExampleB
                        
            println("a.hashcode = ${a.hashCode()}")
            println("b.hashcode = ${b.hashCode()}")
        }
    }

    fun test() {
        mSampleB.test()
    }
    
}

val ExampleA: exampleA = ExampleA()
exampleA.test()
```

<a name="lambda"></a>
### Lambda
- `{ param1, param2 -> ... }`: Kotlin의 람다식이다.
- `it`: 람다식의 파라미터가 `한개`인 경우 매개변수 정의를 `생략`하고 사용할 수 있다.
- 블록의 마지막 줄은 `return`이다.

```kotlin
val list: MutableList<Int> = 
        mutableListOf(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

list.filter {
    it % 2 == 0;

}.map {
    it * 10;

}.forEachIndexed { index, value ->
    println("index = $index // value = $value");
}
```

<a name="higher-order-function"></a>
### Higher-Order-Function
- Kotlin의 메소드는 `1급 객체`이다.
- 따라서 함수를 인자로 `전달`하거나 `리턴`할 수 있다.
- 변수에도 `저장`할 수 있다.
- 매개변수로 함수가 하나 필요한 경우 소괄호`()`를 `생략`할 수 있다.
- `Lambda`로 `축약`해서 사용할 수 있다.

#### 1. 변수에 저장하는 경우
```kotlin
// 기본형
val toString: (Int) -> String = fun(int: Int): String {
    return int.toString()
}

// 축약형
val toInt: (String) -> Int = {
    it.toInt()
}
```

#### 2. 함수 **1개**를 메소드 인자로 받는 경우
```kotlin
fun method(function: () -> Unit) {
    function()
}

method { 
    ...
}
```


#### 3. 함수 **2개**를 메소드 인자로 받는 경우
```kotlin
fun method(functionA: () -> Unit, functionB: () -> Unit) {
    functionA()
    functionB()
}

method ({
    // functionA ...
    
}, {
    // functionB ...
})
```
   

<a name="sam"></a>
### Single Abstract Method (SAM)
- `Java`에서 `하나`의 메소드를 가지는 `Interface` 혹은 `abstract class`와 그 `setter`를 정의해야 함.
    - 예를들면 `Android`의 `View.OnClickListener`와 `view.setOnClickListener(l);`
- 원래 `view.setOnClickListener(object: View.OnClickListener { .. })` 와 같이 선언해야 하는것을 `축약`할 수 있다.
    - `view.setOnClickListener { ... }`

```kotlin
val button: Button by lazy {
    findViewById(R.id.button)
}

button.setOnClickListener {
    ...
}
```


### Standard Library

<a name="standard-library-let"></a>
#### 1. let
- 주로 객체의 `null`체크를 할때 사용한다.
- 블록 내에서 `it`를 사용하여 객체에 접근할 수 있다.
- 블록의 마지막 줄이 리턴된다.
- `run`과 큰 차이가 없다.
  - `let`의 경우 블록이 접근한 객체를 매개변수로 같는 `lambda`식이기 때문에 `it`으로 접근한다.
  - `run`의 경우 블록이 접근한 객체를 확장한 `extension`한 것으로 `this`로 접근한다. 

```kotlin
public inline fun <T, R> T.let(block: (T) -> R): R {
    contract {
        callsInPlace(block, InvocationKind.EXACTLY_ONCE)
    }
    return block(this)
}
```
  
```kotlin
val name: String? = null;

name?.let {
    ...

} ?: let {
    ...
}
```


<a name="standard-library-apply"></a>
#### 2. apply
- 객체의 생성과 동시에 값을 초기화할 때 유용하다.
- `Builder` 패턴같은 느낌으로 사용.
- 블록 내에서 `this`를 사용하여 객체에 접근할 수 있다.
- 접근한 객제 자신이 다시 리턴된다.

```kotlin
public inline fun <T> T.apply(block: T.() -> Unit): T {
    contract {
        callsInPlace(block, InvocationKind.EXACTLY_ONCE)
    }
    block()
    return this
}
```

``` kotlin
class User(
        var age: Int = 0,
        var name: String = "",
        var email: String = ""
);

val user: User = User().apply {
    this.age = 21;
    this.name = "seokchan.kwon";
    this.email = "seokchan.kwon@gmail.com"
}
```


<a name="standard-library-run"></a>
#### 3. run
- 이미 생성한 객체에 대하여 재 접근시 주로 사용한다.
- 블록 내에서 `this`를 사용하여 객체에 접근할 수 있다.
- 블록의 마지막 줄이 리턴된다.
- `let`과 큰 차이가 없다.
  - `let`의 경우 블록이 접근한 객체를 매개변수로 같는 `lambda`식이기 때문에 `it`으로 접근한다.
  - `run`의 경우 블록이 접근한 객체를 확장한 `extension`한 것으로 `this`로 접근한다. 

```kotlin
public inline fun <T, R> T.run(block: T.() -> R): R {
    contract {
        callsInPlace(block, InvocationKind.EXACTLY_ONCE)
    }
    return block()
}
```

```kotlin
class User(
        var age: Int = 0
        var name: String = ""
        var email: String = ""
);

val user: User = User()

user.run {
    this.age = 23;
}
```

<a name="standard-library-with"></a>
#### 4. with
- 이미 생성한 객체에 대하여 재 접근시 주로 사용한다.
- 블록 내에서 `this`를 사용하여 객체에 접근할 수 있다.
- 블록의 마지막 줄이 리턴된다.
- `run`과 용도가 거의 비슷해 보인다.

```kotlin
public inline fun <T, R> with(receiver: T, block: T.() -> R): R {
    contract {
        callsInPlace(block, InvocationKind.EXACTLY_ONCE)
    }
    return receiver.block()
}
```

```kotlin
class Button(
        var text: String = "",
        var textSize: Float = 12f,
        var textColor: String = "#3dbff0"
);

val button: Button = Button()

with(button) {
    this.textSize = 21f;
    this.textColor = "#ffffff";
}
```

<a name="standard-library-also"></a>
#### 5. also
 - 블록 내에서 `it`를 사용하여 객체에 접근할 수 있다.
 - 접근한 객체 자신이 리턴된다.
 - `apply`와 비슷하다.
   - `also`: 블록이 `lambda`식이기 때문에 `it`으로 객체에 접근한다.
   - `apply`: 블록이 `extension function`이기 때문에 `this`로 접근한다.

 ```kotlin
 public inline fun <T> T.also(block: (T) -> Unit): T {
     contract {
         callsInPlace(block, InvocationKind.EXACTLY_ONCE)
     }
     block(this)
     return this
 }
 ```

 ```kotlin
 fun User.copy() = User().also {
     it.age = this.age;
     it.name = this.name;
     it.email = this.email;
 }
 
 val userCopy: User = user.copy();
 ```



<a name="standard-library-takeif"></a>
#### 6. takeIf
 - 블록 내에서 `it`를 사용하여 객체에 접근할 수 있다.
 - 블록의 마지막 줄에서 `Boolean`을 리턴한다.
 - 리턴된 값이 `true`인 경우 `접근한 객체`가 리턴되고, `false`인 경우 `null`이 리턴된다.

 ```kotlin
 public inline fun <T> T.takeIf(predicate: (T) -> Boolean): T? {
     contract {
         callsInPlace(predicate, InvocationKind.EXACTLY_ONCE)
     }
     return if (predicate(this)) this else null
 }
 ```

 ```kotlin
 class User(
         var age: Int = 0
         var name: String = ""
         var email: String = ""
 );
 
 val user: User? = User().takeIf { 
     it.age > 0
 }

 if (user == null) // true
 ```


<a name="standard-library-takeunless"></a>
#### 7. takeUnless
 - 블록 에서 `it`를 사용하여 객체에 접근할 수 있다.ㅎ
 - 블록의 마지막 줄에서 `Boolean`을 리턴한다.
 - 리턴된 값이 `false`인 경우 `접근한 객체`가 리턴되고, `true`인 경우 `null`이 리턴된다.
 - `takeIf`와 반대다.

 ```kotlin
 public inline fun <T> T.takeUnless(predicate: (T) -> Boolean): T? {
     contract {
         callsInPlace(predicate, InvocationKind.EXACTLY_ONCE)
     }
     return if (!predicate(this)) this else null
 }
 ```

 ```kotlin
 class User(
         var age: Int = 0
         var name: String = ""
         var email: String = ""
 );
 
 val user: User? = User().takeIf { 
     it.age > 0
 }

 if (user == null) // false
 ```


<a name="coding-guide"></a>
### 코딩 규칙
- [https://code-examples.net/ko/docs/kotlin/docs/reference/coding-conventions](https://code-examples.net/ko/docs/kotlin/docs/reference/coding-conventions)


<a name="reference"></a>
### Reference
- [https://kotlinlang.org/docs/reference](https://kotlinlang.org/docs/reference)
- [https://thdev.tech/tags/#Kotlin](https://thdev.tech/tags/#Kotlin)









