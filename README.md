# Object-Oriented Software Testing

Master 1 ICE, GLa - V&V - Labs ([course materials](https://combemale.github.io/teaching/m1ice/))

> Créez un projet Java, récupérez la classe MyPoint, et rajoutez la librairie JUnit à votre projet. 

## Test Unitaire pour Java avec JUnit

> Q.1a Tester les constructeurs 1 et 2 (dans une classe de test TestMyPoint). Pour cela, utiliser la Javadoc pour
comprendre le comportement attendu des constructeurs. Utilisez des assertions pour vérifier les valeurs, par exemple :

    ...
    assertEquals (0d, point . getX (), 0.0001);
    ...

> Q.1b Le test de ces constructeurs utilisent les opérations getX et getY. Ne trouvez-vous pas cela étrange qu’un test utilise d’autres opérations ? Que faire ?

Les getters sont nécessaires pour vérifier l'état interne des objets ; de ce fait, ils sont liés au test du constructeur, nous ne pouvons donc pas nous en passer. Nous devons donc nous assurer que les tests des getters passent correctement.

> Q.1c Testez les accesseurs en lecture et écriture (les opérations get et set). Tout d’abord, testez getX et setX ensemble (car elles sont liées, idem pour y). Ensuite créez d’autres tests pour tester les opérations set avec la valeur Double.NaN (cf. la javadoc de ces opérations).

> Q.1d Testez le constructeur 3 et l’opération scale. Plusieurs tests (i.e. plusieurs opérations) seront nécessaires pour le constructeur 3. Vous pouvez constater que la plupart des tests nécessitent la création d’un point au début des opérations de test.

> Q.1e Définissez et utilisez l’opération @Before setUp() et tout ce qui est également nécessaire pour déléguer cette création à l’opération setUp.

> Q.1f Testez l’opération horizontalSymmetry. Là encore, plusieurs tests (i.e. plusieurs opérations) seront nécessaires. Vous remarquerez que cette opération peut lever une exception. Utilisez le paramètre expected de l’annotation Test pour vérifier que cette exception est bien levée en temps voulu.

## Couverture de code

> Q.2a Utilisez l’outil de couverture de code fourni dans Eclipse (ou autre IDE) pour identifier les chemins dans le code non couvert par vos tests. Rajoutez quelques tests si besoins (n’y passez pas trop de temps).

Nous avons utilisé l'outil Eclemma ; 57.7% du code est couvert avant l'ajout de nouveaux tests.

> Q.2b Est-ce que votre code est sûr lorsque toutes les instructions sont couvertes par au moins un test ?

Non, car le code peut avoir un souci de conception ou de logique ; ce n'est pas parce que le test couvre tous les chemins possibles empruntés par les méthodes que ces dernières sont cohérentes ou pertinentes.

> Q.2c Ajoutez le test unitaire suivant et exécutez-le. S’il passe, bien joué. Dans tout les cas cela peut certainement vous aidez à répondre à la question précédente.

    @Test public void testCentralSymmetryNULL ( ) {
        new MyPoint ( 1 0 , 2 0 ) . centralSymmetry ( null ) ;
    }

Il faut ajouter l'attribut "expected" à l'annotation @Test afin que ce test passe.


## Test d'intégration pour Java avec EasyMock ou Mockito

Cet exercice est une brève introduction au principe du mock.

L’opération setPoint(Random r1, Random r2) définit les coordonnées d’un point de manière aléatoire (x avec r1, et y avec r2).

> Q.3a Expliquez en quoi il est impossible de tester en l’état cette opération.
    >> On veut donc utiliser le principe du Mock pour tester cette opération.
    
 Les nouvelles coordonnées du point étant aléatoires, nous ne sommes pas en mesure de déterminer l'état final de l'objet.

> Q.3b Utilisez Easymock ou Mockito pour tester cette opération. 

Mockito a été utilisé afin de tester cette opération.

Avec Mockito :
- N’oubliez pas @RunWith (MockitoJUnitRunner.class). Vous aurez besoin de 2 attributs Random annotée avec @Mock. Le but est de simuler l’opération nextInt(). 
- L’opération translate(ITranslation) déplace le point selon le vecteur de translation donné en paramètre. Cependant ITranslation est une interface, on ne peut donc pas l’instancier.

Avec Easymock : voir la refcard et les slides du cours.

> Q.3c Supposons que nous ne disposons pas d’une implémentation de ITranslation pour tester cette opération, utilisez Mockito ou Easymock et tester finalement cette opération.

## Modifications apportées à la classe MyPoint

* Ajout de la méthode toString()
* Ajout de la méthode hashCode()
* Ajout de la méthode equals()
