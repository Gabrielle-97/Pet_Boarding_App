package sg.edu.rp.c346.id19020303.petboardingapp;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;

import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.EventListener;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.FirebaseFirestoreException;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class MainActivity extends AppCompatActivity {
    EditText etName, etDays, etBoardingDate;
    CheckBox cbVaccinated;
    Spinner petSpinner;
    Button btnSendRequest;

    private FirebaseFirestore db;
    private CollectionReference colRef;
    private DocumentReference docRef;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etName = findViewById(R.id.editTextName);
        etDays = findViewById(R.id.editTextNumberOfDays);
        etBoardingDate = findViewById(R.id.editTextBoardingDate);
        cbVaccinated = findViewById(R.id.checkBoxVaccinated);
        petSpinner = findViewById(R.id.pets_spinner);
        btnSendRequest = findViewById(R.id.btnSend);

        db = FirebaseFirestore.getInstance();
        colRef = db.collection("petboardinginformation");
        docRef = colRef.document("petboarding");


        btnSendRequest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String date = etBoardingDate.getText().toString();

                Date boardDate = null;

                try{
                    boardDate = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss").parse(date);
                } catch (ParseException e) {
                    e.printStackTrace();
                }

                String name = etName.getText().toString();
                Integer numDays = Integer.parseInt(etDays.getText().toString());
                String petType = petSpinner.getSelectedItem().toString();
                Boolean vaccinated = cbVaccinated.isChecked();

                Message msg = new Message(name, petType, boardDate, vaccinated, numDays);
                docRef.set(msg);
            }

        });


    }


}