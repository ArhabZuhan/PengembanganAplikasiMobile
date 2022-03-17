package com.example.pengembanganaplikasimobile;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

public class DaftarActivity extends AppCompatActivity {
    EditText edtNama, edtAlamat, edtEmail, edtPassword, edtrepass;
    FloatingActionButton fab;

    @Override
    protected void onCreate(Bundle savedIntstanceState) {
        super.onCreate(savedIntstanceState);
        setContentView(R.layout.perndaftaran);

        edtAlamat = findViewById(R.id.edalamat);
        edtEmail = findViewById(R.id.edemail);
        edtNama = findViewById(R.id.edNama);
        edtPassword = findViewById(R.id.edpassword);
        edtrepass = findViewById(R.id.edrpas);
        fab = findViewById(R.id.fabSimpan);

        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (edtNama.getText().toString().isEmpty() ||
                        edtAlamat.getText().toString().isEmpty() ||
                        edtEmail.getText().toString().isEmpty() ||
                        edtPassword.getText().toString().isEmpty() ||
                        edtrepass.getText().toString().isEmpty())
                {
                    Snackbar.make(view,"Wajib isi seluruh", Snackbar.LENGTH_LONG).show();
                }
                else
                {
                    if (edtPassword.getText().toString().equals(edtrepass.getText().toString()))
                    {
                        Toast.makeText(getApplicationContext(), "Pendaftaran Berhasil",
                                Toast.LENGTH_LONG).show();
                        Intent i = new Intent(getApplicationContext(), MainActivity.class);
                        startActivity(i);
                    }
                    else
                    {
                        Snackbar.make(view,"Password dan Repassword harus sama",
                                Snackbar.LENGTH_LONG).show();
                    }
                }
            }
        });
    }
}
