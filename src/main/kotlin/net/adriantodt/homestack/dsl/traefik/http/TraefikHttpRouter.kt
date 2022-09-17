package net.adriantodt.homestack.dsl.traefik.http

import net.adriantodt.homestack.dsl.traefik.tcp.TraefikTcpRouter
import net.adriantodt.homestack.dsl.traefik.rule.TraefikRule

open class TraefikHttpRouter(parent: TraefikHttp, name: String): TraefikTcpRouter(parent, name) {
    override val protocol: String = "http"


    var rule: TraefikRule? = null
        set(value) {
            if (value != null) {
                composeService.label("traefik.$protocol.routers.$name.rule" to value.toString())
            }
            field = value
        }
}
