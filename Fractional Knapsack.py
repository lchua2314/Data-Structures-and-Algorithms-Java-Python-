from fractions import Fraction #Need Fraction library to convert a decimal to a fraction.

#Calculates each object's price-to-weight ratio and fills it in the third column of the original list.
def calPriceToWeight(list):
    for row in range(numOfObj):
        list[row][2] = list[row][0]/list[row][1]
        
#Prints the 2D list with object number (row), price (column 1), weight (column 2), and price/weight ratio (column 3)
def print2DList(list):
    print("                Price      Weight   Price/Weight")
    for row in range(numOfObj):
        print("Object ", row + 1, " : ", end="")
        for col in range(3):
            print(" | ", list[row][col], " | ", end="")
        print()   

#Returns a list ordered from the greatest to least price-to-weight ratio by index of object.
def orderObjects(objectList):
    max = objectList[0][2] #Set default max to object 1's price to weight ratio.
    maxIndex = 0 #Set max's index to object 1's index.
    sortedAlready = [] #Create a new list that will be returned with the order of indices from greatest to least.
    #counter = 0 #Used to mark each iteration of the while loop.

    while numOfObj-1 != len(sortedAlready)-1: #Loop while there are object's indices not in sortedAlready[] list. Stop when number of objects is equal to sortedAlready[] list length.
        #print("Going into for loop")
        for row in range(numOfObj): #Check through the whole 2D list's number of rows (num of objects).
            #Check if list "sortedAlready"
            found = sequentialSearch(sortedAlready, row) #Use sequential search to find if the index is already in sortedAlready[] list. Return True if it is already in the list. Return False if it isn't.
            #print("found ==", found)
            if found == True: #If the object is already sorted, skip checking if it is the next max.
                #print("found == True index checked: ", row)
                continue

            if max == None: #If max was set to None (see below for loop), set max to default max and maxIndex as the max's index. 
                max = objectList[row][2]
                maxIndex = row
            
            if max < objectList[row][2]: #If the current "max" is less than price-to-weight ratio of the object that is 
                                         #currently being checked, update max to what is being checked in this iteration.
                max = objectList[row][2]
                maxIndex = row
        #print("counter: ", counter)
        #print("maxIndex: ", maxIndex)
        #print("max: ", max)
        sortedAlready.append(maxIndex) #Add the next max's index to the end of the list.
        max, maxIndex = None, None #Reset max and maxIndex for the next for loop check.
        #counter += 1 #Used to mark each iteration of the while loop.
    return sortedAlready #Return the created list with the order of indices from greatest to least with respect to price-to-weight ratio.

#Sequential Search - Input: a list and the item to be searched for.
#Goes through the list and checks if item matches the current element in the list that is being checked using iterative.
#If item is found in the list, immediately return True.
#If not, return False.
def sequentialSearch(list, item):
    for count in range(len(list)):
        if list[count] == item:
            return True
    return False

#Prints a 1D list using iterative.
def print1DList(inputList):
    for count in range(len(inputList)):
        print("index[", count, "]: ", inputList[count])

#Inputs: 2D list that has the price, weight, and price-to-weight ratio of each object, 
#1D list with the order of object's indices to prioritize,
#and the size of the knapsack
#Output: Returns a 1D list with the quantity of items to pick from based on the orderList[] list.
def portionOfObjs(objectsList, orderList, knapsackSize):
    quantity = [0 for count in range(len(orderList))] #Create a new list with all 0's with the length of orderList.
    #print1DList(quantity)
    weight = 0 #Initialize weight to be checked to 0.
    count = 0 #Initialize count to 0. Saves index where to increase the quantity of a certain object.
              #Will be used for the for loop (filling with 1's) and in the else block below (filling with a decimal).
    for count in range(len(orderList)): #Adds objects into weight based on priority of price-to-weight ratio until weight surpasses knapsack size.
        weight += objectsList[orderList[count]][1] #Add object weight into weight int.
        if weight > knapsackSize: #Check if weight surpasses knapsack size. If so, remove current object and break out of loop.
            weight -= objectsList[orderList[count]][1]
            break
        quantity[count] = 1 #Else if weight <= knapsack size, increase quantity list from 0 to 1 based on object's index.

    #print("Quantity of objects to pick up WITHOUT fraction")
    #print1DList(quantity)

    #print("Weight w/o fraction:",weight, "Object needed for fraction:", count)
    
    #If all can fit into knapsack OR only one object which it's weight is less than or equal to knapsack size, return list.
    if weight == knapsackSize or (len(objectsList) == 1 and objectsList[orderList[0]][1] <= knapsackSize): 
        return quantity #Returns a list with the quantity of items that the knapsack can hold. Only returns 0's and 1's
    else: #Else find the fractional object. 
        i = 2 #i is the denominator of the fraction.
        while 1: #Run loop forever until weight == knapsack which means a perfect fraction is found to fill in remaining space in knapsack.
            #For loop checks all numerators in a denominator except for itself from i-1 to 1. Ex: 3/4 -> 2/4 -> 1/4 (i-(j+1))/i
            for j in range(i-1): #j will be used in numerator. Only iterate i-1 because fraction >= 1 should not be allowed.         
                weight += objectsList[orderList[count]][1]*float((i-(j+1))/i) #Multiple fraction with item weight and add to weight.
                                                                              #j should always be less than i.
                #print("weight:", weight, "Fraction used:", float((i-(j+1))/i))
                if weight == knapsackSize or i == 1000: #If weight is equal to knapsack size, add fraction to the list. Changes first 0 to fraction in list.
                                                        #OR if denominator equals 1000, just return 999/1000 as a fraction.
                    quantity[count] = float((i-(j+1))/i)
                    return quantity #Returns a list with a fraction in it.
                weight -= objectsList[orderList[count]][1]*float((i-(j+1))/i)   
            i += 1 #Increment the denominator.

#Prints the results of profit calculation, 
#total weight (which should equal to knapsack's size unless fraction was not found and it used 999/1000),
#and total profit.
def printResults(objectsList, orderList, quantityOfObjectsList):
    profit = 0.0 #Initialize profit and totalWeight to 0.0 which makes the floats.
    totalWeight = 0.0
    print("Profit Calculation:", end="")
    for count in range(len(quantityOfObjectsList)): #Iterates until number of objects is reached.
        profit += objectsList[orderList[count]][0]*quantityOfObjectsList[count] #Add object price times the quantity of object starting from greatest price-to-weight ratio.
        totalWeight += objectsList[orderList[count]][1]*quantityOfObjectsList[count] #Add object weight times the quantity of that item from greatest price-to-wegiht ratio.
        if count == len(quantityOfObjectsList)-1: #If last iteration, print the last object's price times quantity, equal sign, and final profit.
            print("( Object", orderList[count]+1, ")", objectsList[orderList[count]][0], "x", Fraction(quantityOfObjectsList[count])," = ", profit)
            print("Total Weight:", totalWeight) #Prints total weight of knapsack.
            print("Total Profit:", profit) #Prints total profit from taken items from knapsack.
            break #Break the loop so the next line of code does not occur.
        print("( Object", orderList[count]+1, ")", objectsList[orderList[count]][0], "x", Fraction(quantityOfObjectsList[count]).limit_denominator(), end=" + ")
        #Above^, print object number, price of object, multiplcation sign, quantity, and end with '+' sign

#Main      

while 1:
    knapsackSize = eval(input("Knapsack Size: ")) #Prompt and input user's knapsack size.
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
#Initialize a list called 'objects' and fill in numOfObjx3 list with 'None'.
objects = [[None for _ in range(3)] for _ in range(numOfObj)] 
#Prompt user and input object's price then weight in decsending order.
for row in range(numOfObj):
    while 1:
        objects[row][0] = float(input("Object " + str(row + 1) + " Price: "))
        if objects[row][0] <= -1:
            print("Please enter a price that is non-negative")
        else:
            break
    while 1:
        objects[row][1] = float(input("Object " + str(row + 1) + " Weight: "))
        if objects[row][1] <= 0:
            print("Please enter a weight that is greater than 0")
        else:
            break

#Calculates price-to-weight ratio and fills in the list.
calPriceToWeight(objects)
print("Table after price to weight ratio was calculated:")
print2DList(objects) #Prints out 2D list with prices, weights, and price-to-weight ratios of all objects in descending order.
order = orderObjects(objects) #Initializes list with the priority of objects to take first based on price-to-weight ratio.
print("Order of object's indices from descending order with respect to price to weight ratio:")
print1DList(order) #Prints 1D list 'order' with the indices of priority to take from based on price-to-weight ratio of 'objects' list.
quantityOfObjects = portionOfObjs(objects, order, knapsackSize) #Initializes a list with the quantity of objects to take based on priority of object's price-to-weight ratio.
print("Quantity of objects to pick up:")
print1DList(quantityOfObjects) #Prints the quantity of objects that should be taken based on 'order' list.
printResults(objects, order, quantityOfObjects) #Prints price calculation, total weight of knapsack, and profit.