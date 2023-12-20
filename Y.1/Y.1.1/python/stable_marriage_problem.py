#66050160
def stable_marriage_problem(men_preferences, women_preferences):
    n = len(men_preferences)
    men_partner = {}
    women_partner = {}
    men_free = list(men_preferences.keys())

    while men_free:
        m = men_free.pop(0)
        m_preferences_list = men_preferences[m]

        for w in m_preferences_list:
            if w not in women_partner:
                women_partner[w] = m
                men_partner[m] = w
                break
            else:
                m1 = women_partner[w]
                w_preferences_list = women_preferences[w]
                if w_preferences_list.index(m) < w_preferences_list.index(m1):
                    men_partner[m] = w
                    men_partner[m1] = None
                    men_free.append(m1)
                    women_partner[w] = m
                    break

    return men_partner, women_partner

men_preferences = {
    "M1": ["W1", "W3", "W4", "W2"],
    "M2": ["W2", "W1", "W3", "W4"],
    "M3": ["W2", "W4", "W3", "W1"],
    "M4": ["W3", "W1", "W2", "W4"],
}

women_preferences = {
    "W1": ["M1", "M4", "M2", "M3"],
    "W2": ["M3", "M1", "M2", "M4"],
    "W3": ["M2", "M4", "M1", "M3"],
    "W4": ["M1", "M4", "M3", "M2"],
}

men_partner, women_partner = stable_marriage_problem(men_preferences, women_preferences)

for man, woman in men_partner.items():
    print(f"{man} คู่กับ {woman}")