"""
I have written all this by myself! Yes!!!!!
"""

CourseCode=2152

def say_hello(*args):
  """
  This is written by Reza... Honestly!
  """
  greeting="Hello "
  for person in args:
    greeting+=person + ", "
  return greeting[:-2]

def say_goodbye():
  global CourseCode
  CourseCode=9999
  print("Now we are inside say_goodbuy")
  CourseCode=7777
  print(CourseCode)
  print("Now we are exiting say_goodbuy")




