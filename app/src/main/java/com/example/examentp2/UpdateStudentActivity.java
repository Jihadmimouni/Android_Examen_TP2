package com.example.examentp2;
// UpdateStudentActivity.java
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class UpdateStudentActivity extends AppCompatActivity {
    DatabaseHelper myDb;
    EditText editId, editNewMark;
    Button btnUpdate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_student);

        myDb = new DatabaseHelper(this);

        editId = findViewById(R.id.editTextId);
        editNewMark = findViewById(R.id.editTextNewMark);
        btnUpdate = findViewById(R.id.buttonUpdate);

        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean isUpdated = myDb.updateData(editId.getText().toString(), Integer.parseInt(editNewMark.getText().toString()));

                if (isUpdated)
                    Toast.makeText(UpdateStudentActivity.this, "Student Updated", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(UpdateStudentActivity.this, "Student Not Found", Toast.LENGTH_LONG).show();
            }
        });
    }
}
