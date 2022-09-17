package net.adriantodt.homestack.dsl.compose

class CompositionService(private val parent: CompositionStack, val name: String) {

    var image: String? = null
    var restart: RestartBehavior? = null
    var command: String? = null
        set(value) {
            if (value != null) {
                commandParts.clear()
            }
            field = value
        }
    private val volumes = mutableListOf<String>()
    private val environment = mutableListOf<String>()
    private val ports = mutableListOf<String>()
    private val labels = mutableListOf<String>()
    private val networks = mutableListOf<String>()
    private val commandParts = mutableListOf<String>()

    fun volumes(vararg values: Pair<String, String>) {
        this.volumes += values.map { (from, to) -> "$from:$to" }
    }

    fun environment(vararg values: Pair<String, String>) {
        this.environment += values.map { (from, to) -> "$from=$to" }
    }

    fun ports(vararg values: Pair<String, String>) {
        this.ports += values.map { (from, to) -> "$from:$to" }
    }

    fun label(vararg values: Pair<String, String>) {
        this.labels += values.map { (k, v) -> "$k=$v" }
    }

    fun networks(vararg values: String) {
        this.networks += values
    }

    fun command(vararg values: String) {
        this.command = null
        this.commandParts += values
    }


    override fun toString() = buildString {
        appendLine("$name:")
        image?.let {
            appendLine("  image: $it")
        }
        if (commandParts.isNotEmpty()) {
            appendLine("  command:")
            for (commandPart in commandParts) {
                appendLine("    - \"${commandPart.replace("\"", "\\\"")}\"")
            }
        } else command?.let {
            appendLine("  command: $it")
        }
        if (volumes.isNotEmpty()) {
            appendLine("  volumes:")
            for (volume in volumes) {
                appendLine("    - \"${volume.replace("\"", "\\\"")}\"")
            }
        }
        if (environment.isNotEmpty()) {
            appendLine("  environment:")
            for (value in environment) {
                appendLine("    - \"${value.replace("\"", "\\\"")}\"")
            }
        }
        if (networks.isNotEmpty()) {
            appendLine("  networks:")
            for (network in networks) {
                appendLine("    - \"${network.replace("\"", "\\\"")}\"")
            }
        }
        if (ports.isNotEmpty()) {
            appendLine("  ports:")
            for (port in ports) {
                appendLine("    - \"${port.replace("\"", "\\\"")}\"")
            }
        }
        if (labels.isNotEmpty()) {
            appendLine("  labels:")
            for (label in labels) {
                appendLine("    - \"${label.replace("\"", "\\\"")}\"")
            }
        }
        restart?.let {
            appendLine("  restart: ${it.name.lowercase().replace('_', '-')}")
        }
    }
}
