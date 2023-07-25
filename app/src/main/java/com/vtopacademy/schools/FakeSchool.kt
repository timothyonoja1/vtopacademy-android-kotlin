package com.vtopacademy.schools

import java.util.Date

class FakeSchool {

    fun getFakeSchools(): MutableList<School> {
        val schools: MutableList<School> = mutableListOf()
        schools.add(School(1, 1, "Senior Secondary", Date()))
        return schools
    }

}