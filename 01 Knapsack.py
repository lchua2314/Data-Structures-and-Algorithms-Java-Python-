#Method that creates and returns the list that has the best profits 
#based on weight of knapsack (0 to knapsackSize) vs. object's weight (object 1 to object 1 + object 2, etc)
def createSizeVsObjList(knapsackSize, weight, price, num): 
    newList = [[0 for _ in range(knapsackSize + 1)] for _ in range(num + 1)] 
  
    #Fill up the list from the bottom-up. 
    for i in range(num + 1): 
        for weightOfCol in range(knapsackSize + 1): 
            if weightOfCol == 0 or i == 0: #If object # is 0 or knapsack size is 0, profit will be 0 in that cell. 
                newList[i][weightOfCol] = 0
            elif weight[i-1] > weightOfCol: #If the current object's weight (current because number of objects + 1 extra row)
                                            #is greater than to the current knapsack size in this loop,
                                            #Update newList's current cell to the previous object's profit based on the weight above the current cell.
                newList[i][weightOfCol] = newList[i-1][weightOfCol]
            elif weight[i-1] <= weightOfCol: #If the current object's weight is less than or equal to the current knapsack size in this loop,
                #Update newList's current cell to either the current object's price plus the profit of the previous object's (row) and the current column minus
                #the current object's weight
                #OR the previous object's profit based on the same weight above the current cell based on which one has a higher max. 
                newList[i][weightOfCol] = max(price[i-1] + newList[i-1][weightOfCol-weight[i-1]],  newList[i-1][weightOfCol])  

    return newList
        
#Prints the 2D list with weights (0 to knapsackSize) vs. object number (row)
def print2DList(list, kSackSize):
    print("Weight Axis: ", end="")
    for weight in range(kSackSize + 1):
        print(" | ", weight, " | ", end="")
    print()

    print("           --", end="")
    for _ in range(kSackSize + 1):
        print("---------", end="")
    print()

    for row in range(numOfObj + 1):
        print("Object ", row, " : ", end="")
        for col in range(kSackSize + 1):
            print(" | ", list[row][col], " | ", end="")
        print()   

#Prints a 1D list using iterative.
def print1DList(inputList):
    for count in range(len(inputList)):
        print("Object", count + 1, ": ", inputList[count])

#Prints the results of profit calculation (showing what objects were taken), 
#total weight (which should equal to knapsack's size),
#and total profit.
def findSolSack(twoDList, priceList, weightList, weightOfKnapsack, numberOfObj):

    row = numberOfObj #row and col start at the very last cell that was updated in createSizeVsObjList() method AKA the solution's profit.
    col = weightOfKnapsack

    totalWeight = 0 #Calculates the weight and profit everytime an object is added to knapsack (Not literally, but through text).
    totalProfit = 0

    #While the cell that is being checked is not 0 (which means that it is in either/or
    #the first row or column which is 0 knapsack size or 0 objects to be placed)
    #or the row or col is a negative index 
    while twoDList[row][col] != 0 or row < 0 or col < 0:

        #If the above cell is equal to the current cell, move up. Repeat until they are not.
        while twoDList[row-1][col] == twoDList[row][col]:
            row -= 1

        #When the above cell is no longer equal to the current cell, 
        totalProfit += priceList[row-1] #Add the current object's profit to the total profit 
                                        #(index is subtracted by 1 because n+1 rows. n being number of objects)
        totalWeight += weightList[row-1] #Add the current object's weight to the total weight (index same with price)
        #Inform user of what object is being taken, it's price, it's weight, 
        #current profit and current weight from current and previous objects taken
        print("Taking object", row, "\nPrice:", priceList[row-1] ,"Weight:", weightList[row-1], "\nCurrent Profit:", totalProfit,"Current Weight:", totalWeight ,"\n")
        col -= weightList[row-1] #Move the column by the weight of the object.
        row -= 1 #Move up a cell even if it does not match the current cell's profit so same item is not taken twice.
    
    #After the current cell's item is found to be 0 or the row or col indices are negative, 
    #all objects are taken that leads to the most optimal solution that is the highest profit of objects
    #and equal or below the knapsack size

    #Print to the user the total weight (should be equal or below knapsack size) 
    #and total profit based on the object(s) taken.
    print("\nTotal Weight: ", totalWeight, "\nTotal Profit: ", totalProfit)

#Driver
#Prompt and input user's knapsack size. Has input validation in which knapsack size cannot be less than or equal to 0.
while 1:
    knapsackSize = int(input("Knapsack Size: ")) 
    if knapsackSize <= 0:
        print("Please enter a value that is greater than 0")
    else:
        break
#Prompt user for number of objects and input int value into numOfObj. Has input validation.
numOfObj = 0
while numOfObj <= 0:
    numOfObj = eval(input("Number of Objects: "))
    if numOfObj <= 0:
        print("Please enter a number that is greater than 0.") 

#Initialize lists called 'objectWeights' and 'objectPrices' and make them empty.
objectPrices = [None for _ in range(numOfObj)]
objectWeights = [None for _ in range(numOfObj)]

#Prompt user and input object's price then weight in decsending order. Has input validation.
for objNum in range(numOfObj):
    while 1:
        objectPrices[objNum] = int(input("Object " + str(objNum + 1) + " Price: "))
        if objectPrices[objNum] <= -1:
            print("Please enter a price that is a non-negative integer")
        else:
            break
    while 1:
        objectWeights[objNum] = int(input("Object " + str(objNum + 1) + " Weight: "))
        if objectWeights[objNum] <= 0:
            print("Please enter a weight that is a greater than 0 integer")
        else:
            break

print("\nList of prices based on object number from descending order")
print1DList(objectPrices)

print("\nList of weights based on object number from descending order")
print1DList(objectWeights)

print()
#Create the list with many smaller portions based on knapsack weight and objects that can be taken.
sizeVsObj = createSizeVsObjList(knapsackSize, objectWeights, objectPrices, numOfObj)
#Print the list in a 2D table.
print2DList(sizeVsObj, knapsackSize)
print()

#Goes through the 2D list based on the method learned in class to find the objects to put in the knapsack
#and prompts the user of the object(s) that were picked up with the object's weight and price 
#along with keeping a total weight and total profit that will be displayed at the end.
findSolSack(sizeVsObj, objectPrices, objectWeights, knapsackSize, numOfObj)

exit = input("\nEnter anything to exit program: ")
