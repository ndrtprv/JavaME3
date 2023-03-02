package com.example.myapplication;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ExpandableListView;
import android.widget.SimpleExpandableListAdapter;

import java.util.*;

public class MainActivity extends Activity
        implements ExpandableListView.OnChildClickListener {

    private ArrayList<Group> groups = new ArrayList<>();
    final String TAG = "States";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createGroups();
        ExpandableListView expandableListView = findViewById(R.id.DemoListView);
        SimpleExpandableListAdapter expListAdapter =
                new SimpleExpandableListAdapter(
                        this,
                        createGroupList(),
                        R.layout.group_row,
                        new String[] { "Group Item" },
                        new int[] { R.id.row_name },

                        createChildList(),
                        R.layout.child_row,
                        new String[] { "Sub Item" },
                        new int[] { R.id.grp_child }
                );

        expandableListView.setAdapter(expListAdapter);
        expandableListView.setOnChildClickListener(this);
    }

    private void createGroups() {
        Group webGroup = new Group("Web");
        Group mapGroup = new Group("Map");
        Group phoneGroup = new Group("Phone");

        webGroup.addChild("Browser", WebActivity.class);
        mapGroup.addChild("Show object on map", MapActivity.class);
        phoneGroup.addChild("Telephone",PhoneActivity.class);

        groups.add(webGroup);
        groups.add(mapGroup);
        groups.add(phoneGroup);
    }

    @Override
    public boolean onChildClick(ExpandableListView parent,
                                View v, int groupPosition,
                                int childPosition, long id) {
        Group g = groups.get(groupPosition);

        Class<Activity> action = g.actions.get(childPosition);
        if (action != null) {
            Intent intent = new Intent(this, action);
            startActivity(intent);
        }

        return true;
    }

    private static class Group {

        String name;
        ArrayList<String> children = new ArrayList<>();
        ArrayList<Class<Activity>> actions = new ArrayList<>();

        private Group(String name) {
            this.name = name;
        }

        public void addChild(String name, Class action) {
            children.add(name);
            actions.add(action);
        }
    }

    private List<Map<String,String>> createGroupList() {
        List<Map<String,String>> res = new ArrayList<>();
        for (Group g: groups) {
            Map<String,String> map = new HashMap<>();
            map.put("Group Item",g.name);
            res.add(map);
        }
        return res;
    }

    private List<List<Map<String,String>>> createChildList() {
        List<List<Map<String,String>>> res = new ArrayList<>();
        for (Group g: groups) {
            List<Map<String,String>> tempList = new ArrayList<>();
            for (String s: g.children) {
                Map<String, String> map = new HashMap<>();
                map.put("Sub Item", s);
                tempList.add(map);
            }
            res.add(tempList);
        }
        return res;
    }

    public void onContentChanged() {
        super.onContentChanged();
        Log.i(TAG, "MainActivity: onContentChanged()");
    }
}