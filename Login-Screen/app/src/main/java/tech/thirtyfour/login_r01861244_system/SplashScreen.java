package tech.thirtyfour.login_r01861244_system;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;

import static java.lang.Thread.sleep;

public class SplashScreen extends AppCompatActivity {
    static HashMap<String, String> passwords = new HashMap<String, String>();

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            sleep(750);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        //passwords.put("calap@farmingdale.edu", "peter");
        Intent intent = new Intent(this, MainActivity.class);
        intent.putExtra("map", passwords);
        startActivity(intent);
        finish();
    }
}