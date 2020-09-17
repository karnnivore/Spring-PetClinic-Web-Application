def calc_tax(amount, tax_rate):
    tax = amount * tax_rate      # tax is local variable
    return tax                   # return is necessary

def main():
    tax = calc_tax(85.0, .05)    # tax is local variable
    print("Tax:", tax)           # Tax 4.25
if __name__ == "__main__":  # if main module
    main()			 # call main() function