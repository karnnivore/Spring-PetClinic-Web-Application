#!/usr/bin/env python3
def calculate_future_value(monthly_investment, yearly_interest,
                           years):
    # convert yearly values to monthly values
    monthly_interest_rate = yearly_interest / 12 / 100
    months = years * 12
    # calculate future value
    future_value = 0.0
    for i in range(0, months):
        future_value += monthly_investment
        monthly_interest = future_value * monthly_interest_rate
        future_value += monthly_interest
    return future_value

def main():
    # display a welcome message
    print("The Future Value Calculator\n")
    # get input
    monthly_investment = float(input(
        "Enter monthly investment:   "))
    yearly_interest = float(input(
        "Enter yearly interest rate: "))
    years = int(input(
        "Enter number of years:      "))
    # get the future value
    future_value = calculate_future_value(monthly_investment, yearly_interest, years)
    # display output
    print("Future value:              ", round(future_value, 2))

if __name__ == "__main__":  # if main module
    main()			 # call main() function
