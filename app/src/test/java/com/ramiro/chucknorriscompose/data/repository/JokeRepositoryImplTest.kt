package com.ramiro.chucknorriscompose.data.repository

import com.ramiro.chucknorriscompose.data.api.ServiceCall
import com.ramiro.chucknorriscompose.data.model.Jokemodel
import io.mockk.coEvery
import io.mockk.mockk
import io.mockk.unmockkAll
import kotlinx.coroutines.test.runTest
import org.junit.Assert.*

import org.junit.After
import org.junit.Before
import org.junit.Test
import retrofit2.Response

class JokeRepositoryImplTest {

  private lateinit var service:ServiceCall
  private lateinit var repo:JokeRepository

@Before
 fun setUp() {
 service = mockk()
 repo = JokeRepositoryImpl(service)

 }

@After
 fun tearDown() {
 unmockkAll()

 }

  @Test
  fun `JokeRepo returns getRandomJoke Response`() = runTest {

   val testResponse: Response<Jokemodel> = mockk()

   coEvery { service.getRandomJoke() } returns testResponse

   val jokeRepoResult = repo.getRandomJoke()

   assertEquals(jokeRepoResult, testResponse)

  }
}