package bhakadekailas.backgroundtaskdemo;

import android.os.AsyncTask;
import android.util.Log;


class BackgroundTask extends AsyncTask<Void, Integer, String> {
    private final String TAG = BackgroundTask.class.getSimpleName();

    @Override
    protected void onPreExecute() {
        super.onPreExecute();
        Log.e(TAG, "onPreExecute: ");
    }

    @Override
    protected String doInBackground(Void... args) {
        Log.e(TAG, "doInBackground: ");
        for (int i = 0; i < 10; i++) {
            Integer in = new Integer(i);
            publishProgress(i);
        }
        return "You are at PostExecute";
    }

    protected void onProgressUpdate(Integer... a) {
        super.onProgressUpdate(a);
        Log.e(TAG + " onProgressUpdate", "You are in progress update ... " + a[0]);
    }


    @Override
    protected void onPostExecute(String s) {
        Log.e(TAG, "onPostExecute: ");
        super.onPostExecute(s);
        Log.e(TAG, "onPostExecute: " + s);
    }
}
