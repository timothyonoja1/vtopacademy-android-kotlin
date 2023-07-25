package com.vtopacademy.schools

/** UI state for school list screen. */
data class SchoolListUiState(

    /** Checks whether schools are currently being fetched. */
    val isFetchingSchools: Boolean,

    /** Returns all schools. */
    val schools: MutableList<School> = mutableListOf()
)