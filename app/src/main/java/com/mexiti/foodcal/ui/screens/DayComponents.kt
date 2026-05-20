package com.mexiti.foodcal.ui.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.dimensionResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import coil3.compose.AsyncImage
import com.mexiti.foodcal.R
import com.mexiti.foodcal.model.DailyFood
import coil3.request.ImageRequest
import coil3.request.crossfade




@Composable
fun CardDayInfo(
    dayFood: DailyFood,
    modifier: Modifier = Modifier
){
    Card(
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp,

        ),
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp)
    ) {
        Column {
            DayTitle(day = dayFood.day, title = dayFood.title )
            Spacer(modifier = modifier.height(dimensionResource(id = R.dimen.space_component)))
            ShowImage(imageRes = dayFood.image)
            Spacer(modifier = modifier.height(dimensionResource(id = R.dimen.space_component)))
            BodyContent(body = dayFood.description)
        }

    }

}



@Composable
fun ShowImage(
    imageRes: String,
    modifier: Modifier = Modifier
){
    Box(modifier =
    modifier
        .width(dimensionResource(id = R.dimen.width_size))
        .height(dimensionResource(id = R.dimen.height_size))
        .padding(dimensionResource(id = R.dimen.padding_component))
        .border(BorderStroke(1.dp, MaterialTheme.colorScheme.onBackground)),
        contentAlignment = Alignment.Center
    ) {
        AsyncImage(
            model = ImageRequest.Builder(LocalContext.current)
                .data(imageRes)
                .crossfade(true)
                .build(),
            contentDescription = "Receta",
            contentScale = ContentScale.Crop,
            modifier = Modifier.fillMaxSize()
        )

    }
}



@Composable
fun DayTitle(
    day: Int,
    title: String,
    modifier: Modifier = Modifier
){
    Column(
        modifier
            .width(dimensionResource(id = R.dimen.width_size))
            .padding(dimensionResource(id = R.dimen.padding_component))
    ) {
        Text(
            text = day.toString(),
            style = MaterialTheme.typography.titleLarge
        )
        Spacer(modifier = Modifier.height(10.dp))
        Text(
            text = title,
            style = MaterialTheme.typography.headlineSmall,
        )
    }
}

@Composable
fun BodyContent(
    body: String,
    modifier: Modifier = Modifier
){
    Text(
        text = body,
        style = MaterialTheme.typography.bodyLarge,
        modifier = modifier
            .width(dimensionResource(id = R.dimen.width_size))
            .padding(
                dimensionResource(id = R.dimen.padding_component)
            )
    )

}

