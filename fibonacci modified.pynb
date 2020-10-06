# https://www.hackerrank.com/challenges/fibonacci-modified/problem

#!/bin/python

import math
import os
import random
import re
import sys

# Complete the fibonacciModified function below.
def fibonacciModified(t1, t2, n):
    if 1== n:
        return t1
    elif 2== n:
        return t2
    else:
        for i in range(3, n+1):
            temp= t2
            t2= t1+ t2*t2
            t1= temp
        return t2
if __name__ == '__main__':
    fptr = open(os.environ['OUTPUT_PATH'], 'w')

    t1T2n = raw_input().split()

    t1 = int(t1T2n[0])

    t2 = int(t1T2n[1])

    n = int(t1T2n[2])

    result = fibonacciModified(t1, t2, n)

    fptr.write(str(result) + '\n')

    fptr.close()
