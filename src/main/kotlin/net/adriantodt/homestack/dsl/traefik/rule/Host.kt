package net.adriantodt.homestack.dsl.traefik.rule

/**
 * Check if the request domain (host header value) targets one of the given `domains`.
 */
class Host(vararg domains: String) : TraefikRule() {
    private val toStringValue by lazy {
        domains.joinToString(prefix = "Host(`", separator = "`, `", postfix = "`)")
    }

    override fun toString() = toStringValue
}
