package com.aminovic.core.domain.model

sealed class GoalType(val name: String) {
    object LoseWeight : GoalType("lose-weight")
    object KeepWeight : GoalType("keep-weight")
    object GainWeight : GoalType("gain-weight")

    companion object {
        fun fromString(name: String): GoalType {
            return when (name) {
                "lose-weight" -> LoseWeight
                "keep-weight" -> KeepWeight
                "gain-weight" -> GainWeight
                else -> KeepWeight
            }
        }
    }
}
