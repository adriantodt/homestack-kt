package net.adriantodt.homestack.dsl.traefik.rule

/**
 * Match Query String parameters. It accepts a sequence of key=value pairs.
 */
class Query(vararg parameters: Pair<String, String>) : TraefikRule() {
    private val toStringValue by lazy {
        parameters.joinToString(prefix = "ClientIP(`", separator = "`, `", postfix = "`)") { (k, v) -> "$k=$v" }
    }

    override fun toString() = toStringValue
}
