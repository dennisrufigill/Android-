package com.example.daonew;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.R.layout;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.daonew.database.DaoSession;
import com.example.daonew.database.Users;
import com.example.daonew.database.UsersDao;

import java.util.ArrayList;
import java.util.List;

public class UsersActivity extends AppCompatActivity {

    ListView listView;

    EditText name;
    EditText gender;
    EditText status;
    Button addUserbutton;

    TextView textView;

    boolean createNew = false;

    DaoSession daoSession;


    //
    ArrayAdapter<Users> userArrayAdapter;
    //  List<Users> users1 = new ArrayList<>();

    List<String> usersNameList = new ArrayList<>();
    //

    List<Users> users = new ArrayList<>();
    private Users editUser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_users);
        name = findViewById(R.id.et_userName);
        gender = findViewById(R.id.et_user_gender);
        status = findViewById(R.id.et_userStatus);
        listView = findViewById(R.id.listview);
        // textView = findViewById(R.id.textView);


        addUserbutton = findViewById(R.id.btn_newuser);


        daoSession = ((MyApplication) getApplication()).getDaoSession();

        addUserbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (editUser == null)
                    insetItem();
                else {
                    updateItem();
                }

            }
        });


        setupListView();


    }


    public void insetItem() {
        UsersDao usersDao = daoSession.getUsersDao();
        Users users = new Users();
        users.setName(name.getText().toString());
        users.setGender(gender.getText().toString());
        users.setStatus(Integer.parseInt(status.getText().toString()));
        long id = usersDao.insert(users);
        Toast.makeText(getApplicationContext(), "Item Inserted:  " + id, Toast.LENGTH_SHORT).show();


    }

//   public void showData(){
//        UsersDao usersDao = daoSession.getUsersDao();
//        users1.addAll(usersDao.loadAll());
//        textView.setTextSize(usersDao.loadAll().size());
//
//    }


    private void setupListView() {

        users = daoSession.getUsersDao().queryBuilder().orderDesc(UsersDao.Properties.Id).list();
        userArrayAdapter = new ArrayAdapter<Users>(this, android.R.layout.simple_list_item_1, users);
        listView.setAdapter(userArrayAdapter);

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int i, long l) {


                showOptions(i);


                return true;
            }
        });


    }

    /*     //This method is never used
        private void deleteUserItem(Long id) {
            UsersDao userDao = daoSession.getUsersDao();
            userDao.deleteByKey(id);


        }
    */
    public void showOptions(final int position) {

        //Users selectedItemPosition = users.get(position);
        AlertDialog.Builder alertDialog = new AlertDialog.Builder(this);
        alertDialog.setTitle("Please select");

        alertDialog.setPositiveButton("Edit", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                //  Toast.makeText(getApplicationContext(), "You Clicked Edit" + position, Toast.LENGTH_SHORT).show();
                setValues(position);
//                UsersDao usersDao = daoSession.getUsersDao();
//
//                Users userClicked = users.get(position);
//
//                //   updateItem(userClicked);
//
//                usersDao.update(userClicked);
//
//                addUserbutton.setText("Update");


            }
        });

        alertDialog.setNegativeButton("Delete", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

                //  Toast.makeText(getApplicationContext(), "You CLICKED dElete",Toast.LENGTH_SHORT ).show();

                //  deleteUserItem(i);

                UsersDao userDao = daoSession.getUsersDao();

                Users userClicked = users.get(position);

                //userDao.deleteByKey(id);

                userDao.delete(userClicked);

                Toast.makeText(UsersActivity.this, userClicked.getName() + " Deleted!", Toast.LENGTH_SHORT).show();

                users.remove(position);
                userArrayAdapter.notifyDataSetChanged();


            }
        });


        alertDialog.show();

    }


    public void setValues(int position) {
        addUserbutton.setText(R.string.update);
        editUser = this.users.get(position);
        name.setText(editUser.getName());
        gender.setText(editUser.getGender());
        status.setText("" + editUser.getStatus());


    }


    public void updateItem() {
        UsersDao usersDao = daoSession.getUsersDao();
        editUser.setStatus(Integer.parseInt(status.getText().toString()));
        editUser.setName(name.getText().toString());
        editUser.setGender(gender.getText().toString());
        //    users.setStatus(Integer.parseInt(status.getText().toString()));
        usersDao.saveInTx(editUser);
        Toast.makeText(getApplicationContext(), "Item is updated", Toast.LENGTH_SHORT).show();
        editUser = null;
        name.setText(null);
        status.setText(null);
        gender.setText(null);
        addUserbutton.setText(R.string.insert);

        //

        userArrayAdapter.notifyDataSetChanged();
        //

    }


}