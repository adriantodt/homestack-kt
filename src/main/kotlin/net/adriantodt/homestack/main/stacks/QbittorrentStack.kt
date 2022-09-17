package net.adriantodt.homestack.main.stacks

import net.adriantodt.homestack.dsl.compose.externalNetwork
import net.adriantodt.homestack.dsl.compose.restartUnlessStopped
import net.adriantodt.homestack.dsl.compose.stack
import net.adriantodt.homestack.dsl.traefik.enable
import net.adriantodt.homestack.dsl.traefik.http
import net.adriantodt.homestack.dsl.traefik.http.middleware
import net.adriantodt.homestack.dsl.traefik.http.router
import net.adriantodt.homestack.dsl.traefik.http.service
import net.adriantodt.homestack.dsl.traefik.rule.Host
import net.adriantodt.homestack.dsl.traefik.traefikIntegration
import net.adriantodt.homestack.main.HomestackConfig

fun HomestackConfig.qbittorrentStack() {
    stack("qbittorrent") {
        service {
            val port = "8083"

            image = "lscr.io/linuxserver/qbittorrent"
            environment(
                "PUID" to puid,
                "PGID" to pgid,
                "TZ" to timezone,
                "WEBUI_PORT" to port
            )
            ports(
                "6881" to "6881",
                "6881" to "6881/udp",
                port to port
            )
            networks("default", "internal")
            volumes(
                "$stackRoot/services/qbittorrent/config" to "/config",
                "$stackRoot/files/Downloads" to "/downloads"
            )
            restartUnlessStopped()

            traefikIntegration {
                enable()
                http {
                    router {
                        rule = Host("flix.home.adriantodt.net")
                        middlewares = "jellyfin-middleware"
                    }
                    middleware.headers {
                        customRequestHeaders(
                            "X-Robots-Tag" to "noindex,nofollow,nosnippet,noarchive,notranslate,noimageindex"
                        )
                        frameDeny = true
                        contentTypeNosniff = true
                        browserXSSFilter = true
                    }
                    service.loadBalancer {
                        serverPort = "8096"
                        passHostHeader = true
                    }
                }
            }
        }
        externalNetwork(network = traefikNetwork)
    }
}
