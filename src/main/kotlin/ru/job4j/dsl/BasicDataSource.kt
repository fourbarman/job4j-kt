package ru.job4j.dsl

class BasicDataSource private constructor(
    val driverClassName: String,
    val url: String,
    val username: String,
    val password: String,
    val minIdle: Int,
    val maxIdle: Int,
    val maxOpenPreparedStatements: Int
) {
    class Builder {
        private var driverClassName: String? = null
        private var url: String? = null
        private var username: String? = null
        private var password: String? = null
        private var minIdle: Int? = 0
        private var maxIdle: Int? = 0
        private var maxOpenPreparedStatements: Int? = 0

        fun setDriverClassName(dbDriverClassName: String?) = apply { driverClassName = dbDriverClassName }
        fun setUrl(dbUrl: String?) = apply { url = dbUrl }
        fun setUsername(dbUsername: String?) = apply { username = dbUsername }
        fun setPassword(dbPassword: String?) = apply { password = dbPassword }
        fun setMinIdle(dbMinIdle: Int?) = apply { minIdle = dbMinIdle }
        fun setMaxIdle(dbMaxIdle: Int?) = apply { maxIdle = dbMaxIdle }
        fun setMaxOpenPreparedStatements(dbMaxOpenPss: Int?) = apply { maxOpenPreparedStatements = dbMaxOpenPss }
        fun build(): BasicDataSource = BasicDataSource(
            driverClassName ?: "",
            url ?: "",
            username ?: "",
            password ?: "",
            minIdle ?: 0,
            maxIdle ?: 0,
            maxOpenPreparedStatements ?: 0
        )

        fun print() {
            println(
                """
                | driverClassName = $driverClassName
                | url = $url
                | username = $username
                | password = $password
                | minIdle = $minIdle
                | maxIdle = $maxIdle
                | maxOpenPreparedStatements = $maxOpenPreparedStatements
            """.trimMargin()
            )
        }
    }
}
