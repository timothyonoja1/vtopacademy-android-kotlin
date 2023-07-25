package com.vtopacademy.schools.localdatasource

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/** Injects school local data source. */
@Module
@InstallIn(SingletonComponent::class)
abstract class SchoolLocalDataSourceDI {

    /** Injects SchoolLocalDataSource implementation with given parameter.  */
    @Binds
    @Singleton
    abstract fun bindSchoolLocalDataSource(
        schoolLocalDataSourceImpl: FakeSchoolLocalDataSource
    ): SchoolLocalDataSource

}