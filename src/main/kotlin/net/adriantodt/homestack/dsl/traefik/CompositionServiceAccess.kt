package net.adriantodt.homestack.dsl.traefik

import net.adriantodt.homestack.dsl.compose.CompositionService

interface CompositionServiceAccess {
    val composeService: CompositionService
}
