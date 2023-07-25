package com.vtopacademy.schools.repository

import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

/** Injects school repository interface. */
@Module
@InstallIn(SingletonComponent::class)
abstract class SchoolRepositoryDI {

    /** Injects SchoolRepository implementation with given parameter.  */
    @Binds
    @Singleton
    abstract fun bindSchoolRepository(
        schoolRepositoryImpl: SchoolRepositoryImpl
    ): SchoolRepository

}