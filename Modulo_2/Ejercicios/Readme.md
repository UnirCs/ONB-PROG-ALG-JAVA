# Ejercicio: Crear y Enlazar un Repositorio Local y Remoto con Git

En este ejercicio, aprenderemos cómo crear un repositorio local utilizando `git init`, cómo crear un repositorio remoto en GitHub, y cómo enlazarlos. También verificaremos la conexión mediante `git push` y `git pull`.

## Pasos

### 0. Crear el proyecto Java
1. Dentro de IntelliJ IDEA, crea un nuevo proyecto Java.
2. El proyecto debe ser de tipo "Java" y no debe incluir ningún sistema de control de versiones al momento de crearlo.
3. Usa la versión de Java que hayas instalado previamente.
4. Nombra el proyecto como `mi-proyecto-java`.

### 1. Crear el repositorio local
1. Abre una terminal (dentro del IDE por ejemplo)
2. Asegúrate de estar en el directorio donde deseas crear tu proyecto, es decir, dentro de `mi-proyecto-java`.
3. Ejecuta el comando:
   ```bash
   git init
   ```
   Esto inicializa un nuevo repositorio Git en la carpeta `mi-proyecto-java`.

4. Crea un archivo de ejemplo para confirmar los cambios:
   ```bash
   echo "# Mi Proyecto Java" > README.md
   git add README.md
   git commit -m "Inicializando el repositorio con README"
   ```

### 2. Crear el repositorio remoto en GitHub
1. Ve a [GitHub](https://github.com) e inicia sesión en tu cuenta o crea una nueva.
2. Haz clic en el botón "+" (esquina superior derecha) y selecciona "New repository". También puedes encontrar un botón verde que indica "New Repository" en la página de GitHub.
3. Ingresa el nombre `mi-proyecto-java`.
4. Opcionalmente, añade una descripción. No marques ninguna opción de inicialización (como README o .gitignore).
5. Haz clic en "Create repository".

### 3. Enlazar el repositorio local con el remoto
1. Copia la URL del repositorio remoto desde la página de GitHub (por ejemplo: `https://github.com/tu-usuario/mi-proyecto-java.git`).
2. En la terminal, enlaza el repositorio remoto:
   ```bash
   git remote add origin https://github.com/tu-usuario/mi-proyecto-java.git
   ```

3. Empuja los cambios locales al repositorio remoto:
   ```bash
   git branch -M master
   git push -u origin master
   ```

### 4. Verificar la conexión con `git pull`
1. Realiza un cambio directo en el repositorio remoto desde la interfaz web de GitHub:
    - Navega a tu repositorio remoto.
    - Haz clic en el archivo `README.md` o en el archivo que hayas subido al repositorio.
    - Selecciona "Edit this file".
    - Añade una nueva línea vacia (con el mensaje de commit: "Este es un cambio hecho desde GitHub.").
    - Haz clic en "Commit changes".

2. Vuelve a la terminal y actualiza tu repositorio local:
   ```bash
   git pull origin master
   ```
   Confirma que el cambio hecho en GitHub ahora está presente en tu repositorio local.
