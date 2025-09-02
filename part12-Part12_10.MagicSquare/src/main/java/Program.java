

public class Program {

    public static void main(String[] args) {
        // Test the MagicSquare class here

        MagicSquareFactory msFactory = new MagicSquareFactory();
        MagicSquare magicSquare = msFactory.createMagicSquare(3);

        System.out.println(magicSquare);



        /*


        MagicSquare magicSquare1 = new MagicSquare(3);

        int valueToInsert = 1;

        for(int row = 0; row < magicSquare1.getWidth(); row++){

            for(int column = 0; column < magicSquare1.getHeight(); column++){

                magicSquare1.placeValue(row, column, valueToInsert);
                valueToInsert++;

            }

        }

        System.out.println(magicSquare1);

        System.out.println(magicSquare1.sumsOfRows());
        System.out.println(magicSquare1.sumsOfColumns());
        System.out.println(magicSquare1.sumsOfDiagonals());
        System.out.println("====================");


        MagicSquare magicSquare2 = new MagicSquare(3);
        valueToInsert = 1;

        for(int column = 0; column < magicSquare1.getWidth(); column++){

            for(int row = 0; row < magicSquare1.getHeight(); row++){

                magicSquare2.placeValue(row, column, valueToInsert);
                valueToInsert++;

            }

        }

        System.out.println(magicSquare2);

        System.out.println(magicSquare2.sumsOfRows());
        System.out.println(magicSquare2.sumsOfColumns());
        System.out.println(magicSquare2.sumsOfDiagonals());
        System.out.println("====================");



        MagicSquare magicSquare3 = new MagicSquare(3);

        magicSquare3.placeValue(0, 0, 8);
        magicSquare3.placeValue(0, 1, 1);
        magicSquare3.placeValue(0, 2, 6);
        magicSquare3.placeValue(1, 0, 3);
        magicSquare3.placeValue(1, 1, 5);
        magicSquare3.placeValue(1, 2, 7);
        magicSquare3.placeValue(2, 0, 4);
        magicSquare3.placeValue(2, 1, 9);
        magicSquare3.placeValue(2, 2, 2);

        System.out.println(magicSquare3);

        System.out.println(magicSquare3.sumsOfRows());
        System.out.println(magicSquare3.sumsOfColumns());
        System.out.println(magicSquare3.sumsOfDiagonals());

        System.out.println(magicSquare3.sumsAreSame());

         */

    }
}
