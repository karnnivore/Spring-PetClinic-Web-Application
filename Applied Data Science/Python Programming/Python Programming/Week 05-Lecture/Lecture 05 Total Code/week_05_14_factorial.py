def factorial(num):
    if num == 0:
        return 1
    else:
        return num * factorial(num - 1)


def main():
    fact = factorial(5)     # total = 15
    print("The result is", fact)

if __name__ == "__main__":
    main()