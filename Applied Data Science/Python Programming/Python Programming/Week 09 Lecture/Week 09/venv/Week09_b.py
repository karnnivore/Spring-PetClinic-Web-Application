import csv
import sys
import logging

# def get_movies(filename):
#     try:
#         with open(filename, newline="") as file:
#             raise OSError("OSError")    # for testing
#             movies = []
#             reader = csv.reader(file)
#             for row in reader:
#                 movies.append(row)
#         return movies
#     except Exception as e:
#         print(type(e), e)

# def get_movies(filename):
#     if len(filename) == 0:
#         raise ValueError("The filename argument is required.")
#     with open(filename, newline="") as file:
#         movies = []
#         reader = csv.reader(file)
#         for row in reader:
#             movies.append(row)
#     return movies


def get_movies(filename):
    try:
        with open(filename, newline="") as file:
            movies = []
            reader = csv.reader(file)
            for row in reader:
                movies.append(row)
        return movies
    except Exception as e:
        logging.exception(e)
        raise e


get_movies("d:\movis.csv")