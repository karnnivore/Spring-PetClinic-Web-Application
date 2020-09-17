def factorial(num):
    fact = 1
    for number in range(1, num+1):
        fact = number * fact
    return fact


def main():
    fact = factorial(5)     # total = 15
    print("The result is", fact)

if __name__ == "__main__":
    main()