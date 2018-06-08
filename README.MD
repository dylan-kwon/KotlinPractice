# Kotlin

<a name="index"></a>
## Index
1. [문법](#syntax)
    1. [간단한 특징](#summary)
    2. [변수, 상수](#variable-value)
        1. [타입](#variable-type)
        2. [선언](#variable-define)
        2. [Null](#variable-null)
        2. [초기화](#variable-init)
    3. 

<a name="syntax"></a>
## 문법

<a name="summary"></a>
### 1. 간단한 특징

- 변수 선언시 타입 생략이 가능하다.
- 세미콜론`;` 생략이 가능하다
- 기본적으로 모든 변수, 상수는 `non-null` 타입이다.
- 람다 함수의 기본 변수로 `it`을 사용한다.
- 메소드를 `일급 객체`로 취급한다.
- `==`는 값을 비교하며, `===`는 객체 메모리 주소를 비교한다.

<a name="variable-value"></a>
### 2. 변수, 상수

<a name="variable-type"></a>
>#### 2-1. 변수 타입
>- `String`: 문자열 타입.
>- `Int`: 정수 타입.
>- `Long`: 정수 타입. `Int의 2배`
>- `Float`: 실수 타입.
>- `Double`: 실수 타입. `Float의 2배`
>- `Boolean`: 논리타입 `true/false`
>- `Any`: 모든 타입을 허용.
>- `Nothing`: 모든 타입을 허용하지 않음. `(void)`
>- `Unit`: return 타입 없음.
>
>```kotlin
>val string: String = "string"
>val int: String = 100
>val long: String = 100L
>val float: String = 10.0f
>val double: String = 10.0
>val boolean: Boolean = true 
>``` 
>
<a name="variable-define"></a>
>#### 2-2. 변수 선언
>- `var`: 변수
>- `val`: 상수
>- `const`: `object`나 `companion object` 내에서 `const val`과 같이 사용한다. Java에서 `클래스명.변수명`으로 접근이 가능하다.
>
>```kotlin
>val intValue = 100
>val strValue: String = "string"
>
>var intVariable = 10
>var strVariable: String = "string"
>
>object ObjectClass {
>    const var SINGLETON_STRING: Int = 100           // error.
>    const val SINGLETON_STRING: String = "STRING"   // success.
>}
>
>intValue = 10;          // error
>intVariable = 100       // success
>
>strValue = "hello"      // error.
>strVariable = "hello"   // success. 
>```
>
<a name="variable-null"></a>
>#### 2-3. Null
>- `Kotlin`은 기본적으로 모든 변수, 상수에 대해서 `non-null` 타입이다.
>- `?`: 변수 타입 뒤에 사용하며, `null`을 허용하거나 `nullable` 객체에 안전하게 접근할 수 있다.
>- `!!`: 객체에 접근할 때 사용하며, `non-null`임을 명시한다.
>
>```kotlin
>var strVariable1: String = null     // error.
>var strVariable2: String? = null    // succes.
>
>strVariable2.toString()    // warning.
>strVariable2?.toString()   // success. -> .toString()을 실행하지 않는다.
>
>strVariable = "string"
>strVariable2.toString()    // warning. -> 변수를 할당해도 warning이 나타난다.
>strVariable2!!.toString()  // success.
>```
>
<a name="variable-init"></a>
>#### 2-4. 변수 초기화
>- 변수에 접근시 초기화 하는 `늦은 초기화`를 제공한다.
>- `lateinit`: `var`와 함께 사용한다.
>- `by lazy`: `val`과 함께 사용한다.
>- `var`, `val`에서 각각 사용한다는 차이점 외에 동작 방식에는 차이가 없다.
>
>```kotlin
>lateinit var a: Int = 10
>
>val b: String by lazy {
>    "string"
>}
>```

<a name="conditional"></a>
### 3. 조건문

<a name="conditional-if-else"></a>
> #### 3-1. If-Else
> - `Java`와 사용법이 같다.
> - `Kotlin`에는 3항 연산자가 없기 때문에 `if-else`를 한줄로 쓰는 방법을 사용한다.
> - 블록의 마지막 라인이 리턴으로 작용한다. 
> 
> ``` kotlin
> if ( ... ) {
>     ...
>     
> } else if ( ... ) {
>     ...
>     
> } else {
>     ...
> }
> 
> var variable: Boolean = if ( ... ) {
>     true
>     
> } else {
>     false
> }
> 
> val value: String = if (true) "true" else "false"
> 
> ```


<a name="conditional-when"></a>
> #### 3-2. When






















