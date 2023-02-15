package com.ocprva.salespop.fragments;

import static android.app.Activity.RESULT_OK;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.location.Address;
import android.location.Geocoder;
import android.location.Location;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.ocprva.salespop.R;
import com.ocprva.salespop.api.pojo.Categoria;
import com.ocprva.salespop.api.pojo.NombreCategoria;
import com.ocprva.salespop.api.pojo.ProductData;
import com.ocprva.salespop.api.pojo.Producto;
import com.ocprva.salespop.api.pojo.Usuario;

import java.io.IOException;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SellFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SellFragment extends Fragment {
    private static final int REQUEST_IMAGE = 1;
    ImageView ivImagenProducto;
    Button btnImagenes, btnSubelo;
    Spinner spinnerCategoria;
    EditText etNombreProducto, etDescripcionProducto, etPrecioProducto;
    private static final int PICK_IMAGE_REQUEST = 1;
    Bitmap fotoProducto;

    private void openFileChooser() {
        Intent intent = new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent, PICK_IMAGE_REQUEST);
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == PICK_IMAGE_REQUEST && resultCode == Activity.RESULT_OK
                && data != null && data.getData() != null) {
            Uri uri = data.getData();
            try {
                Bitmap bitmap = MediaStore.Images.Media.getBitmap(getActivity().getContentResolver(), uri);
                // Do something with the image
                fotoProducto = bitmap;
                ivImagenProducto.setImageBitmap(fotoProducto);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public SellFragment() {
        // Required empty public constructor
    }

    public static SellFragment newInstance(String param1, String param2) {
        SellFragment fragment = new SellFragment();
        Bundle args = new Bundle();
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_sell, container, false);

        ivImagenProducto = view.findViewById(R.id.ivImagenProducto);
        btnImagenes = view.findViewById(R.id.btnImagenes);
        btnSubelo = view.findViewById(R.id.btnSubelo);
        spinnerCategoria = view.findViewById(R.id.spinnerCategoria);
        etNombreProducto = view.findViewById(R.id.etNombreProducto);
        etDescripcionProducto = view.findViewById(R.id.etDescripcionProducto);
        etPrecioProducto = view.findViewById(R.id.etPrecioProducto);

        btnImagenes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openFileChooser();
            }
        });

        btnSubelo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (fotoProducto != null && !etNombreProducto.equals("") && !etDescripcionProducto.equals("") && !etPrecioProducto.equals("")){
                    NombreCategoria categoriaSeleccionada = (NombreCategoria) spinnerCategoria.getSelectedItem();

                    Categoria categoria = new Categoria(categoriaSeleccionada);

                    //ProductData.PRODUCTOS.add(new Producto(100, etNombreProducto.getText().toString(), Integer.parseInt(etPrecioProducto.getText().toString()), etDescripcionProducto.getText().toString(), "Valencia", categoria, new Date(2010, 4, 17), new Usuario()));
                }
                else Toast.makeText(getActivity(), "Rellene todos los campos", Toast.LENGTH_SHORT).show();
            }
        });

        final NombreCategoria[] categorias = new NombreCategoria[]{NombreCategoria.MOTOR, NombreCategoria.INMOBILIARIA, NombreCategoria.JUEGOS, NombreCategoria.INFORMATICA, NombreCategoria.TELEFONIA, NombreCategoria.MODA, NombreCategoria.DEPORTES};
        ArrayAdapter<NombreCategoria> adapterCategorias =
                new ArrayAdapter<NombreCategoria>(getActivity(),
                        android.R.layout.simple_spinner_item, categorias);
        spinnerCategoria.setAdapter(adapterCategorias);

        return view;
    }

}