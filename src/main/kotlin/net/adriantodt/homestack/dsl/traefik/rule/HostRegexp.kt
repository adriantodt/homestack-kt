package net.adriantodt.homestack.dsl.traefik.rule

/**
 * Match the request domain.
 */
class HostRegexp(vararg regexps: String) : TraefikRule() {
    private val toStringValue by lazy {
        regexps.joinToString(prefix = "HostRegexp(`", separator = "`, `", postfix = "`)")
    }

    override fun toString() = toStringValue
}
