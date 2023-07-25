package com.vtopacademy.viewmodel

import androidx.lifecycle.MutableLiveData
import com.vtopacademy.schools.School
import com.vtopacademy.schools.SchoolListUiState

/** State holder interface for the UI screens. */
interface MainViewModel {

    /** Returns SchoolListUiState. */
    fun getSchoolListUiState(): MutableLiveData<SchoolListUiState>

    /** Sets selected school. */
    fun setSelectedSchool(school: School)

}