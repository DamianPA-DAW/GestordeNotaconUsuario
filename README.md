# GestordeNotaconUsuario
Actividad de Programación donde tengo que hacer el código de  Gestor de Nota con Usuario. 
Alumno: Damián Pérez Alemán

Gestor de Notas Hecho con Java Swing

Funciones Principales:
- Gestión de Notas: Crear, editar, eliminar y ver notas.
- Seguridad: Registro e inicio de sesión con contraseñas encriptadas (SHA-256).
- Persistencia: Las notas se guardan en un archivo para que no se pierdan al cerrar el programa.
- Interfaz: Menú lateral, editor central y avisos de confirmación.

Tecnologías:
- Java Swing: Para la interfaz gráfica.
- MVC: Código separado por carpetas (Modelos, Vistas, Controladores).
- Serialización: Para guardar los datos en un archivo `.dat`.

Estructura del Código:
- `models`: Clases Nota y Usuario.
- `views`: Pantallas de Login, Registro y Principal.
- `controllers`: Lógica de los botones y eventos.
- `repository`: Guardado de archivos.
- `utils`: Validaciones y seguridad.

Uso:
1. Ejecuta el archivo `main.java`.
2. Regístrate en la pantalla de registro.
3. Inicia sesión y empieza a crear tus notas.
