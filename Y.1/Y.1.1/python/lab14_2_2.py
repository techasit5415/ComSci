from sys import getsizeof
from decimal import Decimal

dec_a = Decimal('0.2')
dec_b = Decimal('0.1')


dec_c = dec_a + dec_b#add
print(dec_c)
print(getsizeof(dec_a))
print(getsizeof(dec_b))
print(getsizeof(dec_c))


dec_c = dec_a - dec_b#Sub
print(dec_c)
print(getsizeof(dec_a))
print(getsizeof(dec_b))
print(getsizeof(dec_c))


dec_c = dec_a * dec_b#Multi
print(dec_c)
print(getsizeof(dec_a))
print(getsizeof(dec_b))
print(getsizeof(dec_c))


dec_c = dec_a / dec_b#Devi
print(dec_c)
print(getsizeof(dec_a))
print(getsizeof(dec_b))
print(getsizeof(dec_c))