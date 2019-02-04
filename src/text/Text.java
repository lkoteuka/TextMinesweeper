package text;

import controller.Controller;
import model.Cell;

public class Text{
    private Controller contr;

    public Text(){}
    public void printField(Cell[][] field, int height, int width, int game){
        System.out.print("_ |");
        for(int j = 0; j < width; j++){
            if(j < 10){
                System.out.print(j + " |");
            } else {
                System.out.print(j + "|");
            }
        }
        System.out.println();
        for(int i = 0; i < height; i++){
            if(i < 10){
                System.out.print(i + " |");
            } else {
                System.out.print(i + "|");
            }
            for(int j = 0; j < width; j++){
                if(field[i][j].getVisible()){
                    if(field[i][j].getState() == 9){
                        System.out.print("* |");
                    } else {
                        System.out.print(field[i][j].getBombsAround()+" |");
                    }
                } else{
                    System.out.print("__|");
                }
            }
            System.out.println();
        }
        if(game == 1){
            System.out.println("-------CONGRATULATIONS YOU WON---------");
            return ;
        } else if(game == -1){
            System.out.println("---------GAME OVER---------");
            return ;
        } else if(game == 0){
            contr.getTurn();
        }
    }

    public void setController(Controller contr){
        this.contr = contr;
    }
}