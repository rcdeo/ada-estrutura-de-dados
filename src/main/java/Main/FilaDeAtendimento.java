package Main;

import dataStructure.Queue;

import java.util.Random;

public class FilaDeAtendimento {

//  Imagine que você está desenvolvendo um sistema de atendimento ao cliente para uma loja. Crie um programa
//  que simule a fila de atendimento, onde os clientes entram na fila e são atendidos um por um.

    public static void main(String[] args) {
        int n = 5;
        var random = new Random();
        int cliente = random.nextInt(101); // limite nao inclue - 0 a 100
        Queue queue = new Queue(cliente);
        System.out.println("Chegou o cliente " + cliente);

//      Simula a chegada dos clientes
        for (int i = 2; i <= n; i++) {
            cliente = random.nextInt(101);
            System.out.println("Chegou o cliente " + cliente);
            queue.enqueue(cliente);
        }

//      Atendimento dos clientes
        var node = queue.dequeue();
        while (node != null) {
            System.out.println("Atendido o cliente " + node.getValue());
            node = queue.dequeue();
        }

    }
}
