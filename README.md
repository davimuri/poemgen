# poemgen

The program was developed as a maven project with Eclipse. It uses TestNG for unit testing. The access point is the class GrammaticalRuleBuilder. This class has a build() method which starts the parsing of the rules from a BufferedReader, and returns an object that represents the main grammatical rule. That object has a generate() method which generates the random poem.

An example of a grammatical rule can be:
ruleName1: word1|word2 <ruleName2> $keyword

This is composed by:
•	Rule name: Text before the colon :
•	Word: Any secuence of characters without white space
•	Keyword: Starts with $
•	Or operator: Character |
•	And operator: Taken as a white space
•	Call to rule: the rule name between <>

Restrictions:
•	There aren´t two or more consecutive white spaces 
•	The precedence of the operators is: and operator, or operator
•	The rule´s parts can´t be grouping to control the precedence
