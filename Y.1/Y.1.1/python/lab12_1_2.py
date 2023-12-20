import random

thai_chance = 0.02
brazil_chance = 0.10
score = {
            'Brazil' :0,
            'Thailand':0
        }

chk = {
            'thai_lost' : 0,
            'thai_goal_atleast_one' : 0,
            'thai_win' : 0,
            'thai_goal_at_least_one_lost_brazil' : 0
        }

for _ in range(100000):
    for minute in range(90):
        random_goal = round(random.random(), 2)
        
        if random_goal == thai_chance:
            score["Thailand"] += 1
        elif random_goal == brazil_chance:
            score["Brazil"] += 1

    if score["Thailand"] < score["Brazil"]:
        chk["thai_lost"] += 1

    if score["Thailand"] >= 1:
        chk["thai_goal_atleast_one"] += 1

    if score["Thailand"] > score["Brazil"]:
        chk["thai_win"] += 1
        
    if (score["Thailand"] >= 1) and (score["Thailand"] < score["Brazil"]):
        chk["thai_goal_at_least_one_lost_brazil"] += 1
print(sorted(chk.items(), key=lambda x:x[1], reverse = True))