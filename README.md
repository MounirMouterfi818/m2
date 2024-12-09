# UCE Génie Logiciel Avancé : Techniques de tests

# Projet de CI/CD

**Nom :** Mounir Mouterfi
**Groupe :** M1IA

## Description

Ce projet met en place une pipeline CI/CD utilisant CircleCI pour automatiser l'exécution des tests et l'intégration continue. Nous utilisons également JaCoCo pour générer des rapports de couverture de tests et Codecov pour visualiser la couverture directement dans GitHub.

## Choix techniques

- **CircleCI :** Nous avons utilisé CircleCI pour orchestrer notre pipeline d'intégration continue. Le workflow comprend l'exécution des tests unitaires avec Maven sur une image Docker contenant le JDK.
- **JaCoCo :** Pour générer la couverture de code, nous utilisons JaCoCo. Cela permet de mesurer le pourcentage de code couvert par les tests unitaires.
- **Codecov :** Nous avons intégré Codecov pour télécharger et visualiser la couverture de test générée par JaCoCo. Cela nous permet de suivre la qualité du code tout au long du développement.

## Badges

![CircleCI](https://circleci.com/gh/MounirMouterfi818/m2.svg?style=shield)
![Codecov](https://codecov.io/gh/MounirMouterfi818/m2/branch/main/graph/badge.svg)

- **CircleCI Badge :** Indicateur du statut actuel des builds dans CircleCI.
- **Codecov Badge :** Indicateur de la couverture de code pour le projet, généré par Codecov.

## Instructions

1. Clonez ce dépôt.
2. Assurez-vous d'avoir Java 22 et Maven installés sur votre machine.
3. Exécutez les tests en local avec la commande suivante :
    ```bash
    mvn clean verify
    ```
4. Poussez vos modifications sur la branche `main` pour voir les résultats dans CircleCI et Codecov.

## Liens Utiles

- [CircleCI Dashboard](https://circleci.com/gh/username/repository)
- [Codecov Dashboard](https://codecov.io/gh/username/repository)


## Introduction

Vous allez à travers ces projet mettre en application une partie des aspects évoqués en cours vis à vis des techniques de tests.  
Pour cela nous allons réaliser un projet logiciel de petite taille, en suivant la roadmap suivante : 
- Setup du projet
- Mise en place des outils d’intégration continue
- Écriture des tests unitaires
- Écriture des mocks, et validation des tests
- Développement dirigé par les tests
- Documentation et conventions de style
- Test d'une implémentation donnée

Durant cette série de TPs, le gestionnaire de version Git sera utilisé à foison, à travers la plateforme GitHub. Si vous n’êtes pas à l’aise avec cet outil[^1], [voici](http://rogerdudler.github.io/git-guide/) un petit guide à garder sous la main.

## Sujets

L'ensemble des sujets de TPs peut être trouvé dans le dossier `TPs`.

Le dossier `src` contient la définition de l'ensemble des interfaces qui seront l'objet de vos travaux.

## Rendus

Le rendu des TPs se fait au rythme suivant :

- TP1 : 2ème séance
- TP2 : 2ème séance
- TP3 : 3ème séance
- TP4 : 5ème séance
- TP5 : dernière séance
- TP6 : dernière séance

Pour chaque rendu vous devez créer un tag à partir du commit qui correspond à la complétion du TP.  
Si vous ne spécifiez pas de tag, le dernier commit à la date-heure de la fin de séance sera celui considéré.

[^1]: Si vous n’êtes vraiment pas à l’aise avec cet outil nous vous conseillons quand même vivement de vous y mettre.
