# JetsProject

# Overview
This program models an airfield housing a fleet of passenger jets, cargo jets, and fighter jets that were populated from a text file. Users are presented with a menu to: <ol><li>list the jets in the airfield</li><li>make the jets in the airfield fly</li><li>see which jet has the fastest speed in MPH and Mach</li><li>see which jet has the furthest range in miles and hours</li><li>have the cargo jets load their cargo</li><li>have the fighter jets start fighting</li><li>add a new jet to the airfield, including<ul><li>jet type</li><li>model</li><li>speed in MPH</li><li>range</li><li>purchase price</li></ul><li>remove a jet specific from the user from the airfield</li><li>exit the program</li></ol>

The fleet dynamically adapts to added or removed jets, and if a user enters an invalid response, they are prompted to reenter the information until they choose to exit the program.

# Technologies & Concepts Used
<li>Java</li><ul>
	<li>abstract superclasses & interfaces</li>
	<li>lists & arraylists</li>
	<li>exceptions & try/catch blocks</li>
	<li>bufferedreader & filereader</li>
	<li>wrapper classes</li>
	<li>encapsulation</li>
	<li>inheritance</li>
	<li>polymorphism & overrides</li>
	<li>iterating over arrays with for & for each loops</li>
	<li>if/else statements</li>
	<li>while loops</li>
	<li>switches</li></ul>
<li>Eclipse</li><ul>
<li>keyboard shortcuts</li>
<li>source menu commands</li></ul>
<li>UML diagrams</li>
<li>Sublime</li>
<li>Git/GitHub</li>
<li>Unix CommandLine</li>
<li>MacOS Terminal</li>
</ul>

# Lessons Learned
##### 11/23/24 updates:
Instructor feedback pointed out that I was asking the user for a number from 1-N but then removing the jets from an ArrayList with a 0-based index. I updated my code so the JetsApplication passed 1 less than the number the user inputed, but found that the incorrect jet was being printed as being removed. That's because I was removing the jet and printing out that jet number's information without accounting for the fact that my ArrayList had been updated. I stored the jet that I removed in a new variable and then substituted that in for the removed jet's information, and it seems to be working correctly now.

##### Challenges:
Taking user input from the JetsApplication class and passing it to the AirField class in order to create a new jet was hard for me (removing a jet was much easier). I first method-chained the multiple fields of a new jet, calling the getUserSpeed from the getUserModel method and so on, but that caused problems with returning values and getting input for the correct variable. Switching to calling each method individually allowed me to reassign the return values as variables and then pass that to my addJetToFleet method in the AirField class, which I wasn't able to do through linking them. 

I noticed a lot of duplicate code like the try catch blocks in my getUser methods in the JetsApplication class and feel like those could probably be put into another method somehow, but I couldn't figure out how to apply a general getUserInput method while getting different data types back (like if they were all Strings I think I could have figured it out).


##### Successes: 
I feel like maybe I could/should have used some sort of Set or even a LinkedList in some of my methods like findFastestJet and findLongestRange since I could iterate through the Set to compare the current and next values, but that seemed complicated and I was already on track with an ArrayList. Plus I can always use more practice iterating through Lists with either a for or enhanced for loop, and it was good seeing the differences/benefits of each (for example, using a for loop when I needed a specific index vs. using a for each loop when I just wanted to iterate through and print out each jet).

I played around with my loops a lot, adding try catch blocks and attempting to "errorproof" my code a little more. Unfortunately I ran into a couple of infinite loops where I had to close Eclipse just to stop it, so I want to continue learning and thinking through where and how to structure my loops. I found success with this project by slowing down and talking through my code plus a little (okay a lot of) trial and error.

##### Overall:
Stubbing out this project as a class helped set me up for success, and I was able to take a lot of the new concepts we learned this week and integrate them into my code while also reinforcing important concepts from the previous weeks. It can get overwhelming and sometimes confusing when there are so many classes and interfaces, but I feel more comfortable and confident in the rules and how they inherit from and interact with each other. I still feel shaky about using the correct terminology but I do think I am proficient at taking notes and recognizing patterns quickly, and things are slowly starting to click and sink in more. Maybe next week I will try more of the stretch goals! :smiley: