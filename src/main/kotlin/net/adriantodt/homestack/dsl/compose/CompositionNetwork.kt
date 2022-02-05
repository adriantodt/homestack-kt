package net.adriantodt.homestack.dsl.compose

class CompositionNetwork(private val parent: CompositionStack, private val name: String) {
    var dockerName: String? = null
    var external: Boolean = false

    override fun toString() = buildString {
        appendLine("$name:")
        if (external) {
            appendLine("  external: true")
        }
        dockerName?.let {
            appendLine("  name: \"${it.replace("\"", "\\\"")}\"")
        }
    }
}
