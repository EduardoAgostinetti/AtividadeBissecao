# Método de Bisseção para Encontrar Raízes

Este repositório contém a implementação do **Método de Bisseção** em Java para encontrar raízes de funções matemáticas. O método é uma técnica numérica usada para localizar raízes de uma função contínua em um intervalo onde a função muda de sinal.

## Descrição do Método de Bisseção

O **Método de Bisseção** é um algoritmo de busca que funciona em intervalos onde a função muda de sinal. O intervalo é repetidamente dividido ao meio, e o lado que contém a raiz é escolhido para continuar o processo, até que a solução seja encontrada com a precisão desejada.

### Passos principais:
1. Escolha um intervalo [a, b] tal que `f(a)` e `f(b)` tenham sinais opostos.
2. Calcule o ponto médio `m = (a + b) / 2`.
3. Se `f(m)` for suficientemente próximo de zero (dentro de uma tolerância), `m` é a raiz.
4. Caso contrário, substitua o intervalo com base no sinal de `f(a)` e `f(m)`, ou de `f(m)` e `f(b)`.
5. Repita até encontrar uma raiz com a precisão desejada ou até o número máximo de iterações.

## Funcionalidades

- **Encontrar múltiplas raízes**: O algoritmo pode verificar intervalos definidos e procurar por raízes em diferentes regiões.
- **Precisão ajustável**: Você pode definir a tolerância (`tol`) e o número máximo de iterações (`maxIter`) para controlar a precisão da solução.
- **Evita duplicação de raízes**: O código verifica se a raiz já foi encontrada antes de adicioná-la à lista de soluções.

## Como Usar

1. Clone este repositório ou copie o código para o seu projeto.
2. Importe a classe `Main` para usar o método de bisseção.
3. Utilize o método `encontrarRaizes` para encontrar as raízes de uma função. Este método recebe os seguintes parâmetros:
    - `f`: A função matemática que você deseja encontrar as raízes.
    - `inicio`: O valor inicial do intervalo.
    - `fim`: O valor final do intervalo.
    - `passo`: O tamanho do intervalo para dividir a busca.
    - `tol`: A tolerância para determinar a precisão das raízes.
    - `maxIter`: O número máximo de iterações para a bisseção.

### Exemplo de Uso:
```java
import java.util.function.Function;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // Função de exemplo: f(x) = x³ - 15x
        Function<Double, Double> funcao = x -> (x * x * x) - (15 * x);
        
        // Encontrar as raízes no intervalo [-5, 5] com passo 0.5, tolerância 1e-6 e 100 iterações máximas
        List<Double> raizes = encontrarRaizes(funcao, -5, 5, 0.5, 1e-6, 100);
        
        // Exibir as raízes encontradas
        System.out.println("Raízes encontradas: " + raizes);
    }
}

## Saída Esperada:
Raízes encontradas: [-3.872982978820801, 0.0, 3.872982978820801]
