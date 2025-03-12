package com.ramiro.chucknorriscompose.presentation

import android.util.Log
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.ramiro.chucknorriscompose.domain.UiStates
import com.ramiro.chucknorriscompose.presentation.viewmodel.JokeViewModel

@Composable
fun JokeScreen(
    modifier: Modifier,
    viewModel: JokeViewModel
){
    val state = viewModel.jokeState.collectAsState().value

    Column(modifier = modifier, verticalArrangement = Arrangement.SpaceBetween) {
        Spacer(modifier = Modifier.height(16.dp))
        Button(onClick = { viewModel.getRandomJoke() }, modifier = Modifier.fillMaxWidth()) { Text(text = "Another Joke") }
        when(state){
            is UiStates.LOADING ->{
                Column { CircularProgressIndicator() }
            }
            is UiStates.SUCCESS -> {
                val joke = state.response

                Card() {
                    Row {
                        AsyncImage(
                            model = joke.iconUrl,
                            contentDescription = "Chuck norris icon",
                            modifier = Modifier.height(75.dp)
                        )
                        Text(text = joke.value.toString())
                    }

                }

            }
            is UiStates.ERROR ->{
                Log.d("JokeScree", "Error: ${state.error}")
            }
        }
    }

}