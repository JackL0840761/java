Overview of general working of code:

Function getAnimalInfo() returns a 2d array.
The array size is made after reading number of lines from file.
After that each column is an attribute. There are 11 attributes in total which are saved in the 2d array namely
0.id 1.name 2.birthday 3.age 4.sex 5.specie 6.season 7.colour 8.weight 9.Park 10.Country

so if I want to get age of the third animal i will write:
animalInfo[3][3];

id, name and birthday are null at first

next function is genBirthDay..this function calculates the birthday and saves them on the 2 attribute place in animal info

genUanimalID also works in same way

....
for names we open the name file and make 4 linked list arrays..after that we store names according to specie
e.g hyena names have names of all the hyenas

Next we take animal from animal info..check their specie..if they belong to bear we give them name from BearNames array and increase the indexBear by 1 so next time we give a bear name it would be the next name and not the one already used.
....
genZooHabitat..this function returns a 4x4 2d array in which 
0 row is for hyena 
1 for lion habitat 
2 for tiger habitat 
3 for bear habitat

we place the id of animals here e.g if simba is a line it will be saved in Habitat[1][2]; 

..
generate FinalReport gets all this information from habitat and animalInfo and generates the final report