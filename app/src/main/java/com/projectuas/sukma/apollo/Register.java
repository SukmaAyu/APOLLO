package com.projectuas.sukma.apollo;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


public class Register extends AppCompatActivity {

    Toolbar toolbar11;

    private FirebaseAuth auth;
    private ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        toolbar11= (Toolbar) findViewById(R.id.toolbar);
        toolbar11.setTitle("Register");
        Button register = (Button) findViewById(R.id.register);
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                User usr = new User(getvText(R.id.user),getvText(R.id.email),getvText(R.id.password),getvText(R.id.cpassword));
                validate(Register.this,usr);
            }
        });
        TextView lupapassword = (TextView) findViewById(R.id.lupapassword);
        lupapassword.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();

                startActivity(new Intent(Register.this,ForgotActivity.class));
            }
        });
    }

    public void validate(Context c, User user)
    {
        int message = 0;
        if(TextUtils.isEmpty(user.nama) || TextUtils.isEmpty(user.email) || TextUtils.isEmpty(user.password))
            { message= R.string.inputdaftar; }
        else if(user.password.length()<5){ message= R.id.lupapassword; }
        else if(!user.cpassword.equals(user.password)){ message= R.id.cpassword; }
        else { register(user); }

        if(message!=0)
        {
            Toast.makeText(c, message, Toast.LENGTH_LONG).show();
        }

    }

    private void register(User usr)
    {
        DatabaseReference mDatabase = FirebaseDatabase.getInstance().getReference("log_register");
        mDatabase.push().setValue(usr);

        progressBar.setVisibility(View.VISIBLE);
        auth = FirebaseAuth.getInstance();
        auth.createUserWithEmailAndPassword(usr.email, usr.password)
                .addOnCompleteListener(Register.this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        Toast.makeText(Register.this, "Mohon Menungggu" + task.isSuccessful(), Toast.LENGTH_SHORT).show();
                        progressBar.setVisibility(View.GONE);
                        // If sign in fails, display a message to the user. If sign in succeeds
                        // the auth state listener will be notified and logic to handle the
                        // signed in user can be handled in the listener.
                        if (!task.isSuccessful()) {
                            Toast.makeText(Register.this, "Gagal Mendaftar" + task.getException(),
                                    Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(Register.this, "Pendaftaran Berhasil",
                                    Toast.LENGTH_SHORT).show();
                            finish();
                        }
                    }
                });
    }
    public String getvText(int id)
    {
        EditText e =  (EditText) findViewById(id);
        return e.getText().toString();
    }
}


