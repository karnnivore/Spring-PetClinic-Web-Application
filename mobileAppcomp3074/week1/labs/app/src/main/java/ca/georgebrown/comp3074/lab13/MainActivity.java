package ca.georgebrown.comp3074.lab13;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final TextView myLabel = findViewById(R.id.my_label);
        myLabel.setText(R.string.label_def_text);

        final EditText myEdit = findViewById(R.id.edit_name);
        Button myButton = findViewById(R.id.button_apply);

        myButton.setOnClickListener(new View.OnClickListener(){
        @Override
        public void onClick(View v) {
            String msg = myEdit.getText().toString();
            myLabel.setText(msg);
        }

        });
    }
}
