# Given list of numbers
numList = [10, 20, 30, 40, 10]
print("Given list is ", numList)

# Get first element in list
firstElement = numList[0]
# Get last element in list
lastElement = numList[-1]

# Check if first and last element are equal
if (firstElement == lastElement):
    print(True)
else:
    print(False)

# Given list of numbers
numList1 = list(input("Enter a sequence of comma separated values: ").split(", "))
print("Given list is ", numList1)

# Get first element in list
firstElement1 = numList1[0]
# Get last element in list
lastElement1 = numList1[-1]

# Check if first and last element are equal
if (firstElement1 == lastElement1):
    print(True)
else:
    print(False)