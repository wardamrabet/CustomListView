package com.mrabet.customlistview;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;


import java.util.ArrayList;
import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    protected ListView maListeView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        maListeView = findViewById(R.id.listviewperso);
        ArrayList<HashMap<String, String>> listItem = new ArrayList<>();
        HashMap<String,String> map;

        map =new HashMap<>();
        map.put("titre","word");
        map.put("description","ce-ci est word");
        map.put("img",String.valueOf(R.drawable.word));
        listItem.add(map);

        map =new HashMap<>();
        map.put("titre","powerpoint");
        map.put("description"," ce-ci est powerpoint");
        map.put("img",String.valueOf(R.drawable.powerpoint));
        listItem.add(map);

        map =new HashMap<>();
        map.put("titre","excel");
        map.put("description"," ce-ci est excel");
        map.put("img",String.valueOf(R.drawable.excel));
        listItem.add(map);

        map =new HashMap<>();
        map.put("titre","outlook");
        map.put("description"," ce-ci est outlook");
        map.put("img",String.valueOf(R.drawable.outlook));
        listItem.add(map);

        SimpleAdapter adapter =new SimpleAdapter(this.getBaseContext(),
                listItem,
                R.layout.activity_list_item,
                new String []{"titre","description","img"},
                new  int[]{R.id.titre,R.id.description,R.id.img});
        maListeView.setAdapter(adapter);
        maListeView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                HashMap<String,String> map = (HashMap<String, String>) maListeView.getItemAtPosition(position);
                Toast.makeText(MainActivity.this,map.get("titre"),Toast.LENGTH_LONG).show();
            }
        });
        maListeView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener(){

            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                HashMap<String,String> map = (HashMap<String, String>) maListeView.getItemAtPosition(position);
                AlertDialog.Builder adb = new AlertDialog.Builder(MainActivity.this);
                        adb.setTitle("Selected Item");
                        adb.setMessage("votre choix: " + map.get("titre"));
                        adb.setPositiveButton("ok",null);
                        adb.show();
                return true;
            }
        });



    }

}
