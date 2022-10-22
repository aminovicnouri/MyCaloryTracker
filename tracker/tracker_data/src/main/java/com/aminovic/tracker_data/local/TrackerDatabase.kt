package com.aminovic.tracker_data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.aminovic.tracker_data.local.entity.TrackedFootEntity


@Database(
    entities = [TrackedFootEntity::class],
    version = 1
)
abstract class TrackerDatabase: RoomDatabase() {

    abstract val dao: TrackerDao
}
