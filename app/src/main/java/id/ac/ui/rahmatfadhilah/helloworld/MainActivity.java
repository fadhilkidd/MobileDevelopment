package id.ac.ui.rahmatfadhilah.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void onClick(View view) {
        TextView text = (TextView) findViewById(R.id.greeting);
        if (isHelloWorld(text.getText().toString())) {
            text.setText(R.string.welcoem);
        } else {
            text.setText(R.string.helloworld);
        }
    }

    public boolean isHelloWorld(String text) {
        if (text.equals("HELLO WORLD!")) {
            return true;
        }
        return false;
    }
}