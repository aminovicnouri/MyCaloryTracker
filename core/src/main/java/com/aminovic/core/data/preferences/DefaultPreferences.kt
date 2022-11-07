package com.aminovic.core.data.preferences

import android.content.SharedPreferences
import com.aminovic.core.domain.model.ActivityLevel
import com.aminovic.core.domain.model.Gender
import com.aminovic.core.domain.model.GoalType
import com.aminovic.core.domain.model.UserInfo
import com.aminovic.core.domain.preferences.Preferences
import com.aminovic.core.domain.preferences.Preferences.Companion.KEY_SHOULD_SHOW_ONBOARDING


class DefaultPreferences(
    private val sharedPref: SharedPreferences
) : Preferences {

    override fun saveGender(gender: Gender) {
        sharedPref.edit()
            .putString(Preferences.KEY_GENDER, gender.name)
            .apply()
    }

    override fun saveAge(age: Int) {
        sharedPref.edit()
            .putInt(Preferences.KEY_AGE, age)
            .apply()
    }

    override fun saveWeight(weight: Float) {
        sharedPref.edit()
            .putFloat(Preferences.KEY_WEIGHT, weight)
            .apply()
    }

    override fun saveHeight(height: Int) {
        sharedPref.edit()
            .putInt(Preferences.KEY_HEIGHT, height)
            .apply()
    }

    override fun saveActivityLevel(activityLevel: ActivityLevel) {
        sharedPref.edit()
            .putString(Preferences.KEY_ACTIVITY_LEVEL, activityLevel.name)
            .apply()
    }

    override fun saveGoalType(goalType: GoalType) {
        sharedPref.edit()
            .putString(Preferences.KEY_GOAL_TYPE, goalType.name)
            .apply()
    }

    override fun saveCarbRatio(ratio: Int) {
        sharedPref.edit()
            .putFloat(Preferences.KEY_CARB_RATIO, ratio.toFloat())
            .apply()
    }

    override fun saveProteinRatio(ratio: Int) {
        sharedPref.edit()
            .putFloat(Preferences.KEY_PROTEIN_RATIO, ratio.toFloat())
            .apply()
    }

    override fun saveFatRatio(ratio: Int) {
        sharedPref.edit()
            .putFloat(Preferences.KEY_FAT_RATIO, ratio.toFloat())
            .apply()
    }

    override fun loadUserInfo(): UserInfo {
        val age = sharedPref.getInt(Preferences.KEY_AGE, -1)
        val height = sharedPref.getInt(Preferences.KEY_HEIGHT, -1)
        val weight = sharedPref.getFloat(Preferences.KEY_WEIGHT, -1f)
        val genderString = sharedPref.getString(Preferences.KEY_GENDER, null)
        val activityLevelString = sharedPref.getString(Preferences.KEY_ACTIVITY_LEVEL, null)
        val goalTypeString = sharedPref.getString(Preferences.KEY_GOAL_TYPE, null)
        val carbRatio = sharedPref.getFloat(Preferences.KEY_CARB_RATIO, -1f)
        val proteinRatio = sharedPref.getFloat(Preferences.KEY_PROTEIN_RATIO, -1f)
        val fatRatio = sharedPref.getFloat(Preferences.KEY_FAT_RATIO, -1f)

        return UserInfo(
            gender = Gender.fromString(genderString ?: "male"),
            age = age,
            height = height,
            weight = weight,
            activityLevel = ActivityLevel.fromString(activityLevelString ?: "medium"),
            goalType = GoalType.fromString(goalTypeString ?: "keep_weight"),
            carbRatio = carbRatio,
            proteinRatio = proteinRatio,
            fatRatio = fatRatio
        )
    }

    override fun saveShouldShowOnboarding(shouldShow: Boolean) {
        sharedPref.edit().putBoolean(KEY_SHOULD_SHOW_ONBOARDING, shouldShow).apply()
    }

    override fun loadShouldShowOnboarding(): Boolean {
        return sharedPref.getBoolean(KEY_SHOULD_SHOW_ONBOARDING, true)
    }
}
