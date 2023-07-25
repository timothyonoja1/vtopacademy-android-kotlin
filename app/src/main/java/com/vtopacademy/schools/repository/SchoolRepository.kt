package com.vtopacademy.schools.repository

import com.vtopacademy.schools.School

/** Repository interface for categories. */
interface SchoolRepository {

    /** Returns all schools.  */
    fun getAllSchools(): MutableList<School>

}