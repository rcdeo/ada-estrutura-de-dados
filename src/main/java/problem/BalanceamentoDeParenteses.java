package problem;

import java.util.Set;
import java.util.Stack;

public class BalanceamentoDeParenteses {

//    Problema 1: Balancemaneto de colchetes em uma expressão.
//
//    Dada uma string de expressão exp, escreva um programa para examinar se os pares e as ordens de {}()[] estão
//    corretos na expressão dada.
//    2*(3+4+5*[2+3)]
//    2*(3+4+5*[2+3])
//    [2*(3+4+5*[2+3]/(2+(3+(7+5)*9)*6)*[5+8]+17)+2]
//
//    Solução (uso de pilhas):
//    Passo 1: Empilhar caracteres de abertura.
//    Passo 2: Ao identificar caracter de fechamento, desempilhar e verificar se coincide com a abertura.
//    Passo 3: Ao final a pilha deve estar vazia.

    public static boolean solve(String expression) {
        Set<Character> openSymbols = Set.of('{', '[', '(');
        Set<Character> closeSymbols = Set.of('}', ']', ')');
        Stack<Character> stack = new Stack<>();

        for (char c : expression.toCharArray()) {
            if (openSymbols.contains(c)) stack.push(c);
            if (closeSymbols.contains(c)) {
                if (stack.isEmpty()) return false;
                var open = stack.pop();
                if (open == '(' && c != ')') return false;
                if (open == '[' && c != ']') return false;
                if (open == '{' && c != '}') return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(solve("2*(3+4+5*[2+3)]"));
        System.out.println(solve("2*(3+4+5*[2+3])"));
        System.out.println(solve("[2*(3+4+5*[2+3]/(2+(3+(7+5)*9)*6)*[5+8]+17)+2]"));
    }
}
