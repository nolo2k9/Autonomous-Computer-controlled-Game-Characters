# Autonomous-Computer-controlled-Game-Characters

The goal for this game is to have enemy agents make decisions based on ever- changing variables. If the current stats of the agents are a certain value they will attack the player and deal damage, otherwise, they will run away and rejuvenate energy to enable them to attack again. Decisions are based on 2 controllers..
Fuzzy Controller
Output of the fuzzy controller is based on 2 inputs. Agent's energy/health. A set of rules id defined in FCL files which are made up of blocks. The Upperbound / Lowerbound of these variables are stored in FUZZIFY blocks. Depending on the current value of a variable a term will be applied from a DEFUZZIFY block. When these terms are reached rules are applied which then applies an action.
The file is then passed to a method within the FuzzyGhosts class. This method reads in the FCL file and passes the current health and energy of the agents into it and outputs a Fuzzy value. In this case, if the fuzzy value is greater than 50 the agent will attack otherwise they run away and regain energy.
Neural network
The network takes in 3 inputs. The agent's current health/energy and the player's weapons. It has 1 hidden layer with 3 neurons and an output layer with 2 neurons. The hidden layer and output are using a Sigmoid activation function. This transforms the inputs into a 0/1. Which enables the network to output a value of 0/1 which is all that’s needed.
After being initialised it is trained with the input and output training data. This training data enables the network to make a decision based on agent stats. After multiple tests, an error rate of 0.06 was found to produce the most accurate results.
