
package com.example.viewproject.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.viewproject.ui.theme.AlegreyaSansFontFamily

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CTextField(
    onValueChange: (String) -> Unit = {},
    hint: String,
    value: String,
) {
    TextField(
        value = value,
        onValueChange = onValueChange,
        placeholder = {
            Text(
                text = hint,
                style = TextStyle(
                    fontSize = 18.sp,
                    fontFamily = AlegreyaSansFontFamily,
                    color = Color(0x80FFFFFF) // semi-transparent white hint
                )
            )
        },
        textStyle = TextStyle(
            fontSize = 18.sp,
            fontFamily = AlegreyaSansFontFamily,
            color = Color.White // white text color for typed input
        ),
        modifier = Modifier
            .fillMaxWidth()
            .padding(bottom = 8.dp),
        colors = TextFieldDefaults.colors(
            focusedContainerColor = Color.Transparent,
            unfocusedContainerColor = Color.Transparent,
            cursorColor = Color.White,
            focusedIndicatorColor = Color.White,
            unfocusedIndicatorColor = Color.Gray,
            focusedTextColor = Color.White,   // white text when focused
            unfocusedTextColor = Color.White  // white text when unfocused
        )
    )
}
