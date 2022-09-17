package net.adriantodt.homestack.dsl.docker

class DockerNetwork(
    val name: String,
    private val attachable: Boolean = false,
    private val internal: Boolean = false
) {
    override fun toString() = buildString {
        append("docker network create ")
        if (attachable) {
            append("--attachable ")
        }
        if (internal) {
            append("--internal ")
        }
        append(name)
    }
}
