package com.example.botondinamico;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Spinner;
import com.example.botondinamico.adapter.adapterBotonRecycler;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity implements NavigationDelegate<Bundle> {
    Button btn;
    RecyclerView rvLista;
    Spinner spinner;
    private adapterBotonRecycler adapter;
    private NavigationState<Integer> navigationState;
    private int currentFragmentPosition = -1;
    private boolean popPending;
    public static Context mContext;
    protected NavigationDelegate<Bundle> navigationDelegate;
    private NavigationAdapter navigationAdapter;
   // private ActivityMainBinding viewDataBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        navigationAdapter = new NavigationAdapter(getSupportFragmentManager());
        setContentView(R.layout.activity_main);
        setTitle("Recicler View");
        controles();
        acciones();
        mContext = getApplicationContext();
        navigationState = new NavigationState<>();
    }

    public static Context getContext() {
        return mContext;
    }

    private void controles() {
        btn = findViewById(R.id.btn);
        rvLista = findViewById(R.id.recicler_view);
        spinner = findViewById(R.id.spinner);

    }

    private void acciones() {
        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                popToResumen();
            }

        });
        llenarLista();
    }

    private void llenarLista() {
        ArrayList<modeloTipoBoton> listaData = new ArrayList<>();
        for (int i = 0; i <30 ; i++) {
            listaData.add(new modeloTipoBoton("Carmen " + i ,0, "Registro"));
        }

        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        rvLista.setLayoutManager(layoutManager);
        adapter = new adapterBotonRecycler(listaData);
        rvLista.setAdapter(adapter);
    }

   private void Registrar() {
        Intent intentMandaA = new Intent(this, Registro.class);
        startActivity(intentMandaA);
        finish();
    }

    @Override
    public void popToResumen() {
        FragmentoResumen fragment = new FragmentoResumen();
        fragment.setNavigationDelegate(this);
       // viewDataBinding.actionBar.setVisibility(View.VISIBLE);
        //viewDataBinding.leftSidebar.setVisibility(View.VISIBLE);
        int fragmentPosition;
        fragmentPosition = navigationAdapter.pushFragment(fragment);
        navigationState.putState(NavigationState.PAGE_SEARCH_CLIENT, fragmentPosition);

        //viewDataBinding.navigationViewPager.setCurrentItem(fragmentPosition);
    }
        /*
        int fragmentPosition;
        fragmentPosition = navigationState.getState(NavigationState.PAGE_GREETING);
        currentFragmentPosition = fragmentPosition;
        popPending = true;+/
       // viewDataBinding.navigationViewPager.setCurrentItem(fragmentPosition, true);
    }

   /* private  void  Resumen(){
        FragmentoResumen fragment = new FragmentoResumen();
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
      //  fragmentTransaction.add(R.id., fragment);
        fragmentTransaction.commit();
    }*/
}