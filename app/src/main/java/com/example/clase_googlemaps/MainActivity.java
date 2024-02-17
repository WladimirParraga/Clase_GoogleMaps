package com.example.clase_googlemaps;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentActivity;

import android.graphics.Color;
import android.graphics.Point;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.maps.CameraUpdate;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.OnMapReadyCallback;
import com.google.android.gms.maps.Projection;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;
import com.google.android.gms.maps.model.PolylineOptions;

import java.util.ArrayList;

public class MainActivity extends FragmentActivity
        implements OnMapReadyCallback {
    GoogleMap mapa;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        SupportMapFragment mapFragment = (SupportMapFragment)
                getSupportFragmentManager()
                        .findFragmentById(R.id.map);
        mapFragment.getMapAsync(this);
    }

    @Override
    public void onMapReady(@NonNull GoogleMap googleMap ) {
        mapa = googleMap;
        mapa.setMapType(GoogleMap.MAP_TYPE_SATELLITE);
        mapa.getUiSettings().setZoomControlsEnabled(true);
        CameraUpdate camUpd1 = CameraUpdateFactory.
                newLatLngZoom(new LatLng(-1.0126, -79.4696), 20);
        mapa.moveCamera(camUpd1);
        mapa.setInfoWindowAdapter(new GoogleMap.InfoWindowAdapter() {
            @Override
            public View getInfoWindow(Marker marker) {
                return null; //
            }
            @Override
            public View getInfoContents(Marker marker) {
                View view = getLayoutInflater().inflate(R.layout.mensaje, null);
                ImageView imageView = view.findViewById(R.id.ImgFacultad);
                TextView titleTextView = view.findViewById(R.id.txtNomFacultad);
                TextView infoTextView = view.findViewById(R.id.txtinfo);
                if (marker.getTitle().equals("Facultad de Enfermería")) {
                    imageView.setImageResource(R.drawable.facuenfermeria);
                    titleTextView.setText("Facultad de Enfermería");
                    infoTextView.setText("Formar íntegramente profesionales de la salud con sólidas bases científicas, humanísticas que le permitan actuar ante las necesidades de salud brindando una atención integral demostrando alto compromiso ético en el cuidado de la vida, contribuyendo con su conocimiento al desarrollo de la investigación, ciencia e " +
                            "innovación mejorando las condiciones de bienestar de la comunidad garantizando el derecho a la salud.");
                } else if (marker.getTitle().equals("Facultad de Ciencias Empresariales")) {
                    imageView.setImageResource(R.drawable.facuempresariales);
                    titleTextView.setText("Facultad de Ciencias Empresariales");
                    infoTextView.setText("La Facultad de Ciencias Empresariales de la UTEQ tiene la misión de formar profesionales altamente competitivos en los niveles Técnico, Tecnológico, Pregrado y Postgrado, en el manejo administrativo, " +
                            "financiero y de gestión en las organizaciones públicas y privadas");
                } else if (marker.getTitle().equals("Facultad de Ciencias Sociales, Económicas y Financieras")) {
                    imageView.setImageResource(R.drawable.facusociales);
                    titleTextView.setText("Facultad de Ciencias Sociales, Económicas y Financieras");
                    infoTextView.setText("La Facultad de Ciencias Sociales Económicas y Financieras forma profesionales comprometidos con la comunidad, con suficientes bases teóricas y prácticas sobre el mejor uso de los recursos planteando soluciones a los problemas" +
                            " que impiden alcanzar el bienestar económico y financiero de toda la sociedad.");
                } else if (marker.getTitle().equals("Facultad de Ciencias de la Educación")) {
                    imageView.setImageResource(R.drawable.facueducacion);
                    titleTextView.setText("Facultad de Ciencias de la Educación");
                    infoTextView.setText("Formar profesionales y académicos competitivos y de excelencia, generando conocimientos, tecnología, servicios de calidad y soluciones a los problemas de la sociedad, sustentada en principios.");
                }
                return view;
            }
        });
        LatLng Fcsalud = new LatLng(-1.0128590472579106, -79.46936342524782);
        mapa.addMarker(new MarkerOptions()
                .position(Fcsalud)
                .title("Facultad de Ciencias de la Salud"));
        LatLng FCempresariales = new LatLng(-1.0122690534315153, -79.47022709657386);
        mapa.addMarker(new MarkerOptions()
                .position(FCempresariales)
                .title("Facultad de Ciencias Empresariales"));
        LatLng FCeconomicas = new LatLng(-1.0125908682592284, -79.47052213957345);
        mapa.addMarker(new MarkerOptions()
                .position(FCeconomicas)
                .title("Facultad de Ciencias Sociales, Económicas y Financieras"));
        LatLng FCeduacion = new LatLng(-1.0125694139383714, -79.47101566604547);
        mapa.addMarker(new MarkerOptions()
                .position(FCeduacion)
                .title("Facultad de Ciencias de la Educación"));
    }

}