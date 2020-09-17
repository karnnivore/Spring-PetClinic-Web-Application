tax = 0.0                       # tax is global variable

def calc_tax(amount, tax_rate):
    tax = amount * tax_rate     # tax is local variable
    print("Tax:", tax)          # Tax 4.25 (local)

def main():
    calc_tax(85.0, .05)
    print("Tax:", tax)          # Tax 0.0 (global)


if __name__ == "__main__":  # if main module
    main()			 # call main() function