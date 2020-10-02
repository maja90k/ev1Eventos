package cl.inacap.misconciertos;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import cl.inacap.misconciertos.dao.EventosDAO;
import cl.inacap.misconciertos.dao.EventosDAOLista;
import cl.inacap.misconciertos.dto.Evento;


public class MainActivity extends AppCompatActivity {
    private EditText nombreAr, valor;
    private CalendarView calendario;
    private Spinner genero;
    private Spinner calificacion;
    private String fecha;
    private Button agregarBtn;
    private ListView listView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final List<Evento> eventoList = EventosDAOLista.getInstance().getAll();
        final ArrayAdapter arrayAdapter = new ArrayAdapter(getApplicationContext(), android.R.layout.simple_list_item_1, eventoList);
        this.nombreAr = findViewById(R.id.nombreAr);
        this.calendario = findViewById(R.id.calendario);
        this.genero = findViewById(R.id.genero);
        this.calificacion = findViewById(R.id.calificacion);
        this.valor = findViewById(R.id.valor);
        this.agregarBtn = findViewById(R.id.agregarBtn);
        this.listView = findViewById(R.id.listView);

        calendario.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int year, int month, int day) {
                fecha = day + "/" + month + "/" + year;
            }
        });

        this.agregarBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                List<String> listErrores = new ArrayList<>();
                try {
                    String nombre = validarTexto(nombreAr);
                    int valorE = validarEntero(valor);
                    if (listErrores.isEmpty()) {
                        if (calendario.getMinDate() == 0) {
                            listErrores.add("Seleccione una fecha");
                        }
                        Evento e = new Evento();
                        e.setNombreAr(nombre);
                        e.setCalendario(fecha);
                        e.setGenero(genero.getSelectedItem().toString());
                        e.setCalificacion(calificacion.getSelectedItemPosition() + 1);
                        e.setValor(valorE);
                        eventoList.add(e);
                        Toast.makeText(MainActivity.this, "Exito en agregar un evento", Toast.LENGTH_SHORT).show();
                    }
                } catch (Exception ex) {
                    Toast.makeText(MainActivity.this, ex.toString(), Toast.LENGTH_SHORT).show();
                }
                listView.setAdapter(arrayAdapter);
            }
        });
    }

    public Integer validarEntero(EditText editText) {
        int number = 0;
        try {
            if (!editText.getText().toString().isEmpty()) {
                number = Integer.parseInt(editText.getText().toString().trim());
            }
        } catch (Exception ex) {
            Toast.makeText(this, "Ingrese valor valido " + ex.toString(), Toast.LENGTH_SHORT).show();
        }
        return number;
    }

    public String validarTexto(EditText editText) {
        String texto = null;
        try {
            if (!editText.getText().toString().isEmpty()) {
                texto = editText.getText().toString().trim();
            }
        } catch (Exception ex) {
            Toast.makeText(this, "Ingrese texto valido " + ex.toString(), Toast.LENGTH_SHORT).show();
        }
        return texto;
    }

}

