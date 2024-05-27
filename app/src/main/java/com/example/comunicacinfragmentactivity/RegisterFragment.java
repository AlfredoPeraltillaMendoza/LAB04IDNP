package com.example.comunicacinfragmentactivity;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.os.Bundle;
import androidx.fragment.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link RegisterFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class RegisterFragment extends Fragment {

    private OnRegisterListener callback;

    public interface OnRegisterListener {
        void onRegister(User user);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getActivity() instanceof OnRegisterListener) {
            callback = (OnRegisterListener) getActivity();
        } else {
            throw new RuntimeException("Activity must implement OnRegisterListener");
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_register, container, false);

        EditText editTextName = view.findViewById(R.id.editTextName);
        EditText editTextEmail = view.findViewById(R.id.editTextEmail);
        EditText editTextPassword = view.findViewById(R.id.editTextPassword);
        Button buttonRegister = view.findViewById(R.id.buttonRegister);

        buttonRegister.setOnClickListener(v -> {
            String name = editTextName.getText().toString();
            String email = editTextEmail.getText().toString();
            String password = editTextPassword.getText().toString();

            User newUser = new User(name, email, password);

            if (callback != null) {
                callback.onRegister(newUser);
            }
        });

        return view;
    }
}