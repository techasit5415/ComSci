import random


def createPoint(studenId, amount_point, x):
    for a in range(amount_point):
        y = r*x + studenId
        return (x, y)


def decode(p, x):
    x0, y0 = p[0]
    x1, y1 = p[1]

    return (y0 * (-x1/(x0-x1))) + (y1 * (-x0/(x1-x0)))


Id = int(input("ID : "))
amount_point = 4

r = random.randrange(1, 101)
p = [createPoint(Id, amount_point, x)
     for x in range(1, amount_point+1)]

print(f" Fee m: {r}")
print("All POINT:")
for point in p:
    print(f"({point[0]}, {point[1]})")

selected_points = random.sample(p, 2)
print("POINT:")
for point in selected_points:
    print(f"({point[0]}, {point[1]})")

decoded = decode(selected_points, 0)
print(f"decord: {decoded}")
