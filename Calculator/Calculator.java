import java.util.Scanner;

class Calculator {
    private Scanner scanner;
    private int totalSolvedCount, additionSolveCounter, subtractionSolveCounter, multiplicationSolveCounter, divisionSolveCounter;

    Calculator() {
        this.scanner = new Scanner(System.in);
        this.totalSolvedCount = 0;
        this.additionSolveCounter = 0;
        this.subtractionSolveCounter = 0;
        this.multiplicationSolveCounter = 0;
        this.divisionSolveCounter = 0;
    }
    
    private void printIntro() {
        String systemUser = System.getProperty("user.name");
        System.out.printf("Hello %s welcome to Calculator v.0.0.1 \n\n", systemUser);
    }

    private void calculate() {
        boolean using = true;
        int operationChoice;
        String[] operationChoices = {"addition", "subtraction", "multiplication", "division"};
        int operandOne;
        int operandTwo;

        do {
            System.out.println("Which operation would you like to perform");
            System.out.println("(1) addition");
            System.out.println("(2) subtraction");
            System.out.println("(3) multiplication");
            System.out.println("(4) division");

            operationChoice = this.scanner.nextInt();
            System.out.printf("You chose %s \n", operationChoices[operationChoice-1]);

            System.out.println("Give me a number");
            operandOne = this.scanner.nextInt();
            System.out.println("Give me another number");
            operandTwo = this.scanner.nextInt();

            switch(operationChoices[operationChoice-1]) {
                case "addition":
                    System.out.printf("Addition result: %d \n", operandOne + operandTwo);
                    this.additionSolveCounter++;
                    break;
                case "subtraction":
                    System.out.printf("Subtraction result: %d \n", operandOne - operandTwo);
                    this.subtractionSolveCounter++;
                    break;
                case "multiplication":
                    System.out.printf("Multiplication result: %d \n", operandOne * operandTwo);
                    this.multiplicationSolveCounter++;
                    break;
                case "division":
                    System.out.printf("Division result: %d \n", operandOne / operandTwo);
                    this.divisionSolveCounter++;
                    break;
            }            
    
            System.out.println("would you like to solve another problem?");
            System.out.println("(0) No");
            System.out.println("(1) Yes");
            int userAnswer = this.scanner.nextInt();

            if(userAnswer == 0) {
                using = false;
            } else {
                using = true;
            }
            
            this.totalSolvedCount++;
        } while(using);

    }

    private void printResult() {
        System.out.println("Calculation Results \n");

        System.out.printf("Addition Solve Count %d \n", this.additionSolveCounter);
        System.out.printf("Subtraction Solve Count %d \n", this.subtractionSolveCounter);
        System.out.printf("Multiplication Solve Count %d \n", this.multiplicationSolveCounter);
        System.out.printf("Division Solve Count %d \n", this.divisionSolveCounter);

        System.out.printf("Total Problems solved %d \n", this.totalSolvedCount);
        
    };

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        
        calculator.printIntro();
        calculator.calculate();
        calculator.printResult();
    }
}