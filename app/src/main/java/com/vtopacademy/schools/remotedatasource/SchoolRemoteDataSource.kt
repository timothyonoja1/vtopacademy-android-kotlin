package com.vtopacademy.schools.remotedatasource
import com.vtopacademy.schools.School

/** School remote data source interface.  */
interface SchoolRemoteDataSource {

    /** Returns all schools.  */
    fun getAllSchools(): MutableList<School>

}