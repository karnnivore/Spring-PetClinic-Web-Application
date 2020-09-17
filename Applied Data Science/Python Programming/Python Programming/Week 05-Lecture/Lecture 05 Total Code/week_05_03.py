#!/usr/bin/env python3
def calculate_future_value(monthly_investment, yearly_interest, years=20):
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

future_value = calculate_future_value(100, 8.5)
print("Future value:\t\t\t" + str(round(future_value, 2)))

future_value = calculate_future_value(100, 8.5, 10)
print("Future value:\t\t\t" + str(round(future_value, 2)))

#How to call the function with named arguments
future_value = calculate_future_value(
    years=10,
    monthly_investment=100,
    yearly_interest=8.5)
print("Future value:\t\t\t" + str(round(future_value, 2)))
