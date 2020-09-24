package ca.georgebrown.comp3074.lab3;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends ListActivity {

    //String[] list = {"Android", "iOS", "Symbian"};
    List<Item> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        list = new ArrayList<Item>();
        list.add(new Item("Android", "is cool", android.R.drawable.ic_media_play));
        list.add(new Item("iOS", "is next", android.R.drawable.ic_media_play));
        list.add(new Item("Symbian", "is old", android.R.drawable.ic_media_play));
        ItemArrayAdapter adapter = new ItemArrayAdapter(this,
                //android.R.layout.simple_list_item_1, android.R.id.text1, list) //using predefined layout
                R.layout.row_layout, R.id.large_text, R.id.small_text, R.id.testIcon, list); //using custom layout
        setListAdapter(adapter);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);

        Toast.makeText(this, "Item " + position + " was selected: " +
                list.get(position).getLargeText(),
                Toast.LENGTH_LONG).show();

    }
}