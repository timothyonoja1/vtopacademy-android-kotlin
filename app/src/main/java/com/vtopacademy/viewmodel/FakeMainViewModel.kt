package com.vtopacademy.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.vtopacademy.schools.FakeSchool
import com.vtopacademy.schools.School
import com.vtopacademy.schools.SchoolListUiState
import dagger.hilt.android.lifecycle.HiltViewModel
import java.util.Date
import javax.inject.Inject

/** Fake MainViewModel implementation class. Used for testing purposes only. */
@HiltViewModel
class FakeMainViewModel @Inject constructor() : ViewModel(), MainViewModel {

    private var selectedSchool: School

    override fun getSchoolListUiState(): MutableLiveData<SchoolListUiState> {
        val schoolListUiState: MutableLiveData<SchoolListUiState> by lazy {
            MutableLiveData<SchoolListUiState>()
        }
        val fakeSchool = FakeSchool()
        schoolListUiState.value = SchoolListUiState(
            false, fakeSchool.getFakeSchools())
        return schoolListUiState
    }

    override fun setSelectedSchool(school: School) {
        selectedSchool = school
    }

    init {
        selectedSchool = School(0, 0, "", Date())
    }
}