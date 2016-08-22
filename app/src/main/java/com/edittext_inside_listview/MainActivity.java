package com.edittext_inside_listview;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {
    private ListView mSamplelist;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.samplelistitems);
        mSamplelist=(ListView)findViewById(R.id.samplelist);
        mSamplelist.setAdapter(new List_Comments(getApplicationContext()));
    }

    public class List_Comments extends BaseAdapter {

        private Context context;
        viewHold viewholder = null;
        public ArrayList<ListItem> myItems = new ArrayList<ListItem>();
        // Constructor to initialize values
        public List_Comments(Context context) {
            for (int i = 0; i < 20; i++) {
                ListItem listItem = new ListItem();
                listItem.caption = "Input" + i;
                myItems.add(listItem);
            }
            notifyDataSetChanged();
            this.context = context;

        }

        @Override
        public int getCount() {
            return myItems.size();
        }


        @Override
        public Object getItem(int position) {

            return position;
        }

        @Override
        public long getItemId(int position) {

            return position;
        }

        // Number of times getView method call depends upon MCategories.length

        public View getView(final int position, View convertView,
                            ViewGroup parent) {
            // LayoutInflator to call external grid_item.xml file
            LayoutInflater inflater = (LayoutInflater) context
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            if (convertView == null) {
                viewholder = new viewHold();
                convertView = new View(context);
                convertView = inflater.inflate(R.layout.activity_main, null);
                viewholder.caption=(EditText)convertView.findViewById(R.id.viewedit) ;
                convertView.setTag(viewholder);

            } else {
                viewholder = (viewHold) convertView.getTag();
            }
                viewholder.caption.setText((myItems.get(position).caption));
                viewholder.caption.setId(position);
                viewholder.caption.setOnFocusChangeListener(new View.OnFocusChangeListener() {
                    public void onFocusChange(View v, boolean hasFocus) {
                        if (!hasFocus){
                            final int position = v.getId();
                            final EditText Caption = (EditText) v;
                            myItems.get(position).caption = Caption.getText().toString();
                        }
                    }
                });
            return convertView;
        }
        class viewHold {
            public EditText caption;
        }
        class ListItem {
            public String caption;
        }
    }
}
