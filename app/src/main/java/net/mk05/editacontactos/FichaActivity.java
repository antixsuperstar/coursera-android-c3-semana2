package net.mk05.editacontactos;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import java.util.ArrayList;

public class FichaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ficha);

        Bundle datos = getIntent().getExtras().getBundle("contacto");
        ArrayList<Integer> fecha = datos.getIntegerArrayList("fechNac");
        String esteContacto[] = datos.getStringArray("textosContacto");

        ((TextView)findViewById(R.id.txtNombre)).setText(esteContacto[0]);
        ((TextView)findViewById(R.id.txtFechaNac0)).setText(fecha.get(0).toString());
        ((TextView)findViewById(R.id.txtFechaNac1)).setText(fecha.get(1).toString());
        ((TextView)findViewById(R.id.txtFechaNac2)).setText(fecha.get(2).toString());
        ((TextView)findViewById(R.id.txtTelefono)).setText(esteContacto[1]);
        ((TextView)findViewById(R.id.txtEmail)).setText(esteContacto[2]);
        ((TextView)findViewById(R.id.txtDesc)).setText(esteContacto[3]);

        ((Button)findViewById(R.id.btnEditarDatos)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onBackPressed();
            }
        });
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        Intent intent = new Intent();
        intent.putExtra("contacto", getIntent().getExtras().getBundle("contacto"));
        setResult(RESULT_OK, intent);
        finish();
    }
}
