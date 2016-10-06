/** 
Simple Linear Algebra Library for Transformations in Java
Nuwan Perera 2016
**/

public class MatrixMath {
    // Change the size of a vector by a scalar factor
    public static double[] scale(double [] vec, double scalar){
        for (int i = 0; i < 3; i++){
            vec[i] *= scalar;
        }
        return vec;
    }
	
	// Scale a each element of a matrix by a scalar factor
    public static double[][] scale(double[][] matrix, double scalar){
        int rows = matrix.length;
        int cols = matrix[0].length;
        for (int i = 0; i < rows; i++){
            for (int j = 0; j < cols; j++){
                matrix[i][j] *= scalar;
            }
        }
        return matrix;
    }
	
	// Overloaded methods to handle matrix-matrix and matrix-vector multiplication
    //  Vector-matrix
    public static double[] multiply(double[] matB, double[][] matA){
        int aRows = matA.length;
        int aCols = matA[0].length;
        int bRows = matB.length;
        int bCols = 1;
        if (aCols != bRows){
            throw new IllegalArgumentException ("Columns and rows do not match!");
        }
        double[]matC = new double [aRows];
        for(int i = 0; i<bRows; i++){
            matC[i] = 0.00000;
        }
        for (int i = 0; i < aRows; i++){
            for(int j = 0; j < bCols; j++){
                for (int k = 0; k < aCols; k++){
                    matC[i] += matA[i][k] * matB[j];
                }
            }
        }
        return matC;
    }
    // Matrix-vector multiplication
    public static double[] multiply(double[][]matA, double[] matB){
        int aRows = matA.length;
        int aCols = matA[0].length;
        int bRows = matB.length;
        int bCols = 1;
        if (aCols != bRows){
            throw new IllegalArgumentException ("Columns and rows do not match!");
        }
        double[]matC = new double [aRows];
        for(int i = 0; i<bRows; i++){
            matC[i] = 0.00000;
        }
        for (int i = 0; i < aRows; i++){
            for(int j = 0; j < bCols; j++){
                for (int k = 0; k < aCols; k++){
                    matC[i] += matA[i][k] * matB[j];
                }
            }
        }
        return matC;
    }
    // Matrix-matrix multiplication
    public static double[][] multiply(double[][] matA, double[][] matB){
        int aRows = matA.length;
        int aCols = matA[0].length;
        int bRows = matB.length;
        int bCols = matB[0].length;
        if (aCols != bRows){
            throw new IllegalArgumentException ("Columns and rows do not match!");
        }
        double[][] matC = new double [aRows][bCols];
        for(int i = 0; i<aRows; i++){
            for (int j = 0; j<bCols; j++){
                matC[i][j] = 0.00000;
            }
        }
        for (int i = 0; i < aRows; i++){
            for(int j = 0; j < bCols; j++){
                for (int k = 0; k < aCols; k++){
                    matC[i][j] += matA[i][k] * matB[k][j];
                }
            }
        }
        return matC;
    }
	
	// Translate matrix - overloaded methods for matrix translation and vector translation
    public static double[] translate(double[] vec, double[] translation){
        int aRows = vec.length;
        int bRows = translation.length;
        for (int i = 0; i < aRows; i++){
            vec[i] += translation[i];
        }
        return vec;
    }
    // Overloaded
    public static double[][] translate(double[][] matrix, double[] translation){
        int aRows = matrix.length;
        int bRows = translation.length;
        int aCols = matrix[0].length;
        int bCols = 1;
        for (int i = 0; i < aRows; i++){
            for (int j = 0; j < aCols; j++){
                for (int k = 0; k < bRows; k++){
                    matrix[i][j] += translation[k];
                }
            }
        }
        return matrix;
    }