package com.vtopacademy.schools.remotedatasource
import com.vtopacademy.retrofit.ApiService
import com.vtopacademy.schools.School
import com.vtopacademy.schools.SchoolResponse
import java.util.Date
import javax.inject.Inject

/** SchoolRemoteDataSource Implementation class.  */
class SchoolRemoteDataSourceImpl @Inject constructor(
    private val apiService: ApiService
) : SchoolRemoteDataSource {

    override fun getAllSchools(): MutableList<School> {
        val apiCall = apiService.allSchools
        return try {
            val schoolResponses = apiCall.execute().body()!!
            convertToSchools(schoolResponses)
        } catch (exception: Exception){
            exception.printStackTrace()
            return mutableListOf()
        }
    }

    private fun convertToSchools(
        schoolResponses: MutableList<SchoolResponse>
    ): MutableList<School> {
        val schools: MutableList<School> = mutableListOf()
        val dateSavedToLocalDataSource = Date()
        for ((schoolID, number, name) in schoolResponses) {
            schools.add(School(schoolID, number, name, dateSavedToLocalDataSource))
        }
        return schools;
    }

}