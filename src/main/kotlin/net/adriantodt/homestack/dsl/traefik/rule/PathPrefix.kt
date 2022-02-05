package net.adriantodt.homestack.dsl.traefik.rule

/**
 * Match request prefix path.
 */
class PathPrefix(vararg regexps: String) : TraefikRule() {
    private val toStringValue by lazy {
        regexps.joinToString(prefix = "PathPrefix(`", separator = "`, `", postfix = "`)")
    }

    override fun toString() = toStringValue
}
