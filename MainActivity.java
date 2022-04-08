package com.example.unitconverter;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener
{
    EditText InputText;
    ImageButton metre, temp, kilogram;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Spinner menu = findViewById(R.id.dropdown_menu);
        menu.setOnItemSelectedListener(this);
        ArrayAdapter<CharSequence>adapter = ArrayAdapter.createFromResource(this,
                R.array.dropdown_menu, android.R.layout.simple_spinner_dropdown_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        menu.setAdapter(adapter);
    }

    public void onItemSelected(AdapterView<?> parent, View view, int position, long id)
    {
        InputText = findViewById(R.id.InputText);
        String spinnerInput = parent.getItemAtPosition(position).toString();

        TextView Textview1 = findViewById(R.id.Textview1);
        TextView Result1 = findViewById(R.id.Result1);
        TextView Textview2 = findViewById(R.id.Textview2);
        TextView Result2 = findViewById(R.id.Result2);
        TextView Textview3 = findViewById(R.id.Textview3);
        TextView Result3 = findViewById(R.id.Result3);

        metre = findViewById(R.id.metre);
        metre.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick (View view)
            {
                if (spinnerInput.equals("Metre"))
                {
                    float inputNum = Integer.parseInt(InputText.getText().toString());
                    Textview1.setText("Centimetre");
                    Result1.setText(String.format("%.2f", inputNum*100));
                    Textview2.setText("Foot");
                    Result2.setText(String.format("%.2f", inputNum*3.28));
                    Textview3.setText("Inch");
                    Result3.setText(String.format("%.2f", inputNum*39.37));
                }
                else{
                    Toast.makeText(getApplicationContext(), "Please select the correct conversion" +
                            "icon", Toast.LENGTH_SHORT).show();
                }
            }
        });

        temp = findViewById(R.id.temp);
        temp.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick (View view)
            {
                if (spinnerInput.equals("Celsius"))
                {
                    float inputNum = Integer.parseInt(InputText.getText().toString());
                    Textview1.setText("Fahrenheit");
                    Result1.setText(String.format("%.2f", (inputNum*9/5)*32));
                    Textview2.setText("Kelvin");
                    Result2.setText(String.format("%.2f", inputNum+273.15));
                    Textview3.setText("");
                    Result3.setText(String.format(""));
                }
                else{
                    Toast.makeText(getApplicationContext(), "Please select the correct conversion" +
                            "icon", Toast.LENGTH_SHORT).show();
                }
            }
        });

        kilogram = findViewById(R.id.kilogram);
        kilogram.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick (View view)
            {
                if (spinnerInput.equals("Kilogram"))
                {
                    float inputNum = Integer.parseInt(InputText.getText().toString());
                    Textview1.setText("Gram");
                    Result1.setText(String.format("%.2f", inputNum*1000));
                    Textview2.setText("Ounce(Oz)");
                    Result2.setText(String.format("%.2f", inputNum*35.27));
                    Textview3.setText("Pound(lb)");
                    Result3.setText(String.format("%.2f", inputNum*2.2));
                }
                else{
                    Toast.makeText(getApplicationContext(), "Please select the correct conversion" +
                            "icon", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public void onNothingSelected(AdapterView<?> parent){

    }
}