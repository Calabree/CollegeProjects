package tech.thirtyfour.login_r01861244_system;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;


public class  MainActivity extends AppCompatActivity {

     HashMap<String, String> passwords;


    EditText loginEmail, loginPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        loginEmail = (EditText) findViewById(R.id.loginEmail);
        loginPassword = (EditText) findViewById(R.id.loginPassword);
        Intent intent = getIntent();
        passwords = (HashMap<String, String>)intent.getSerializableExtra("map");


    }
    boolean emailIsValid(String emailToCheck) {
        String emailValidationRegex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        return emailToCheck.matches(emailValidationRegex);

    }

    public void loginButton(View view) {


        //System.out.println(passwords.get(loginEmail.getText().toString()));
        passwords.put("calap@farmingdale.edu", "peter"); //default username and password to test login

        String email = loginEmail.getText().toString();

        if (!emailIsValid(email)){
            Toast.makeText(MainActivity.this, "Please enter a valid email", Toast.LENGTH_SHORT).show();
            return;
        }
        if (passwords.get(loginEmail.getText().toString()) == null) {
            Toast.makeText(MainActivity.this, "This email is not in our database", Toast.LENGTH_SHORT).show();
            return;
        }
        if (!loginPassword.getText().toString().equals(passwords.get(loginEmail.getText().toString()))) {
            Toast.makeText(MainActivity.this, "Incorrect Password", Toast.LENGTH_SHORT).show();
            return;
        }
        else {
            startActivity(new Intent(this, loginSuccessful.class));
            finish();
        }

    }

    public void registerButton(View view){

        startActivity(new Intent(this, Registration.class));
    }
}