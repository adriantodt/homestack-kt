package net.adriantodt.homestack.dsl.traefik.rule

/**
 * Check if there is a key `key` defined in the headers, with a value that matches the regular expression `regexp`
 */
class HeadersRegexp(key: String, regexp: String) : TraefikRule() {
    private val toStringValue by lazy { "HeadersRegexp(`$key`, `$regexp`)" }

    override fun toString() = toStringValue
}
