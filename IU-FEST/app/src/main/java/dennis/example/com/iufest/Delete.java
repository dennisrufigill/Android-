package dennis.example.com.iufest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Delete extends AppCompatActivity {

    Button delete;
    EditText et_id;

    DataBaseHelper myDb;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);

        delete = (Button) findViewById(R.id.button);
        et_id = (EditText) findViewById(R.id.editText) ;

        myDb = new DataBaseHelper(this);

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (et_id.getText().toString().equals("")) {
                    Toast.makeText(getBaseContext(), "Enter User ID to delete", Toast.LENGTH_SHORT).show();
                }
                else {

                    Integer deletedRows = myDb.deleteData(et_id.getText().toString());

                    if (deletedRows > 0) {
                        Toast.makeText(getBaseContext(), "Data Deleted Successfully ", Toast.LENGTH_SHORT).show();
                        et_id.setText("");
                    } else
                        Toast.makeText(getBaseContext(), "Data not Deleted ", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }
}
