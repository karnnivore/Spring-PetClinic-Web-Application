class Animal:
  def __init__(self, Name='Nothing', Gender='', Weight=0, Height=0):
    self.name=Name
    self.gender=Gender
    self.__weight=Weight
    self.__height=Height

  def GetName(self):
    return "The name of the "+ __class__.__name__ + " is " + self.name

  def IsFemale(self):
    if len(self.gender)==1 and ord(self.gender) ==70 or ord(self.gender) ==102:
      return True
    return False

  @property
  def weight(self):
      return self.__weight

  @weight.setter
  def weight(self, Weight):
      self.__weight=Weight

class Dog(Animal):
  def __init__(self, Name='', Gender='', Weight=0, Height=0, Teeth=0):
    Animal.__init__(self, Name, Gender, Weight, Height)
    self.teeth = Teeth

  def CanBeMother(self):
    if self.IsFemale():
      return self.name +" can be mother"
    return self.name + " cannot be mother"