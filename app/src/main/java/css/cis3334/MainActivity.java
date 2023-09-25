package css.cis3334;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity
{
    EditText totalBill;
    EditText numPeople;
    CheckBox outstandingService;
    TextView totalTipText;
    TextView tipPerPersonText;
    public static final double NORMAL_TIP_RATE = 0.15;
    public static final double OUTSTANDING_TIP_RATE = 0.20;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        totalBill = findViewById(R.id.editTextNumberDecimalBillAmount);
        numPeople = findViewById(R.id.enterNumberPlainTextDecimal);
        outstandingService = findViewById(R.id.checkBoxOutstandingService);
        totalTipText = findViewById(R.id.totalTipAmount);
        tipPerPersonText = findViewById(R.id.tipPerPersonAmount);


        Button calculateBtn = findViewById(R.id.calculatorTIpButton);
        calculateBtn.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view)
            {
                double bill = Double.parseDouble(totalBill.getText().toString());
                int people = Integer.parseInt(numPeople.getText().toString());

                // This sets the tip rate to 0.20 if the outstanding service checkbox is check, otherwise sets it to 0.15
                double tipRate = outstandingService.isChecked() ? OUTSTANDING_TIP_RATE : NORMAL_TIP_RATE;


                // These calculate the total tip amount and the tip per person
                double totalTip = bill * tipRate;
                double tipPerPerson = totalTip / people;

                // Formats the total tip as currency and display it in the "totalTipText" TextView
                totalTipText.setText(NumberFormat.getCurrencyInstance().format(totalTip));

                //Formats the Tip per person as currency and display it in the "tipPerPersonText" TextView
                tipPerPersonText.setText(NumberFormat.getCurrencyInstance().format(tipPerPerson));
            }
        });
    }

//new cheanges test 2
}