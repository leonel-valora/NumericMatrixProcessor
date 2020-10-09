package processor;
import java.util.Scanner;
public class Main {
    private static final Scanner sc;
    static {
        sc = new Scanner(System.in);
    }

    public static void main(String[] args) {
        int userChoice = showMenu();
        String result = "";

        while(userChoice != 0){
            switch(userChoice){
                case 1:
                    result = matrixFormating(matricesAddition());
                    break;
                case 2:
                    result = matrixFormating(matrixByAConstant());
                    break;
                case 3:
                    result = matrixFormating(matricesMultiplication());
                    break;
                case 4:
                    result = matrixFormating(transposeOfAMatrix());
                    break;
                case 5:
                    result = String.valueOf(determinantOfAMatrix());
                    break;
                case 6:
                    result = inverseMatrix();
                    break;
                default:
                    System.out.println("Option no valid");
            }
            if(!result.isEmpty()){
                System.out.println(result);
            }
            userChoice = showMenu();
        }
    }

    //Method to show operations menu
    private static int showMenu(){
        Scanner sc = new Scanner(System.in);
        int userChoice;

        System.out.println(
                        "1. Add matrices\n" +
                        "2. Multiply matrix by a constant\n" +
                        "3. Multiply matrices\n" +
                        "4. Transpose matrix\n"+
                        "5. Calculate a determinant\n"+
                        "6. Inverse matrix\n"+
                        "0. Exit");
        userChoice = sc.nextInt();

        return userChoice;
    }

    //Method to add two matrices
    private static double[][] matricesAddition(){
        //Defining a matrix result
        double[][] matrixResult;

        //get input size A
        System.out.print("Enter size of first matrix: ");
        int rowsA = sc.nextInt();
        int columnsA = sc.nextInt();

        //Fill matrix A
        System.out.println("Enter first matrix:");
        double[][] matrixA = fillMatrix(rowsA, columnsA);

        //get input size B
        System.out.print("Enter size of second matrix: ");
        int rowsB = sc.nextInt();
        int columnsB = sc.nextInt();

        //fill matrixB
        System.out.println("Enter second matrix:");
        double[][] matrixB = fillMatrix(rowsB, columnsB);

        //check if sizes are equals
        if (rowsA == rowsB && columnsA == columnsB) {
            matrixResult= new double[rowsA][columnsA];
            //adding elements
            for (int i = 0; i < matrixA.length; i++) {
                for(int j = 0; j < matrixA[0].length; j++) {
                    matrixResult[i][j] = matrixA[i][j] + matrixB[i][j];
                }
            }
        }
        else {
            return null;
        }
        //return result
        return matrixResult;
    }

    //Method to multiply a matrix by a constant
    private static double[][] matrixByAConstant(){
        double[][] matrixResult;

        //get input size A
        System.out.print("Enter size of matrix: ");
        int rows = sc.nextInt();
        int columns = sc.nextInt();

        //set a result matrix
        matrixResult = new double[rows][columns];

        //Fill matrix A
        System.out.println("Enter matrix:");
        double[][] matrix = fillMatrix(rows, columns);

        //get constant to multiply
        System.out.print("Enter constant: ");
        int constant = sc.nextInt();

        //multiply by constant
        for (int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                matrixResult[i][j] = matrix[i][j] * constant;
            }
        }

        return matrixResult;
    }

    //Method to multiply matrices
    private static double[][] matricesMultiplication() {
        double[][] matrixResult;

        //get input size A
        System.out.print("Enter size of first matrix: ");
        int rowsA = sc.nextInt();
        int columnsA = sc.nextInt();

        //Fill matrix A
        System.out.println("Enter first matrix:");
        double[][] matrixA = fillMatrix(rowsA, columnsA);

        //get input size B
        System.out.print("Enter size of second matrix: ");
        int rowsB = sc.nextInt();
        int columnsB = sc.nextInt();

        //fill matrixB
        System.out.println("Enter second matrix:");
        double[][] matrixB = fillMatrix(rowsB, columnsB);

        //check if size of columnA == rowB
        if(columnsA == rowsB) {
            //defining result matrix
            matrixResult = new double[rowsA][columnsB];
            //multiply row by column
            for(int i = 0; i < matrixA.length; i++) {
                for(int j = 0; j < matrixB[0].length; j++) {
                    double mulResult = 0;
                    for(int k = 0; k < matrixA[0].length; k++){
                         mulResult += matrixA[i][k] * matrixB[k][j];
                    }
                    matrixResult[i][j] = mulResult;
                }
            }
        }
        else {
            matrixResult = null;
        }
        return matrixResult;
    }

    private static double[][] matricesMultiplication(double[][] matrixA, double[][] matrixB) {
        double[][] matrixResult;
        int rowsB = matrixB.length;
        int columnsA = matrixA[0].length;
        //check if size of columnA == rowB
        if(columnsA == rowsB ) {
            //defining result matrix
            matrixResult = new double[matrixA.length][matrixB[0].length];
            //multiply row by column
            for(int i = 0; i < matrixA.length; i++) {
                for(int j = 0; j < matrixB[0].length; j++) {
                    double mulResult = 0;
                    for(int k = 0; k < matrixA[0].length; k++){
                         mulResult += matrixA[i][k] * matrixB[k][j];
                    }
                    matrixResult[i][j] = mulResult;
                }
            }
        }
        else {
            matrixResult = null;
        }
        return matrixResult;
    }

    //Method to transpose a matrix
    private static double[][] transposeOfAMatrix() {
        //show menu
        System.out.println(
                        "1. Main diagonal\n" +
                        "2. Side diagonal\n" +
                        "3. Vertical line\n" +
                        "4. Horizontal line");
        //get request
        System.out.print("Your choice: ");
        int userChoice = sc.nextInt();

        //get size of the matrix
        System.out.print("Enter matrix size: ");
        int rows = sc.nextInt();
        int columns = sc.nextInt();

        //fill matrix
        double[][] matrix = fillMatrix(rows, columns);

        //set result matrix
        double[][] matrixResult = new double[rows][columns];

        //execute type of transpose
        switch (userChoice){
            case 1:
                matrixResult = mainDiagonalTransposition(matrix);
                break;
            case 2:
                matrixResult = sideDiagonalTransposition(matrix);
                break;
            case 3:
                matrixResult = verticalLineTransposition(matrix);
                break;
            case 4:
                matrixResult = horizontalLineTransposition(matrix);
                break;
            default:
                System.out.println("Option no valid");
        }
        return matrixResult;
    }

    //main diagonal transposition
    private static double[][] mainDiagonalTransposition(double[][] matrix) {
        double[][] matrixResult = new double[matrix.length][matrix[0].length];
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                matrixResult[i][j] = matrix[j][i];
            }
        }
        return matrixResult;
    }

    //side diagonal transposition
    private static double[][] sideDiagonalTransposition(double[][] matrix) {
        double[][] matrixResult = new double[matrix.length][matrix[0].length];
        int lastIndex = matrix.length - 1;
        for(int i = lastIndex; i >= 0 ; i--) {
            for(int j = lastIndex; j >= 0; j--) {
                matrixResult[lastIndex-i][lastIndex-j] = matrix[j][i];
            }
        }

        return matrixResult;
    }

    //vertical line transposition
    private static double[][] verticalLineTransposition(double[][] matrix) {
        double[][] matrixResult = new double[matrix.length][matrix[0].length];
        int lastIndex = matrix.length - 1;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrixResult[i][j] = matrix[i][lastIndex - j];
            }
        }

        return matrixResult;
    }

    //horizontal line transposition
    private static double[][] horizontalLineTransposition(double[][] matrix) {
        double[][] matrixResult = new double[matrix.length][matrix[0].length];
        int lastIndex = matrix.length - 1;
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                matrixResult[i][j] = matrix[lastIndex-i][j];
            }
        }
        return matrixResult;
    }

    //method to determinant of a matrix
    private static double determinantOfAMatrix() {
        double determinant;

        //get size of the matrix
        System.out.print("Enter matrix size: ");
        int rows = sc.nextInt();
        int columns = sc.nextInt();

        //filling matrix
        System.out.println("Enter matrix:");
        double[][] matrix = fillMatrix(rows, columns);

        //check matrix´s size
        if(rows == 2 && columns == 2) {
            determinant = simpleDeterminant(matrix);
        }
        else {
            //if matrix´s size is greater than 2x2
            determinant = laplaceDeterminant(matrix);
        }

        return determinant;
    }

    //get minor
    private static double simpleDeterminant(double[][] matrix) {
        double a = matrix[0][0] * matrix[1][1];
        double b = matrix[0][1] * matrix[1][0];
        return a - b;
    }

    //laplace determinant
    private static double laplaceDeterminant(double[][] matrix){
        double result = 0;
        //get determinant
        for(int i = 0; i < matrix[0].length; i++) {
            //get scalar and simbol
            double m = matrix[0][i];
            int sign = (int) Math.pow(-1, i);

            double[][] subMatrix = minorMatrix(matrix, 0, i);

            //get cofactor
            if(subMatrix.length == 2 && subMatrix[0].length == 2) {
                result += (m * sign) * simpleDeterminant(subMatrix);
            }
            else {
                //recursive call
                result  += (m * sign) * laplaceDeterminant(subMatrix);
            }
        }

        return result;
    }

    //getting minor matrix
    private static double[][] minorMatrix(double[][] matrix, int indexRow, int indexCol) {
        //set a submatrix
        double[][] subMatrix = new double[matrix.length -1][matrix.length - 1];
        int nRow = 0;
        int nCol = 0;

        //filling submatrix
        for(int i = 0; i < subMatrix.length; i++) {
            for(int j = 0; j < subMatrix[0].length; j++){
                //check if index isn´t equals
                if(nRow == indexRow) {
                    ++nRow;
                }
                if(nCol == indexCol) {
                    ++nCol;
                }
                subMatrix[i][j] = matrix[nRow][nCol];
                //next element
                ++nCol;
            }
            //next row
            ++nRow;
            nCol = 0;
        }
        return subMatrix;
    }

    //method to get inverse matrix
    private static String inverseMatrix() {
        double determinant;
        double[][] matrixTranspose;
        double[][] matrixResult;
        double[][] matrixCofactors;

        //get matrix´s size
        System.out.println("Enter matrix size: ");
        int rows = sc.nextInt();
        int columns = sc.nextInt();

        //filling matrix
        System.out.println("Enter matrix:");
        double[][] matrix = fillMatrix(rows, columns);

        //get determinant
        if(rows ==2  && columns == 2) {
            determinant = simpleDeterminant(matrix);
        }
        else {
            determinant = laplaceDeterminant(matrix);
        }

        //check if matrix has inverse
        if(determinant != 0) {
            matrixTranspose = mainDiagonalTransposition(matrix);
            matrixCofactors = new double[rows][columns];
            double cofactor = 0;

            //filling inverse matrix
            for(int i = 0; i < matrixTranspose.length; i++) {
                for(int j = 0; j < matrixTranspose[0].length; j++) {
                    double[][] subMatrix = minorMatrix(matrixTranspose, i, j);
                    if(subMatrix.length == 3){
                        cofactor = triangleRule(subMatrix);
                    }
                    else if( subMatrix.length == 2){
                        cofactor = simpleDeterminant(subMatrix);
                    }
                    int sign = (int) Math.pow(-1, i+j);
                    matrixCofactors[i][j] = sign * cofactor;
                }
            }

            //dividing by determinant
            matrixResult = matrixDivision(matrixCofactors, determinant);
            //System.out.println(matrixFormating(matrixResult));
            //check if inverse is valid
            if(checkInverseMatrix(matrix, matrixResult)){
                return matrixFormating(matrixResult);
            }
        }

        return "This matrix doesn't have an inverse.";
    }

    private static double triangleRule(double[][] matrix) {
        double result = 0;
        if(matrix.length == 3){
            result = (matrix[0][0] * matrix[1][1] * matrix[2][2])
                    + (matrix[0][1] * matrix[1][2] * matrix[2][0])
                    + (matrix[0][2] * matrix[1][0] * matrix[2][1])
                    - (matrix[0][2] * matrix[1][1] * matrix[2][0])
                    - (matrix[0][0] * matrix[1][2] * matrix[2][1])
                    - (matrix[0][1] * matrix[1][0] * matrix[2][2]);
        }
        return result;
    }

    //dividing matrix by a constant
    private static double[][] matrixDivision(double[][] matrix, double divisor) {
        double[][] matrixResult = new double[matrix.length][matrix[0].length];
        for(int i = 0; i < matrix.length; i++) {
            for(int j = 0; j < matrix[0].length; j++) {
                matrixResult[i][j] = matrix[i][j] / divisor;
            }
        }
        return matrixResult;
    }

    private static boolean checkInverseMatrix(double[][] matrix, double[][] inverseMatrix) {
        double[][] multiplyMatrix = matricesMultiplication(matrix, inverseMatrix);
        for(int i = 0; i < multiplyMatrix.length; i++) {
            for(int j = 0; j < multiplyMatrix[0].length; j++) {
                if(i == j && Math.round(multiplyMatrix[i][j]) != 1) {
                    return false;
                }
                else if(i != j && Math.round(multiplyMatrix[i][j]) != 0) {
                    return false;
                }
            }
        }
        return true;
    }
    //Method to read elements from a matrix
    private static double[][] fillMatrix(int rows, int columns) {
        double[][] matrix = new double[rows][columns];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = sc.nextDouble();
            }
        }
        return matrix;
    }

    //Method to format the ouput matrix
    private static String matrixFormating(double[][] matrix) {
        String result = "The result is:\n";
        if(matrix != null) {
            for(double[] row : matrix) {
                for(double item : row) {
                    result += item +" ";
                }
                result.trim();
                result += "\n";
            }
        }
        else {
            result = "The operation cannot be performed.";
        }
        return result.trim();
    }
}
