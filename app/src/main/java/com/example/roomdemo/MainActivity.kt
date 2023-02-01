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
import android.app.Application
import android.app.appsearch.SearchResults
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.LocalViewModelStoreOwner
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState

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
                    //ScreenSetup()
                    val owner = LocalViewModelStoreOwner.current
                    owner?.let {
                        val viewModel: MainViewModel = viewModel(
                            it,
                            "MainViewModel",
                            MainViewModelFactory(
                                LocalContext.current.applicationContext as Application
                            )
                        )
                        ScreenSetup(viewModel)
                    }
                }
            }
        }
    }
}

@Composable
fun ScreenSetup(viewModel: MainViewModel) {

    val allProducts by viewModel.allProducts.observeAsState(listOf())
    val searchResults by viewModel.searchResults.observeAsState(listOf())

    MainScreen(
        allProducts = allProducts,
        searchResults = searchResults,
        viewModel = viewModel
    )
}

@Composable
fun MainScreen(
    allProducts: List<Product>,
    searchResults: List<Product>,
    viewModel: MainViewModel
) {

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



class MainViewModelFactory(val application: Application) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T: ViewModel> create(modelClass: Class<T>): T {
        return MainViewModel(application) as T
    }
}











