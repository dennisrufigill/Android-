package dennis.example.com.iufest;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Programs extends AppCompatActivity {

    HashMap<String, List<String>> myHeader;
    List<String> myChild;
    ExpandableListView expList;
    MyAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_programs);

        expList = (ExpandableListView) findViewById(R.id.idListView);
        myHeader = MyAdapter.DataProvider.getInfo();
        myChild = new ArrayList<String>(myHeader.keySet());
        adapter = new MyAdapter(this, myHeader, myChild);
        expList.setAdapter(adapter);


    }
}

    class MyAdapter extends BaseExpandableListAdapter {

        public static DataProvider DataProvider;
        private Context ctx;
        private HashMap<String, List<String>> ChildTitles;
        private List<String> HeaderTitles;

        MyAdapter(Context ctx, HashMap<String, List<String>> ChildTitles, List<String> HeaderTitles) {
            this.ctx = ctx;
            this.ChildTitles = ChildTitles;
            this.HeaderTitles = HeaderTitles;
        }

        @Override
        public int getGroupCount() {
            return HeaderTitles.size();
        }

        @Override
        public int getChildrenCount(int groupPosition) {
            return ChildTitles.get(HeaderTitles.get(groupPosition)).size();
        }

        @Override
        public Object getGroup(int groupPosition) {
            return HeaderTitles.get(groupPosition);
        }

        @Override
        public Object getChild(int groupPosition, int childPosition) {
            return ChildTitles.get(HeaderTitles.get(groupPosition)).get(childPosition);
        }

        @Override
        public long getGroupId(int groupPosition) {
            return groupPosition;
        }

        @Override
        public long getChildId(int groupPosition, int childPosition) {
            return groupPosition;
        }

        @Override
        public boolean hasStableIds() {
            return false;
        }

        @Override
        public View getGroupView(int groupPosition, boolean isExpanded, View view, ViewGroup parent) {
            String title = (String) this.getGroup(groupPosition);
            if (view == null) {
                LayoutInflater inflater = (LayoutInflater) this.ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                view = inflater.inflate(R.layout.custom_header, null);
            }
            TextView text = (TextView) view.findViewById(R.id.idTitle);
            text.setTypeface(null, Typeface.BOLD);
            text.setText(title);
            return view;
        }

        @Override
        public View getChildView(int i, int i1, boolean b, View view, ViewGroup viewGroup) {
            String title = (String) this.getChild(i, i1);
            if (view == null) {
                LayoutInflater inflater = (LayoutInflater) this.ctx.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                view = inflater.inflate(R.layout.custom_childitems, null);
            }
            TextView text = (TextView) view.findViewById(R.id.idChild);
            text.setText(title);
            return view;

        }

        @Override
        public boolean isChildSelectable(int groupPosition, int childPosition) {
            return true;
        }
    }

         class DataProvider {

            public static HashMap <String, List<String>> getInfo() {

                HashMap <String, List<String>> HeaderDetails = new HashMap<String, List<String>>();
                List<String> ChildDetails1 = new ArrayList<String>();
                ChildDetails1.add("Bachelors in Computer Sciences");
                ChildDetails1.add("Bachelors in Software Engineering");
                ChildDetails1.add("Bachelors in Telecommunication ");
                ChildDetails1.add("Bachelors in Electronics Engineering");
                ChildDetails1.add("Bachelors in Electrical Engineering");

                List<String> ChildDetails2 = new ArrayList<String>();
                ChildDetails2.add("Masters in Computer Sciences");
              //  ChildDetails2.add("Masters in Software Engineering");
                ChildDetails2.add("Masters in Telecommunication ");
                ChildDetails2.add("Masters in Electronics Engineering");
              //  ChildDetails2.add("Masters in Electrical Engineering");

                List<String> ChildDetails3 = new ArrayList<String>();
                ChildDetails3.add("M.Phil in Computer Sciences");
               // ChildDetails3.add("M.Phil in Software Engineering");
                ChildDetails3.add("M.Phil in Telecommunication ");
                ChildDetails3.add("M.Phil in Electronics Engineering");
                //ChildDetails3.add("M.Phil in Electrical Engineering");


                List<String> ChildDetails4 = new ArrayList<String>();
                ChildDetails4.add("Phd in Computer Sciences");
               // ChildDetails4.add("Phd in Software Engineering");
                ChildDetails4.add("Phd in Telecommunication");
                ChildDetails4.add("Phd in Electronics Engineering");
              //  ChildDetails4.add("Phd in Electrical Engineering");

                HeaderDetails.put("Bachelors", ChildDetails1);
                HeaderDetails.put("Masters", ChildDetails2);
                HeaderDetails.put("M.Phil", ChildDetails3);
                HeaderDetails.put("Phd", ChildDetails4);

                

                return  HeaderDetails;

        }
    }


  
