package controller;

import model.Model;

import java.util.Scanner;

public class Controller{
    private Model model;
    public Controller(){}

    public void getTurn(){
        int x = 0, y = 0;
        Scanner in = new Scanner(System.in);
        x = in.nextInt();
        y = in.nextInt();
        model.setTurn(x, y, -1);
    }

    public void setModel(Model y){
        this.model = y;
    }
}