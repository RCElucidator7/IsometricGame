### Advanced Object Orientated Programming Project
## Isometric Game

We were required to implement an isometric game that challenges a player to complete some 
type of quest. 
The game should end, with suitable celebration and fanfare, when the appropriate player action fulfills the quest.

We were given a set of stub classes that implements the basic features of an isometric game, but they were 
deliberately badly designed. The objective was to extend, modify and refactor the code provided to create an 
elegant game design with the aims of accomplishing the following:

• Group together cohesive elements into methods, types and packages.

• Loosely-couple together all programme elements to the maximum extent possible.

• Create a reusable set of abstractions that are defined by interfaces and base classes.

• Encapsulate at method, type, package and module level.

• Apply creational, structural and behavioural design patterns throughout the game where appropriate. 
There  are  obvious  uses  for factories, builders,  flyweights, observers and proxies in an isometric game.

• Use the Swing MVC framework to write custom sprites and game objects.

##Game Objective

The objective of this game is to explore the world look for a way out. This can be done by interacting with items in the 
world until you obtain a key. The player is free to explore the world by using the arrow keys to determine a direction 
and pressing "X" to advance a tile. Some tiles are inexcessable until a certain item is found so be careful.

##Patterns implemented

Singleton:
I used the singleton pattern when initalising the setup for the game by loading in the images. The classes I used this in 
are the Setup interface and SetupImplementor class. (I have called these classes in the init() method that was used in the 
GameView file. This may be the incorrect place to have it but I couldn't find another solution at the time).

Builder:
I used the builder pattern for creating the array values for the ground material and items on the map. Here I used a single 
Level interface, two builders, one for each array and two Enums for each builder.

Factory/Flyweight:
I used this pattern with the character sprite. I had a Character interface, a sprite class which implemented this interface 
and a SpriteFactory class.

##Gameplay features
These features were not present in the starter file and were implemented myself:


• The character is set to the drawn tiles and cannot go off the edge of the grid.

• The character cannot walk on the "Sea" tile, this results in a game over unless they pick up the "Boots of Water Walking".

• The character can interact with certain items on the grid by pressing the "C" key.

• When changing from isometric to cartesian view, the model will move accordingly to whichever view is being used.



