package ca.georgebrown.comp3074.lab22;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView myLabel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        myLabel = findViewById(R.id.my_label);

        myLabel.setText("onCreate was executed \n");

        Button btnMaps = findViewById(R.id.btn_maps);
        btnMaps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openMaps();
            }
        });

        Button btnActivity = findViewById(R.id.btn_activity);
        btnActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity();
            }
        });
    }

    private void openMaps() {
        //Uri location = Uri.parse("google.streetview:cbll:37.7749,-122.4194");
        //Uri location = Uri.parse("geo:37.7749,-122.4194");
        Uri location = Uri.parse("https://google.com");
        Intent openMap = new Intent(Intent.ACTION_VIEW, location);
        startActivity(openMap);
    }

    private void openActivity() {
        Intent start = new Intent(getApplicationContext(), SecondActivity.class);
        startActivity(start);
    }

    @Override
    protected void onStart() {
        super.onStart();
        String msg = myLabel.getText().toString();
        myLabel.setText(msg + "onStart was executed \n");
    }

    @Override
    protected  void onResume() {
        super.onResume();
        String msg = myLabel.getText().toString();
        myLabel.setText(msg + "onResume was executed \n");
    }

    @Override
    protected  void onPause() {
        super.onPause();
        String msg = myLabel.getText().toString();
        myLabel.setText(msg + "onPause was executed \n");
    }

    @Override
    protected  void onRestart() {
        super.onRestart();
        String msg = myLabel.getText().toString();
        myLabel.setText(msg + "onRestart was executed \n");
    }

    @Override
    protected  void onStop() {
        super.onStop();
        String msg = myLabel.getText().toString();
        myLabel.setText(msg + "onStop was executed \n");
    }

    @Override
    protected  void onDestroy() {
        String msg = myLabel.getText().toString();
        super.onDestroy();
        Log.d("GBC-LOG", msg +"onDestroy was executed");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inf = getMenuInflater();
        inf.inflate(R.menu.main_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.menu_activity:
                openActivity();
                return true;
            case R.id.menu_maps:
                openMaps();
                return true;
            default: return super.onOptionsItemSelected(item);
        }
    }
}