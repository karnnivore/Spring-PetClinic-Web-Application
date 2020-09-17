# with open("members.txt") as file:
#     for line in file:
#         print(line, end="")
#         #print(line)
#     print()
#
# print("****************************")
#
# with open("members.txt") as file:
#     contents = file.read()
#     print(contents)
#
# print("****************************")
#
# with open("members.txt") as file:
#     members = file.readlines();
#     print(members[0], end="")
#     print(members[1])
#
# print("****************************")
#
# with open("members.txt") as file:
#     member1 = file.readline();
#     print(member1, end="")
#     member2 = file.readline();
#     print(member2)
#
# members = ["Pia Lee", "Kay Kim", "Reza Dibaj"]
# with open("newMembers.txt", "w") as file:
#     for m in members:
#         file.write(m + "\n")          # adds new line
#
# members = []
# with open("newMembers.txt") as file:
#     for line in file:
#         line = line.replace("\n", "") # removes new line
#         members.append(line)
# print(members)
#
# years = [1975, 1979, 1983]
# with open("years.txt", "w") as years_file:
#     for year in years:
#         years_file.write(str(year) + "\n")  # converts int to str
#
# years = []
# with open("years.txt") as file:
#     for line in file:
#         line = line.replace("\n", "")
#         years.append(int(line))    # converts str to int
# print(years)










