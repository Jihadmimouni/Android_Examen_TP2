package com.example.examentp2;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

public class DeleteStudentActivity extends AppCompatActivity {
    DatabaseHelper myDb;
    EditText editId;
    Button btnDelete;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_student);

        myDb = new DatabaseHelper(this);

        editId = findViewById(R.id.editTextId);
        btnDelete = findViewById(R.id.buttonDelete);

        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Integer deletedRows = myDb.deleteData(editId.getText().toString());

                if (deletedRows > 0)
                    Toast.makeText(DeleteStudentActivity.this, "Student Deleted", Toast.LENGTH_LONG).show();
                else
                    Toast.makeText(DeleteStudentActivity.this, "Student Not Found", Toast.LENGTH_LONG).show();
            }
        });
    }
}
