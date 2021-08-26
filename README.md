# DiceDistributionSimulator

## Assignment 1: Create a Spring Boot application
Create a REST endpoint to execute a dice distribution simulation:<BR>
1. Roll 3 pieces of 6-sided dice a total of 100 times.<BR>
  a. For every roll sum the rolled number from the dice (the result will be between 3 and 18).<BR>
  b. Count how many times each total has been rolled.<BR>
  c. Return this as a JSON structure.<BR>
2. Make the number of dice, the sides of the dice and the total number of rolls configurable through query parameters.<BR>
3. Add input validation:<BR>
  a. The number of dice and the total number of rolls must be at least 1.<BR>
  b. The sides of a dice must be at least 4.<BR>

### Solution 1: 
Endpoints:<BR>
1. DiceDistributionSimulator: <BR>
			localhost:8080/dds?dices=3&sides=6&rolls=5<BR>
			localhost:8080/dds?dices=3&sides=4&rolls=5<BR>
			localhost:8080/dds?dices=5&sides=9&rolls=5<BR>
2. Badinput:<BR>
			localhost:8080/dds<BR>
			localhost:8080/dds?dices=3<BR>
			localhost:8080/dds?dices=0&sides=6<BR>
			localhost:8080/dds?dices=0&sides=6&rolls=5<BR>
			
## Assignment 2: Store the result of the simulation from Assignment 1 in a database
Create a REST endpoint that can query the stored data:<BR>
1. Return the total number of simulations and total rolls made, grouped by all existing dice number–dice side combinations.<BR>
	a. Eg. if there were two calls to the REST endpoint for 3 pieces of 6 sided dice, once with a total number of rolls of 100 and once with a total number of rolls of 200, then there were a total of 2 simulations, with a total of 300 rolls for this combination.<BR>

2. For a given dice number–dice side combination, return the relative distribution, compared to the total rolls, for all the simulations.<BR>
	a. In case of a total of 300 rolls, if the sum „3” was rolled 4 times, that would be 1.33%.<BR>
	b. If the sum „4” was rolled 3 times, that would be 1%.<BR>
	c. If the total „5” was rolled 11 times, that would be 3.66%. Etc...<BR>
	
### Solution 2: 
Endpoints:<BR>
		localhost:8080/dds/summary<BR>
		localhost:8080/dds/relativesummary<BR>
		localhost:8080/dds/relativesummary/3/6<BR>
		
Database Tables:<BR>
The application uses Derby database which creates data files at path C:\Database\Derby  in windows.

<img src="https://embed.creately.com/tZifotMJFUZ?type=svg">
			
			
			
			
