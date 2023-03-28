import java.util.Scanner;

public class Fibonacci {
    static long fibo(int n) {
        if (n < 2) {
            return n;
        } else {
            return fibo(n - 1) + fibo(n - 2);
        }
    }

    public static void main(String[] args) {

	// teste do programa. Imprime os 30 primeiros termos
    Scanner leitor = new Scanner(System.in);
    int N = leitor.nextInt();
	for (int i = 0; i < N; i++) {
            System.out.print(Fibonacci.fibo(i) + " ");
        }
    }
}
