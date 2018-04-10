package com.cam.evento;

import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import com.cam.evento.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final EditText etNombre = (EditText)findViewById(R.id.etNombre);
        Button btBoton1 = (Button) findViewById(R.id.btBoton1);
        //Agregando manejador de evento en la creacion.
        btBoton1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this,  etNombre.getText().toString(), Toast.LENGTH_SHORT).show();
            }
        });

        Button btBoton3=(Button) findViewById(R.id.btBoton3);
        //agregar manejador de evento, sin crear uno nuevo, asignando a la clase MainActivity el tener que manejarlo
        //esto obliga a la clase MainActivity tenga implementado en onclicklistener, y que la clase tenga un metodo click
        btBoton3.setOnClickListener(this);


    }



    //metodo para responder al click
    @Override
    public void onClick(View v)
    {
        //el boton 2 al darle click va a invocar este metodo, gracias a la propiedad onclick del xml
        //ahora el boton 3 tambien termina invocando este mismo metodo, pero no queremos que revise lo mismo que el boton 2.
        if(v.getId()==R.id.btBoton3)
        {
            //el objeto v contiene en la clase generica, el boton o control que invoco el evento, y lo diferencia con el id
            Spinner spBoton=(Spinner) findViewById(R.id.spNombres);
            Toast.makeText(this, spBoton.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
        }
        else if(v.getId()==R.id.btBoton4)
        {
            //para obtener el radio seleccionado, se trabaja desde el grupo de radios
            RadioGroup rgGrupo= (RadioGroup) findViewById(R.id.rgGrupo);
            RadioButton rbSelec=(RadioButton) findViewById(rgGrupo.getCheckedRadioButtonId()); // se obtiene el id del seleccionado
            Toast.makeText(this, rbSelec.getText().toString(), Toast.LENGTH_SHORT).show();
        }
        CheckBox cbAceptar= (CheckBox) findViewById(R.id.cbAceptar);
        Toast.makeText(this, String.valueOf(cbAceptar.isChecked()), Toast.LENGTH_SHORT).show();
    }
}
