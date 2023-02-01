package com.example.roomdemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedTextField
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.roomdemo.ui.theme.RoomDemoTheme
import kotlin.math.sin

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            RoomDemoTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    ScreenSetup()
                }
            }
        }
    }
}

@Composable
fun ScreenSetup() {
    MainScreen()
}

@Composable
fun MainScreen() {

}

@Composable
fun TitleRow(head1: String, head2: String, head3: String) {
    Row(modifier = Modifier
        .background(MaterialTheme.colors.primary)
        .fillMaxWidth()
        .padding(5.dp)
    ) {
        Text(
            text = head1, 
            color = Color.White,
            modifier = Modifier
                .weight(0.1f)
        )
        Text(
            text = head2,
            color = Color.White,
            modifier = Modifier
                .weight(0.2f)
        )
        Text(
            text = head3,
            color = Color.White,
            modifier = Modifier
                .weight(0.2f)
        )
    }
}

@Composable
fun ProductRow(id: Int, name: String, quantity: Int) {
    Row(modifier = Modifier
        .fillMaxWidth()
        .padding(5.dp)
    ) {
        Text(text = id.toString(), modifier = Modifier.weight(0.1f))
        Text(text = name, modifier = Modifier.weight(0.2f))
        Text(text = quantity.toString(), modifier = Modifier.weight(0.2f))
    }
}

@Composable
fun CustomTextField(
    title: String,
    textState: String,
    onTextChange: (String) -> Unit,
    keyboardType: KeyboardType
) {
    OutlinedTextField(
        value = textState,
        onValueChange = { onTextChange(it) },
        keyboardOptions = KeyboardOptions(
            keyboardType = keyboardType
        ),
        singleLine = true,
        label = { Text(text = title) },
        modifier = Modifier.padding(10.dp),
        textStyle = TextStyle(fontWeight = FontWeight.Bold,
            fontSize = 30.sp)
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    RoomDemoTheme {
        ScreenSetup()
    }
}











