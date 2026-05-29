# acore-player-dashboard 🎮

Backend para un dashboard de jugadores de AzerothCore. Sistema de gestión integral para que los jugadores consulten sus personajes, vean información de la subasta y controlen sus cuentas desde una interfaz web.

## 🎯 Descripción del Proyecto

Este es un backend moderno desarrollado con **Spring Boot** que integra autenticación SRP6, JWT, y acceso a múltiples bases de datos de AzerothCore. Proporciona endpoints REST para que un frontend (React) consuma los datos de forma segura.

**Estado:** En desarrollo (Fase 1: Consulta de personajes y autenticación en proceso)

## ✨ Funcionalidades Actuales

- ✅ **Autenticación SRP6**: Login seguro compatible con AzerothCore
- ✅ **JWT**: Tokens para sesiones sin estado
- ✅ **Consulta de Personajes**: Listar y ver detalles de personajes por cuenta
- ✅ **Validación de Seguridad**: Verificar que el usuario solo vea sus propios personajes
- ✅ **CORS**: Integración con frontend en `http://localhost:5173`
- ✅ **DTOs y Mapeos**: Conversión de entidades con enums (clase, raza)

## 🔮 Funcionalidades Futuras

- 🚧 **Sistema de Subasta**: Comprar/vender items en la subasta del reino
- 🚧 **Consultar Inventario**: Ver inventario y banco de cada personaje
- 🚧 **Dashboard Estadísticas**: Datos de progreso de personajes

## 🛠 Tecnologías

- **Framework**: Spring Boot 4.x
- **Base de Datos**: MySQL (AzerothCore - acore_auth, acore_characters)
- **Autenticación**: SRP6 + JWT
- **ORM**: Hibernate/JPA
- **Build Tool**: Maven
- **Lombok**: Para reducir boilerplate

## 📦 Estructura del Proyecto

```
src/main/java/com/wow/dashboard/
├── domain/
│   ├── model/          # Entidades JPA (Account, Character)
│   ├── repository/     # Interfaces JPA Repository
│   └── enums/          # Enums (CharacterClass, CharacterRace)
├── application/
│   ├── service/        # Lógica de negocio
│   └── mapper/         # DTOs y mapeos
├── security/
│   ├── jwt/            # Token generation y filtros
│   ├── service/        # AuthService con SRP6
│   └── config/         # SecurityConfig
└── web/
    ├── controller/     # REST Controllers
    └── dto/            # Response/Request DTOs
```

## 🚀 Endpoints Principales

### Autenticación
- `POST /api/auth/login` - Login con usuario/contraseña

### Personajes
- `GET /api/characters` - Listar personajes del usuario (requiere JWT)
- `GET /api/characters/{guid}` - Ver detalles de un personaje (requiere JWT y pertenencia a la cuenta)

## 📋 Requisitos

- JDK 21+
- Maven 3.8+
- MySQL 8.0+
- AzerothCore instalado y ejecutándose

## 🔧 Configuración

1. Clonar el repositorio
2. Configurar `application.yaml` con tu datasource de AzerothCore
3. Ejecutar `mvn clean install`
4. Iniciar: `mvn spring-boot:run`

**URL Base**: `http://localhost:8080`

## 📝 Notas de Desarrollo

- Las entidades usan validación `ddl-auto: validate` para evitar cambios no autorizados
- El JWT incluye el `userId` como claim para extracciones automáticas en controladores
- CORS habilitado solo para `http://localhost:5173` (frontend local)
- Próximas fases usarán arquitectura mejorada para el sistema de subasta
