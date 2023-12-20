from sys import getsizeof

float_a = 0.2
float_b = 0.1


float_c = float_a + float_b

print(float_c)#addi
print(getsizeof(float_a))
print(getsizeof(float_b))
print(getsizeof(float_c))

float_c = float_a - float_b#Sub
print(float_c)
print(getsizeof(float_a))
print(getsizeof(float_b))
print(getsizeof(float_c))

float_c = float_a * float_b#Multi
print(float_c)
print(getsizeof(float_a))
print(getsizeof(float_b))
print(getsizeof(float_c))


float_c = float_a / float_b#Divi
print(float_c)
print(getsizeof(float_a))
print(getsizeof(float_b))
print(getsizeof(float_c))