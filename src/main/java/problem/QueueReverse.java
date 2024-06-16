package problem;

import java.util.LinkedList;
import java.util.Queue;

public class QueueReverse {

//    Problema 2: Revertendo os primeiros K elementos de uma fila.
//
//    Dado  um inteiro K e uma fila de inteiros, a tarefa é inverter a ordem dos primeiros k elementos da fila,
//    deixando os demais elementos na mesma ordem relativa. Exemplos:
//    [1, 2, 3, 4, 5] -> K=2 -> [2, 1, 3, 4, 5]
//    [1, 2, 3, 4, 5] -> K=4 -> [4, 3, 2, 1, 5]
//
//    Solução (uso de filas):
//    Passo 1: Para os K primeiros elementos:
//          1.1: desenfileirar elemento x
//          1.2: reordena (K-1) elementos
//          1.3: enfileirar elemento x

//    Passo 2: Para os N-K elementos:
//          2.1: desenfileirar
//          2.2: enfileirar

    public static Queue<Integer> reverseFirstK(Queue<Integer> queue, int k) {
        solveQueue(queue, k);
        int n = queue.size() - k;
        while (n-- > 0) {
            int element = queue.remove();
            queue.add(element);
        }
        return queue;
    }

    private static void solveQueue(final Queue<Integer> queue, final int k) {
        if (k == 0) return;
        int element = queue.remove();
        solveQueue(queue, k - 1);
        queue.add(element);
    }

    public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(1);
        queue.add(2);
        queue.add(3);
        queue.add(4);
        queue.add(5);

        System.out.println(reverseFirstK(queue, 4));
    }
}
