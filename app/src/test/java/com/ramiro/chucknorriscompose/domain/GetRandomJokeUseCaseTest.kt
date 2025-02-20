package com.ramiro.chucknorriscompose.domain

import com.ramiro.chucknorriscompose.data.repository.JokeRepository
import io.mockk.clearAllMocks
import io.mockk.coEvery
import io.mockk.every
import io.mockk.mockk
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.toList
import kotlinx.coroutines.test.UnconfinedTestDispatcher
import kotlinx.coroutines.test.runTest
import org.junit.Assert.*

import org.junit.After
import org.junit.Before
import org.junit.Test

class GetRandomJokeUseCaseTest {

    private val mockRepository = mockk<JokeRepository>()
    private lateinit var testObject: GetRandomJokeUseCase
    @OptIn(ExperimentalCoroutinesApi::class)
    private val mockDispatcher = UnconfinedTestDispatcher()


    @Before
    fun setUp() {
        testObject = GetRandomJokeUseCase(mockRepository)
    }

    @After
    fun tearDown() {
        clearAllMocks()
    }

    @Test
    fun `response is successful but body is null`() = runTest(mockDispatcher){
        //assert
        coEvery { mockRepository.getRandomJoke() } returns mockk{
            every { isSuccessful } returns true
            every { body() } returns null
        }
        //action
        val result = testObject.getRandomJoke().toList()
        //verification
        assertEquals(result.size, 2)
        assertTrue(result[0] is UiStates.LOADING)
        assertTrue(result[1] is UiStates.ERROR)
        assertEquals("List is empty!", (result[1] as UiStates.ERROR).error.localizedMessage)
    }
}