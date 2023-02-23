package com.ocprva.salespop.fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.ocprva.salespop.R;
import com.ocprva.salespop.api.pojo.Usuario;

public class UserFragment extends Fragment {

    private Usuario usuario;
    private TextView nameUsuario, nickNameUsuario, emailUsuario, telefonoUsuario, enVentaUsuario;
    private Button btnCerrarSesion, btnBorrarCuenta;


    public UserFragment() {
        // Required empty public constructor
    }

    public static UserFragment newInstance(Usuario user) {
        UserFragment fragment = new UserFragment();
        Bundle args = new Bundle();
        args.putSerializable("user", user);
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
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_user, container, false);

        usuario = (Usuario) getArguments().getSerializable("user");

        nameUsuario = view.findViewById(R.id.nameUsuario);
        nickNameUsuario = view.findViewById(R.id.nickNameUsuario);
        emailUsuario = view.findViewById(R.id.emailUsuario);
        telefonoUsuario = view.findViewById(R.id.telefonoUsuario);
        enVentaUsuario = view.findViewById(R.id.enVentaUsuario);

        btnCerrarSesion = view.findViewById(R.id.btnCerrarSesion);
        btnBorrarCuenta = view.findViewById(R.id.btnBorrarCuenta);

        nameUsuario.setText(nameUsuario.getText().toString() + usuario.getName());
        nickNameUsuario.setText(nickNameUsuario.getText().toString() + usuario.getUserName());
        emailUsuario.setText(emailUsuario.getText().toString() + usuario.getMail());
        telefonoUsuario.setText(telefonoUsuario.getText().toString() + usuario.getNumTel());
        enVentaUsuario.setText(enVentaUsuario.getText().toString() + usuario.getOnSale().size());


        return view;
    }
}