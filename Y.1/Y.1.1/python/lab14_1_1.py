import random

def calcuhamming_encode(data):
    encoded_data = [0] * 11
    
    encoded_data[2] = data[0]
    encoded_data[4] = data[1]
    encoded_data[5] = data[2]
    encoded_data[6] = data[3]
    encoded_data[8] = data[4]
    encoded_data[9] = data[5]
    encoded_data[10] = data[6]
    
    encoded_data[0] = encoded_data[2] ^ encoded_data[4] ^ encoded_data[6] ^ encoded_data[8] ^ encoded_data[10]
    encoded_data[1] = encoded_data[2] ^ encoded_data[5] ^ encoded_data[6] ^ encoded_data[9] ^ encoded_data[10]
    encoded_data[3] = encoded_data[4] ^ encoded_data[5] ^ encoded_data[6] ^ encoded_data[7]
    
    return encoded_data

def ensimulate_bit_flip(encoded_data):
    position_to_flip = random.randint(0, 10)
    
    encoded_data[position_to_flip] = 1 - encoded_data[position_to_flip]
    
    return encoded_data

def ernhamming_decode(encoded_data):
    syndrome1 = encoded_data[0] ^ encoded_data[2] ^ encoded_data[4] ^ encoded_data[6] ^ encoded_data[8] ^ encoded_data[10]
    syndrome2 = encoded_data[1] ^ encoded_data[2] ^ encoded_data[5] ^ encoded_data[6] ^ encoded_data[9] ^ encoded_data[10]
    syndrome3 = encoded_data[3] ^ encoded_data[4] ^ encoded_data[5] ^ encoded_data[6] ^ encoded_data[10]
    
    error_position = syndrome1 + 2 * syndrome2 + 4 * syndrome3
    
    if error_position > 0:
        encoded_data[error_position - 1] = 1 - encoded_data[error_position - 1]
    
    decoded_data = [encoded_data[2], encoded_data[4], encoded_data[5], encoded_data[6], encoded_data[8], encoded_data[9], encoded_data[10]]
    
    return decoded_data

data_value = random.randint(0, 127)

data_bits = [int(bit) for bit in format(data_value, '07b')]

encoded_data = calcuhamming_encode(data_bits)

encoded_data_with_error = ensimulate_bit_flip(encoded_data)

decoded_data = ernhamming_decode(encoded_data_with_error)

print(f"Original Data: {data_bits}")
print(f"Encoded Data: {encoded_data}")
print(f"Received Data with Error: {encoded_data_with_error}")
print(f"Decoded Data: {decoded_data}")