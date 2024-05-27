package com.example.comunicacinfragmentactivity;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements RegisterFragment.OnRegisterListener {

    private TextView textViewUserInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewUserInfo = findViewById(R.id.textViewUserInfo);

        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        RegisterFragment registerFragment = new RegisterFragment();
        fragmentTransaction.add(R.id.fragment_container, registerFragment);
        fragmentTransaction.commit();
    }

    @Override
    public void onRegister(User user) {
        String userInfo = "Nombre: " + user.getName() + "\nCorreo: " + user.getEmail();
        textViewUserInfo.setText(userInfo);
    }
}