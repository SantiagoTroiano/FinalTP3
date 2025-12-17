# FinanzasApp - TP3 Final

**FinanzasApp** es una aplicación nativa de Android desarrollada con **Kotlin** y **Jetpack Compose** para la gestión integral de finanzas personales.  
Este proyecto corresponde a **Taller de Programación 3 (TP3)** y demuestra el uso de arquitectura moderna, navegación compleja, persistencia remota y patrones de diseño actuales.

---

## 🚀 Descripción General

FinanzasApp permite a los usuarios registrar y monitorear sus ingresos y egresos, ofreciendo una herramienta intuitiva para la gestión de finanzas personales.  
Según el perfil configurado, se habilitan funcionalidades adaptadas a cada necesidad.

Los usuarios pueden:
- Registrar ingresos mensuales
- Cargar gastos fijos y variables
- Categorizar movimientos (hogar, transporte, entretenimiento, salud, etc.)
- Establecer metas de ahorro
- Visualizar reportes dinámicos
- Recibir alertas e insights de consumo

---

## ✨ Funcionalidades Destacadas

- Registro y visualización de **ingresos y egresos**
- Agrupación de transacciones por **mes**
- Filtros por tipo de movimiento (income / expense)
- Dashboard con balances y resumen financiero
- Navegación fluida entre múltiples pantallas
- Soporte para **Modo Claro / Modo Oscuro**
- Inicio de sesión con **biometría**
- Visualización de estadísticas financieras
- Búsqueda de movimientos por categoría o monto

---

## 🗄️ Persistencia de Datos

### Firebase Firestore
- Almacenamiento remoto de transacciones
- Sincronización en la nube
- Lectura asincrónica con Coroutines

### Room Database
- Persistencia local de preferencias del usuario
- Guardado del estado del tema (Dark / Light)
- Soporte offline para configuración

---

## 🛠 Tech Stack & Arquitectura

El proyecto sigue los lineamientos de **Modern Android Development (MAD)** y una arquitectura **MVVM** clara y escalable.

### Tecnologías utilizadas
- Lenguaje: **Kotlin**
- UI: **Jetpack Compose (Material Design 3)**
- Arquitectura: **MVVM**
- Inyección de Dependencias: **Hilt (Dagger)**
- Navegación: **Navigation Compose**
- Persistencia remota: **Firebase Firestore KTX**
- Persistencia local: **Room Database**
- Concurrencia: **Coroutines + StateFlow**
- Seguridad: **AndroidX Biometric**

---

## 🧩 Inyección de Dependencias con Hilt

Se implementó **Hilt** para desacoplar las capas de la aplicación y respetar el ciclo de vida de Android.

Antes:
- Las clases creaban manualmente sus dependencias
- Alto acoplamiento
- Menor escalabilidad y testabilidad

Ahora:
- Las dependencias se inyectan por constructor
- `TransactionsViewModel` recibe `TransactionsRepository`
- `TransactionsRepository` recibe `FirestoreService`

Beneficios:
- Menor acoplamiento
- Mejor testeo
- Código más mantenible
- Respeto del ciclo de vida de Android


---

## ✅ Cumplimiento de Criterios de Evaluación

| Criterio                  | Estado | Detalle                                          |
| ------------------------- | :----: | ------------------------------------------------ |
| Funcionalidad             |    ✅   | Registro, filtros y visualización de movimientos |
| Diseño & Estética         |    ✅   | UI 100% Compose, sin Relay ni XML legacy         |
| Componentes               |    ✅   | Componentes reutilizables                        |
| Navegación                |    ✅   | Navigation Compose con múltiples rutas           |
| Listados                  |    ✅   | Listados agrupados por mes                       |
| Room                      |    ✅   | Persistencia local de preferencias               |
| Retrofit                  |    ✅   | Cliente configurado, no consumido activamente    |
| ViewModel                 |    ✅   | StateFlow y manejo de estado                     |
| Arquitectura              |    ✅   | Separación Data → Repository → ViewModel → UI    |
| Inyección de Dependencias |    ✅   | Hilt implementado correctamente                  |
| Extras                    |    ✅   | Firebase, Biometría, Dark Mode                   |

---

## ⚙️ Configuración e Instalación

1. Clonar el repositorio:

```bash
git clone https://github.com/SantiagoTroiano/FinalTP3.git)
```

2. Abrir en Android Studio
   Versión recomendada: **Ladybug / Koala**

3. Configurar Firebase:

* Agregar `google-services.json` en la carpeta `/app`
* El archivo no se incluye en el repositorio por seguridad

4. Compilar:

* Java 17
* compileSdk 36

5. Ejecutar:

* Conectar un dispositivo o emulador
* Presionar **Run**

---

## 📄 Datos Académicos

Desarrollado para la materia **Taller de Programación 3**

**Institución:** ORT Argentina

**Alumno:** Santiago M. Troiano

**Año:** 2025

**Instancia:** Final

```
```
