package com.example.examentp2;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

public class FirstActivity extends AppCompatActivity {
    DatabaseHelper myDb;
    ListView listView;
    String[] options = {"Add", "Delete", "Update", "View"};
    int[] images = {R.drawable.ic_add, R.drawable.ic_delete, R.drawable.ic_update, R.drawable.ic_view}; // Replace with actual icons

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first);

        myDb = new DatabaseHelper(this);
        listView = findViewById(R.id.listView);

        // Use CustomAdapter to display images and text
        CustomAdapter adapter = new CustomAdapter(this, options, images);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                switch (position) {
                    case 0: // Add
                        startActivity(new Intent(FirstActivity.this, AddStudentActivity.class));
                        break;
                    case 1: // Delete
                        startActivity(new Intent(FirstActivity.this, DeleteStudentActivity.class));
                        break;
                    case 2: // Update
                        startActivity(new Intent(FirstActivity.this, UpdateStudentActivity.class));
                        break;
                    case 3: // View
                        viewAllStudents();
                        break;
                }
            }
        });
    }

    private void viewAllStudents() {
        Cursor res = myDb.getAllData();
        if (res.getCount() == 0) {
            showMessage("Error", "No students found");
            return;
        }

        StringBuilder buffer = new StringBuilder();
        while (res.moveToNext()) {
            buffer.append("ID: ").append(res.getString(0)).append("\n");
            buffer.append("Name: ").append(res.getString(1)).append("\n");
            buffer.append("Lastname: ").append(res.getString(2)).append("\n");
            buffer.append("Mark: ").append(res.getString(3)).append("\n\n");
        }
        showMessage("Student List", buffer.toString());
    }

    private void showMessage(String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(message);
        builder.show();
    }
}
