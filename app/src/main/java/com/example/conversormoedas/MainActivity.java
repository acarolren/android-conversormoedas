package com.example.conversormoedas;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private viewHolder mViewHolder = new viewHolder();

    @Override
    // metodo que cria a activity
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.mViewHolder.editValue = findViewById(R.id.edit_value);
        this.mViewHolder.textDolar = findViewById(R.id.text_dolar);
        this.mViewHolder.textEuro = findViewById(R.id.text_euro);
        this.mViewHolder.textPeso = findViewById(R.id.text_peso);
        this.mViewHolder.buttonCalculate = findViewById(R.id.button_calculate);
        // callbutton1
        /*this.mViewHolder.buttonCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //codigo
            }
        });*/
        // callbutton2 - classe precisa implementar interface
        this.mViewHolder.buttonCalculate.setOnClickListener(this);
        this.clearValues();
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.button_calculate){
            String value = this.mViewHolder.editValue.getText().toString();
            if("".equals(value)) {
                Toast.makeText(this, this.getString(R.string.informeValor), Toast.LENGTH_LONG).show();
            }else{
                Double real = Double.valueOf(value);
                this.mViewHolder.textDolar.setText(String.format("%.3f", (real * 5.35)));
                this.mViewHolder.textEuro.setText(String.format("%.3f", (real * 5.86)));
                this.mViewHolder.textPeso.setText(String.format("%.3f", (real * 0.078)));
            }
        }
    }

    // callbutton3
    /*public void teste(View view) {
        //codigo
    }*/



    /* ViewHolder - classe privada e estatica que contem todos os elementos de interface
                    que sao instanciados uma vez no onCreate()
                    faz com que findViewById nao seja chamado muitas vezes              */

    private static class viewHolder {
        EditText editValue;
        TextView textDolar;
        TextView textEuro;
        TextView textPeso;
        Button buttonCalculate;
    }
    private void clearValues(){
        this.mViewHolder.textDolar.setText("");
        this.mViewHolder.textEuro.setText("");
        this.mViewHolder.textPeso.setText("");
    }
}
