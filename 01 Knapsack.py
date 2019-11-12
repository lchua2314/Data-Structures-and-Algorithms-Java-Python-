#Method that creates and returns the list that has the best profits 
#based on weight of knapsack (0 to knapsackSize) vs. object's weight (object 1, object 1 + object 2, etc)
def createSizeVsObjList(knapsackSize, weight, price, num): 
    newList = [[0 for _ in range(knapsackSize + 1)] for _ in range(num + 1)] 
  
    #Fill up the list from the bottom-up. 
    for i in range(num + 1): 
        for weightOfCol in range(knapsackSize + 1): 
            if weightOfCol == 0 or i == 0: #If object # is 0 or knapsack size is 0, profit will be 0 in that cell. 
                newList[i][weightOfCol] = 0
            elif weight[i-1] > weightOfCol: 
                newList[i][weightOfCol] = newList[i-1][weightOfCol]
            elif weight[i-1] <= weightOfCol: #If the previous weight is less than or equal to the current knapsack size in this loop,
                #Update newList's current cell to either the current object's price plus 
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
def findSolSack(twoDlist, priceList, weightList, weightOfKnapsack, numberOfObj):

    row = numberOfObj
    col = weightOfKnapsack

    totalWeight = 0
    totalProfit = 0

    while twoDlist[row][col] != 0 or row < 0 or col < 0:

        while twoDlist[row-1][col] == twoDlist[row][col]:
            row -= 1

        col -= weightList[row-1]
        totalProfit += priceList[row-1]
        totalWeight += weightList[row-1]
        print("Taking object", row, "\nPrice:", priceList[row-1] ,"Weight:", weightList[row-1], "\nCurrent Profit:", totalProfit,"Current Weight:", totalWeight ,"\n")
        row -= 1
    
    print("\nTotal Weight: ", totalWeight, "\nTotal Profit: ", totalProfit)

#Driver
while 1:
    knapsackSize = int(input("Knapsack Size: ")) #Prompt and input user's knapsack size.
    if knapsackSize <= 0:
        print("Please enter a value that is greater than 0")
    else:
        break
#Prompt user for number of objects and input int value into numOfObj
numOfObj = 0
while numOfObj <= 0:
    numOfObj = eval(input("Number of Objects: "))
    if numOfObj <= 0:
        print("Please enter a number that is greater than 0.") 

#Initialize lists called 'objectWeights' and 'objectPrices' and make them empty.
objectPrices = [None for _ in range(numOfObj)]
objectWeights = [None for _ in range(numOfObj)]

#Prompt user and input object's price then weight in decsending order.
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
sizeVsObj = createSizeVsObjList(knapsackSize, objectWeights, objectPrices, numOfObj)
print2DList(sizeVsObj, knapsackSize)
print()

findSolSack(sizeVsObj, objectPrices, objectWeights, knapsackSize, numOfObj)

exit = input("\nEnter anything to exit program: ")