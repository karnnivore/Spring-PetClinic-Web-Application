import csv

# movies = [["Monty Python and the Holy Grail", 1975],
#           ["Cat on a Hot Tin Roof", 1958],
#           ["On the Waterfront", 1954]]
#
# with open("moviesTemp.csv", "w", newline="") as file:
#     writer = csv.writer(file)
#     writer.writerows(movies)


with open("moviesTemp.csv", newline="") as file:
    reader = csv.reader(file)
    for row in reader:
        print(row[0] + " (" + str(row[1]) + ")")
