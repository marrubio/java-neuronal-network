package es.marugi.learn;

import java.util.Arrays;

// Utilidades para análisis y métricas
public class NetworkUtils {
    public static double meanSquaredError(double[] predicted, double[] actual) {
        double sum = 0;
        for (int i = 0; i < predicted.length; i++) {
            sum += Math.pow(predicted[i] - actual[i], 2);
        }
        return sum / predicted.length;
    }

    public static void printWeights(NeuralNetwork network) {
        System.out.println("=== PESOS DE LA RED ===");
        for (int layerIndex = 0; layerIndex < network.layers.length; layerIndex++) {
            System.out.printf("Capa %d:\n", layerIndex + 1);
            Layer layer = network.layers[layerIndex];

            for (int neuronIndex = 0; neuronIndex < layer.neurons.length; neuronIndex++) {
                Neuron neuron = layer.neurons[neuronIndex];
                System.out.printf("  Neurona %d: Pesos=%s, Bias=%.4f\n",
                        neuronIndex, Arrays.toString(neuron.weights), neuron.bias);
            }
        }
    }

    public static double[] normalizeInput(double[] input, double min, double max) {
        double[] normalized = new double[input.length];
        for (int i = 0; i < input.length; i++) {
            normalized[i] = (input[i] - min) / (max - min);
        }
        return normalized;
    }
}