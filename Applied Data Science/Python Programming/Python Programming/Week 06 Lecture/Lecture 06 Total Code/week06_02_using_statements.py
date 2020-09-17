with open("test.txt", "w") as outfile:
    outfile.write("Now! Lets do something Interesting NOW!!!")

print("Successfully Done!")
print("****************************")

with open("test.txt", "r") as infile:
    print(infile.readline())

