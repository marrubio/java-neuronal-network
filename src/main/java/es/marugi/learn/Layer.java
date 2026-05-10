package es.marugi.learn;

// Clase que representa una capa de la red neuronal
class Layer {
    Neuron[] neurons;
    double[] lastInput;  // Para el backpropagation
    double[] lastOutput; // Para el backpropagation

    public Layer(int neuronCount, int inputSize) {
        neurons = new Neuron[neuronCount];
        for (int i = 0; i < neuronCount; i++) {
            neurons[i] = new Neuron(inputSize);
        }
    }

    public double[] forward(double[] input) {
        lastInput = input.clone();
        double[] output = new double[neurons.length];

        for (int i = 0; i < neurons.length; i++) {
            output[i] = neurons[i].activate(input);
        }

        lastOutput = output.clone();
        return output;
    }

    public double[] backward(double[] error, double learningRate) {
        double[] inputError = new double[lastInput.length];

        for (int i = 0; i < neurons.length; i++) {
            // Calcular el gradiente para esta neurona
            double delta = error[i] * ActivationFunction.sigmoidDerivative(lastOutput[i]);

            // Actualizar pesos
            for (int j = 0; j < neurons[i].weights.length; j++) {
                inputError[j] += neurons[i].weights[j] * delta;
                neurons[i].weights[j] += learningRate * delta * lastInput[j];
            }

            // Actualizar bias
            neurons[i].bias += learningRate * delta;
        }

        return inputError;
    }
}
