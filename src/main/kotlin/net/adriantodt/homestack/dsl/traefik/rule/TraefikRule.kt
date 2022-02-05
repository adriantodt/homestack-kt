package net.adriantodt.homestack.dsl.traefik.rule

abstract class TraefikRule {
    open val not: TraefikRule by lazy { Not(this) }

    open infix fun or(other: TraefikRule): AnyOf {
        return AnyOf(listOf(this, other))
    }

    open infix fun and(other: TraefikRule): AllOf {
        return AllOf(listOf(this, other))
    }

    class Not(val rule: TraefikRule) : TraefikRule() {
        override val not: TraefikRule get() = rule

        override fun toString(): String {
            if (rule is Not) {
                return rule.rule.toString()
            } else if (rule is AllOf || rule is AnyOf) {
                return "!($rule)"
            }
            return "!$rule"
        }
    }

    class AllOf(val rules: List<TraefikRule>) : TraefikRule() {
        init {
            if (rules.isEmpty()) {
                throw IllegalArgumentException("Rules must not be empty.")
            }
        }

        override infix fun and(other: TraefikRule): AllOf {
            return AllOf(rules + other)
        }

        override fun toString(): String {
            if (rules.size == 1) {
                return rules.single().toString()
            }

            return rules.joinToString(" && ") {
                if (it is AnyOf) "($it)" else it.toString()
            }
        }
    }

    class AnyOf(val rules: List<TraefikRule>) : TraefikRule() {
        init {
            if (rules.isEmpty()) {
                throw IllegalArgumentException("Rules must not be empty.")
            }
        }

        override infix fun or(other: TraefikRule): AnyOf {
            return AnyOf(rules + other)
        }

        override fun toString(): String {
            if (rules.size == 1) {
                return rules.single().toString()
            }

            return rules.joinToString(" && ") {
                if (it is AllOf) "($it)" else it.toString()
            }
        }
    }
}
