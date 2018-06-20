package dennis.example.com.iufest;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class FestMenu extends AppCompatActivity {

    String menus[] = {"Programs", "Deans/HODs", "Faculty", "IULMS","ICEEST"};
    ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fest_menu);

        listView= (ListView) findViewById(R.id.listView);

        ArrayAdapter <String> adapter  = new ArrayAdapter<String>(getBaseContext(),android.R.layout.simple_list_item_1, menus);
        listView.setAdapter(adapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if(position == 1)
                {
                    Intent intent = new Intent(FestMenu.this,Deans.class);
                    startActivity(intent);
                }
                if(position == 0)
                {
                    Intent intent = new Intent(FestMenu.this, Programs.class);
                    startActivity(intent);
                }

                if(position == 3)
                {
                    Uri webpage=Uri.parse("http://iulms.edu.pk/");
                    Intent webIntent = new Intent(Intent.ACTION_VIEW,webpage);
                    startActivity(webIntent);
                }


                if(position == 4)
                {
                    Uri webpage=Uri.parse( "http://iqra.edu.pk/iceest-2017/");
                    Intent webIntent = new Intent(Intent.ACTION_VIEW,webpage);
                    startActivity(webIntent);
                }

                if(position == 2)
                {
                    Intent intent = new Intent(FestMenu.this, Faculty.class);
                    startActivity(intent);
                }



            }
        });

    }
}
