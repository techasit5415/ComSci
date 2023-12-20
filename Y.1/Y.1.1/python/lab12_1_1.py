import random

event = ['H', 'T']
i = 0
percent_head = 0
sum_percent = 0
while i < 3 :
    head = 0
    tail=0
    for round in range(100000) :
        coin = random.choice(event)
        if coin == 'H' :
            head += 1
        if coin =='T':
            tail +=1
    percent_head = head / 100000 * 100
    sum_percent += percent_head
    i += 1


print("head = ", head)
print("Tail = ", tail)
print(sum_percent / 3)