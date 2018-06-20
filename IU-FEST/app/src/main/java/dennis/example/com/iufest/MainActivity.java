package dennis.example.com.iufest;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btn_fest;
    TextView tv_visitus;

    DataBaseHelper myDb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myDb = new DataBaseHelper(this);




        btn_fest = (Button) findViewById(R.id.btn_Fest);
        tv_visitus = (TextView) findViewById(R.id.tv_visitus);

        btn_fest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getBaseContext(),FestMenu.class);
                startActivity(intent);
            }
        });

        tv_visitus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Uri webpage=Uri.parse("http://iqra.edu.pk");
                Intent webIntent = new Intent(Intent.ACTION_VIEW,webpage);
                startActivity(webIntent);


            }
        });

    }
}
