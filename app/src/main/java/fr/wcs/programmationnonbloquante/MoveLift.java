package fr.wcs.programmationnonbloquante;

import android.graphics.Bitmap;
import android.os.AsyncTask;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import static android.os.SystemClock.sleep;

public class MoveLift extends AsyncTask {


    @Override
    protected void onPreExecute() {
        super.onPreExecute();

    }


    @Override
    protected Object doInBackground(Object[] objects) {
        sleep(3000);
        floorCount.setText(this);
    }


    @Override
    protected void onProgressUpdate(Object[] values) {
        super.onProgressUpdate(values);
    }

    @Override
    protected void onPostExecute(Object o) {
        super.onPostExecute(o);
    }


}
