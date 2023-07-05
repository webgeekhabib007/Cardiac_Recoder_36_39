package com.example.cardiac_recoder_36_39;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.cardiac_recoder_36_39.model.CardiacModel;
import com.google.gson.Gson;

/**
 * This class is used to create
 * the form for the user to
 * give input.
 * @version 1.0
 * @since 2020-03-08
 */
public class AddActivity extends AppCompatActivity {

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;
    //ArrayList<CardiacModel> dataArrayList;
    Gson gson;

    EditText date_input,time_input,systolic_input,diastolic_input,heartrate_input,comment_input;
    String date, time, systolic, diastolic, heartrate, comment;
    Button save_button;
    CardiacModel cardiacModel;

    /**
     *  creating form where user give
     *  input.
     * @param savedInstanceState
     */

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        //readData();

        date_input = findViewById(R.id.dateValue);
        time_input = findViewById(R.id.timeValue);
        systolic_input = findViewById(R.id.systolicValue);
        diastolic_input = findViewById(R.id.diastolicValue);
        heartrate_input = findViewById(R.id.heartRateValue);
        comment_input = findViewById(R.id.commentValue);
        save_button = findViewById(R.id.addButton);

        /**
         * button for save the data to
         * the database
         */
        save_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                inputFormat();
//
            }
        });

    }

    /**
     * This method is used to
     * check the input format
     * and save the data to
     * the database.
     * @return void
     * @exception NumberFormatException
     * @see NumberFormatException
     * @see TextUtils
     */
    private void inputFormat() {
        if(!TextUtils.isEmpty(time_input.getText())) {
            if (!TextUtils.isEmpty(date_input.getText())) {
                if ((Integer.parseInt(systolic_input.getText().toString()) >= 0) && (Integer.parseInt(systolic_input.getText().toString()) <= 200) && (!TextUtils.isEmpty(systolic_input.getText()))) {
                    if ((Integer.parseInt(diastolic_input.getText().toString()) >= 0) && (Integer.parseInt(diastolic_input.getText().toString()) <= 150) && (!TextUtils.isEmpty(diastolic_input.getText()))) {
                        if ((Integer.parseInt(heartrate_input.getText().toString()) >= 0) && (Integer.parseInt(heartrate_input.getText().toString()) <= 150) && (!TextUtils.isEmpty(heartrate_input.getText()))) {

                            date = date_input.getText().toString();
                            time = time_input.getText().toString();
                            systolic = systolic_input.getText().toString();
                            diastolic = diastolic_input.getText().toString();
                            heartrate = heartrate_input.getText().toString();
                            comment = comment_input.getText().toString();
                            cardiacModel = new CardiacModel(date, time, systolic, diastolic, heartrate, comment);
                            new DataList().addRecord(cardiacModel);
                            //jamiArray.add(modelclass);
                            PreferenceManager.getDefaultSharedPreferences(AddActivity.this).edit().clear().commit();
                            writeData();
                            //RecordList.mcl.add(modelclass);
                            ListActivity.customAdapter.notifyDataSetChanged();
                            Toast.makeText(AddActivity.this, "Data Insertion Successful", Toast.LENGTH_LONG).show();


                            finish();

                        } else {
                            heartrate_input.setError("Invalid range ");

                            // Toast.makeText(DataEntry.this, "Invalid data format added", Toast.LENGTH_LONG).show();

                        }

                    } else {
                        diastolic_input.setError("Invalid range");
                        //Toast.makeText(DataEntry.this, "Invalid data format added", Toast.LENGTH_LONG).show();
                    }
                } else {
                    systolic_input.setError("Invalid range");
                    //Toast.makeText(DataEntry.this, "Invalid data format added", Toast.LENGTH_LONG).show();
                }
            } else {
                date_input.setError("The field must be required");
            }
        }
        else{
            time_input.setError("The field must be required");
        }
    }

    /**
     * This method is used to
     * write the data to the
     * database.
     * @return void
     */
    private void writeData() {
        sharedPreferences = getSharedPreferences("Habib",MODE_PRIVATE);
        editor = sharedPreferences.edit();
        gson = new Gson();
        String jsonString = gson.toJson(DataList.array);
        editor.putString("Talha",jsonString);
        editor.apply();
    }
}