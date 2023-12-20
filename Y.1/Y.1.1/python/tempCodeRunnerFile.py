import random

# Function to encode data using Hamming Code (11, 7)
def hamming_encode(data):
    # Initialize the encoded message with zeros
    encoded_data = [0] * 11
    
    # Copy the data bits to their corresponding positions in the encoded message
    encoded_data[2] = data[0]
    encoded_data[4] = data[1]
    encoded_data[5] = data[2]
    encoded_data[6] = data[3]
    encoded_data[8] = data[4]
    encoded_data[9] = data[5]
    encoded_data[10] = data[6]
    
    # Calculate the parity bits (R1, R2, R4)
    encoded_data[0] = encoded_data[2] ^ encoded_data[4] ^ encoded_data[6] ^ encoded_data[8] ^ encoded_data[10]
    encoded_data[1] = encoded_data[2] ^ encoded_data[5] ^ encoded_data[6] ^ encoded_data[9] ^ encoded_data[10]
    encoded_data[3] = encoded_data[4] ^ encoded_data[5] ^ encoded_data[6] ^ encoded_data[7]
    
    return encoded_data

# Function to simulate a single bit flip in the received data
def simulate_bit_flip(encoded_data):
    # Choose a random position to flip a bit (0 to 10)
    position_to_flip = random.randint(0, 10)
    
    # Flip the bit at the chosen position
    encoded_data[position_to_flip] = 1 - encoded_data[position_to_flip]
    
    return encoded_data

# Function to decode Hamming Code (11, 7) and correct errors if possible
def hamming_decode(encoded_data):
    # Calculate the syndromes for error detection
    syndrome1 = encoded_data[0] ^ encoded_data[2] ^ encoded_data[4] ^ encoded_data[6] ^ encoded_data[8] ^ encoded_data[10]
    syndrome2 = encoded_data[1] ^ encoded_data[2] ^ encoded_data[5] ^ encoded_data[6] ^ encoded_data[9] ^ encoded_data[10]
    # Change 'encoded_data[11]' to 'encoded_data[10]' here:
    syndrome3 = encoded_data[3] ^ encoded_data[4] ^ encoded_data[5] ^ encoded_data[6] ^ encoded_data[10]
    
    # Calculate the error position (if any)
    error_position = syndrome1 + 2 * syndrome2 + 4 * syndrome3
    
    # Correct the error (if an error is detected)
    if error_position > 0:
        encoded_data[error_position - 1] = 1 - encoded_data[error_position - 1]
    
    # Retrieve the original data bits
    decoded_data = [encoded_data[2], encoded_data[4], encoded_data[5], encoded_data[6], encoded_data[8], encoded_data[9], encoded_data[10]]
    
    return decoded_data

# Randomly generate a data value between 0 and 127
data_value = random.randint(0, 127)

# Convert the data value to a binary list with 7 bits
data_bits = [int(bit) for bit in format(data_value, '07b')]

# Encode the data using Hamming Code (11, 7)
encoded_data = hamming_encode(data_bits)

# Simulate a bit flip in the received data
encoded_data_with_error = simulate_bit_flip(encoded_data)

# Decode the received data and correct errors (if any)
decoded_data = hamming_decode(encoded_data_with_error)

# Print the original data, encoded data, received data with error, and decoded data
print(f"Original Data: {data_bits}")
print(f"Encoded Data: {encoded_data}")
print(f"Received Data with Error: {encoded_data_with_error}")
print(f"Decoded Data: {decoded_data}")