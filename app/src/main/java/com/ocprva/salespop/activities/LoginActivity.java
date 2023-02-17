package com.ocprva.salespop.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.ocprva.salespop.R;
import com.ocprva.salespop.api.pojo.Product;
import com.ocprva.salespop.api.pojo.ProductServiceInterfaz;
import com.ocprva.salespop.api.pojo.Usuario;
import com.ocprva.salespop.api.pojo.UsuarioServiceInterfaz;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class LoginActivity extends AppCompatActivity {
    Button btnLogin;
    TextView btnSignUp;
    TextView btnGuest;
    EditText etMail;
    EditText etPwd;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnLogin = findViewById(R.id.btnLogin);
        btnSignUp = findViewById(R.id.btnSignUp);
        btnGuest = findViewById(R.id.btnGuest);

        etMail = findViewById(R.id.etMail);
        etPwd = findViewById(R.id.etPwd);
    }

    public void onClick(View view){
        Intent intent;
        switch (view.getId()){
            case R.id.btnLogin:
                if(!etMail.getText().toString().equals("") && !etPwd.getText().toString().equals("")){
                    Retrofit retrofit = new Retrofit.Builder().baseUrl("http://192.168.8.12:8080/api/").addConverterFactory(GsonConverterFactory.create()).build();

                    UsuarioServiceInterfaz service = retrofit.create(UsuarioServiceInterfaz.class);
                    Call<Usuario> call = service.validarUsuario(etMail.getText().toString(), etPwd.getText().toString());

                    call.enqueue(new Callback<Usuario>() {
                        @Override
                        public void onResponse(Call<Usuario> call, Response<Usuario> response) {
                            System.out.println("funciona retrofit usuario");

                            Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                            intent.putExtra("usuario", response.body());
                            startActivity(intent);

                        }

                        @Override
                        public void onFailure(Call<Usuario> call, Throwable t) {
                            System.out.println("no funciona retrofit usuario");
                        }
                    });
                    /*Retrofit retrofit = new Retrofit.Builder().baseUrl("http://192.168.8.12:8080/api/").addConverterFactory(GsonConverterFactory.create()).build();

                    UsuarioServiceInterfaz service = retrofit.create(UsuarioServiceInterfaz.class);
                    Call<ArrayList<Usuario>> call = service.getUsuarios();

                    call.enqueue(new Callback<ArrayList<Usuario>>() {
                        @Override
                        public void onResponse(Call<ArrayList<Usuario>> call, Response<ArrayList<Usuario>> response) {
                            System.out.println("funciona retrofit usuario");
                            ArrayList<Usuario> listaUsuarios = response.body();
                            for (Usuario usuario : listaUsuarios) {
                                if (etMail.getText().toString().equals(usuario.getMail()) && etPwd.getText().toString().equals(usuario.getPassword())){
                                    System.out.println("usuario encontrado: "+ usuario.toString());
                                    Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                                    intent.putExtra("usuario", usuario);
                                    startActivity(intent);
                                    return;
                                }
                            }
                            Toast.makeText(LoginActivity.this, "Usuario no encontrado", Toast.LENGTH_SHORT).show();
                        }

                        @Override
                        public void onFailure(Call<ArrayList<Usuario>> call, Throwable t) {
                            System.out.println("no funciona retrofit usuario");
                        }
                    });*/
                }
                break;

            case R.id.btnSignUp:
                intent = new Intent(LoginActivity.this, SignUpActivity.class);
                startActivity(intent);
                break;

            case R.id.btnGuest:
                intent = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(intent);
                break;
        }
    }
}