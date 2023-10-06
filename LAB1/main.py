import math

print('ax^2+bx+c=0')
a = float(input('a:'))
b = float(input('b:'))
c = float(input('c:'))

D = b**2-4*a*c

if D<0:
    print('no roots!')
else:
    if D==0:
        print('The root is: ' + str(-b/(2*a)))
    else:
        print('The roots are: ' + str((-b + math.sqrt(D))/ (2 * a)) + ' and ' + str((-b - math.sqrt(D))/ (2 * a)))

