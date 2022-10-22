package com.aminovic.tracker_data.local

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.aminovic.tracker_data.local.entity.TrackedFootEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface TrackerDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertTrackedFood(trackedFootEntity: TrackedFootEntity)

    @Delete
    suspend fun deleteTrackedFood(trackedFootEntity: TrackedFootEntity)

    @Query(
        """
            SELECT *
            FROM trackedfootentity
            WHERE dayOfMonth = :day AND month = :month AND year = :year
        """
    )
    fun getFoodsForDate(day: Int, month: Int, year: Int): Flow<List<TrackedFootEntity>>
}
