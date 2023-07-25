package com.vtopacademy.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.vtopacademy.schools.School
import com.vtopacademy.schools.SchoolListUiState
import com.vtopacademy.schools.repository.SchoolRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import java.util.Date
import javax.inject.Inject

/** MainViewModel implementation class. */
@HiltViewModel
class MainViewModelImpl @Inject constructor(
    private val schoolRepository: SchoolRepository
) : ViewModel(), MainViewModel{

    private var selectedSchool: School
    private var schoolListUiState: MutableLiveData<SchoolListUiState> = MutableLiveData()

    override fun getSchoolListUiState(): MutableLiveData<SchoolListUiState> {
        schoolListUiState.value = SchoolListUiState(true, mutableListOf())
        viewModelScope.launch(Dispatchers.IO) {
            val schools = schoolRepository.getAllSchools()
            schoolListUiState.postValue(SchoolListUiState(false, schools))
        }
        return schoolListUiState
    }

    override fun setSelectedSchool(school: School) {
        selectedSchool = school
    }

    init {
        selectedSchool = School(0, 0, "", Date())
    }
}