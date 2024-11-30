package com.example.examentp2;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class AddStudentActivity extends AppCompatActivity {
    DatabaseHelper myDb;
    EditText editName, editLastName, editMark;
    Button btnAddData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_student);

        myDb = new DatabaseHelper(this);

        editName = findViewById(R.id.editTextName);
        editLastName = findViewById(R.id.editTextLastName);
        editMark = findViewById(R.id.editTextMark);
        btnAddData = findViewById(R.id.buttonAdd);

        btnAddData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isInserted = myDb.insertData(
                        editName.getText().toString(),
                        editLastName.getText().toString(),
                        Integer.parseInt(editMark.getText().toString())
                );

                if (isInserted)
                    Toast.makeText(AddStudentActivity.this, "Student Added", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(AddStudentActivity.this, "Error Adding Student", Toast.LENGTH_LONG).show();
            }
        });
    }
}
