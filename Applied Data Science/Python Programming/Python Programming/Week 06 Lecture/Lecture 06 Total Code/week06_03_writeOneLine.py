with open("members.txt", "w") as file:
    file.write("John Cleese\n")

print("Successfully Done!")
print("****************************")

with open("members.txt", "a") as file:
    file.write("Eric Idle\n")
