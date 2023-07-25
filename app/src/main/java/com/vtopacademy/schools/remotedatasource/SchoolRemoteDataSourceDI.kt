package com.vtopacademy.schools.remotedatasource

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/** Injects school remote data source interface. */
@Module
@InstallIn(SingletonComponent::class)
abstract class SchoolRemoteDataSourceDI {

    /** Injects SchoolRemoteDataSource implementation with given parameter.  */
    @Binds
    @Singleton
    abstract fun bindCategoryRemoteDataSource(
        schoolRemoteDataSourceImpl: FakeSchoolRemoteDataSource
    ): SchoolRemoteDataSource

}