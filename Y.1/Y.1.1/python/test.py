import numpy as np
x=np.array([21,180,50,195,96,44,171,135,120,75,106,198,])
y=np.array([8350.0,22755.0,13455.0,21100.0,15000.0,12500.0,20700.0,19722.0,16115.0,13100.0,15670.0,25300.0])
i = 0
j=0
sumxbar = 0
sumybar = 0
while i < 12:
    sumxbar += x[i]
    sumybar += y[i]
    i+=1

xbar = sumxbar / len(x)
rxbar =round(xbar, 4)
ybar = sumybar / len(x)
rybar =round(ybar, 4)


while j < 12:
    sum=+(x[j]-rxbar)*(y[j]-rybar)
    print (sum)
    j+=1
rsum =round(sum, 4)

print ('----------------')
print (rsum)