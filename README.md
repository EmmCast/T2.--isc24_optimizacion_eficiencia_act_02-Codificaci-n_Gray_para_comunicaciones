# Actividad 2 – Codificación Gray para Comunicaciones  
Optimización y Eficiencia de Algoritmos  

## 📘 Descripción
Este proyecto implementa dos contadores:
- **Contador binario ascendente** (función `INCREMENTO`)
- **Contador Gray ascendente** (función `INCREMENTO_GRAY`)

El objetivo es comparar ambos sistemas desde el punto de vista del **costo total de cambios de bits (flips)** al contar de **0 a 31** usando 5 bits.

El costo se define como el número de bits que cambian entre estados consecutivos.

---

## 🎯 Objetivos del proyecto
- Analizar el comportamiento del contador binario y su costo por incremento.
- Implementar el contador Gray usando la fórmula `Gray(k) = k ^ (k >> 1)`.
- Generar una tabla detallada de estados desde 0 hasta 31.
- Calcular el **costo total** de cambios para ambos contadores.
- Demostrar por qué la codificación Gray es más eficiente y estable en comunicaciones digitales.

---

## 🧠 Fundamentos teóricos

### 🔹 Contador binario
El incremento en binario puede requerir cambiar varios bits debido al acarreo.  
Ejemplo:

01111 → 10000 (cambia 5 bits)

Costo total (0..31): **57 flips**

---

### 🔹 Contador Gray
En Gray, dos valores consecutivos siempre difieren en **un solo bit**.  
Costo por incremento: **1**  
Costo total (0..31): **31 flips**

Grey(k) se obtiene como:

        g = k ^ (k >> 1)

## 🧩 Estructura del proyecto

        src/
        └── gray/
        ├── BitUtils.java
        ├── Counters.java
        └── Main.java


## Ejecutar

java -cp out gray.Main