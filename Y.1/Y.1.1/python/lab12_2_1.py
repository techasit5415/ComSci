import random
import math

def is_prime(number):
    if number < 2:
        return False
    for i in range(2, number // 3):
        if number  % i == 0:
            return False
    
    return True

def gen_prime(min, max):
    prime = random.randint(min,max)
    while not is_prime(prime):
        prime = random.randint(min,max)
    return prime

def mod_inverse(e, phi):
    for d in range(3, phi):
        if (d * e) % phi == 1:
            return d
        
p = gen_prime(1, 100)
q = gen_prime(1, 100)

while p == q:
    q = gen_prime(1, 100)

n = p * q
phi_n = (p-1) * (q-1)

e = random.randint(1, phi_n - 1)
while math.gcd(e, phi_n) != 1:
    e = random.randint(1, phi_n - 1)

d = mod_inverse(e, phi_n)

print(f"Public Key: {e}")
print(f"Private Key: {d}")

message = "66050160"

message_encoded = [ord(c) for c in message]
cipher_text = [pow(c, e, n) for c in message_encoded]

print("Encoded:",*cipher_text)

message_encoded = [pow(c, d, n) for c in cipher_text]
message = "".join(chr(c) for c in message_encoded)

print("Decoded:",message)
