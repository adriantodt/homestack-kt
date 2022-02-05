package net.adriantodt.homestack.dsl.traefik.rule

/**
 * Check if there is a key `key` defined in the headers, with the value `value`
 */
class Headers(key: String, value: String) : TraefikRule() {
    private val toStringValue by lazy { "Headers(`$key`, `$value`)" }

    override fun toString() = toStringValue
}
