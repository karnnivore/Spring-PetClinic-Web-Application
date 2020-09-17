from animal import Animal
from animal import Dog

animal_one=Animal()
animal_two=Animal("Elephant", "M", 150, 200)
animal_three=Animal("Eagle", "F")
animal_four=Animal("Tiger")

dog_one=Dog()
dog_two=Dog("Golden Retriever", "M", 50, 75)
dog_three=Dog("Poodle", "F", 20)
dog_four=Dog("Husky")

print(dog_two.name)
print(dog_two.gender)

print(dog_three.name)
print(dog_three.gender)

print(dog_four.name)
print(dog_four.gender)


animal = Animal("AnyAnimal", "M", 120, 240)
print("Animal GetName result is \n", animal.GetName())
print("Animal IsFemale result is \n", animal.IsFemale())
print()
dog1 = Dog("Golden Retriever", "F", 50, 75)
print("Dog GetName result is \n", dog1.GetName())
print("Dog IsFemale result is \n", dog1.IsFemale())
print("Dog CanBeMother result is \n", dog1.CanBeMother())
print()
dog2 = Dog("Husky", "M", 50, 75)
print("Dog GetName result is \n", dog2.GetName())
print("Dog IsFemale result is \n", dog2.IsFemale())
print("Dog CanBeMother result is \n", dog2.CanBeMother())
print('***************************************')
animal.weight=10
print("The anilal weight is ", animal.weight)

dog1.weight=20
print("The dog weight is ", dog1.weight)