package com.example.hiltpractice

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Qualifier

@InstallIn(SingletonComponent::class)
@Module
object HiltModules {

    @Provides
    fun provideEngine(piston: Piston): Engine {
        return Engine(piston)
    }

    @Provides
    fun provideCar(engine: Engine, @Four number: Int): Car {
        return Car(engine, number)
    }

    @Provides
    fun providePiston(numberOfPiston: NumberOfPiston): Piston {
        return Piston(numberOfPiston)
    }

    @Provides
    fun provideNumberofPiston(): NumberOfPiston {
        return NumberofPistonImpl()

    }

    @Provides
    @Four
    fun providesFourInt(): Int {
        return 4
    }

    @Provides
    @Six
    fun providesSixInt(): Int {
        return 6
    }
}

@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class Four


@Qualifier
@Retention(AnnotationRetention.BINARY)
annotation class Six


