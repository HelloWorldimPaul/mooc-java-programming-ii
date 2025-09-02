
public class MagicSquareFactory {

    public MagicSquare createMagicSquare(int size) {

        MagicSquare square = new MagicSquare(size);

        // implement the creation of a magic square with the Siamese method algorithm here

        int y = 0;
        int x = size / 2;
        int numToPlace = 1;

        while (numToPlace <= size * size) {

            square.placeValue(x, y, numToPlace);
            numToPlace++;

            //int candidateY = y;
            //int candidateX = x;

            int candidateY = y - 1;
            int candidateX = x + 1;

            //y--;
            //x++;

            if (candidateY < 0) {
                candidateY = size - 1;

            }

            if (candidateX >= size) {

                candidateX = 0;
            }

            if (square.readValue(candidateX, candidateY) == 0) {

                y = candidateY;
                x = candidateX;

            }else{

                y++;
                if(y >= size){
                    y = 0;
                }
            }






        }

        return square;
    }

}