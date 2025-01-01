The goal is to create a program that takes as an argument the location of a file with the following structure: 
k n v1,v2,v3,v4,...,
vn w1,w2,w3,w4,...,wn 
where: k - capacity of the backpack 
n - number of items 
v1,...,vn - n values of items 
w1,...,wn - n weights of items. 
The program should then use the Brute Force method to solve the knapsack problem for the data in the file. 
A vector of n bits should be output as the answer, where the i-th bit 1 indicates the insertion of the i-th item into the backpack. 
Also, as the programme runs, progress information should be printed out - number of iterations, best vector found so far, etc. 
NOTE: The acceptable memory complexity is O(n)
