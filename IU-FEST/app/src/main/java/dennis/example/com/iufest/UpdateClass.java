package dennis.example.com.iufest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class UpdateClass extends AppCompatActivity {

    private DataBaseHelper myDb;

    EditText et_name,et_surname,et_designation, et_id;

    Button btn_updatedatafinal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update_class);

        myDb = new DataBaseHelper(this);

        et_id = (EditText) findViewById(R.id.et_id);
        et_name = (EditText) findViewById(R.id.et_name);
        et_surname = (EditText) findViewById(R.id.et_surname);
        et_designation = (EditText) findViewById(R.id.et_designation);

        btn_updatedatafinal = (Button) findViewById(R.id.btn_updatedatafinal);

        UpdateData();

    }

    public void UpdateData()
    {
        btn_updatedatafinal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(et_id.getText().toString().equals("")) {
                    Toast.makeText(getBaseContext(), "Enter User Id first to Update", Toast.LENGTH_SHORT).show();
                }
                else if(et_name.getText().toString().equals("")){
                    Toast.makeText(getBaseContext(), "Enter Name", Toast.LENGTH_SHORT).show();
                }
                else if(et_surname.getText().toString().equals("")){
                    Toast.makeText(getBaseContext(), "Enter Surname", Toast.LENGTH_SHORT).show();
                }
                else if(et_designation.getText().toString().equals("")){
                    Toast.makeText(getBaseContext(), "Enter Designation", Toast.LENGTH_SHORT).show();
                }
                else {

                    boolean isUpdate = myDb.updateData(et_id.getText().toString(), et_name.getText().toString(), et_surname.getText().toString(), et_designation.getText().toString());

                    if (isUpdate == true) {
                        Toast.makeText(getBaseContext(), "Data Updated Successfully ", Toast.LENGTH_SHORT).show();

                        et_name.setText("");
                        et_surname.setText("");
                        et_designation.setText("");
                        et_id.setText("");
                    } else
                        Toast.makeText(getBaseContext(), "Data not Updated ", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
