package com.example.temaseminar4;

import java.io.Serializable;

public class Cinema implements Serializable {

    private String nume;
    private String gen;
    private String tipSala;
    private boolean parcare;
    private boolean are3D;
    private float rating;

    public Cinema(String nume, String gen, String tipSala,
                  boolean parcare, boolean are3D, float rating) {
        this.nume = nume;
        this.gen = gen;
        this.tipSala = tipSala;
        this.parcare = parcare;
        this.are3D = are3D;
        this.rating = rating;
    }

    public String getNume() { return nume; }
    public String getGen() { return gen; }
    public String getTipSala() { return tipSala; }
    public boolean isParcare() { return parcare; }
    public boolean isAre3D() { return are3D; }
    public float getRating() { return rating; }

    @Override
    public String toString() {
        return "Cinema{" + "nume='" + nume + '\'' + ", gen='" + gen + '\'' +
                ", tipSala='" + tipSala + '\'' + ", parcare=" + parcare +
                ", are3D=" + are3D + ", rating=" + rating + '}';
    }
}