package com.example.snackbar_text_feild_kotlin

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.snackbar_text_feild_kotlin.ui.theme.SnackbartextfeildkotlinTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            SnackbartextfeildkotlinTheme {
                val scaffoldState = rememberScaffoldState()

                var textFeildState by remember { mutableStateOf("") }

                val scope = rememberCoroutineScope()

                Scaffold(
                    scaffoldState = scaffoldState
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center,
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(horizontal = 30.dp)
                    ) {
                        TextField(
                            value = textFeildState,
                            onValueChange = {
                                textFeildState = it
                            },
                            label = {
                                Text(text = "Enter")
                            },
                            singleLine = true,
                            modifier = Modifier.fillMaxWidth()
                        )
                        Spacer(modifier = Modifier.height(20.dp))
                        Button(
                            onClick = { scope.launch { scaffoldState.snackbarHostState.showSnackbar(textFeildState) } }
                        ) {
                            Text(text = "Submit")
                        }
                    }
                }
            }
        }
    }
}


