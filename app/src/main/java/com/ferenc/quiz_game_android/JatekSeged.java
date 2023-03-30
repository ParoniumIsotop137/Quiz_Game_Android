package com.ferenc.quiz_game_android;

import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.List;


public class JatekSeged {


    public void KomponensFeltoltes(List<Kerdes> kerdesek, TextView txtUjKerdes, TextView txtValasz_A, TextView txtValasz_B, TextView txtValasz_C, TextView txtValasz_D, int sorSzam) {

        txtUjKerdes.setText(kerdesek.get(sorSzam).getKerdes());
        txtValasz_A.setText(kerdesek.get(sorSzam).getValasz_A());
        txtValasz_B.setText(kerdesek.get(sorSzam).getValasz_B());
        txtValasz_C.setText(kerdesek.get(sorSzam).getValasz_C());
        txtValasz_D.setText(kerdesek.get(sorSzam).getValasz_D());

    }

    public int JoValaszKijelzes(CheckBox chBoxValaszA, CheckBox chBoxValaszB, CheckBox chBoxValaszC, CheckBox chBoxValaszD, Kerdes kerdes, TextView txtValasz_A, TextView txtValasz_B, TextView txtValasz_C, TextView txtValasz_D) {

        if (chBoxValaszA.isChecked() && kerdes.getHelyesValasz().equals("valasz_a")) {

            txtValasz_A.setBackgroundColor(Color.GREEN);
            return 1;

        } else if (chBoxValaszB.isChecked() && kerdes.getHelyesValasz().equals("valasz_b")) {

            txtValasz_B.setBackgroundColor(Color.GREEN);
            return 1;


        } else if (chBoxValaszC.isChecked() && kerdes.getHelyesValasz().equals("valasz_c")) {

            txtValasz_C.setBackgroundColor(Color.GREEN);
            return 1;


        } else if (chBoxValaszD.isChecked() && kerdes.getHelyesValasz().equals("valasz_d")) {
            txtValasz_D.setBackgroundColor(Color.GREEN);
            return 1;
        }
        return 0;

    }



    public void CheckBoxVisszaAllitas(CheckBox chBoxValaszA, CheckBox chBoxValaszB, CheckBox chBoxValaszC, CheckBox chBoxValaszD) {


        chBoxValaszA.setSelected(false);
        chBoxValaszA.setChecked(false);
        chBoxValaszB.setSelected(false);
        chBoxValaszB.setChecked(false);
        chBoxValaszC.setSelected(false);
        chBoxValaszC.setChecked(false);
        chBoxValaszD.setSelected(false);
        chBoxValaszD.setChecked(false);

    }

    public void AlapHelyezet(CheckBox chBoxValaszA, CheckBox chBoxValaszB, CheckBox chBoxValaszC, CheckBox chBoxValaszD, TextView txtUjKerdes, TextView txtValaszA, TextView txtValaszB, TextView txtValaszC, TextView txtValaszD, Button btnTovabb) {

        chBoxValaszA.setEnabled(true);
        chBoxValaszB.setEnabled(true);
        chBoxValaszC.setEnabled(true);
        chBoxValaszD.setEnabled(true);

        txtUjKerdes.setText("");
        txtValaszA.setBackgroundColor(Color.TRANSPARENT);
        txtValaszA.setText("");
        txtValaszA.setBackgroundColor(Color.YELLOW);
        txtValaszB.setBackgroundColor(Color.TRANSPARENT);
        txtValaszB.setText("");
        txtValaszB.setBackgroundColor(Color.YELLOW);
        txtValaszC.setBackgroundColor(Color.TRANSPARENT);
        txtValaszC.setText("");
        txtValaszC.setBackgroundColor(Color.YELLOW);
        txtValaszD.setBackgroundColor(Color.TRANSPARENT);
        txtValaszD.setText("");
        txtValaszD.setBackgroundColor(Color.YELLOW);

        btnTovabb.setEnabled(false);
        btnTovabb.setVisibility(View.INVISIBLE);


    }
}