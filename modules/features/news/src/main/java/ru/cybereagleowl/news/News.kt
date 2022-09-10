package ru.cybereagleowl.news

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun NewsStub() {
    Column() {
        Text(text = "News composable")
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = "News 1")
        Text(text = "News 2")
        Text(text = "News 3")
    }
}

@Preview(showBackground = true)
@Composable
fun NewsStubPreview() {
    NewsStub()
}