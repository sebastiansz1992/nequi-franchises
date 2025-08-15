# Proyecto - Despliegue en AWS con ECS Fargate, ECR y RDS MySQL

Arquitectura:

<img width="1250" height="788" alt="image" src="https://github.com/user-attachments/assets/e27d0fe5-9a68-425f-983a-fcbbd9e97c6b" />

1.	Usuario / Cliente
   -	Envía solicitudes HTTP/HTTPS a través de Internet.

2.	Amazon Route 53 (opcional)
   -	Si usas un dominio propio, gestionará el enrutamiento de DNS hacia tu servicio.

3.	Application Load Balancer (ALB)
   -	Recibe el tráfico HTTP/HTTPS y lo distribuye a las tareas de ECS.

4.	Amazon ECS con Fargate
   -	Ejecuta tu servicio en contenedores.
   -	Obtiene la imagen desde Amazon ECR.

5.	Amazon ECR (Elastic Container Registry)
   -	Almacena la imagen Docker creada a partir de tu Dockerfile.

6.	Amazon RDS MySQL
   -	Base de datos relacional donde se almacenan los datos de la aplicación.
   -	Conectada a ECS dentro de una VPC privada para mayor seguridad.

7.	Security Groups y Subnets
   -	Controlan el acceso a ECS y RDS.
   -	RDS solo accesible desde ECS.
   -	ALB en subredes públicas, ECS y RDS en subredes privadas.

---

Este proyecto describe cómo desplegar una aplicación en **AWS** utilizando:
- **Amazon RDS (MySQL)** para la base de datos.
- **Amazon ECR** para almacenar la imagen Docker.
- **Amazon ECS con Fargate** para ejecutar la aplicación sin administrar servidores.

---

## 📋 Prerrequisitos

Antes de iniciar, asegúrate de tener:
- Una cuenta de **AWS**.
- **AWS CLI** instalado y configurado (`aws configure`).
- **Docker** instalado.
- **Git** instalado.
- Permisos para crear recursos en AWS (ECR, ECS, RDS, IAM).

---

## ⚙️ Paso 1 - Crear base de datos RDS MySQL

1. Inicia sesión en la consola de AWS.
2. Ve a **RDS** → **Create Database**.
3. Selecciona:
   - Engine: **MySQL**.
   - Template: **Free tier** (o producción si aplica).
   - Configura nombre de usuario y contraseña.
   - Habilita acceso público si necesitas conexión externa (recomendado solo para pruebas).
   - Asigna un **Security Group** que permita acceso desde ECS.
4. Guarda el **endpoint**, usuario y contraseña.

---

## 📦 Paso 2 - Crear repositorio en Amazon ECR

1. Ve a **Amazon ECR** → **Create Repository**.
2. Asigna un nombre (ej: `mi-servicio`).
3. Guarda la URI del repositorio (ej: `123456789012.dkr.ecr.us-east-1.amazonaws.com/mi-servicio`).

---

## 🐳 Paso 3 - Construir y subir imagen Docker

bash
# Autenticar Docker con ECR
aws ecr get-login-password --region us-east-1 | docker login --username AWS --password-stdin <ID_CUENTA>.dkr.ecr.us-east-1.amazonaws.com

# Construir imagen
docker build -t mi-servicio .

# Etiquetar imagen para ECR
docker tag mi-servicio:latest <ID_CUENTA>.dkr.ecr.us-east-1.amazonaws.com/mi-servicio:latest

# Subir imagen
docker push <ID_CUENTA>.dkr.ecr.us-east-1.amazonaws.com/mi-servicio:latest

---

## ☁️ Paso 4 - Crear Cluster y Servicio en ECS con Fargate

1. Ve a Amazon ECS → Clusters → Create Cluster.
2. Selecciona Fargate.
3. Crea un Task Definition:
   - Tipo: Fargate.
   - Container: usa la imagen del ECR.
   - Configura variables de entorno para la conexión a la base de datos:
     - DB_HOST (endpoint RDS)
     - DB_USER
     - DB_PASS
     - DB_NAME
4. Crea el Service:
   - Tipo: Fargate.
   - Define número de tareas (tasks).
   - Asigna un Load Balancer si es necesario.
  
---

## 🔍 Paso 5 - Verificar despliegue
1. Ve al Service en ECS y revisa que las tareas estén corriendo.
2. Si tienes un Load Balancer, abre la URL para validar que el servicio responde.
