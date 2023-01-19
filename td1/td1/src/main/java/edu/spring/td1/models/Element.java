package edu.spring.td1.models;

import java.util.Objects;

public class Element {

    private String nom;
    private int evaluation;

    public String getNom() {
        return nom;
    }

    public int getEvaluation() {
        return evaluation;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setEvaluation(int evaluation) {
        this.evaluation = evaluation;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Element element = (Element) o;
        return evaluation == element.evaluation && nom.equals(element.nom);
    }


}
