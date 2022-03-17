package com.example.pengembanganaplikasimobile;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnlogin;
    EditText edemail, edpassword;
    String nama, password;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnlogin = findViewById(R.id.btsignin);
        edemail = findViewById(R.id.edemail);
        edpassword = findViewById(R.id.edpassword);

        btnlogin.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {

                nama = edemail.getText().toString();
                password = edpassword.getText().toString();

                String email = "zuhan@mail.com";
                String pass = "12345";

                validation();
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        if (item.getItemId() == R.id.mnDaftar)
        {
            Intent i = new Intent(getApplicationContext(), DaftarActivity.class);
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(R.menu.menu, menu);

        return super.onCreateOptionsMenu(menu);
    }

    public void validation(){

        nama = edemail.getText().toString();
        password = edpassword.getText().toString();

        if (nama.isEmpty() && password.isEmpty())
        {
            edemail.setError("Email Diperlukan");
            edpassword.setError("Password Diperlukan");
        } else {
            if (nama.equals("zuhan@mail.com") && password.equals("12345")) {
                Toast t = Toast.makeText(getApplicationContext(),
                        "Login Berhasil. Email anda : " + nama + " dan Password anda : " + password + "", Toast.LENGTH_LONG);
                t.show();

                Bundle b = new Bundle();
                b.putString("a",nama.trim());
                b.putString("b",password.trim());
                Intent i = new Intent(getApplicationContext(), ActivityHasil.class);
                i.putExtras(b);
            } else if (!nama.equals("zuhan@mail.com") && password.equals("12345")) {
                Toast t = Toast.makeText(getApplicationContext(),
                        "Email salah", Toast.LENGTH_LONG);
                t.show();
            } else if (nama.equals("zuhan@mail.com") && !password.equals("12345")) {
                Toast t = Toast.makeText(getApplicationContext(),
                        "Password salah", Toast.LENGTH_LONG);
                t.show();
            } else {
                Toast t = Toast.makeText(getApplicationContext(),
                        "Email dan Password salah", Toast.LENGTH_LONG);
                t.show();
            }
        }
    }

    private class DaftarActivity {
    }
}
