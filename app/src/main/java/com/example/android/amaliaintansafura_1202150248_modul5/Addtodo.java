package com.example.android.amaliaintansafura_1202150248_modul5;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Addtodo extends AppCompatActivity {
    //deklarasi variable yang akan digunakan
    private EditText ToDo, Description, Priority;
    private Database db;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addtodo);
        setTitle("Tambahkan To Do");

        //membuat referensi dari variabelnya
        ToDo = (EditText) findViewById(R.id.editTodo);
        Description = (EditText) findViewById(R.id.editDescription);
        Priority = (EditText) findViewById(R.id.editPriority);
        db = new Database(this);
    }
    @Override
    public void onBackPressed() {
        //intent ke MainActivity
        Intent a = new Intent(Addtodo.this, MainActivity.class);
        //eksekusi intentnya
        startActivity(a);
        //menutup aktivitas setelah intent dijalankan
        this.finish();
    }

    public void addTodo(View view) {
        //apabila data dari todoname, deskripsi dan prioritas di isi
        if (db.inputdata(new TambahData(ToDo.getText().toString(), Description.getText().toString(), Priority.getText().toString()))){
            //
            Toast.makeText(this, "To Do List Berhasil Ditambahkan !", Toast.LENGTH_SHORT).show();
            //intent ke mainActivity
            startActivity(new Intent(Addtodo.this, MainActivity.class));
            //menutup aktivitas agar tidak kembali ke activity yang dijalankan setelah intent
            this.finish();
        }else {
            //apabila edit text kosong maka akan muncul toast bahwa tidak bisa menambah ke dalam list
            Toast.makeText(this, "List harus diisi", Toast.LENGTH_SHORT).show();
            //set semua edit text menjadi kosong
            ToDo.setText(null);
            Description.setText(null);
            Priority.setText(null);
        }
    }
}
