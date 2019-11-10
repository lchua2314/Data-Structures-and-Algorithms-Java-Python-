from fractions import Fraction

def calPriceToWeight(list):
    #Order the ids from greatest to least price to weight ratios.
    for row in range(numOfObj):
        list[row][2] = list[row][0]/list[row][1]
        
def print2DList(list):
    print("                Price      Weight   Price/Weight")
    for row in range(numOfObj):
        print("Object ", row + 1, " : ", end="")
        for col in range(3):
            print(" | ", list[row][col], " | ", end="")
        print()   

def orderObjects(objectList):
    max = objectList[0][2]
    sortedAlready = []
    counter = 0
    maxIndex = 0
    while numOfObj-1 != len(sortedAlready)-1:
        #print("Going into for loop")
        for row in range(numOfObj):
            #Check if list "sortedAlready"
            found = sequentialSearch(sortedAlready, row)
            #print("found ==", found)
            if found == True: #If the object is already sorted, skip checking if it is the next max.
                #print("found == True index checked: ", row)
                continue

            if max == None:
                max = objectList[row][2]
                maxIndex = row
            
            if max < objectList[row][2]:
                max = objectList[row][2]
                maxIndex = row
        #print("counter: ", counter)
        #print("maxIndex: ", maxIndex)
        #print("max: ", max)
        sortedAlready.append(maxIndex) #Index out of bounds
        max, maxIndex = None, None
        counter += 1
    return sortedAlready


def sequentialSearch(list, item):
    for count in range(len(list)):
        if list[count] == item:
            return True
    return False

def print1DList(inputList):
    for count in range(len(inputList)):
        print("list[", count, "]: ", inputList[count])

def portionOfObjs(objectsList, orderList, knapsackSize):
    quantity = [0 for count in range(len(orderList))]
    #print1DList(quantity)
    weight = 0
    count = 0
    for count in range(len(orderList)):
        weight += objectsList[orderList[count]][1]
        if weight > knapsackSize:
            weight -= objectsList[orderList[count]][1]
            break
        quantity[count] = 1

    #print("Quantity of objects to pick up WITHOUT fraction")
    #print1DList(quantity)

    #print("Weight w/o fraction:",weight, "Object needed for fraction:", count)
    
    #If all can fit into knapsack, return list.
    if weight == knapsackSize:
        return quantity
    else: #Else find the fractional object.
        i = 2
        tempWeight = weight
        while 1:
            for j in range(i-1):         
                tempWeight += objectsList[orderList[count]][1]*float((i-(j+1))/i) #2-0+1/2, 3-1+1/3
                #print("tempWeight:", tempWeight, "Fraction used:", float((i-(j+1))/i))
                if tempWeight == knapsackSize:
                    quantity[count] = float((i-(j+1))/i)
                    return quantity
                tempWeight -= objectsList[orderList[count]][1]*float((i-(j+1))/i)   
            i += 1

def printResults(objectsList, orderList, quantityOfObjectsList):
    profit = 0.0
    totalWeight = 0.0
    print("Profit Calculation:", end="")
    for count in range(len(quantityOfObjectsList)):
        profit += objectsList[orderList[count]][0]*quantityOfObjects[count]
        totalWeight += objectsList[orderList[count]][1]*quantityOfObjects[count]
        if count == len(quantityOfObjects)-1:
            print("( Object", orderList[count]+1, ")", objectsList[orderList[count]][0], "x", quantityOfObjects[count]," = ", profit)
            print("Total Weight:", totalWeight)
            print("Total Profit:", profit)
            break
        print("( Object", orderList[count]+1, ")", objectsList[orderList[count]][0], "x", Fraction(quantityOfObjects[count]).limit_denominator(), end=" + ")
        

#Main method:        
numOfObj = eval(input("Number of Objects: "))

objects = [[None for _ in range(3)] for _ in range(numOfObj)]
   
col = 0
for row in range(numOfObj):
    objects[row][col] = float(input("Object " + str(row + 1) + " Price: "))
    col += 1
    objects[row][col] = float(input("Object " + str(row + 1) + " Weight: "))
    col = 0

calPriceToWeight(objects)
print("Table after price to weight ratio was calculated:")
print2DList(objects)
order = orderObjects(objects)
print("Order of object's indices from descending order with respect to price to weight ratio:")
print1DList(order)
knapsackSize = eval(input("Knapsack Size: "))
quantityOfObjects = portionOfObjs(objects, order, knapsackSize)
print("Quantity of objects to pick up:")
print1DList(quantityOfObjects)
printResults(objects, order, quantityOfObjects)