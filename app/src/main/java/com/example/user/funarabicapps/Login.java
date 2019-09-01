package com.example.user.funarabicapps;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;



public class Login extends AppCompatActivity {
    Button btnGoToRegister;
    Button btnGoToLogin;
    MySQLHelper myDb;
    EditText username;
    EditText password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        btnGoToRegister = (Button) findViewById(R.id.buttonmain);
        btnGoToLogin = (Button) findViewById(R.id.button18);
        myDb = new MySQLHelper(this);
        username = (EditText) findViewById(R.id.editText2);
        password = (EditText) findViewById(R.id.editText3);

        GoToRegister();
        GoToLogin();
    }

    public void GoToLogin() {
        btnGoToLogin.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Cursor res = myDb.fetchAll();
                        int col = res.getCount();
                        if (col == 0) {
                            Toast.makeText(Login.this, "Username and password not match", Toast.LENGTH_LONG).show();
                        } else {
                            while (res.moveToNext()) {
                                String id = "" + res.getInt(0);
                                String user = res.getString(1);
                                String pass = res.getString(2);

                                if (username.getText().toString().equals("" + user) &&
                                        password.getText().toString().equals("" + pass)) {

                                    Intent intent = new Intent("com.example.user.funarabicapps.Register");
                                    startActivity(intent);
                                    res.moveToNext();
                                }
                            }
                        }

                    }
                }

        );
    }

    public void GoToRegister(){
        btnGoToRegister.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent("com.example.user.funarabicapps.RegisterActivity");
                        startActivity(intent);
                    }
                }
        );
    }
}
