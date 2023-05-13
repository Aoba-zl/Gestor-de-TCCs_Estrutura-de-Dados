package controller;

import model.Area;

public class AreaController
{
    Area area;

    public String getAreaSubArea() {
        return area.subArea;
    }

    public void setAreaSubArea(String subArea) {
        area.subArea = subArea;
    }

    public String getAreaNome() {
        return area.nome;
    }

    public void setAreaNome(String nome) {
        area.nome = nome;
    }
}
