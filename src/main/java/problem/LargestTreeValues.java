package problem;

import dataStructure.Tree;

import java.util.ArrayList;
import java.util.List;

public class LargestTreeValues {

//    Problema 3: Maior valor em cada nível da Árvore Binária.
//
//    Dada uma ávore binária, econtre o maior valor em cada nível.
//
//    Solução:
//    Passo 1: Utilize o algoritmo BFS (não usado aqui) para percorrer a árvore e uma lista auxiliar.
//    Passo 2: Para cada elementoe e seu nível na árvore:
//          2.1: Se a lista possuir índice == nível, substitua pelo maior valor.
//          2.2: Senão, adicione na lista.

    public static List<Integer> largestValues(Tree tree) {
        var list = new ArrayList<Integer>();
        solveTree(tree.root, 0, list);
        return list;
    }

    private static void solveTree(final Tree.Node node, final int level, final ArrayList<Integer> list) {
        if (node == null) return;

        if (level == list.size()) {
            list.add(node.value);
        } else {
            list.set(level, Math.max(list.get(level), node.value));
        }

        solveTree(node.left, level + 1, list);
        solveTree(node.right, level + 1, list);
    }

    public static void main(String[] args) {
        Tree tree = new Tree();
        tree.insert(100);

        tree.insert(10);
        tree.insert(5);

        tree.insert(6);
        tree.insert(1);
        tree.insert(7);
        tree.insert(5);

        System.out.println(largestValues(tree));
    }
}
