package fr.wcs.programmationnonbloquante;

import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.Timer;
import java.util.TimerTask;



import static android.os.SystemClock.sleep;


public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button0 = findViewById(R.id.button0);
        Button button1 = findViewById(R.id.button1);
        Button button2 = findViewById(R.id.button2);
        Button button3 = findViewById(R.id.button3);
        Button button4 = findViewById(R.id.button4);
        Button button5 = findViewById(R.id.button5);
        Button button6 = findViewById(R.id.button6);
        Button button7 = findViewById(R.id.button7);
        Button button8 = findViewById(R.id.button8);
        Button button9 = findViewById(R.id.button9);

        button0.setOnClickListener(this);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
        button8.setOnClickListener(this);
        button9.setOnClickListener(this);

        TextView floorCount = findViewById(R.id.floor_count);

    }
    private boolean isLiftMoving = false;
    private int currentFloor = 0;

    @Override
    public void onClick(View v){
        switch(v.getId()){
            case R.id.button0 :
                goToFloor(0);
                break;
            case R.id.button1 :
                goToFloor(1);
                break;
            case R.id.button2 :
                goToFloor(2);
                break;
            case R.id.button3 :
                goToFloor(3);
                break;
            case R.id.button4 :
                goToFloor(4);
                break;
            case R.id.button5 :
                goToFloor(5);
                break;
            case R.id.button6 :
                goToFloor(6);
                break;
            case R.id.button7 :
                goToFloor(7);
                break;
            case R.id.button8 :
                goToFloor(8);
                break;
            case R.id.button9 :
                goToFloor(9);
                break;
            default:
                break;
        }

    }

    private void goToFloor(int floor) {
        if (!isLiftMoving && floor != currentFloor) {
            moveNextFloor(floor);
            isLiftMoving = false;
        }
    }

    private void moveNextFloor(int floor) {
        if (floor != currentFloor) {
            isLiftMoving = true;
            waitForIt();
            currentFloor = (floor > currentFloor) ? currentFloor + 1 : currentFloor - 1;
            TextView floorCount = (TextView) findViewById(R.id.floor_count);
            floorCount.setText(String.valueOf(currentFloor));
            moveNextFloor(floor);
        }
    }

    private void waitForIt() {
        MoveLift mMoveLift = new MoveLift();
        mMoveLift.execute();
    }
}
