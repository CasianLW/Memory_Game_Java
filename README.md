
# Memory card flipping game

![gif](https://media.giphy.com/media/nK0H37nPLUpI1XrVtS/giphy.gif)

## Installation / utilisation
Le jeu se trouve dans le dossier 'memory_game', télécharger ce fichier et 'run' dans votre IDE.
(attention le SDK & JavaFX à avoir)

## Etapes projet:
### Partie 1 : Setup
1. Init JavaFx project : memory_game
2. Creation des classes vides
   (Utilise memory_game crée à l'aide d'intelliJ si tu ne veut pas perdre à nouveau du temps avec les prochaines etapes)
3. Ajout librarie JavaFx au projet deja existant ! (File > Structure Project > Libraries + activate 'lib' on File > Structure Project > Modules)
4. Configurer la VM pour JavaFX (Run > Edit Configurations > Add VM options : --module-path "C:\Program Files\javafx-sdk-20.0.1\lib" --add-modules=javafx.controls  )
5. Assurez-vous que la version de JavaFX et du SDK sont compatibles (notre cas 20.0.1 et 19) (File>Edit Conf..)
6. Si tu as utilisé memory_game mets toutes tes classes là-bas et travaille dans ce fichier, tu peux t'en passer du 3 4 5)

### Partie 2 : Dev
1. Commencer par configurer et créer le main/mainController et le main.fxml pour afficher la fenetre de jeu (avec modes de jeu, theme & noms players)
2. Tester la table de jeu 'run'
3. Créer les classes les plus simples 'Players' , 'Scoreboard' et 'Card'
4. La partie Game qui nécessite le plus de temps car beaucoup de logique et tests nécessaires
5. Gestion des erreurs et corrections bugs (animation, double flip, etc)
   (plus de details dans les commits j'ai été assez verbose)


[![Review Assignment Due Date](https://classroom.github.com/assets/deadline-readme-button-24ddc0f5d75046c5622901739e7c5dd533143b0c8e959d652212380cedb1ea36.svg)](https://classroom.github.com/a/IY5vZRPk)
