package net.mk05.editacontactos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            Bundle datos = getIntent().getExtras().getBundle("contacto");
            String textos[] = datos.getStringArray("textosContacto");
            ArrayList<Integer> fechNac = datos.getIntegerArrayList("fechNac");
            DatePicker dp = (DatePicker)findViewById(R.id.cntFechaNacimiento);

            ((TextView)findViewById(R.id.cntNombre)).setText(textos[0]);
            dp.updateDate(fechNac.get(0), fechNac.get(1), fechNac.get(2));
            ((TextView)findViewById(R.id.cntTelefono)).setText(textos[1]);
            ((TextView)findViewById(R.id.cntEmail)).setText(textos[2]);
            ((TextView)findViewById(R.id.cntDesc)).setText(textos[3]);

        } catch (Exception e) {
            // Simplemente no hacemos nada...
        }

        final Button btnSiguiente = (Button) findViewById(R.id.btnSig);
        btnSiguiente.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                DatePicker dp = (DatePicker)findViewById(R.id.cntFechaNacimiento);
                String datosContacto[] = new String[] {((TextView)findViewById(R.id.cntNombre)).getText().toString(),
                        ((TextView)findViewById(R.id.cntTelefono)).getText().toString(),
                        ((TextView)findViewById(R.id.cntEmail)).getText().toString(),
                        ((TextView)findViewById(R.id.cntDesc)).getText().toString()};
                ArrayList<Integer> fecha = new ArrayList<Integer>();
                fecha.add(dp.getYear());
                fecha.add(dp.getMonth());
                fecha.add(dp.getDayOfMonth());

                Bundle esteContacto = new Bundle();
                esteContacto.putStringArray("textosContacto", datosContacto);
                esteContacto.putIntegerArrayList("fechNac", fecha);

                startActivity(new Intent(MainActivity.this, FichaActivity.class).putExtra("contacto", esteContacto));
            }
        });
    }
}
