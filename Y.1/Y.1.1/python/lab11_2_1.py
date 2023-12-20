#66050160
def car(Instructor_preferences, Sales_preferences):
    n = len(Instructor_preferences)
    Instructor_partner = {}
    Sales_partner = {}
    Instructor_free = list(Instructor_preferences.keys())

    while Instructor_free:
        m = Instructor_free.pop(0)
        m_preferences_list = Instructor_preferences[m]

        for w in m_preferences_list:
            if w not in Sales_partner:
                Sales_partner[w] = m
                Instructor_partner[m] = w
                break
            else:
                m1 = Sales_partner[w]
                w_preferences_list = Sales_preferences[w]
                if w_preferences_list.index(m) < w_preferences_list.index(m1):
                    Instructor_partner[m] = w
                    Instructor_partner[m1] = None
                    Instructor_free.append(m1)
                    Sales_partner[w] = m
                    break

    return Instructor_partner, Sales_partner

Instructor_preferences = {
    "อ.วิชญะ" : ["Honda", "Mini", "Toyota"],
    "อ.ธีระ"   : ["Mini", "Toyota", "Honda"],
    "อ.สันธนะ": ["Mini", "Honda", "Toyota"],
}

Sales_preferences = {
    "Mini": ["อ.วิชญะ", "อ.ธีระ", "อ.สันธนะ"],
    "Honda": ["อ.สันธนะ", "อ.ธีระ", "อ.วิชญะ"],
    "Toyota": ["อ.วิชญะ", "อ.ธีระ", "อ.สันธนะ"],
    
}

Instructor_partner, Sales_partner = car(Instructor_preferences, Sales_preferences)

for Instructor, Sales in Instructor_partner.items():
    print(f"{Instructor} คู่กับเซลล์ขายรถ {Sales}")