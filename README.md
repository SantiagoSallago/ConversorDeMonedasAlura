# Conversor de Divisas (USD a ARS, BRL, CLP) con Java y ExchangeRate API

Este es un proyecto Java que permite al usuario consultar tasas de cambio actualizadas desde la moneda estadounidense (USD) hacia tres monedas latinoamericanas: pesos argentinos (ARS), reales brasileños (BRL) y pesos chilenos (CLP). El programa utiliza la [ExchangeRate API](https://www.exchangerate-api.com/) y permite realizar conversiones interactivas por consola.

## ✨ Funcionalidades

- Obtiene tasas de cambio actualizadas en tiempo real.
- Permite elegir la moneda a la que se desea convertir.
- Calcula el monto correspondiente según la tasa actual.
- Funciona completamente desde consola.
- Manejo básico de errores y entradas del usuario.

## 📦 Requisitos

- Java 11 o superior
- Conexión a internet
- Cuenta gratuita en [ExchangeRate API](https://www.exchangerate-api.com/) para obtener tu API Key

## 🚀 Ejecución

1. Cloná este repositorio:
   ```bash
   git clone https://github.com/SantiagoSallago/ConversorDeMonedasAlura.git
   cd nombre-del-repo
   
Agregá tu propia API key en el archivo Main.java:

String key = "TU_API_KEY_AQUI";

Compila y ejecuta.
