package es.marugi.learn;

// Clase principal de la Red Neuronal
class NeuralNetwork {
    public Layer[] layers;
    private double learningRate = 0.1;

    public NeuralNetwork(int inputSize, int hiddenSize, int outputSize) {
        layers = new Layer[2];
        layers[0] = new Layer(hiddenSize, inputSize);  // Capa oculta
        layers[1] = new Layer(outputSize, hiddenSize); // Capa de salida
    }

    // Predicción (Forward Pass)
    public double[] predict(double[] input) {
        double[] currentInput = input;

        for (Layer layer : layers) {
            currentInput = layer.forward(currentInput);
        }

        return currentInput;
    }

    // Entrenamiento (Forward + Backward Pass)
    public void train(double[] input, double[] expectedOutput) {
        // Forward pass
        double[] output = predict(input);

        // Backward pass (Backpropagation)
        double[] error = new double[output.length];
        for (int i = 0; i < output.length; i++) {
            error[i] = expectedOutput[i] - output[i];
        }

        // Propagar el error hacia atrás
        for (int i = layers.length - 1; i >= 0; i--) {
            error = layers[i].backward(error, learningRate);
        }
    }

    public void printArchitecture() {
        System.out.println("Capas de la red:");
        for (int i = 0; i < layers.length; i++) {
            System.out.printf("Capa %d: %d neuronas, %d conexiones por neurona\n",
                    i + 1, layers[i].neurons.length, layers[i].neurons[0].weights.length);
        }
        System.out.printf("Tasa de aprendizaje: %.2f\n", learningRate);
        System.out.printf("Función de activación: Sigmoid\n");
    }
}