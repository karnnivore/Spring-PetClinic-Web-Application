package ca.georgebrown.comp3074.lab3;

import android.app.ListActivity;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends ListActivity {

    //String[] list = {"Android", "iOS", "Symbian"};
    ItemArrayAdapter adapter;
    List<Item> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        list = new ArrayList<Item>();
        list.add(new Item("Bread", 0, android.R.drawable.ic_input_add));
        list.add(new Item("Milk", 0, android.R.drawable.ic_input_add));
        list.add(new Item("Juice", 0, android.R.drawable.ic_input_add));
        list.add(new Item("Chicken", 0, android.R.drawable.ic_input_add));
        list.add(new Item("Beef", 0, android.R.drawable.ic_input_add));
        list.add(new Item("Ice Cream", 0, android.R.drawable.ic_input_add));
        list.add(new Item("Ramen", 0, android.R.drawable.ic_input_add));
        adapter = new ItemArrayAdapter(this,
                //android.R.layout.simple_list_item_1, android.R.id.text1, list) //using predefined layout
                R.layout.row_layout, R.id.large_text, R.id.small_text, R.id.testIcon, list); //using custom layout
        setListAdapter(adapter);
    }


    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        super.onListItemClick(l, v, position, id);
        list.get(position).setSmallText(1);
        //list.set(position, list);
        Toast.makeText(this, "Item " + position + " was selected: " +
                list.get(position).getLargeText() + " Small Text: "+list.get(position).getSmallText()+ " id" + id,
                Toast.LENGTH_LONG).show();
        adapter.notifyDataSetChanged();

    }


}