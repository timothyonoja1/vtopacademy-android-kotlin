package com.vtopacademy.schools.localdatasource

import com.vtopacademy.schools.School
import javax.inject.Inject

/** Fake School local data source implementation class. Used for unit testing only. */
class FakeSchoolLocalDataSource @Inject constructor() : SchoolLocalDataSource {

    private val schools: MutableList<School> = mutableListOf()
    private var outdated: Boolean = true

    override fun isOutdated(): Boolean {
        return outdated
    }

    override fun getAllSchools(): MutableList<School> {
        return schools
    }

    override fun updateSchools(schools: MutableList<School>): Boolean {
        deleteAllSchools()
        this.schools.addAll(schools)
        outdated = false
        return true
    }

    override fun deleteAllSchools(): Boolean {
        schools.clear()
        outdated = true
        return true
    }
}