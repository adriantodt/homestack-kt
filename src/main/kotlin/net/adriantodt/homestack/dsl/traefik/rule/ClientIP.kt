package net.adriantodt.homestack.dsl.traefik.rule

/**
 * Match if the request client IP is one of the given IP/CIDR. It accepts IPv4, IPv6 and CIDR formats.
 */
class ClientIP(vararg values: String) : TraefikRule() {
    private val toStringValue by lazy {
        values.joinToString(prefix = "ClientIP(`", separator = "`, `", postfix = "`)")
    }

    override fun toString() = toStringValue
}
