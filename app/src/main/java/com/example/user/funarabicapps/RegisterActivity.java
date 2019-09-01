package com.example.user.funarabicapps;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;



public class RegisterActivity extends AppCompatActivity {
    private static EditText name, username, phone, email, pass, pass2;
    private static EditText password;
    private static TextView tvname, tvusername, tvphone, tvemail, tvpass, tvpass2;
    private static Button btn_register;
    MySQLHelper Db;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        name = (EditText) findViewById(R.id.editname);
        username = (EditText) findViewById(R.id.editusername);
        phone = (EditText) findViewById(R.id.editphone);
        email = (EditText) findViewById(R.id.editemail);
        pass = (EditText) findViewById(R.id.editpass);
        pass2 = (EditText) findViewById(R.id.editpass2);
        btn_register = (Button) findViewById(R.id.button_register);
        Db = new MySQLHelper(this);
        // LoginButton();
        register();
    }

    public void register() {


        btn_register.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View arg3) {
                boolean isInserted = Db.insertData(name.getText().toString(),
                        username.getText().toString(),
                        phone.getText().toString(),
                        email.getText().toString(),
                        pass.getText().toString(),
                        pass2.getText().toString());
                if (isInserted == true) {
                    Intent intent = new Intent("com.example.user.funarabicapps.Register");
                    startActivity(intent);
                }
            }

        });

    }
}



