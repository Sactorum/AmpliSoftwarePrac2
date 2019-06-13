# Pràctica d'apliació d'Enginyeria del Programari 2

## Apartat A:
Amb aquesta descripció, nosaltres deduïm que el patró a utilitzar és el patró Observador. Les classes de la capa de domini no poden dependre de les classes que estiguin a la capa presentació. <br/>
Ja que el que es vol, és que les capes externes (presentació) puguin ser assabentades dels canvis que es produeixen a les seves instàncies de les classe internes (domini). 

## Apartat B:
Per poder realitzar la implementació del apartat A, s'ha declarat _abstract_ els mètodes `setBroken` i `repair` de la classe MachineComposite. <br/> 
La implementació d'aquests mètodes són molt semblants. El que s'ha fet és comprovar si el estat prèvi és el mateix que l'estat que esdevindrà. Si canvia cridarà el mètode `notifyChange` que notificarà als observadors aquest canvi.<br/> 


## Apartat C: 
La classe MachineComposite implementa la classe _Observer_ . Aquesta classe ens permet observar els canvis de les subcomponents de la màquina. La classe MachineComposite té dos atributs, una llista de màquines i un comptador de màquines averiades. <br/>

Per afegir una màquina es fa ús de `addComponent`. Aquest mètode afegeix la màquina a la llista i comprova que no estigui trencada.  Si la màquina està trencada i la màquina a la que és afegida estava funcional (no hi ha cap maquina trencada), es procedeix a incrementar el contador i es notifica d'aquest canvi. Altrament, no es notifica.  <br/>

Els mètodes `setBroken` i `repair`és idéntic que els mètodes en la classe Machine. El métode `isBroken` retorna :
 - Cert, si no hi ha cap maquina averiada i l'estat d'aquesta no ho està.  
 - Fals, si existeix una màquina averiada ja sigui aquesta o qualsevol de les components. 

Ja que estem implementant la interfície _Observator_ cal implentar el métode `update`. Aquest mètode serveix de disparador en cas d'existir un canvi en les seves components. El tractament d'aquest event consisteix en incrementar o decrementar si una subcomponent s'averia o no i posteriorment es notifica dels canvis. 
