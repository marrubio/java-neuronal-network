# java-neuronal-network
Java neuronal network learning sample

## Conceptos Fundamentales Implementados:
1. Arquitectura de la Red

- **Neuronas**: Unidades básicas que procesan información
- **Capas**: Conjuntos de neuronas organizadas (entrada, oculta, salida)
- **Pesos y Bias**: Parámetros que la red aprende durante el entrenamiento

2. Proceso de Aprendizaje

- Forward Pass: Los datos fluyen desde la entrada hasta la salida
- Función de Activación: Sigmoid para introducir no-linealidad
- Backpropagation: Algoritmo para ajustar pesos basado en el error
- Gradiente Descendiente: Método para minimizar la función de pérdida

3. Ejemplo Práctico: XOR
 La aplicación entrena la red para aprender la función XOR, que es un problema clásico porque no es linealmente separable (no se puede resolver con una línea recta).
 Cómo Ejecutar:
 ```bash
   javac NeuralNetworkDemo.java
   java NeuralNetworkDemo
 ```

## Extensiones Posibles:

- Más funciones de activación (ReLU, Tanh) - ya incluidas
- Diferentes arquitecturas (más capas, más neuronas)
- Regularización para evitar overfitting
- Diferentes optimizadores (Adam, RMSprop)
- Validación cruzada para evaluar el modelo
