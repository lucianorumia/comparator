package com.ticmas.desarrollo_aplicaciones_moviles.proyecto.comparator

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.ticmas.desarrollo_aplicaciones_moviles.proyecto.comparator.view.MainViewModel
import kotlinx.coroutines.test.*
import org.junit.Rule

@OptIn(kotlinx.coroutines.ExperimentalCoroutinesApi::class)

class UnitTest {
    private lateinit var viewModel: MainViewModel

    @get:Rule
    val instantTaskRule = InstantTaskExecutorRule()
    
    private val dispatcher = StandardTestDispatcher()

}