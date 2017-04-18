package br.com.calculodearea;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinner = (Spinner) findViewById(R.id.spinner);
        List<String> categories = new ArrayList<String>();
        categories.add("Triângulo");
        categories.add("Retangulo");
        categories.add("Quadrado");
        categories.add("Circulo");

        // Creating adapter for spinner
        ArrayAdapter<String> dataAdapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, categories);

        // Drop down layout style - list view with radio button
        dataAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // attaching data adapter to spinner
        spinner.setAdapter(dataAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            EditText altura = (EditText) findViewById(R.id.altura);
            EditText base = (EditText) findViewById(R.id.base);
            EditText raio = (EditText) findViewById(R.id.raio);
            TextView resultado = (TextView) findViewById(R.id.resultado);
            Button calcular = (Button) findViewById(R.id.calcular);

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                if (position == 0) {
                    base.setVisibility(View.VISIBLE);
                    altura.setVisibility(View.VISIBLE);

                    raio.setVisibility(View.INVISIBLE);
                    calcular.setVisibility(View.VISIBLE);
                    calcular.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View v) {

                            Double calculo = Double.parseDouble(base.getText().toString()) * Double.parseDouble(altura.getText().toString()) / 2;
                            resultado.setText(calculo.toString());

                            altura.setText("");
                            base.setText("");
                        }
                    });
                } else if (position == 1) {
                    altura.setVisibility(View.VISIBLE);
                    base.setVisibility(View.VISIBLE);


                    raio.setVisibility(View.INVISIBLE);

                   calcular.setOnClickListener(new View.OnClickListener() {
                       @Override
                       public void onClick(View v) {
                           resultado.setText("" + Double.parseDouble(altura.getText().toString()) * Double.parseDouble(base.getText().toString()));
                       }
                   });
                } else if (position == 2) {
                    altura.setVisibility(View.VISIBLE);
                    base.setVisibility(View.INVISIBLE);
                    raio.setVisibility(View.INVISIBLE);
                   calcular.setOnClickListener(new View.OnClickListener() {
                       @Override
                       public void onClick(View v) {
                           double r = Double.parseDouble(altura.getText().toString()) * Double.parseDouble(altura.getText().toString());
                           resultado.setText("" + r);
                       }
                   });
                } else if (position == 3) {
                    altura.setVisibility(View.INVISIBLE);
                    base.setVisibility(View.INVISIBLE);
                    raio.setVisibility(View.VISIBLE);

                  calcular.setOnClickListener(new View.OnClickListener() {
                      @Override
                      public void onClick(View v) {
                          Double r = Double.parseDouble(raio.getText().toString());
                          r = r * r;
                          resultado.setText("" + r*3.14);
                      }
                  });
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }


}
