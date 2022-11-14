package ru.cybereagleowl.authorization.presentation.view

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.material.Text
import androidx.compose.ui.Modifier
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

@Composable
fun AuthorizationStub(string1: String) {
    Column() {
        Text(text = "Authorization composable")
        Spacer(modifier = Modifier.height(8.dp))
        Text(text = string1)
        Text(text = "Authorization 3")
        Text(text = "Authorization 2")
    }
}

@Preview(showBackground = true)
@Composable
fun AuthorizationStubPreview() {
    AuthorizationStub("sdfsafasf")
}