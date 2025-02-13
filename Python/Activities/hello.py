print("Hello, World!")

#demography details - This is a comment.
name = "Divya Rukmini"
Surname = 'MohanRaj'
DateOfBirth = 18
DateOfBirthMonth = 18.03

#DOB = 18 Mar # type: ignore

"""
This is a comment
written in
more than just one line
"""

print(type(name))
print(type(Surname))
print(type(DateOfBirth))
print(type(DateOfBirthMonth))
#print(type(DOB))

multipleLineString = """
Multiple
Lines
In
A 
Single
Variable
"""

print(multipleLineString)
print(name.upper())
print(Surname.lower())
print(Surname[0])
print(name[0:5])
print(name[0:3])
print(len(name))
print(len(Surname))

print(name.replace("i", "e"))
print(name.replace("I", "e"))
print(name.split(" "))

exist = "Div" in name
notexist = "Div" in Surname

print(exist)
print(notexist)

fullname = name + " " + Surname
print(fullname)

dobDetails = "My date of birth is {}"
print(dobDetails.format(DateOfBirthMonth))

dobMonth = 3

dobDetailsMultipleFormat = "Different Format : My date of birth is {} {}"
dobDetailsMultipleFormat1 = f"Different Format : My date of birth is {DateOfBirth} {dobMonth}"
print(dobDetailsMultipleFormat.format(DateOfBirth, dobMonth))
print(dobDetailsMultipleFormat1)

fruits = ["apple", "cherries", "oranges", "banana"]
print(fruits[0:3])
fruits.append("kiwi")
fruits.insert(1, "nuts")
fruits.remove("banana")

print(fruits)

copyList = fruits.copy
#copyList.remove("cherries")
print(copyList)
print(fruits)



