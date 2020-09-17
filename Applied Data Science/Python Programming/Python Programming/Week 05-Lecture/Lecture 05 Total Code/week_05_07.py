TAX_RATE = 0.05                  # TAX_RATE is global
def calc_tax(amount):
    tax = amount * TAX_RATE      # use constant here
    print("Tax:", tax)          # Tax 4.25 (local)
    return tax

def main():
    myTax=calc_tax(85.0)
    print("Tax:", myTax)          # Tax 0.0 (global)


if __name__ == "__main__":  # if main module
    main()			 # call main() function