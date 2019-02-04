package main;

import model.Model;
import controller.Controller;
import text.Text;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class Main{
    ArrayList realMatrix = new ArrayList<Character>();
    ArrayList visibleMatrix = new ArrayList<Character>();

    public static void main(String[] argv){
        if(argv.length > 0){
            int height = 0, width = 0, bombs = 0;
            Scanner in = new Scanner(System.in);
            while(height < 3 || width < 3 || height > 30 || width > 30) {
                System.out.println("Введите размер поля (min: 3x3; max: 30x30): ");
                height = in.nextInt();
                width = in.nextInt();
            }
            while(bombs < 1 || bombs > height * width - 1) {
                System.out.println("Введите количество мин (min: 1):");
                bombs = in.nextInt();
            }
            Model model = new Model(height, width, bombs);
            Controller contr = new Controller();
            Text text = new Text();

            contr.setModel(model);
            text.setController(contr);
            model.setText(text);

        } else {
            return ;
        }
    }
}