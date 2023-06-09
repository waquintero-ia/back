package com.example.back;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.ComponentName;
import android.os.Bundle;
import android.util.Log;

import com.example.back.model.Empleado;
import com.example.back.sinterface.CrudEmpleadoInterface;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;

public class MainActivity extends AppCompatActivity {

    CrudEmpleadoInterface cruempleado;
    List<Empleado> listEmpleado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getAll();
        Empleado empleado = null;
        create(empleado);
        delete();
        callEdit(empleado);

    }

    private void getAll(){

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.0.12:8081/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        cruempleado = retrofit.create(CrudEmpleadoInterface.class);
        Call<List<Empleado>> call = cruempleado.getAll();


        call.enqueue (new Callback<List<Empleado>>() {
            @Override
            public void onResponse(Call<List<Empleado>> call, retrofit2.Response<List<Empleado>> response) {
                if (!response.isSuccessful()) {
                    //System.out.println(response.message());
                    Log.e("Response err:,", response.message());
                    return;
                }
                listEmpleado = response.body();
                //listEmpleado.forEach(p-> System.out.println(p.toString()));
                listEmpleado.forEach(p -> Log.i("Empleados: ", p.toString()));
            }

            @Override
            public void onFailure(Call<List<Empleado>> call, Throwable t) {
                //System.out.println(t.getMessage());
                Log.e("Throw error:", t.getMessage());
            }

        });

    }

    private void create(Empleado empleado){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.0.12:8081/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        cruempleado = retrofit.create(CrudEmpleadoInterface.class);
        empleado = new Empleado("Pepita", "504", "z@gmail.com" );
        Call<Empleado> call = cruempleado.create(empleado);

        call.enqueue(new Callback<Empleado>() {
            @Override
            public void onResponse(Call<Empleado> call, Response<Empleado> response) {
                if (!response.isSuccessful()) {
                    //System.out.println(response.message());
                    Log.e("Response err:,", response.message());
                    return;
                }
            }

            @Override
            public void onFailure(Call<Empleado> call, Throwable t) {
                Log.e("Throw error:", t.getMessage());
            }
        });
    }

    private void delete(){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.0.12:8081/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        cruempleado = retrofit.create(CrudEmpleadoInterface.class);
        Call<Empleado> call = cruempleado.delete(4L);

        call.enqueue(new Callback<Empleado>() {
            @Override
            public void onResponse(Call<Empleado> call, Response<Empleado> response) {
                if (!response.isSuccessful()) {
                    //System.out.println(response.message());
                    Log.e("Response err:,", response.message());
                    return;
                }
            }

            @Override
            public void onFailure(Call<Empleado> call, Throwable t) {
                Log.e("Throw error:", t.getMessage());
            }
        });
    }

    private void callEdit(Empleado empleado){
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://192.168.0.12:8081/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        cruempleado = retrofit.create(CrudEmpleadoInterface.class);
        empleado = new Empleado("Pepito", "666", "zz@gmail.com" );
        Call<Empleado> call = cruempleado.callEdit(10L,empleado);

        call.enqueue(new Callback<Empleado>() {
            @Override
            public void onResponse(Call<Empleado> call, Response<Empleado> response) {
                if (!response.isSuccessful()) {
                    //System.out.println(response.message());
                    Log.e("Response err:,", response.message());
                    return;
                }
            }

            @Override
            public void onFailure(Call<Empleado> call, Throwable t) {
                Log.e("Throw error:", t.getMessage());
            }
        });
    }
}