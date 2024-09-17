@file:OptIn(ExperimentalMaterial3Api::class)

package com.mustk.movieappcompose.presentation.movie_list.views

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.focus.onFocusChanged
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.mustk.movieappcompose.presentation.Screen
import com.mustk.movieappcompose.presentation.movie_list.MovieListViewModel
import com.mustk.movieappcompose.presentation.movie_list.MoviesEvent
import com.mustk.movieappcompose.util.Constant.DEFAULT_SEARCH

@Composable
fun MovieListScreen(
    navController: NavController,
    viewModel: MovieListViewModel = hiltViewModel()
) {
    val state = viewModel.state.value
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Black)
    ) {
        Column {
            SearchBar(modifier = Modifier
                .fillMaxWidth()
                .padding(20.dp),
                hint = DEFAULT_SEARCH,
                onSearch = {
                    viewModel.onEvent(MoviesEvent.Search(it))
                }
            )
            LazyColumn(modifier = Modifier.fillMaxSize()) {
                items(state.movies) { movie ->
                    MovieListRow(movie = movie) {
                        navController.navigate(Screen.MovieDetailScreen.route + "/${movie.imdbID}")
                    }
                }
            }
        }
    }
}

@Composable
fun SearchBar(
    modifier: Modifier,
    hint: String = "",
    onSearch: (String) -> Unit = {}
) {
    var queryText by remember { mutableStateOf("") }
    var isHintDisplayed by remember { mutableStateOf(hint != "") }
    Box(modifier = modifier) {
        TextField(
            value = queryText,
            onValueChange = {
                queryText = it
            },
            keyboardActions = KeyboardActions(onDone = {
                onSearch(queryText)
            }),
            maxLines = 1,
            singleLine = true,
            textStyle = TextStyle(color = Color.Black),
            shape = RoundedCornerShape((12.dp)),
            colors = TextFieldDefaults.textFieldColors(
                containerColor = Color.White
            ),
            modifier = Modifier
                .fillMaxWidth()
                .shadow(5.dp, CircleShape)
                .background(Color.White, CircleShape)
                .padding(horizontal = 20.dp)
                .onFocusChanged {
                    isHintDisplayed = it.isFocused != true && queryText.isNotBlank()
                }
        )
        if (isHintDisplayed) {
            Text(
                text = hint,
                color = Color.LightGray,
                modifier = Modifier
                    .padding(horizontal = 20.dp, vertical = 12.dp)
            )
        }
    }
}