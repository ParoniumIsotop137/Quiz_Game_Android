package com.ferenc.quiz_game_android;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class FajlKezelo {

    public List<Kerdes> KerdesBeolvasas(InputStreamReader fajlnev, String elvalaszto) throws IOException {

        List<Kerdes> kerdesek = new ArrayList<Kerdes>();

        try (BufferedReader br = new BufferedReader(fajlnev)){

            br.readLine();

            while (br.ready()){

                String [] egySor = br.readLine().split(elvalaszto);

                kerdesek.add(new Kerdes(Integer.parseInt(egySor[0]),egySor[1], egySor[2], egySor[3], egySor[4], egySor[5], egySor[6]));

            }

        } catch (Exception e) {
            throw new IOException("Hiba az adatok beolvasásakor: "+e.getMessage());
        }

        return kerdesek;

    }

}
