package dennis.example.com.iufest;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Faculty extends AppCompatActivity {

    DataBaseHelper myDb;

    EditText et_name,et_surname,et_designation, et_id;

    Button btn_addData,btn_showdata, btn_updateData, btn_deleteData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faculty);

        myDb = new DataBaseHelper(this);

       et_id = (EditText) findViewById(R.id.et_id);
        et_name = (EditText) findViewById(R.id.et_name);
        et_surname = (EditText) findViewById(R.id.et_surname);
        et_designation = (EditText) findViewById(R.id.et_designation);

        btn_addData = (Button) findViewById(R.id.btn_addDATA);
        btn_showdata = (Button) findViewById(R.id.btn_showdata);
        btn_updateData = (Button) findViewById(R.id.btn_updatedata);
        btn_deleteData = (Button) findViewById(R.id.btn_deleteData);

        btn_updateData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Faculty.this, UpdateClass.class);
                startActivity(intent);

            }
        });

        btn_deleteData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Faculty.this, Delete.class);
                startActivity(intent);

            }
        });




        AddData();
        showData();
      //  UpdateData();
       // DeleteData();
    }


    public void AddData()
    {
        btn_addData.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if(et_name.getText().toString().equals("")){
                    Toast.makeText(getBaseContext(), "Enter Name", Toast.LENGTH_SHORT).show();
                }
                else if(et_surname.getText().toString().equals("")){
                    Toast.makeText(getBaseContext(), "Enter Surname", Toast.LENGTH_SHORT).show();
                }
                else if(et_designation.getText().toString().equals("")){
                    Toast.makeText(getBaseContext(), "Enter Designation", Toast.LENGTH_SHORT).show();
                }
                else {

                    boolean isInserted = myDb.insertData(et_name.getText().toString(), et_surname.getText().toString(), et_designation.getText().toString());
                    if (isInserted == true) {
                        Toast.makeText(getBaseContext(), "Data Inserted ", Toast.LENGTH_SHORT).show();

                        et_name.setText("");
                        et_surname.setText("");
                        et_designation.setText("");
                    } else {
                        Toast.makeText(getBaseContext(), "Data not Inserted ", Toast.LENGTH_SHORT).show();

                    }
                }
            }
        });
    }



    public void showData()
    {
        btn_showdata.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Cursor res = myDb.getAllData();

                if(res.getCount()==0)
                {
                    //show message

                    showMessage("Error", "No Data Found");
                    return;
                }

                StringBuffer buffer = new StringBuffer();
                while (res.moveToNext())
                {
                    buffer.append("Id:" + res.getString(0)+"\n");
                    buffer.append("Name:" + res.getString(1)+"\n");
                    buffer.append("Surname:" + res.getString(2)+"\n");
                    buffer.append("Designation:" + res.getString(3)+"\n" + "\n");
                }
                //show all data

                showMessage("Data", buffer.toString());
            }
        });
    }

    public  void showMessage(String title, String Message)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(title);
        builder.setMessage(Message);
        builder.show();
    }


//    public void UpdateData()
//    {
//        Intent intent = new Intent(getBaseContext(), UpdateClass.class);
//        startActivity(intent);
////        btn_updateData.setOnClickListener(new View.OnClickListener() {
////            @Override
////            public void onClick(View v) {
////
////                boolean isUpdate = myDb.updateData(et_id.getText().toString(),et_name.getText().toString(),et_surname.getText().toString(),et_designation.getText().toString());
////
////                if(isUpdate ==  true)
////                {
////                    Toast.makeText(getBaseContext(), "Data Updated Successfully ", Toast.LENGTH_SHORT).show();
////
////                    et_name.setText("");
////                    et_surname.setText("");
////                    et_designation.setText("");
////                    et_id.setText("");
////                }
////
////                else
////                    Toast.makeText(getBaseContext(), "Data not Updated ", Toast.LENGTH_SHORT).show();
////            }
////        });
//    }

//    public void DeleteData()
//    {
//        btn_deleteData.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//
//                Integer deletedRows  = myDb.deleteData(et_id.getText().toString());
//
//                if(deletedRows >0)
//                {
//                    Toast.makeText(getBaseContext(), "Data Deleted Successfully ", Toast.LENGTH_SHORT).show();
//                    et_id.setText("");
//                }
//
//                else
//                    Toast.makeText(getBaseContext(), "Data not Deleted ", Toast.LENGTH_SHORT).show();
//
//            }
//        });
//    }



}
