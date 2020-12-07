package id.ac.ui.rahmatfadhilah.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    static {
        System.loadLibrary("cpp_code");
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView greeting = findViewById(R.id.greeting);
        greeting.setText(echo());
    }

    public native String echo();

    public void onTimerButtonClick(View view) {
        Intent intent = new Intent(this, TimerActivity.class);
        this.startActivity(intent);
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

    @Override
    public void onBackPressed() {
        Toast.makeText(MainActivity.this, "Klik tombol exit untuk keluar!", Toast.LENGTH_LONG).show();
    }

    public void onExitButtonClicked(View view) {
        super.onDestroy();
    }
}