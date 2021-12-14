//piece class, allows for ships to ahve types and attributes
public class Piece {
    int type;
    int size;
    boolean alive;
    String name;
    char charName;
    int hits;



    //piece constructor, automatically assigns attributes based on ship type
    public Piece(int type){
        this.type = type;
        /*this.size =size;
        this.alive = alive;
        this.name=name;
        this.charName= charName;*/

        if(type == 0){
            size = 2;
            name = "Destroyer";
            charName = 'd';
        }
        if(type == 1){
            size = 3;
            name = "Submarine";
            charName = 's';
        }
        if(type == 2){
            size = 3;
            name = "Cruiser";
            charName = 'r';
        }
        if(type == 3){
            size = 4;
            name = "Battleship";
            charName = 'b';
        }
        if(type == 4){
            size = 5;
            name = "Carrier";
            charName = 'c';
        }



    }

}