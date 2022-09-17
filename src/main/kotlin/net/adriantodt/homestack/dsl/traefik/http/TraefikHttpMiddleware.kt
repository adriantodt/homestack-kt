package net.adriantodt.homestack.dsl.traefik.http

import net.adriantodt.homestack.dsl.traefik.tcp.TraefikTcpMiddleware

open class TraefikHttpMiddleware(parent: TraefikHttp, name: String) : TraefikTcpMiddleware(parent, name) {
    override val protocol: String = "http"

    val headers: TraefikHttpHeadersMiddleware
        get() = TraefikHttpHeadersMiddleware(this)

    fun headers(block: TraefikHttpHeadersMiddleware.() -> Unit): TraefikHttpHeadersMiddleware {
        return headers.also(block)
    }
}
