package  es.marugi.learn;

import java.util.*;

// Clase principal para demostrar la red neuronal
public class NeuralNetworkDemo {
    public static void main(String[] args) {
        System.out.println("=== DEMO DE RED NEURONAL SIMPLE ===\n");

        // Crear una red neuronal para aprender XOR
        // XOR es un problema clásico que no es linealmente separable
        NeuralNetwork network = new NeuralNetwork(2, 4, 1); // 2 inputs, 4 hidden, 1 output

        // Datos de entrenamiento para XOR
        double[][] inputs = {
                {0, 0},
                {0, 1},
                {1, 0},
                {1, 1}
        };

        double[][] expectedOutputs = {
                {0}, // 0 XOR 0 = 0
                {1}, // 0 XOR 1 = 1
                {1}, // 1 XOR 0 = 1
                {0}  // 1 XOR 1 = 0
        };

        System.out.println("Entrenando la red neuronal para aprender XOR...");
        System.out.println("Progreso del entrenamiento:");

        // Entrenar la red
        for (int epoch = 0; epoch < 10000 ; epoch++) {
            for (int i = 0; i < inputs.length; i++) {
                network.train(inputs[i], expectedOutputs[i]);
            }

            // Mostrar progreso cada 1000 épocas
            if (epoch % 1000 == 0) {
                double error = calculateTotalError(network, inputs, expectedOutputs);
                System.out.printf("Época %d: Error = %.6f\n", epoch, error);
            }
        }

        System.out.println("\n=== RESULTADOS DESPUÉS DEL ENTRENAMIENTO ===");

        // Probar la red entrenada
        for (int i = 0; i < inputs.length; i++) {
            double[] output = network.predict(inputs[i]);
            System.out.printf("Entrada: [%.0f, %.0f] -> Salida: %.4f (Esperado: %.0f)\n",
                    inputs[i][0], inputs[i][1], output[0], expectedOutputs[i][0]);
        }

        // Mostrar arquitectura de la red
        System.out.println("\n=== ARQUITECTURA DE LA RED ===");
        network.printArchitecture();
    }

    private static double calculateTotalError(NeuralNetwork network, double[][] inputs, double[][] expectedOutputs) {
        double totalError = 0;
        for (int i = 0; i < inputs.length; i++) {
            double[] output = network.predict(inputs[i]);
            totalError += Math.pow(output[0] - expectedOutputs[i][0], 2);
        }
        return totalError / inputs.length;
    }
}
