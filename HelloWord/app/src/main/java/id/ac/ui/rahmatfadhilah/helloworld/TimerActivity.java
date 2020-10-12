package id.ac.ui.rahmatfadhilah.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.CountDownTimer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

public class TimerActivity extends AppCompatActivity  {
    private static final long START_TIME_IN_MILLIS = 300000;
    Button timerButtonStart;
    Button timerButtonReset;
    TextView timerText;
    long timeLeftInMillis;
    long endTime;
    boolean timerOn;
    CountDownTimer timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.timer_activity);
        init();
    }

    protected void init() {
        timeLeftInMillis = START_TIME_IN_MILLIS;
        timerButtonStart = (Button) findViewById(R.id.timerButtonStart);
        timerButtonReset = (Button) findViewById(R.id.timerButtonReset);
        timerText = (TextView) findViewById(R.id.timerTimeText);

        updateStartButton();
        updateTimerText();
        prepareButtonListener();
        resetTimer();
    }

    protected void prepareButtonListener() {
        timer = new CountDownTimer(timeLeftInMillis, 1000){
            @Override
            public void onTick(long millisUntilFinished){
                updateTimerText();
            }
            public  void onFinish(){
                updateStartButton();
            }
        };

        timerButtonStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (timerOn) {
                    pauseTimer();
                } else {
                    startTimer();
                }
            }
        });

        timerButtonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetTimer();
            }
        });
    }

    protected void updateStartButton() {
        if (timeLeftInMillis > 0) {
            timerButtonStart.setEnabled(true);
        } else {
            timerButtonStart.setEnabled(false);
        }
    }

    protected void startTimer() {
        endTime = System.currentTimeMillis() + timeLeftInMillis;
        timer = new CountDownTimer(timeLeftInMillis, 1000){
            @Override
            public void onTick(long millisUntilFinished){
                timeLeftInMillis = millisUntilFinished;
                updateTimerText();

            }
            public  void onFinish(){
                timerText.setText("00:00");
                timerOn = false;
                updateStartButton();
            }
        }.start();
        timerOn = true;
        timerButtonStart.setText(R.string.pause_timer);
    }

    protected void pauseTimer() {
        timer.cancel();
        timerOn = false;
        timerButtonStart.setText(R.string.start_timer);
    }

    protected void resetTimer() {
        timeLeftInMillis = START_TIME_IN_MILLIS;
        timerOn = false;
        timerButtonStart.setText(R.string.start_timer);
        timer.cancel();
        updateStartButton();
        updateTimerText();
    }

    protected void updateTimerText() {
        int minutes = (int) (timeLeftInMillis / 1000) / 60;
        int seconds = (int) (timeLeftInMillis / 1000) % 60;
        String timeLeftFormatted = String.format(Locale.getDefault(), "%02d:%02d", minutes, seconds);
        timerText.setText(timeLeftFormatted);
    }

    @Override
    protected void onPause() {
        super.onPause();

        SharedPreferences prefs = getSharedPreferences("prefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();

        editor.putLong("millisLeft", timeLeftInMillis);
        editor.putBoolean("timerRunning", timerOn);
        editor.putLong("endTime", endTime);
        editor.apply();
        if (timer != null) {
            timer.cancel();
        }
    }

    @Override
    protected void onStop() {
        super.onStop();

        SharedPreferences prefs = getSharedPreferences("prefs", MODE_PRIVATE);
        SharedPreferences.Editor editor = prefs.edit();

        editor.putLong("millisLeft", timeLeftInMillis);
        editor.putBoolean("timerRunning", timerOn);
        editor.putLong("endTime", endTime);
        editor.apply();
        if (timer != null) {
            timer.cancel();
        }
    }

    @Override
    protected void onStart() {
        super.onStart();
        SharedPreferences prefs = getSharedPreferences("prefs", MODE_PRIVATE);
        timeLeftInMillis = prefs.getLong("millisLeft", START_TIME_IN_MILLIS);
        timerOn = prefs.getBoolean("timerRunning", false);
        updateTimerText();
        if (timerOn) {
            endTime = prefs.getLong("endTime", 0);
            timeLeftInMillis = endTime - System.currentTimeMillis();
            if (timeLeftInMillis < 0) {
                timeLeftInMillis = 0;
                timerOn = false;
                updateTimerText();
                updateStartButton();
            } else {
                startTimer();
            }
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        SharedPreferences prefs = getSharedPreferences("prefs", MODE_PRIVATE);
        timeLeftInMillis = prefs.getLong("millisLeft", START_TIME_IN_MILLIS);
        timerOn = prefs.getBoolean("timerRunning", false);
        updateTimerText();
        if (timerOn) {
            endTime = prefs.getLong("endTime", 0);
            timeLeftInMillis = endTime - System.currentTimeMillis();
            if (timeLeftInMillis < 0) {
                timeLeftInMillis = 0;
                timerOn = false;
                updateTimerText();
                updateStartButton();
            } else {
                startTimer();
            }
        }
    }
}