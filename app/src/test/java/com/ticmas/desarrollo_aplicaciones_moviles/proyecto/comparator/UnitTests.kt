package com.ticmas.desarrollo_aplicaciones_moviles.proyecto.comparator

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.ticmas.desarrollo_aplicaciones_moviles.proyecto.comparator.view.MainViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.coroutines.test.*
import org.junit.Rule
import org.junit.Before
import org.junit.After
import org.junit.Test
import org.junit.Assert.*

@OptIn(kotlinx.coroutines.ExperimentalCoroutinesApi::class)

class UnitTests {
    private lateinit var viewModel: MainViewModel

    @get:Rule
    val instantTaskRule = InstantTaskExecutorRule()
    private val dispatcher = StandardTestDispatcher()

    @Before
    fun setup() {
        Dispatchers.setMain(dispatcher)
        viewModel = MainViewModel()
    }

    @After
    fun tearDown() {
        Dispatchers.resetMain()
    }

    @Test
    fun checkInitialState() = runTest {
        val state = viewModel.match.value?.state
        assertEquals(false, state)
    }

    @Test
    fun testComparison() = runTest {
        launch {
            viewModel.compareInputs("Ticmas", "Ticmas")
        }

        advanceUntilIdle()

        val matchState = viewModel.match.value?.state

        launch {
            viewModel.compareInputs("Ticmas", "tIcmás")
        }

        advanceUntilIdle()

        val noMatchState = viewModel.match.value?.state

        assertArrayEquals(arrayOf(matchState, noMatchState), arrayOf(true, false))
    }
}