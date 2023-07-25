package com.vtopacademy.schools.repository

import com.vtopacademy.schools.School
import com.vtopacademy.schools.localdatasource.SchoolLocalDataSource
import com.vtopacademy.schools.remotedatasource.SchoolRemoteDataSource
import javax.inject.Inject

/** SchoolRepository Implementation class. */
class SchoolRepositoryImpl @Inject constructor(
    private val schoolLocalDataSource: SchoolLocalDataSource,
    private val schoolRemoteDataSource: SchoolRemoteDataSource
) : SchoolRepository {

    override fun getAllSchools(): MutableList<School> {
        if (schoolLocalDataSource.isOutdated()) {
            refreshSchools()
        }
        return schoolLocalDataSource.getAllSchools()
    }

    private fun refreshSchools() {
        val results = schoolRemoteDataSource.getAllSchools()
        if (results.isNotEmpty()) {
            schoolLocalDataSource.updateSchools(results);
        }
    }
}