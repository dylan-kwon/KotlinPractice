class User private constructor(builder: Builder) {

    private var age: Int? = null;
    private var name: String? = null;
    private var email: String? = null;
    private var password: String? = null;

    public fun getAge(): Int? = this.age;
    public fun getName(): String? = this.name;
    public fun getEmail(): String? = this.email;
    public fun getPassword(): String? = this.password;

    init {
        this.age = builder.age;
        this.name = builder.name;
        this.email = builder.email;
        this.password = builder.password;
    }

    class Builder {

        public var age: Int? = null;
        public var name: String? = null;
        public var email: String? = null;
        public var password: String? = null;

        public fun setAge(age: Int): Builder {
            this.age = age;
            return this;
        }

        public fun setName(name: String): Builder {
            this.name = name;
            return this;
        }

        public fun setEmail(email: String): Builder {
            this.email = email;
            return this;
        }

        public fun setPassword(password: String): Builder {
            this.password = password
            return this;
        }

        public fun build(): User = User(this);

    }

}

val user: User = User.Builder()
        .setAge(21)
        .setName("seokchan.kwon")
        .setEmail("seokchan.kwon@gmail.com")
        .setPassword("password!!")
        .build();

println("age = " + user.getAge());
println("name = " + user.getName());
println("email = " + user.getEmail());
println("password = " + user.getPassword());