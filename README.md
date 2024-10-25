# TodoList API

Cette API REST, développée avec Spring Boot, permet la gestion d'une liste de tâches (CRUD complet) avec un endpoint supplémentaire pour supprimer toutes les tâches en une seule requête.

## Table des matières

- [Installation](#installation)
- [Endpoints](#endpoints)
    - [GET /api/todos](#get-apitodos)
    - [GET /api/todos/{id}](#get-apitodosid)
    - [POST /api/todos](#post-apitodos)
    - [PUT /api/todos/{id}](#put-apitodosid)
    - [DELETE /api/todos/{id}](#delete-apitodosid)
    - [DELETE /api/todos/all](#delete-apitodosall)
- [Dépendances](#dépendances)
- [Contact](#contact)

## Installation

1. **Cloner le dépôt** :
   ```bash
   git clone https://github.com/tonylapoche/todolist-api.git
   cd todolist-api
   ```

2. **Configurer la base de données** : Assurez-vous de bien configurer une base de données (par exemple, H2, MySQL) dans le fichier `application.properties`.

3. **Lancer l'application** :
   ```bash
   ./mvnw spring-boot:run
   ```

4. L'API sera disponible sur `http://localhost:8080/api/todos`.

## Endpoints

### GET /api/todos

**Description** : Récupère toutes les tâches.

- **URL** : `/api/todos`
- **Méthode HTTP** : `GET`
- **Réponse** :
    - **Code 200** : Liste de toutes les tâches
    - **Exemple de réponse** :
      ```json
      [
        {
          "id": 1,
          "title": "Acheter des courses",
          "description": "Acheter du lait, des œufs et du pain.",
          "completed": false
        },
        ...
      ]
      ```

### GET /api/todos/{id}

**Description** : Récupère une tâche par son `id`.

- **URL** : `/api/todos/{id}`
- **Méthode HTTP** : `GET`
- **Paramètres de chemin** :
    - `id` (Long) : ID de la tâche.
- **Réponse** :
    - **Code 200** : Détails de la tâche.
    - **Code 404** : Tâche non trouvée.
    - **Exemple de réponse** :
      ```json
      {
        "id": 1,
        "title": "Acheter des courses",
        "description": "Acheter du lait, des œufs et du pain.",
        "completed": false
      }
      ```

### POST /api/todos

**Description** : Crée une nouvelle tâche.

- **URL** : `/api/todos`
- **Méthode HTTP** : `POST`
- **Corps de requête** :
  ```json
  {
    "title": "Titre de la tâche",
    "description": "Description de la tâche",
    "completed": false
  }
  ```
- **Réponse** :
    - **Code 201** : Tâche créée avec succès, avec l’URL de la nouvelle tâche.
    - **Exemple de réponse** :
      ```json
      {
        "id": 2,
        "title": "Titre de la tâche",
        "description": "Description de la tâche",
        "completed": false
      }
      ```

### PUT /api/todos/{id}

**Description** : Met à jour une tâche existante.

- **URL** : `/api/todos/{id}`
- **Méthode HTTP** : `PUT`
- **Paramètres de chemin** :
    - `id` (Long) : ID de la tâche à mettre à jour.
- **Corps de requête** :
  ```json
  {
    "id": 2,
    "title": "Titre mis à jour",
    "description": "Description mise à jour",
    "completed": true
  }
  ```
- **Réponse** :
    - **Code 200** : Détails de la tâche mise à jour.
    - **Code 404** : Tâche non trouvée.

### DELETE /api/todos/{id}

**Description** : Supprime une tâche par son `id`.

- **URL** : `/api/todos/{id}`
- **Méthode HTTP** : `DELETE`
- **Paramètres de chemin** :
    - `id` (Long) : ID de la tâche à supprimer.
- **Réponse** :
    - **Code 204** : Tâche supprimée avec succès.
    - **Code 404** : Tâche non trouvée.

### DELETE /api/todos/all

**Description** : Supprime toutes les tâches.

- **URL** : `/api/todos/all`
- **Méthode HTTP** : `DELETE`
- **Réponse** :
    - **Code 204** : Toutes les tâches ont été supprimées avec succès.

## Dépendances

- Spring Boot
- Spring Web
- Lombok
- Base de données (par exemple, H2 pour les tests ou MySQL en production)

## Contact

Pour toute question ou suggestion d'amélioration, veuillez me contacter :

- **Email** : terrade.antoine.pro@gmail.com
- **GitHub** : [https://github.com/tonylapoche/todolist-api](https://github.com/tonylapoche/todolist-api)
