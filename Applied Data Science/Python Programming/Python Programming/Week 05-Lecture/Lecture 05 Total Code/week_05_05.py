tax = 0.0

tax = 0.0                       # tax is global variable
def calc_tax(amount, tax_rate):
    global tax                  # access global variable
    tax = amount * tax_rate     # change global variable
    print("Tax:", tax)
def main():
    calc_tax(85.0, .05)
    print("Tax:", tax)          # Tax 4.25 (global)

if __name__ == "__main__":  # if main module
    main()			 # call main() function