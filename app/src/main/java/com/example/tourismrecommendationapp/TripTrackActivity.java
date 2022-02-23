package com.example.tourismrecommendationapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.ContextCompat;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;

import ernestoyaquello.com.verticalstepperform.VerticalStepperFormLayout;
import ernestoyaquello.com.verticalstepperform.interfaces.VerticalStepperForm;

public class TripTrackActivity extends AppCompatActivity implements VerticalStepperForm{

    VerticalStepperFormLayout verticalStepperForm;

    EditText name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trip_track);

        String[] mySteps = {"First Place", "Second Place", "Third Place"};
        int colorPrimary = ContextCompat.getColor(getApplicationContext(), R.color.colorPrimary);
        int colorPrimaryDark = ContextCompat.getColor(getApplicationContext(), R.color.colorPrimaryDark);

        // Finding the view
        verticalStepperForm = (VerticalStepperFormLayout) findViewById(R.id.vertical_stepper_form);

        // Setting up and initializing the form
        VerticalStepperFormLayout.Builder.newInstance(verticalStepperForm, mySteps, this, this)
                .primaryColor(colorPrimary)
                .primaryDarkColor(colorPrimaryDark)
                .displayBottomNavigation(true) // It is true by default, so in this case this line is not necessary
                .init();
    }

    @Override
    public View createStepContentView(int stepNumber) {
        View view = null;
        switch (stepNumber) {
            case 0:
                view = createNameStep();
                break;
            case 1:
                view = createEmailStep();
                break;
            case 2:
                view = createPhoneNumberStep();
                break;
        }
        return view;
    }

    @Override
    public void onStepOpening(int stepNumber) {
        switch (stepNumber) {
            case 0:
                checkName();
                break;
            case 1:
//                checkName(stepNumber);
                break;
            case 2:
                // As soon as the phone number step is open, we mark it as completed in order to show the "Continue"
                // button (We do it because this field is optional, so the user can skip it without giving any info)
                verticalStepperForm.setStepAsCompleted(2);
                // In this case, the instruction above is equivalent to:
                // verticalStepperForm.setActiveStepAsCompleted();
                break;
        }
    }

    @Override
    public void sendData() {

    }

    private View createNameStep() {
        // Here we generate programmatically the view that will be added by the system to the step content layout
        name = new EditText(this);
        name.setSingleLine(true);
        name.setHint("First Place");
        name.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                checkName();
            }
        });
        return name;
    }

    private View createEmailStep() {
        // In this case we generate the view by inflating a XML file
        LayoutInflater inflater = LayoutInflater.from(getBaseContext());
        RelativeLayout emailLayoutContent = (RelativeLayout) inflater.inflate(R.layout.select_palce_for_track_step, null, false);
        EditText email = (EditText) emailLayoutContent.findViewById(R.id.email);

        return emailLayoutContent;
    }

    private View createPhoneNumberStep() {
        LayoutInflater inflater = LayoutInflater.from(getBaseContext());
        RelativeLayout phoneLayoutContent = (RelativeLayout) inflater.inflate(R.layout.select_palce_for_track_step, null, false);

        return phoneLayoutContent;
    }
    private void checkName() {

        if(name.length() >= 3 && name.length() <= 40) {
            verticalStepperForm.setActiveStepAsCompleted();
        } else {
            // This error message is optional (use null if you don't want to display an error message)
            String errorMessage = "The name must have between 3 and 40 characters";
            verticalStepperForm.setActiveStepAsUncompleted(errorMessage);
        }
    }





}