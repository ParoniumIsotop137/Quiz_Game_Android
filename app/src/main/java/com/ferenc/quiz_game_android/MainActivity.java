package com.ferenc.quiz_game_android;

import android.graphics.Color;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;


import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnUjJatek;
    Button btnEredmeny;
    Button btnTovabb;
    Button btnMegall;
    TextView txtUjKerdes;
    CheckBox chBoxValasz_A;
    CheckBox chBoxValasz_B;
    CheckBox chBoxValasz_C;
    CheckBox chBoxValasz_D;
    TextView txtValasz_A;
    TextView txtValasz_B;
    TextView txtValasz_C;
    TextView txtValasz_D;

    private int joValaszok;
    private int sorSzam;
    private boolean joValasz;

    private FajlKezelo fajl;
    private JatekSeged seged;

    private List<Kerdes> kerdesek;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnUjJatek = findViewById(R.id.btnUjJatek);
        btnEredmeny = findViewById(R.id.btnEredmeny);
        btnEredmeny.setEnabled(false);
        btnEredmeny.setVisibility(View.INVISIBLE);

        btnTovabb = findViewById(R.id.btnTovabb);
        btnTovabb.setEnabled(false);
        btnTovabb.setVisibility(View.INVISIBLE);

        btnMegall = findViewById(R.id.btnMegall);
        btnMegall.setEnabled(false);
        btnMegall.setVisibility(View.INVISIBLE);

        txtUjKerdes = findViewById(R.id.txtUjKerdes);
        txtValasz_A = findViewById(R.id.txtValasz_A);
        txtValasz_B = findViewById(R.id.txtValasz_B);
        txtValasz_C = findViewById(R.id.txtValasz_C);
        txtValasz_D = findViewById(R.id.txtValasz_D);

        chBoxValasz_A = findViewById(R.id.chBoxValasz_A);
        chBoxValasz_B = findViewById(R.id.chBoxValasz_B);
        chBoxValasz_C = findViewById(R.id.chBoxValasz_C);
        chBoxValasz_D = findViewById(R.id.chBoxValasz_D);

        chBoxValasz_A.setSelected(false);
        chBoxValasz_B.setSelected(false);
        chBoxValasz_C.setSelected(false);
        chBoxValasz_D.setSelected(false);

        fajl = new FajlKezelo();
        seged = new JatekSeged();
        joValaszok = 0;


    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.btnUjJatek:
                sorSzam = 0;
                joValaszok = 0;
                btnMegall.setEnabled(false);
                btnMegall.setVisibility(View.INVISIBLE);
                kerdesek = new ArrayList<Kerdes>();
                try {
                    InputStreamReader iStream = new InputStreamReader(getAssets()
                            .open("Kerdesek.csv"));
                    kerdesek = fajl.KerdesBeolvasas(iStream, ";");
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();
                }
                btnUjJatek.setEnabled(false);
                btnUjJatek.setVisibility(View.INVISIBLE);
                seged.KomponensFeltoltes(kerdesek, txtUjKerdes, txtValasz_A, txtValasz_B, txtValasz_C, txtValasz_D, sorSzam);
                break;
            case R.id.chBoxValasz_A:
                EredmenyButtonEngedelyezes();
                chBoxValasz_B.setEnabled(false);
                chBoxValasz_C.setEnabled(false);
                chBoxValasz_D.setEnabled(false);

                break;
            case R.id.chBoxValasz_B:
                EredmenyButtonEngedelyezes();
                chBoxValasz_A.setEnabled(false);
                chBoxValasz_C.setEnabled(false);
                chBoxValasz_D.setEnabled(false);

                break;
            case R.id.chBoxValasz_C:
                EredmenyButtonEngedelyezes();
                chBoxValasz_B.setEnabled(false);
                chBoxValasz_A.setEnabled(false);
                chBoxValasz_D.setEnabled(false);

                break;
            case R.id.chBoxValasz_D:
                EredmenyButtonEngedelyezes();
                chBoxValasz_B.setEnabled(false);
                chBoxValasz_C.setEnabled(false);
                chBoxValasz_A.setEnabled(false);

                break;
            case R.id.btnEredmeny:

                Kerdes kerdes = kerdesek.get(sorSzam);

                joValaszok += seged.JoValaszKijelzes(chBoxValasz_A, chBoxValasz_B, chBoxValasz_C, chBoxValasz_D, kerdes, txtValasz_A, txtValasz_B, txtValasz_C, txtValasz_D);

                if((joValaszok-1) == sorSzam){
                    btnTovabb.setEnabled(true);
                    btnTovabb.setVisibility(View.VISIBLE);
                }
                else {

                    try {
                        Thread.sleep(1000);
                        Toast.makeText(getApplicationContext(), "Helytelen válasz!", Toast.LENGTH_LONG).show();
                        btnTovabb.setEnabled(false);
                        btnTovabb.setVisibility(View.INVISIBLE);
                        Kiertekeles();
                    } catch (InterruptedException e) {
                        throw new RuntimeException(e);
                    }

                }
                btnEredmeny.setEnabled(false);

                if (joValaszok == 5) {
                    Toast.makeText(getApplicationContext(), "5. helyes válasz: Gratulálunk az első garantált nyereményéhez, mely 100.000Ft!", Toast.LENGTH_LONG).show();
                    btnMegall.setVisibility(View.VISIBLE);
                    btnMegall.setEnabled(true);
                }
                if (joValaszok == 10) {
                    Toast.makeText(getApplicationContext(), "10. helyes válasz: Gratulálunk  a következő garantált nyereményéhez, mely 10.000.000Ft!", Toast.LENGTH_LONG).show();
                }
                break;
            case R.id.btnTovabb:
                sorSzam++;

                btnEredmeny.setVisibility(View.INVISIBLE);
                if (sorSzam < kerdesek.size()) {

                    seged.CheckBoxVisszaAllitas(chBoxValasz_A, chBoxValasz_B, chBoxValasz_C, chBoxValasz_D);
                    seged.AlapHelyezet(chBoxValasz_A, chBoxValasz_B, chBoxValasz_C, chBoxValasz_D, txtUjKerdes, txtValasz_A, txtValasz_B, txtValasz_C, txtValasz_D, btnTovabb);
                    seged.KomponensFeltoltes(kerdesek, txtUjKerdes, txtValasz_A, txtValasz_B, txtValasz_C, txtValasz_D, sorSzam);

                } else {
                    seged.AlapHelyezet(chBoxValasz_A, chBoxValasz_B, chBoxValasz_C, chBoxValasz_D, txtUjKerdes, txtValasz_A, txtValasz_B, txtValasz_C, txtValasz_D, btnTovabb);
                    seged.CheckBoxVisszaAllitas(chBoxValasz_A, chBoxValasz_B, chBoxValasz_C, chBoxValasz_D);

                    btnMegall.setEnabled(false);
                    btnMegall.setVisibility(View.INVISIBLE);

                    btnUjJatek.setEnabled(true);
                    btnUjJatek.setVisibility(View.VISIBLE);
                    Fonyeremeny();
                }
                break;
            case R.id.btnMegall:
                Kiertekeles();
                btnMegall.setEnabled(false);
                btnMegall.setVisibility(View.INVISIBLE);
                break;
        }
    }

    private void Kiertekeles() {

        String nyeremeny = "";

        seged.AlapHelyezet(chBoxValasz_A, chBoxValasz_B, chBoxValasz_C, chBoxValasz_D, txtUjKerdes, txtValasz_A, txtValasz_B, txtValasz_C, txtValasz_D, btnTovabb);
        seged.CheckBoxVisszaAllitas(chBoxValasz_A, chBoxValasz_B, chBoxValasz_C, chBoxValasz_D);
        if (joValaszok >= 5 && joValaszok < 10) {
            nyeremeny = "Garantált nyereménye 100.000Ft!";
        } else if (joValaszok >= 10) {
            nyeremeny = "Garantált nyereménye 10.000.000Ft!";
        }else if(joValaszok == 15){
            Fonyeremeny();
        } else {
            nyeremeny = "Sajnáljuk, de nem ért el az első garantált nyereményig.";
        }

        Toast.makeText(getApplicationContext(), nyeremeny, Toast.LENGTH_LONG).show();
        btnEredmeny.setEnabled(false);
        btnEredmeny.setVisibility(View.INVISIBLE);
        btnMegall.setEnabled(false);
        btnMegall.setVisibility(View.INVISIBLE);
        btnUjJatek.setEnabled(true);
        btnUjJatek.setVisibility(View.VISIBLE);

    }

    private void Fonyeremeny() {

        Toast.makeText(getApplicationContext(), "Gratulálunk megnyerte a fődíjat, a 25.000.000Ft-ot!", Toast.LENGTH_LONG).show();
    }

    public void EredmenyButtonEngedelyezes() {
        btnEredmeny.setVisibility(View.VISIBLE);
        btnEredmeny.setEnabled(true);
    }







}