import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class Main {
    public static List<Double> encontrarRaizes(Function<Double, Double> f, double inicio, double fim, double passo, double tol, int maxIter) {
        List<Double> raizes = new ArrayList<>();
        double a = inicio;
        double b = a + passo;

        while (b <= fim) {
            // Se f(a) ou f(b) forem zero, adicionamos a raiz diretamente se ainda não estiver na lista
            if (Math.abs(f.apply(a)) < tol && !raizes.contains(a)) {
                raizes.add(a);
            }
            if (Math.abs(f.apply(b)) < tol && !raizes.contains(b)) {
                raizes.add(b);
            }

            // Verifica se há mudança de sinal indicando uma raiz no intervalo [a, b]
            if (f.apply(a) * f.apply(b) < 0) {
                double raiz = bissecao(f, a, b, tol, maxIter);
                if (!raizes.contains(raiz)) { // Evita duplicatas
                    raizes.add(raiz);
                }
            }

            a = b;
            b = a + passo;
        }
        return raizes;
    }

    private static double bissecao(Function<Double, Double> f, double a, double b, double tol, int maxIter) {
        double meio = 0;
        for (int i = 0; i < maxIter; i++) {
            meio = (a + b) / 2;
            double fMeio = f.apply(meio);

            if (Math.abs(fMeio) < tol || (b - a) / 2 < tol) {
                return meio;
            }

            if (f.apply(a) * fMeio < 0) {
                b = meio;
            } else {
                a = meio;
            }
        }
        return meio;
    }

    public static void main(String[] args) {
        // Exemplo: f(x) = x³ - 15x
        Function<Double, Double> funcao = x -> (x * x * x) - (15 * x);
        List<Double> raizes = encontrarRaizes(funcao, -5, 5, 1, 1e-6, 1);

        System.out.println("Raízes encontradas: " + raizes);
    }
}
