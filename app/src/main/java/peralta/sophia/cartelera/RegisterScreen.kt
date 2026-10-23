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
import androidx.compose.ui.keepScreenOn
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.google.firebase.Firebase
import com.google.firebase.auth.auth
import peralta.sophia.cartelera.ui.theme.CarteleraTheme

@Composable
fun RegisterScreen(
    onRegisterOk: () -> Unit,
    onCancel: () -> Unit
){
    var email by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }
    var confirmation by rememberSaveable { mutableStateOf("") }
    var errorMsg by rememberSaveable { mutableStateOf("") }

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
            text = "Create account",
            style = MaterialTheme.typography.headlineLarge
        )
        OutlinedTextField(
            value = email,
            onValueChange = {email = it},
            label = {Text("Username")},
            singleLine = true,
            modifier = Modifier.fillMaxWidth(),
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
        )
        OutlinedTextField(
            value = confirmation,
            onValueChange = {confirmation = it},
            label = {Text("Verify password")},
            singleLine = true,
            visualTransformation = PasswordVisualTransformation(),
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Password
            ),
            modifier = Modifier.fillMaxWidth()
        )

        if (errorMsg.isNotEmpty()) {
            Text(
                text = errorMsg,
                color = MaterialTheme.colorScheme.error
            )

        }
        Button(
            onClick = {
                errorMsg = validateRegister(email, password, confirmation)
                if (errorMsg.isEmpty()) {
                    Firebase.auth.createUserWithEmailAndPassword(email.trim(), password)
                        .addOnCompleteListener { task ->
                            if (task.isSuccessful) {
                                onRegisterOk()
                            } else {
                                errorMsg = task.exception?.message ?: "Error registering user"
                            }
                        }
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Register")
        }

        TextButton(onClick =  onCancel) {
            Text("Already have an account? Log in")
        }
    }
}

fun validateRegister(
    email: String,
    password: String,
    confirmation: String
): String {
    if (email.isBlank() || password.isBlank() || confirmation.isBlank()) {
        return "Empty fields are not allowed"
    }
    if (password.length < 6) {
        return "Password must have at least 6 characters"
    }
    if (password != confirmation) {
        return "Passwords do not match"
    }
    return ""
}

@Preview
@Composable
fun RegisterScreenPreview(){
    CarteleraTheme {
        RegisterScreen(onRegisterOk = {}, onCancel = {})
    }

}
