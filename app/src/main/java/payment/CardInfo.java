package payment;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.maiaraalmeida_comp304_lab2_exerc01.R;

public class CardInfo extends AppCompatActivity {

    EditText txtFirstName, txtLastName, txtCVV, txtMonth, txtYear;
    Button btnApplyTransaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_info);
        txtFirstName = findViewById(R.id.txtFirstName);
        txtLastName = findViewById(R.id.txtLastName);
        txtCVV = findViewById(R.id.txtCVV);
        txtMonth = findViewById(R.id.txtMonth);
        txtYear = findViewById(R.id.txtYear);
        btnApplyTransaction = findViewById(R.id.btnApplyTransaction);

        int maxMonth = 12;
        int minMonth = 1;

        int minYear = 2021;
        int maxYear = 2030;

        int maxCVV=999;
        int minCVV = 100;


        btnApplyTransaction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"clicked", Toast.LENGTH_SHORT).show();
                if(txtFirstName.getText()==null||
                        txtLastName.getText()==null||
                        txtCVV.getText()==null||
                        txtMonth.getText()==null||
                        txtYear.getText()==null){
                    Toast.makeText(getApplicationContext(),"Fill all the fields to proceed with the rent, please", Toast.LENGTH_SHORT).show();
                } else {
                    try {
                        int month = Integer.valueOf(txtMonth.getText().toString());
                        int year = Integer.valueOf(txtYear.getText().toString());
                        int cvv = Integer.valueOf(txtCVV.getText().toString());
                        if (month > maxMonth || month < minMonth) {
                            Toast.makeText(getApplicationContext(), "Month out of range, please type a valid month", Toast.LENGTH_SHORT).show();
                        } else if (year > maxYear || year < minYear) {
                            Toast.makeText(getApplicationContext(), "Year out of range, please type a valid Year", Toast.LENGTH_SHORT).show();
                        }else if (cvv > maxCVV || cvv < minCVV) {
                            Toast.makeText(getApplicationContext(), "Year out of range, please type a valid CVV", Toast.LENGTH_SHORT).show();
                        } else {
                            Toast.makeText(getApplicationContext(), "Thanks for your rent", Toast.LENGTH_SHORT).show();
                        }
                    } catch (Exception e){
                        Toast.makeText(getApplicationContext(), "Please type only valid numbers", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}