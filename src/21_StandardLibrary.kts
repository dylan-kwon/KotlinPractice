/**
 * let
 * 변수의 null 체크를 할 때 주로 사용한다.
 **/
val name: String? = null;

name?.let {
    println("name is not null");

} ?: let {
    println("name is null");
}

println();

/**
 * apply
 * 객체의 생성과 동시에 값을 초기화할 때 유용하다.
 **/
class User(
        var age: Int = 0,
        var name: String = "",
        var email: String = ""
);

val user: User = User().apply {
    age = 21;
    name = "seokchan.kwon";
    email = "seokchan.kwon@gmail.com"
}

user.let {
    println(it.age);
    println(it.name);
    println(it.email);
}

println();

/**
 * run
 * 이미 생성한 객체에 대하여 재 접근시 주로 사용한다.
 **/
user.run {
    age = 23;
}

user.let {
    println(it.age);
    println(it.name);
    println(it.email);
}


println();


/**
 * with
 * 해당 변수에 접근할 때 사용한다.
 * run과 활용도가 비슷한듯.
 */
class Button(
        var text: String = "",
        var textSize: Float = 12f,
        var textColor: String = "#3dbff0"
);

val button: Button = Button().apply {
    text = "with";
    textSize = 16f;
    textColor = "#acd04a"
}

with(button) {
    textSize = 21f;
    this.textColor = "#ffffff";
}

button.let {
    println(it.text);
    println(it.textSize);
    println(it.textColor);
}


println();

/**
 * also
 * 첫번째 블록과 두번째 블록을 분리시켜주는 역할을 한다.
 * 앞 블록은 this로, 뒷 블록은 it로 접근 가능하다.
 * 아래 함수의 경우 user.copy()에서의 user는 this로 접근할 수 있다.
 * User().also { .. } 즉 새로 생성된 User 객체는 it으로 접근할 수 있다.
 **/
fun User.copy() = User().also {
    it.age = this.age;
    it.name = this.name;
    it.email = this.email;
}

val userCopy: User = user.copy();
userCopy.run {
    println(age);
    println(name);
    println(email);
}

println();

/**
 * takeIf
 * 값을 체크하여 boolean 타입으로 리턴
 * true인 경우에는 자기 자신을 리턴하지만, false인 경우 null을 리턴한다.
 */
println("user.takeIf: true = ${user.takeIf {
    it.age > 20;
}}")

println("user.takeIf: true = ${user.takeIf {
    it.age > 30;
}}")


val takeIfUser: User? = user.takeIf {
    it.age > 20
}

when (takeIfUser) {
    is User -> {
        println("takeIfUser is User Type");
    }
    else -> {
        println("takeIfUser is not User Type");
    }
}

println();

/**
 * takeUnless
 * takeIf와 반대의 기능
 * true인 경우 null을, false인 경우 자기 자신을 리턴한다.
 */
println("user.takeUnless: true = ${user.takeUnless {
    it.age > 20;
}}")

println("user.takeUnless: true = ${user.takeUnless {
    it.age > 30;
}}")


val takeUnlessUser: User? = user.takeUnless {
    it.age > 30
}

when (takeUnlessUser) {
    is User -> {
        println("takeUnlessUser is User Type");
    }
    else -> {
        println("takeUnlessUser is not User Type");
    }
}
