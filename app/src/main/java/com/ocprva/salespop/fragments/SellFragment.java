package com.ocprva.salespop.fragments;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.provider.MediaStore;
import android.util.Base64;
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
import com.ocprva.salespop.activities.FailureActivity;
import com.ocprva.salespop.api.pojo.Categoria;
import com.ocprva.salespop.api.pojo.CategoryServiceInterfaz;
import com.ocprva.salespop.api.pojo.Foto;
import com.ocprva.salespop.api.pojo.FotoServiceInterfaz;
import com.ocprva.salespop.api.pojo.Product;
import com.ocprva.salespop.api.pojo.ProductServiceInterfaz;
import com.ocprva.salespop.api.pojo.Usuario;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

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
    String[] categorias;
    Usuario usuario;

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

    public static SellFragment newInstance(Usuario user) {
        SellFragment fragment = new SellFragment();
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
        View view = inflater.inflate(R.layout.fragment_sell, container, false);

        usuario = (Usuario) getArguments().getSerializable("user");

        ivImagenProducto = view.findViewById(R.id.ivImagenProducto);
        btnImagenes = view.findViewById(R.id.btnImagenes);
        btnSubelo = view.findViewById(R.id.btnSubelo);
        spinnerCategoria = view.findViewById(R.id.spinnerCategoria);
        etNombreProducto = view.findViewById(R.id.etNombreProducto);
        etDescripcionProducto = view.findViewById(R.id.etDescripcionProducto);
        etPrecioProducto = view.findViewById(R.id.etPrecioProducto);

        final String[] categorias = new String[]{"MOTOR", "INMOBILIARIA", "JUEGOS", "INFORMATICA", "TELEFONIA", "MODA", "DEPORTES"};
        ArrayAdapter<String> adapterCategorias =
               new ArrayAdapter<String>(getActivity(),
                      android.R.layout.simple_spinner_item, categorias);
        spinnerCategoria.setAdapter(adapterCategorias);

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
                    //NombreCategoria categoriaSeleccionada = (NombreCategoria) spinnerCategoria.getSelectedItem();

                    //Categoria categoria = new Categoria(categoriaSeleccionada);

                    //ProductData.PRODUCTOS.add(new Producto(100, etNombreProducto.getText().toString(), Integer.parseInt(etPrecioProducto.getText().toString()), etDescripcionProducto.getText().toString(), "Valencia", categoria, new Date(2010, 4, 17), new Usuario()));
                }
                else Toast.makeText(getActivity(), "Rellene todos los campos", Toast.LENGTH_SHORT).show();
            }
        });

        Retrofit retrofit = new Retrofit.Builder().baseUrl("http://192.168.8.12:8080/api/").addConverterFactory(GsonConverterFactory.create()).build();

        CategoryServiceInterfaz service = retrofit.create(CategoryServiceInterfaz.class);
        Call<ArrayList<Categoria>> call = service.getCategorias();

        call.enqueue(new Callback<ArrayList<Categoria>>() {
            @Override
            public void onResponse(Call<ArrayList<Categoria>> call, Response<ArrayList<Categoria>> response) {
                System.out.println(response.body());

                btnSubelo.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        if (fotoProducto != null && !etNombreProducto.equals("") && !etDescripcionProducto.equals("") && !etPrecioProducto.equals("")){
                            String stringcategoriaSeleccionada =  spinnerCategoria.getSelectedItem().toString();
                            Categoria categoriaSeleccionada = new Categoria();
                            for (Categoria categoria: response.body()) {
                                if (categoria.getName().equals(stringcategoriaSeleccionada)){
                                    categoriaSeleccionada = categoria;
                                }
                            }

                            System.out.println(usuario.getName());

                            List<Product>listaOnSale = new ArrayList<>();

                            Product nuevoProducto = new Product();
                            nuevoProducto.setName(etNombreProducto.getText().toString());
                            nuevoProducto.setCategoria(categoriaSeleccionada);

                            System.out.println(categoriaSeleccionada.toString());

                            nuevoProducto.setPrice(Integer.parseInt(etPrecioProducto.getText().toString()));
                            nuevoProducto.setDescription(etDescripcionProducto.getText().toString());
                            nuevoProducto.setPublicationDate("2018-04-14");
                            nuevoProducto.setUbication("Valencia");
                            if (usuario.getOnSale() == null){
                                usuario.setOnSale(listaOnSale);
                            }
                            else{
                                listaOnSale = usuario.getOnSale();
                                listaOnSale.add(nuevoProducto);
                                usuario.setOnSale(listaOnSale);
                            }
                            nuevoProducto.setSeller(usuario);

                            Bitmap bitmap = fotoProducto; // The Bitmap object

                            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                            bitmap.compress(Bitmap.CompressFormat.PNG, 1, byteArrayOutputStream);
                            byte[] byteArray = byteArrayOutputStream.toByteArray();
                            String base64String = Base64.encodeToString(byteArray, Base64.DEFAULT);
                            List<Foto> listaFoto= new ArrayList<>();

                            Foto foto = new Foto();
                            foto.setName("foto "+ nuevoProducto.getName());
                            foto.setUrlImagen(base64String);
                            foto.setProduct(nuevoProducto);
                            //listaFoto.add(foto);
                            if (nuevoProducto.getFoto() == null){
                                nuevoProducto.setFoto(listaFoto);
                            }

                            System.out.println(usuario.toString());

                            System.out.println(nuevoProducto.toString());

                            ProductServiceInterfaz productService = retrofit.create(ProductServiceInterfaz.class);
                            Call<Product> callProduct = productService.addProduct(nuevoProducto);
                            callProduct.enqueue(new Callback<Product>() {
                                @Override
                                public void onResponse(Call<Product> call, Response<Product> response) {
                                    System.out.println("Articulo añadido");
                                    System.out.println("Response Code: " + response.code() + "|| Funciona? : " + response.isSuccessful());
                                }
                                @Override
                                public void onFailure(Call<Product> call, Throwable t) {
                                    System.out.println("Error al añadir el producto");
                                }
                            });
                            /*FotoServiceInterfaz fotoService = retrofit.create(FotoServiceInterfaz.class);
                            Call<Foto> callFoto = fotoService.addFoto(foto);
                            callFoto.enqueue(new Callback<Foto>() {
                                @Override
                                public void onResponse(Call<Foto> call, Response<Foto> response) {


                                }

                                @Override
                                public void onFailure(Call<Foto> call, Throwable t) {

                                }
                            });*/


                        }
                        else Toast.makeText(getActivity(), "Rellene todos los campos", Toast.LENGTH_SHORT).show();
                    }
                });
            }

            @Override
            public void onFailure(Call<ArrayList<Categoria>> call, Throwable t) {
                Intent intent = new Intent(getActivity(), FailureActivity.class);
                System.out.println("Sell Not Connecting");
                startActivity(intent);
            }
        });



        return view;
    }

}