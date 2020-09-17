"""
def add_numbers(upper):
    total = 0
    for number in range(upper + 1):
        total += number
    return number
"""
def add_numbers(upper):
    if upper == 0:
        return upper
    else:
        return upper + add_numbers(upper - 1)

def main():
    total = add_numbers(5)     # total = 15
    print("The result is", total)

if __name__ == "__main__":
    main()