package com.miguelcr.simplelist;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    ListView lista;
    List<String> students;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // 1. ListView component
        lista = findViewById(R.id.listViewStudents);

        // 2. Data: list of students
        students = new ArrayList<>();
        students.add("Filip I");
        students.add("Hubert I");
        students.add("Filip II");
        students.add("Milosz I");
        students.add("Hubert II");
        students.add("Grzegorz");
        students.add("Jakub I");
        students.add("Dominik");
        students.add("Dorian");
        students.add("Michal");
        students.add("Daniel I");
        students.add("Milosz II");
        students.add("Jakub II");
        students.add("Marcin");
        students.add("Daniel II");
        students.add("Wiktor");

        // 3. Define Adapter
        ArrayAdapter adapterStudents = new ArrayAdapter(
                this,
                android.R.layout.simple_list_item_1,
                students
        );

        // 4. Connect the Apdater with the ListView component
        lista.setAdapter(adapterStudents);

        // 5. Click event
        lista.setOnItemClickListener(new ListView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "Name: " + students.get(position), Toast.LENGTH_SHORT).show();
            }
        });
    }
}
