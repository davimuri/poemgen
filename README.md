# poemgen

The program was developed as a maven project with Eclipse. It uses TestNG for unit testing. The access point is the class GrammaticalRuleBuilder. This class has a build() method which starts the parsing of the rules from a BufferedReader, and returns an object that represents the main grammatical rule. That object has a generate() method which generates the random poem.

An example of a grammatical rule can be:<br/>
ruleName1: word1|word2 &lt;ruleName2&gt; $keyword

This is composed by:<br/>
•	Rule name: Text before the colon :<br/>
•	Word: Any secuence of characters without white space<br/>
•	Keyword: Starts with $<br/>
•	Or operator: Character |<br/>
•	And operator: Taken as a white space<br/>
•	Call to rule: the rule name between &lt;&gt;<br/>

Restrictions:<br/>
•	There are not two or more consecutive white spaces <br/>
•	The precedence of the operators is: and operator, or operator<br/>
•	The rule parts can not be grouping to control the precedence<br/>
