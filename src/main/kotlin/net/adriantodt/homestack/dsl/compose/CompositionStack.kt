package net.adriantodt.homestack.dsl.compose

class CompositionStack(val name: String) {

    private val services = mutableListOf<CompositionService>()
    private val networks = mutableListOf<CompositionNetwork>()

    @ComposeDsl
    fun service(name: String = this.name, block: CompositionService.() -> Unit): CompositionService {
        val service = CompositionService(this, name).apply(block)
        services += service
        return service
    }

    @ComposeDsl
    fun network(name: String, block: CompositionNetwork.() -> Unit): CompositionNetwork {
        val network = CompositionNetwork(this, name).apply(block)
        networks += network
        return network
    }

    override fun toString() = buildString {
        appendLine("version: '3.9'")

        if (services.isNotEmpty()) {
            appendLine()
            appendLine("services:")
            for (service in services) {
                for (line in service.toString().trim().lines()) {
                    appendLine("  $line")
                }
            }
        }

        if (networks.isNotEmpty()) {
            appendLine()
            appendLine("networks:")
            for (network in networks) {
                for (line in network.toString().trim().lines()) {
                    appendLine("  $line")
                }
            }
        }
    }
}
