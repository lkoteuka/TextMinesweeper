package model;

import text.Text;

import java.util.Random;

import static java.lang.Math.random;

public class Model{
    private Cell[][] field;
    private int height;
    private int width;
    private int score;
    private int bombs;
    private Text text;

    public Model(int height, int width, int bombs){
        this.field = new Cell[height][width];
        this.height = height;
        this.width = width;
        this.bombs = bombs;

        createField();
    }

    public int bombsAround(int x, int y) {

        int result = 0;
        int ax;
        int ay;
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                ay = y + i;
                ax = x + j;
                if (ay >= 0 && ay < this.width && ax >= 0 && ax < this.height) {
                    if (this.field[ax][ay].getState() == 9) {
                        result++;
                    }
                }

            }
        }
        return result;
    }

    private void createField(){

        for(int i = 0; i < height; i++){
            for(int j = 0; j <width; j++){
                field[i][j] = new Cell(i, j, 0, 0);
            }
        }

        int k = 0, f = 0;
        Random rand = new Random(1234);

        while(k != bombs) {
            for (int i = 0; i < height; i += height/((rand.nextInt(3) + 1))) {
                for (int j = 0; j < width; j += width/((rand.nextInt(3) + 1))) {
                    if(k == bombs){
                        break;
                    }
                    if (rand.nextBoolean()) {
                        if (field[i][j].getState() != 9){
                            field[i][j].setState(9);
                            if(i - 1 >= 0 && rand.nextBoolean()){
                                field[i-1][j].setState(9);
                                k++;
                                if(k == bombs){
                                    break;
                                }
                            }
                            if(i + 1 < height && rand.nextBoolean()){
                                field[i+1][j].setState(9);
                                k++;
                                if(k == bombs){
                                    break;
                                }
                            }
                            if(j - 1 >=0 && rand.nextBoolean()){
                                field[i][j-1].setState(9);
                                k++;
                                if(k == bombs){
                                    break;
                                }
                            }
                            if(j + 1 < width && rand.nextBoolean()){
                                field[i][j+1].setState(9);
                                k++;
                                if(k == bombs){
                                    break;
                                }
                            }
                            k++;
                        }
                    }
                }
            }
        }

        for(int i = 0; i < height; i++){
            for(int j = 0; j < width; j++){
                field[i][j].setBombsAround(bombsAround(i, j));
            }
        }
    }

    public void setTurn(int x, int y, int flag){
        field[x][y].setVisible(true);
        score++;
        if(field[x][y].getBombsAround() == 0){
            int ax;
            int ay;
            for (int i = -1; i < 2; i += 2) {
                ay = y + i;
                ax = x;
                if (ay >= 0 && ay < this.width && ax >= 0 && ax < this.height) {
                    if (field[ax][ay].getVisible() == false) {
                        this.setTurn(ax, ay, 0);
                    }
                }
                ay = y;
                ax = x + i;
                if (ay >= 0 && ay < this.width && ax >= 0 && ax < this.height) {
                    if (field[ax][ay].getVisible() == false) {
                        this.setTurn(ax, ay, 0);
                    }
                }
            }
        } else if(field[x][y].getState() == 9){
            this.setVisibleAll();
            text.printField(field, height, width, -1);
        }
        if(flag == -1){
            if(score == height*width - bombs){
                this.setVisibleAll();
                text.printField(field, height, width, 1);
            } else if(field[x][y].getState() != 9){
                text.printField(field, height, width, 0);
            }
        }
    }

    public void setText(Text text){
        this.text = text;
        text.printField(field, height, width, 0);
    }

    private void setVisibleAll(){
        for(int i = 0; i < height; i++){
            for(int j = 0; j < width; j++){
                field[i][j].setVisible(true);
            }
        }
    }
}