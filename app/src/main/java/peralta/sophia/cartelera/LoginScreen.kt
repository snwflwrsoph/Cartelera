package peralta.sophia.cartelera

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.firebase.Firebase
import com.google.firebase.auth.auth
import peralta.sophia.cartelera.ui.theme.CarteleraTheme

@Composable
fun LoginScreen(
    onLoginOk:() -> Unit,
    onRegister: () -> Unit){
    var user by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("")}
    var hayError by rememberSaveable { mutableStateOf(false) }
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        verticalArrangement = Arrangement.spacedBy(
            space = 12.dp,
            alignment = Alignment.CenterVertically
        ),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = "Fake Netflix",
            style = MaterialTheme.typography.headlineLarge
        )
        OutlinedTextField(
            value = user,
            onValueChange = {user = it},
            label = {Text("Username")},
            singleLine = true,
            modifier = Modifier.fillMaxWidth(),
            isError = hayError
        )
        OutlinedTextField(
            value = password,
            onValueChange = {password = it},
            label = {Text("Password")},
            singleLine = true,
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password
            ),
            modifier = Modifier.fillMaxWidth(),
            isError = hayError
        )
        if (hayError) {
            Text(
                text = "Username or password incorrect",
                color = MaterialTheme.colorScheme.error
            )
        }
        Button(
            onClick = {
                if (user.isBlank() || password.isBlank()) {
                    hayError = true
                } else {
                    Firebase.auth.signInWithEmailAndPassword(user.trim(), password)
                        . addOnCompleteListener {task ->
                            if (task.isSuccessful) {
                                onLoginOk()
                            } else {
                                hayError = true
                            }
                        }
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Log In")
        }

        TextButton(onClick = onRegister) {
            Text("Don't have an account? Register")
        }
    }
}

@Preview
@Composable
fun LoginScreenPreview(){
    CarteleraTheme {
        LoginScreen(onLoginOk = {}, onRegister = {})
    }
}