package com.vtopacademy.schools.repository

import com.vtopacademy.schools.FakeSchool
import com.vtopacademy.schools.School
import javax.inject.Inject

/** Fake School repository implementation class. Used for unit testing only. */
class FakeSchoolRepository @Inject constructor() : SchoolRepository {

    override fun getAllSchools(): MutableList<School> {
        val fakeSchool = FakeSchool()
        return fakeSchool.getFakeSchools()

    }
}