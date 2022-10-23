package com.aminovic.tracker_domain.use_case

import com.aminovic.tracker_domain.model.TrackedFood
import com.aminovic.tracker_domain.repository.TrackerRepository


class DeleteTrackedFood(
    private val repository: TrackerRepository
) {
    suspend operator fun invoke(
        trackedFood: TrackedFood
    ) {
        return repository.deleteTrackedFood(trackedFood)
    }
}
