package com.aminovic.onboarding_domain.use_case

import com.aminovic.core.R
import com.aminovic.core.util.UiText

class ValidateNutrients {
    operator fun invoke(
        carbsRatioText: String,
        proteinsRatioText: String,
        fatsRatioText: String,
    ): Result {
        val carbsRatio = carbsRatioText.toIntOrNull()
        val proteinsRatio = proteinsRatioText.toIntOrNull()
        val fatsRatio = fatsRatioText.toIntOrNull()

        if (carbsRatio == null || proteinsRatio == null || fatsRatio == null) {
            return Result.Error(
                message = UiText.StringResource(R.string.error_invalid_values)
            )
        }
        if (carbsRatio + proteinsRatio + fatsRatio != 100) {
            return Result.Error(
                message = UiText.StringResource(R.string.error_not_100_percent)
            )
        }

        return Result.Success(
            carbsRatio = carbsRatio,
            proteinsRatio = proteinsRatio,
            fatRatio = fatsRatio
        )
    }

    sealed class Result {
        data class Success(
            val carbsRatio: Int,
            val proteinsRatio: Int,
            val fatRatio: Int,
        ) : Result()

        data class Error(val message: UiText) : Result()
    }
}
