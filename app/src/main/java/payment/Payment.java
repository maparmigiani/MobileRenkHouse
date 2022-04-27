package payment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import com.example.maiaraalmeida_comp304_lab2_exerc01.R;

public class Payment extends AppCompatActivity {

    String homeId;
    TextView txtFood, txtSport;
    Button btnPay,btnInfo;
    RadioButton radCash, radCredit, radDebit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);
        txtFood = findViewById(R.id.txtFood);
        txtSport = findViewById(R.id.txtSport);
        btnPay = findViewById(R.id.btnPayMethod);
        btnInfo = findViewById(R.id.btnSend);
        radCash = findViewById(R.id.rBtnChash);
        radCredit = findViewById(R.id.rBtnDebit);
        radDebit = findViewById(R.id.rBtnCredit);
        Intent intent= getIntent();
        Bundle b = intent.getExtras();

        if(b!=null)
        {
            homeId =(String) b.get("HOME_ID");
        }

        //Event listeners
        btnPay.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if(radCash.isChecked() == false){
                    Intent intent;
                    intent = new Intent(getApplicationContext(), CardInfo.class);
                    intent.putExtra("HOME_ID", homeId);
                    startActivity(intent);
                } else {
                    Toast.makeText(getApplicationContext(),"All set for your house", Toast.LENGTH_SHORT).show();
                }

            }
        });
        btnInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(getApplicationContext(),"Thank you for the Information", Toast.LENGTH_SHORT).show();
            }
        });


    }
}