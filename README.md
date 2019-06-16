# Pràctica d'ampliació d'Enginyeria del Programari 2

## Apartat A:
Amb aquesta descripció, nosaltres deduïm que el patró a utilitzar és el patró Observador. Les classes de la capa de domini no poden dependre de les classes que estiguin a la capa presentació. <br/>
Ja que el que es vol, és que les capes externes (presentació) puguin ser assabentades dels canvis que es produeixen a les seves instàncies de les classes internes (domini). 

## Apartat B:
Per poder realitzar la implementació del apartat A, s'ha declarat _abstract_ els mètodes 'setBroken' i 'repair' de la classe MachineComposite. <br/>
La implementació d'aquests mètodes són molt semblants. El que s'ha fet és comprovar si l'estat previ és el mateix que l'estat que esdevindrà. Si es canvia, cridarà el mètode 'notifyChange' que notificarà als observadors aquest canvi. Altrament, no es realitzarà cap canvi ni acció.

## Apartat C: 
La classe MachineComposite implementa la classe _Observer_ . Aquesta classe ens permet observar els canvis de les subcomponents de la màquina. La classe MachineComposite té dos atributs, una llista de màquines i un comptador de màquines avariades. <br/>

Per afegir una màquina es fa ús de 'addComponent'. Aquest mètode afegeix la màquina a la llista i comprova que no estigui trencada. Si la màquina està trencada i la màquina a la qual és afegida estava funcional (no hi ha cap màquina trencada), es procedeix a incrementar el comptador i es notifica d'aquest canvi. Altrament, no es notifica.  <br/>
Si per error s'afegeix un _null_ el que succeirà és una excepció pertanyent a `NullPointerExcepetion.class`. <br/>

Els mètodes 'setBroken' i 'repair' és idèntic que els mètodes en la classe Machine. El mètode 'isBroken' retorna:
 - Cert, si no hi ha cap màquina avariada i l'estat d'aquesta no ho està.
 - Fals, si existeix una màquina avariada, sigui aquesta o qualsevol de les components.

Ja que estem implementant la interfície _Observer_ cal implementar el mètode 'update'. Aquest mètode serveix de disparador en cas d'existir un canvi en les seves components. El tractament d'aquest esdeveniment consisteix en un increment o decrement si una subcomponent s'avaria o no i posteriorment es notifica dels canvis.

## Apartat D: 
Per evitar duplicitat de codi, s'ha realitzat la implementació dels mètodes `setBroken` i `repair` en la classe abstracta. 
Aquestes millores estàn en els següents arxius de codi font:
 - [MachineComponent](https://github.com/Sactorum/AmpliSoftwarePrac2/blob/master/src/MachineD/MachineComponent.java)
 - [Machine](https://github.com/Sactorum/AmpliSoftwarePrac2/blob/master/src/MachineD/Machine.java)
 - [MachineComposite](https://github.com/Sactorum/AmpliSoftwarePrac2/blob/master/src/MachineD/MachineComponent.java)
 
 
