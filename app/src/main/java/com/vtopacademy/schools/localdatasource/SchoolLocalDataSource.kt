package com.vtopacademy.schools.localdatasource

import com.vtopacademy.schools.School

/** School local data source interface. */
interface SchoolLocalDataSource {

    /** Checks whether school local data source is up-to-date.  */
    fun isOutdated(): Boolean

    /** Returns all schools.  */
    fun getAllSchools(): MutableList<School>

    /** Returns true after saving successfully.  */
    fun updateSchools(schools: MutableList<School>): Boolean

    /** Returns true after deleting successfully.  */
    fun deleteAllSchools(): Boolean
}