package tech.thirtyfour.login_r01861244_system;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;
import java.util.Map;

public class Registration extends AppCompatActivity {

    EditText firstName, lastName, dateOfBirth, email, psswd;
    static HashMap<String, String> passwords = new HashMap<String, String>();
    public  Map<String, String> fname = new HashMap<String, String>();
    public  Map<String, String> lname = new HashMap<String, String>();
    public  Map<String, String> DOB = new HashMap<String, String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);
        firstName=(EditText) findViewById(R.id.FirstName);
        lastName=(EditText) findViewById(R.id.LastName);
        dateOfBirth=(EditText) findViewById(R.id.DateOB);
        email=(EditText) findViewById(R.id.email);
        psswd=(EditText) findViewById(R.id.newPassword);
    }

    boolean emailIsValid(String emailToCheck) {
        String emailValidationRegex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        return emailToCheck.matches(emailValidationRegex);

    }
    public void registerButton(View view) {

        if(firstName.getText().toString().isEmpty() || lastName.getText().toString().isEmpty() || dateOfBirth.getText().toString().isEmpty() || email.getText().toString().isEmpty() || psswd.getText().toString().isEmpty()){
            Toast.makeText(Registration.this, "ALL FIELDS ARE REQUIRED, PLEASE FILL OUT AND EMPTY FIELDS", Toast.LENGTH_SHORT).show();
            return;
        }

        if(!emailIsValid(email.getText().toString())) {
            System.out.println(firstName.getText().toString());
            System.out.println("second print");
            Toast.makeText(Registration.this, "PLEASE ENTER A VALID EMAIL", Toast.LENGTH_SHORT).show();
            return;
        }

        if(firstName.getText().toString().length() < 3){
            Toast.makeText(Registration.this, "FIRST NAME MAY NOT BE SHORTER THAN 3 CHARACTERS", Toast.LENGTH_SHORT).show();
            return;
        }


        fname.put(email.getText().toString(),firstName.getText().toString());
        lname.put(email.getText().toString(),lastName.getText().toString());
        DOB.put(email.getText().toString(),dateOfBirth.getText().toString());
        passwords.put(email.getText().toString(),psswd.getText().toString());

        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("map", passwords);
        startActivity(intent);
        finish();
    }
}