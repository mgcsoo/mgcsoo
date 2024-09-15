import java.util.Scanner;

class TwoDimensional {

    // Function to create and populate the 2D array
    public static int[][] Array(int rows, int cols) {
        Scanner scanner = new Scanner(System.in);
        int[][] array = new int[rows][cols];
        System.out.println("--------------------------------------------------");
        System.out.println("Enter a number between 1 and 100:");

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                while (true) {
                    System.out.print("Enter a number for element [" + (i + 1) + "][" + (j + 1) + "]: ");
                    try {
                        int value = Integer.parseInt(scanner.nextLine());
                        if (value >= 1 && value <= 100) {
                            array[i][j] = value;
                            break;
                        } else {
                            System.out.println("Number out of range. Please enter a number between 1 and 100.");
                        }
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid input. Please enter an integer.");
                    }
                }
            }
        }
        return array;
    }

    public static void displayArray(int[][] array) {
        System.out.println("--------------------------------------------------");
        int maxElementLength = 0;
        for (int[] row : array) {
            for (int element : row) {
                int length = String.valueOf(element).length();
                if (length > maxElementLength) {
                    maxElementLength = length;
                }
            }
        }

        int columnWidth = maxElementLength + 1;

        System.out.println("\nArray:");
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                System.out.printf("%-" + columnWidth + "d", array[i][j]);
            }
            System.out.println();
        }
        System.out.println();
    }

    // Function to find the maximum element and its position in the 2D array
    public static int[] findMaximumElement(int[][] array) {
        int maxValue = array[0][0];
        int maxRow = 0;
        int maxCol = 0;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] > maxValue) {
                    maxValue = array[i][j];
                    maxRow = i;
                    maxCol = j;
                }
            }
        }

        return new int[]{maxValue, maxRow + 1, maxCol + 1}; 
    }

    // Function to find the minimum element and its position in the 2D array
    public static int[] findMinimumElement(int[][] array) {
        int minValue = array[0][0];
        int minRow = 0;
        int minCol = 0;

        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (array[i][j] < minValue) {
                    minValue = array[i][j];
                    minRow = i;
                    minCol = j;
                }
            }
        }

        return new int[]{minValue, minRow + 1, minCol + 1}; 
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Prompt user to choose the array dimensions
        System.out.println("------------------------------------------------");
        System.out.println("Choose the dimensions of the array:");
        System.out.println("------------------------------------------------");
        System.out.println("1. 3x4");
        System.out.println("2. 1x2");
        System.out.println("3. 2x3");
        System.out.println("4. 4x5");
        System.out.println("5. 5x6");
        System.out.println("-------------------------------------------------");
        System.out.print("Enter the number corresponding to your choice: ");
        
        int choice = Integer.parseInt(scanner.nextLine());
        int rows = 0;
        int cols = 0;

        // Set rows and cols based on user's choice
        switch (choice) {
            case 1:
                rows = 3;
                cols = 4;
                break;
            case 2:
                rows = 1;
                cols = 2;
                break;
            case 3:
                rows = 2;
                cols = 3;
                break;
            case 4:
                rows = 4;
                cols = 5;
                break;
            case 5:
                rows = 5;
                cols = 6;
                break;
            default:
                System.out.println("Invalid choice. Defaulting to 3x4.");
                rows = 3;
                cols = 4;
                break;
        }

        // Initialize and populate the array
        int[][] array = Array(rows, cols);

        // Display the array
        displayArray(array);

        // Ask the user if they want to find both maximum and minimum elements
        System.out.println("---------------------------------------------------------------------------------------");
        System.out.print("Would you like to find both the maximum and minimum elements? (Enter 'yes' or 'no'): ");
        String findBoth = scanner.nextLine().trim().toLowerCase();

        if (findBoth.equals("yes")) {
            // Find both maximum and minimum elements and their positions
            int[] maxInfo = findMaximumElement(array);
            int[] minInfo = findMinimumElement(array);
            
            int maxValue = maxInfo[0];
            int maxRow = maxInfo[1];
            int maxCol = maxInfo[2];
            
            int minValue = minInfo[0];
            int minRow = minInfo[1];
            int minCol = minInfo[2];

            // Output the results
            System.out.println("---------------------------------------------------------------------------------------");
            System.out.println("The maximum element is " + maxValue + ", located at row " + maxRow + " column " + maxCol + ".");
            System.out.println("The minimum element is " + minValue + ", located at row " + minRow + " column " + minCol + ".");
        } else if (findBoth.equals("no")) {
            // Ask the user whether they want to find the maximum or minimum element
            System.out.print("Would you like to find the maximum or minimum element? (Enter 'max' or 'min'): ");
            String findChoice = scanner.nextLine().trim().toLowerCase();

            if (findChoice.equals("min")) {
                // Find the minimum element and its position
                int[] minInfo = findMinimumElement(array);
                int minValue = minInfo[0];
                int minRow = minInfo[1];
                int minCol = minInfo[2];

                // Output the result
                System.out.println("---------------------------------------------------------------------------------------");
                System.out.println("The minimum element is " + minValue + ", located at row " + minRow + " column " + minCol + ".");
            } else if (findChoice.equals("max")) {
                // Find the maximum element and its position
                int[] maxInfo = findMaximumElement(array);
                int maxValue = maxInfo[0];
                int maxRow = maxInfo[1];
                int maxCol = maxInfo[2];

                // Output the result
                System.out.println("----------------------------------------------------------------------------------------");
                System.out.println("The maximum element is " + maxValue + ", located at row " + maxRow + " column " + maxCol + ".");
            } else {
                System.out.println("Invalid choice. Please enter 'max' or 'min'.");
            }
        } else {
            System.out.println("Invalid choice. Please enter 'yes' or 'no'.");
        }
    }
}
