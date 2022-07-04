Projet Systèmes Distribués

L’objectif est de créer un système distribué basé sur les micro-services permettant de gérer les factures des clients en utilisant l’architecture que nous avons  déjà développé auparavant en y intégrant un système de sécurité basé sur Keycloak, Un Bus de messagerie asynchrone avec KAFKA.

Les axes de projet :

	La mise en place des micro-services

      	Customer-Service
   
      	 Inventory-Service 
   
      	 Billing-Service 
   
      	Eureka Discovery Service 
   
      	Spring Cloud Gateway
   
	La mise en place du service de Sécurité avec Keycloak

	Sécurité l’ensemble des micro-services fonctionnels

	Mise en place d’une solution de messagerie asynchrone avec le Broker KAFKA 

	Mettre en place le Broker KAFKA

	Partie Front End avec Angular Framework

 
La mise en place des micro-services


L’approche micro service est le découpage de la application en plusieurs (sous application) micro services. Alors pour la communication entres ces micro services  il y a le service GATE WAY qui permet de publier les informations de chaque micro service créer (adresse IP, Port…) ou bien d’appeler Eureka Discovery Service qui  permet d’enregistrer les noms des micros service créer. Et dans ce cas chaque services est responsable d’une seule fonctionnalité qui développer testé et déployé séparément des autres avec une technologie différente des  autres.
•	Eureka Discovery Service : Service d’enregistrement  qui donne tous les instances des micros services démarrer.
 

![image](https://user-images.githubusercontent.com/102171677/177163012-aac0fc3d-5478-4a09-925e-d71c99fd9cb9.png)



•	Customer-Service : Service qui utilise sa propre base de données pour gérer les clients.
Consulter les clients.
 
 ![image](https://user-images.githubusercontent.com/102171677/177163063-6be3e4b5-961f-49c8-95a8-01c542771941.png)

•	Inventory-Service : Service qui utilise sa propre base de données pour gérer les produits.
Consulter les produits.
 
 ![image](https://user-images.githubusercontent.com/102171677/177163136-84034392-a9e0-4014-b667-f9b9984ae2a1.png)

•	Billing-Service : Service qui utilise sa propre base de données pour gérer les factures partir des autre micros services via la communication rest.
Consulter une facture par son id
 
 ![image](https://user-images.githubusercontent.com/102171677/177163173-c8d648c6-3f45-4fbb-aae4-e740cc74ac28.png)

 
Les informations principale d’une factures:

![image](https://user-images.githubusercontent.com/102171677/177163359-6d539e4e-ba49-4cf9-ae73-5dade65269ae.png)

 
•	Spring Cloud Gateway : Service qui permet de consulter les fonctionnalités des autres micros service utilisent leurs noms.
  Consulter les produits via getway.

  ![image](https://user-images.githubusercontent.com/102171677/177163471-08553839-d089-421b-90ef-e2c37c685aec.png)
 
  Consulter les clients via getway.
 
 ![image](https://user-images.githubusercontent.com/102171677/177163552-ddab00da-01f7-4136-afeb-d7916c243a1e.png)


   
  Consulter une facture par son id via getway.
 
 ![image](https://user-images.githubusercontent.com/102171677/177163577-cfd0c15b-0d66-455f-9928-e5927aae893a.png)


  La base de données des micros services :
  
  ![image](https://user-images.githubusercontent.com/102171677/177163653-a480af37-ff75-46e1-8063-dfdcb3811a4a.png)


La mise en place du service de Sécurité avec Keycloak

Dans cette partie nous avons met en pratique le service de sécurité avec keycloak qui centraliser l’infrastructure de sécurité des applications  comme :
Gestion des identités.
Authentification.
Autorisation.
Keycloak  baser sur les standard comme :
OpenID
OAuth2 samL2
Et aussi keycloak propose des adaptateurs comme spring boot&springSecurité.
Alors pour traveller avec Keycloak il faut d’Avord le télécharger id le lancer sur la machine après la spécification de jdk utiliser.

![image](https://user-images.githubusercontent.com/102171677/177163748-5d7cef61-4118-4ec6-ac20-6411cd4b129d.png)

 
Après il faut avoir un compte dans keycloak pour accéder au espace administrateur.
![image](https://user-images.githubusercontent.com/102171677/177163773-1349dc33-25a1-46b9-820f-cd9c06a2bab7.png)

 
 Créer un realm dans keycloak comme un espace dans laquelle nous avons  sécurisé les applications.
 ![image](https://user-images.githubusercontent.com/102171677/177163821-fa7bb91f-c722-46ee-b4bc-ab83f7af1bd6.png)
 
Alors après on peut gérer plusieurs fonctionnalités comme :
La création des clients ou bien les applications à sécuriser.

![image](https://user-images.githubusercontent.com/102171677/177163892-fd05ff29-4259-4968-b1ec-99053d4c1148.png)

 
La création des roules :

![image](https://user-images.githubusercontent.com/102171677/177163913-b99bf545-f52b-4829-b5fd-48907575ad50.png)


 Les créations des utilisateurs et affecter les roules.
 
 ![image](https://user-images.githubusercontent.com/102171677/177163954-101fd699-48aa-4fbe-ae4d-fdcf2f786662.png)


Personnaliser les paramétrages des tokens.

![image](https://user-images.githubusercontent.com/102171677/177163978-1451dd64-ef69-4378-a01b-cdb0f2a3ee93.png)


Après la vérification d’authentification d’utilisateurs avec advance rest client :

![image](https://user-images.githubusercontent.com/102171677/177164026-0362609f-200a-4fcc-a96a-ea4f189e82ae.png)

 

Pour obtient l’Access et refresh token ou bien keypublic :

![image](https://user-images.githubusercontent.com/102171677/177164058-b17ebded-956e-4774-bfd5-26c5a06319ec.png)


Alors après la sécurisation des micros services :
Sécurité des produits :

![image](https://user-images.githubusercontent.com/102171677/177164100-71eaee17-8892-4b3e-8e0d-7b0fd544bb1b.png)

 
Sécurité des clients :

![image](https://user-images.githubusercontent.com/102171677/177164129-c74c4d35-1fe9-4aaa-9637-c786eb428380.png)


Sécurité des factures :

![image](https://user-images.githubusercontent.com/102171677/177164161-cb095a9f-5b83-4d96-b6b9-427f35617be7.png)

 
Tester l’authentification avec un roule BILLING_MANAGER pour accéder aux factures dans advance rest client.
Avant l’authentification :

![image](https://user-images.githubusercontent.com/102171677/177164196-52061373-086d-4bb2-8311-8f21bb98dd0d.png)

 
Après l’authentification seule:

![image](https://user-images.githubusercontent.com/102171677/177164230-79deb514-1bb2-4ad2-97d8-552b0507a073.png)

 
L’authentification avec le roule demandé :

![image](https://user-images.githubusercontent.com/102171677/177164291-d3446ba4-6d61-4720-9e78-5cc7e162e579.png)

![image](https://user-images.githubusercontent.com/102171677/177164317-d33d4eb3-783d-487b-a6b6-3091d2b6b183.png)


Mise en place d’une solution de messagerie asynchrone avec le Broker KAFKA

kafka en principe fourni un broker généralement besoin de démarrer ce forme d'un cluster donc on peut démarrer plusieurs instance de broker kafka et pour coordonner ces instances kafka besoin d'un utile qui s'appelé zookeeper et aussi dans l'API kafka contiennes Producer API qui permet à n'importe quel application d'envoyer des messages et de faire la communication asynchrone, consumer API qui permet à n'importe quel application de consumer des données ou des messages.
Donc on va créer une application spring boot pour produire un événement et envoyer ou bien consumer  un message dans une topic kafka .Mais tout d'abord on va démarrer kafka après le démarrage de zookeeper.
Start kafka et zookeeper.

![image](https://user-images.githubusercontent.com/102171677/177164390-f78f6400-8489-4db6-93cd-f2524106da15.png)

 
Après nous avons besoin de crées un Producer kafka et un consumer kafka pour faire de la messagerie asynchrone.
Le Producer il doit publier des informations d’une facture dans une topic Facture

![image](https://user-images.githubusercontent.com/102171677/177164491-c27054d4-9173-4bfb-b825-d08a5286396f.png)

 
Puis le consommer lire  le message et enregistrer les informations de facture dans son base de données.

![image](https://user-images.githubusercontent.com/102171677/177164544-a59807b4-4ba9-48e9-9a57-d57ec3b59f8d.png)

 
 
Partie Front End avec Angular Framework

Dans la partie Front End de projet j’ai utilisé le Framework angular pour consulter et gérer, les clients les produit et les factures. Alors cette Framework créer la partie front end des applications web de type SPA (Single Page Application réactive)qui contient une seule page HTML(index.html) récupérée du serveur .et pour naviguer entre les différentes partie de cette application.java Script est utilisé pour envoyer des requêtes http vers le serveur pour récupérer du contenu dynamique généralement au format JSON. Ce contenu JSON est ensuite affiché coté client au format HTML dans la même page. Dans ce projet j’ai travaillé avec angulare2 qui baser sur les composants web.
Démarrage de Framework angular.
Pour démarrer angular il faut télécharger d’abord node js pour installer les bibliothèques java script, puis angula clir qui permet de générer, compiler, tester et déployer des projets angular: npm install –g @angular/cli ,ng new projet, ng serve, ng g c nomcom…
Install angular :

![image](https://user-images.githubusercontent.com/102171677/177164601-9e1b89d1-150b-4d8a-8b66-34a2e5d18063.png)
 
Crée un projet angular:

![image](https://user-images.githubusercontent.com/102171677/177164643-fdfe79e4-905c-4c29-8393-a179d4267eab.png)

 
Consulter le projet  via le port 4200 :

![image](https://user-images.githubusercontent.com/102171677/177164676-4fffc1f8-cd35-4ba7-8301-ab5a269e7683.png)

 
Les interfaces de mon application (Front end) sont :
Consulter les produits :

![image](https://user-images.githubusercontent.com/102171677/177164722-5d598884-3b1a-4315-a9eb-d1366d17e652.png)

 
Consulter les clients :

![image](https://user-images.githubusercontent.com/102171677/177164759-e299e8a1-9764-4e57-8828-ad410511487a.png)

 
Consulter les informations sur une facture :

![image](https://user-images.githubusercontent.com/102171677/177164810-ece2a0cc-7198-4b97-a2fe-fd44dcfa6480.png)


Ajouter un client :

![image](https://user-images.githubusercontent.com/102171677/177164865-c19a53bd-adb0-4766-8181-e0908ea653b5.png)
 
Ajouter un produit :

![image](https://user-images.githubusercontent.com/102171677/177164905-bf8314ca-b4e4-4b70-b1c6-465458785ac7.png)

 


