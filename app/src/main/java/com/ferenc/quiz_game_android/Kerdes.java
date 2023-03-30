package com.ferenc.quiz_game_android;

public class Kerdes {

    private int id;
    private String kerdes;
    private String valasz_A;
    private String valasz_B;
    private String valasz_C;
    private String valasz_D;
    private String helyesValasz;

    public Kerdes(int id, String kerdes, String valasz_A, String valasz_B, String valasz_C, String valasz_D, String helyesValasz) {
        this.id = id;
        this.kerdes = kerdes;
        this.valasz_A = valasz_A;
        this.valasz_B = valasz_B;
        this.valasz_C = valasz_C;
        this.valasz_D = valasz_D;
        this.helyesValasz = helyesValasz;
    }

    public int getId() {
        return id;
    }

    public String getKerdes() {
        return kerdes;
    }

    public String getValasz_A() {
        return valasz_A;
    }

    public String getValasz_B() {
        return valasz_B;
    }

    public String getValasz_C() {
        return valasz_C;
    }

    public String getValasz_D() {
        return valasz_D;
    }

    public String getHelyesValasz() {
        return helyesValasz;
    }
}
