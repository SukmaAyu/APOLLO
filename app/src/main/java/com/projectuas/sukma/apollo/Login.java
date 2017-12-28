package com.projectuas.sukma.apollo;

import android.content.Intent;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class Login extends AppCompatActivity {

    Toolbar toolbar;

    FirebaseAuth auth;
    private ProgressBar progressBar;
    private FirebaseAuth.AuthStateListener authListener;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        toolbar= (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle("Login System");

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);

        TextView register = (TextView) findViewById(R.id.register);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);

        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Login.this, Register.class);
                startActivity(intent);
            }
        });

        //get firebase auth instance
        auth = FirebaseAuth.getInstance();

        if (auth.getCurrentUser() != null) {
            Intent intent = new Intent(Login.this, MainActivity.class); //mapActivity // Change LoginActivity to SignupActivity if you are calling ImageActivity from SignupActivity
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
            startActivity(intent);
            finish();
        }
        findViewById(R.id.login).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signIn();
            }
        });

    }
    private void signIn() {
        if(!TextUtils.isEmpty(getvText(R.id.email)) || !TextUtils.isEmpty(getvText(R.id.email)))
        {
            progressBar.setVisibility(View.VISIBLE);
            //auth = FirebaseAuth.getInstance();

            auth = FirebaseAuth.getInstance();
            auth.signInWithEmailAndPassword(getvText(R.id.email),getvText(R.id.password))
                    .addOnCompleteListener(Login.this, new OnCompleteListener<AuthResult>() {
                        @Override
                        public void onComplete(@NonNull Task<AuthResult> task) {
                            Toast.makeText(Login.this, "Login sukses" + task.isSuccessful(), Toast.LENGTH_SHORT).show();
                            progressBar.setVisibility(View.GONE);
                            // If sign in fails, display a message to the user. If sign in succeeds
                            // the auth state listener will be notified and logic to handle the
                            // signed in user can be handled in the listener.
                            if (!task.isSuccessful()) {
                                Toast.makeText(Login.this, "Authentication failed." + task.getException(),
                                        Toast.LENGTH_SHORT).show();
                            } else {
                                Toast.makeText(Login.this, "Successed to Login",
                                        Toast.LENGTH_SHORT).show();
                                finish();
                                startActivity(new Intent(Login.this, MainActivity.class));
                            }
                        }
                    });
        }
    }
    public String getvText(int id)
    {
        EditText e =  (EditText) findViewById(id);
        return e.getText().toString();
    }
}