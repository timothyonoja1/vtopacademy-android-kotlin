package com.vtopacademy.schools

import java.util.*

/** School entity class. */
data class School(

    /** Returns schoolID. */
    val schoolID: Int,

    /** Returns school number. */
    val number: Int,

    /** Returns school name. */
    val name: String,

    /** Returns dateSavedToLocalDatabase. */
    var dateSavedToLocalDatabase: Date?

)