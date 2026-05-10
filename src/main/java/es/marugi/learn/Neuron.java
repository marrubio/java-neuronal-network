package es.marugi.learn;

import java.util.Random;

// Clase que representa una neurona individual
class Neuron {
    double[] weights;
    double bias;
    private Random random = new Random();

    public Neuron(int inputSize) {
        weights = new double[inputSize];
        // Inicializar pesos aleatoriamente entre -1 y 1
        for (int i = 0; i < inputSize; i++) {
            weights[i] = random.nextGaussian() * 0.5; // Distribución normal
        }
        bias = random.nextGaussian() * 0.5;
    }

    public double activate(double[] inputs) {
        double sum = bias;

        // Calcular la suma ponderada
        for (int i = 0; i < inputs.length; i++) {
            sum += inputs[i] * weights[i];
        }

        // Aplicar función de activación (sigmoid)
        return ActivationFunction.sigmoid(sum);
    }
}