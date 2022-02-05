package net.adriantodt.homestack.dsl.traefik.rule

/**
 * Match exact request path.
 */
class Path(vararg regexps: String) : TraefikRule() {
    private val toStringValue by lazy {
        regexps.joinToString(prefix = "Path(`", separator = "`, `", postfix = "`)")
    }

    override fun toString() = toStringValue
}
