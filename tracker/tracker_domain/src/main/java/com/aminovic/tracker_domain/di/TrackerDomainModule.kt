package com.aminovic.tracker_domain.di

import com.aminovic.core.domain.preferences.Preferences
import com.aminovic.tracker_domain.repository.TrackerRepository
import com.aminovic.tracker_domain.use_case.*
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ViewModelComponent
import dagger.hilt.android.scopes.ViewModelScoped


@Module
@InstallIn(ViewModelComponent::class)
class TrackerDomainModule {

    @ViewModelScoped
    @Provides
    fun provideTrackerUseCases(
        repository: TrackerRepository,
        preferences: Preferences
    ): TrackerUseCases {
        return TrackerUseCases(
            trackFood = TrackFood(repository = repository),
            searchFood = SearchFood(repository = repository),
            deleteTrackedFood = DeleteTrackedFood(repository = repository),
            getFoodsForDate = GetFoodsForDate(repository = repository),
            calculateMealNutrients = CalculateMealNutrients(preferences = preferences)
        )
    }
}
