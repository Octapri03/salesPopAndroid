package com.ocprva.salespop.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;

import com.ocprva.salespop.R;
import com.ocprva.salespop.api.pojo.NombreCategoria;
import com.ocprva.salespop.api.pojo.Producto;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link SellFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class SellFragment extends Fragment {
    ImageView ivImagenProducto;
    Button btnImagenes, btnSubelo;
    Spinner spinnerCategoria;
    EditText etNombreProducto, etDescripcionProducto, etPrecioProducto;

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
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        ivImagenProducto = view.findViewById(R.id.ivImagenProducto);
        btnImagenes = view.findViewById(R.id.btnImagenes);
        btnSubelo = view.findViewById(R.id.btnSubelo);
        spinnerCategoria = view.findViewById(R.id.spinnerCategoria);
        etNombreProducto = view.findViewById(R.id.etNombreProducto);
        etDescripcionProducto = view.findViewById(R.id.etDescripcionProducto);
        etPrecioProducto = view.findViewById(R.id.etPrecioProducto);

        final NombreCategoria[] categorias = new NombreCategoria[]{NombreCategoria.MOTOR, NombreCategoria.INMOBILIARIA, NombreCategoria.JUEGOS, NombreCategoria.INFORMATICA, NombreCategoria.TELEFONIA, NombreCategoria.MODA, NombreCategoria.DEPORTES};
        ArrayAdapter<NombreCategoria> adapterCategorias =
                new ArrayAdapter<NombreCategoria>(getActivity(),
                        android.R.layout.simple_spinner_item, categorias);
        spinnerCategoria.setAdapter(adapterCategorias);

        return view;
    }
}