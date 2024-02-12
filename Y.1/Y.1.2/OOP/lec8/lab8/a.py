import math

def first(num):
    sum = 0
    for i in range(num):
        sum += ((-1) ** i) / (2 * i + 1)
    return 4 * sum

def second(num):
    pi_values = []
    for i in range(1, num + 1):
        pi_values.append(first(i))
    return pi_values


num_List = [10, 100, 1000, 10000, 100000]

for num in num_List:
    pi_values = second(num)
    print(f"Iterations: {num}, Pi Values: {pi_values}")
