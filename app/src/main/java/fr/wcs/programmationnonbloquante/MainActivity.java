package fr.wcs.programmationnonbloquante;


import android.os.AsyncTask;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;



public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private boolean isLiftMoving = false;
    private int currentFloor = 0;
    private int floor;


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


    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.button0:
                goToFloor(0);
                break;
            case R.id.button1:
                goToFloor(1);
                break;
            case R.id.button2:
                goToFloor(2);
                break;
            case R.id.button3:
                goToFloor(3);
                break;
            case R.id.button4:
                goToFloor(4);
                break;
            case R.id.button5:
                goToFloor(5);
                break;
            case R.id.button6:
                goToFloor(6);
                break;
            case R.id.button7:
                goToFloor(7);
                break;
            case R.id.button8:
                goToFloor(8);
                break;
            case R.id.button9:
                goToFloor(9);
                break;
            default:
                break;
        }

    }


    private void goToFloor(int floor) {
        MoveLift mMoveLift = new MoveLift();
        mMoveLift.execute(floor);
    }


    private class MoveLift extends AsyncTask<Integer, Integer, Integer> {

        TextView floorCount = (TextView) findViewById(R.id.floor_count);


        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }


        @Override
        protected Integer doInBackground(Integer... integers) {

            floor = integers[0];

            if (!isLiftMoving && floor != currentFloor) {
                isLiftMoving = true;

                while (currentFloor != floor) {

                    currentFloor = (floor > currentFloor) ? currentFloor + 1 : currentFloor - 1;
                    try {
                        Thread.sleep(3000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    publishProgress(currentFloor);
                }
            }
            isLiftMoving = false;
            return currentFloor;
        }

        @Override
        protected void onProgressUpdate(Integer ... values) {
            floorCount.setText(String.valueOf(values[0]));
        }

        @Override
        protected void onPostExecute(Integer currentFloor) {
        }
    }
}








