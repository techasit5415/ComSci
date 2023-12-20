
import random

box_box = ["A", "B", "C"]
box = { 

    "A" : False, 
    "B" : False, 
    "C" : False

}

not_switch = 0
switch = 0

for _ in range(100000):


    box["A"] = False
    box["B"] = False 
    box["C"] = False
    my_selected = "A"

    box[random.choice(box_box)] = True


    opend_box = []
    for box_name in box_box:
        if box_name != my_selected and box[box_name] != True:
            opend_box.append(box_name)
            break

 
    already_open = random.choice(opend_box)

  
    for box_name in box_box:
        if box_name != my_selected and box_name != already_open:
            my_selected = box_name
            break

    if box[my_selected] == True:
        switch += 1
    else:
        not_switch += 1

switch_chance = switch/100000
not_switch_chance = not_switch/100000

if switch_chance > not_switch_chance:
    print(f"switch: {switch_chance}%")
    print(f"not_switch: {not_switch_chance}%")
    print("Change and your opportunities increase.")
else:
    print(f"switch: {switch_chance}%")
    print(f"not_switch: {not_switch_chance}%")
    print("If you don't change, chances are more than you can change.")