def easyHuffmanCoding(text):
    char_count = {}

    for char in text:
        if char in char_count:
            char_count[char] += 1
        else:
            char_count[char] = 1

    sorted_counts = sorted(
        char_count.items(), key=lambda x: x[1], reverse=True)

    rank = 1
    ranked_result = {}
    for char, count in sorted_counts:
        ranked_result[char] = '0' * (rank - 1) + '1'
        rank += 1

    encoded = "".join([ranked_result[char] for char in text])

    return encoded


text = input("TEXT : ")
encoded_text = easyHuffmanCoding(text)
print(encoded_text)
