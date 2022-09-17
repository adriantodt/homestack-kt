package net.adriantodt.homestack.dsl.traefik.http

import net.adriantodt.homestack.dsl.traefik.CompositionServiceAccess
import net.adriantodt.homestack.dsl.traefik.Named

class TraefikHttpHeadersMiddleware(
    val parent: TraefikHttpMiddleware
) : Named by parent, CompositionServiceAccess by parent {
    fun customRequestHeaders(vararg values: Pair<String, String>) {
        composeService.label(
            *values.map { (k, v) -> "traefik.http.middlewares.$name.headers.customrequestheaders.$k" to v }
                .toTypedArray()
        )
    }

    var frameDeny: Boolean? = null
        set(value) {
            field = value?.also {
                composeService.label("traefik.http.middlewares.$name.headers.frameDeny" to value.toString())
            }
        }

    var contentTypeNosniff: Boolean? = null
        set(value) {
            field = value?.also {
                composeService.label("traefik.http.middlewares.$name.headers.contentTypeNosniff" to value.toString())
            }
        }

    var browserXSSFilter: Boolean? = null
        set(value) {
            field = value?.also {
                composeService.label("traefik.http.middlewares.$name.headers.browserXSSFilter" to value.toString())
            }
        }
}
