package bdyb.fitpalmobile.activity;

import android.app.Activity;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.RadioButton;

import bdyb.fitpalmobile.R;

/**
 * Created by BDyb on 2017-06-27.
 */

public class KcalActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.kcal_activity);
    }

    public void handleDisplayButton(View view) {
        RadioButton radioLow = (RadioButton) findViewById(R.id.kcal_radioLow);
        RadioButton radioMeidum = (RadioButton) findViewById(R.id.kcal_radioMedium);
        RadioButton radioHigh = (RadioButton) findViewById(R.id.kcal_radioHigh);

        if (radioLow.isChecked())
            System.out.println("LOW");
        else if (radioMeidum.isChecked())
            System.out.println("MEDIUM");
        else if (radioHigh.isChecked())
            System.out.println("HIGH");
    }
}
