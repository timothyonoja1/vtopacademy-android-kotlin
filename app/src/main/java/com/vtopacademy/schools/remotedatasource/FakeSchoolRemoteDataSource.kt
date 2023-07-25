package com.vtopacademy.schools.remotedatasource

import com.vtopacademy.schools.FakeSchool
import com.vtopacademy.schools.School
import javax.inject.Inject

/** Fake Category remote data source implementation class. Used for unit testing only. */
class FakeSchoolRemoteDataSource @Inject constructor() : SchoolRemoteDataSource {

    override fun getAllSchools(): MutableList<School> {
        val fakeSchool = FakeSchool()
        return fakeSchool.getFakeSchools()
    }
}