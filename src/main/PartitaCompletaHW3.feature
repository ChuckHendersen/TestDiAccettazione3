Feature: partita completa HW3
#simula una partita completa
  @testBuilder
  Scenario: Labirinto bilocale
  	Given carico un labirinto completo per testare una partita
  	Given carico il comando "guarda"
  	And carico il comando "prendi aicrot"
   	And carico il comando "vai est"
   	And carico il comando "guarda"
   	And carico il comando "vai ovest"
   	And carico il comando "vai nord"
   	And carico il comando "guarda"
   	And carico il comando "vai sud"
   	And carico il comando "vai sud"
   	And carico il comando "posa aicrot"
   	And carico il comando "prendi aicrot"
   	And carico il comando "posa aicrot"
   	And carico il comando "prendi aicrot"
   	And carico il comando "posa aicrot"
   	And carico il comando "prendi torcia"
   	And carico il comando "vai nord"
   	And carico il comando "vai est"
   	And carico il comando "posa torcia"
   	And carico il comando "prendi chiave"
   	And carico il comando "vai ovest"
   	And carico il comando "vai nord"
   	And carico il comando "posa chiave"
   	And carico il comando "vai ovest"
   	And il gioco e stato avviato
   	Then hai vinto la partita