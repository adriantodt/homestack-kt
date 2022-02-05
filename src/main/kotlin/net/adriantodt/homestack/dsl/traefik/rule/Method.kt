package net.adriantodt.homestack.dsl.traefik.rule

/**
 * Check if the request method is one of the given `methods` (`GET`, `POST`, `PUT`, `DELETE`, `PATCH`, `HEAD`)
 */
class Method(vararg methods: String) : TraefikRule() {
    private val toStringValue by lazy {
        methods.joinToString(prefix = "Method(`", separator = "`, `", postfix = "`)")
    }

    override fun toString() = toStringValue
}

