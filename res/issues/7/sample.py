print " - Big O notation"
print " - Python 2.7.*"
print ""

def isFirstElementNull(elements, value):
    return elements[0] == value

print isFirstElementNull(["1","2"],"1")

def containsValue(elements, value):
    for e in elements:
        if e == value:
            return True
    return False

print containsValue(["1","2"],"3")

def containsDuplicates(elements):
    for m in range(len(elements)):
        for n in range(len(elements)):
            if (m != n) and elements[m] == elements[n]:
                return True
    return False
print containsDuplicates(["1","2","3","2"])


def fibonacci(num):
    if num < 2:
        return num
    return fibonacci(num - 2) + fibonacci(num - 1)

print fibonacci(11)

def binarySearch(elements, key):
    begin = 0
    end = len(elements) - 1
    while (begin <= end):
        mid = begin + (end - begin)/2
        if elements[mid] > key:
            end = mid + 1
        elif elements[mid] < key:
            begin = mid + 1
        else:
            return mid
    return -1

print binarySearch([1,2,3,4,5,6,7,8,9,11,22,33,44,55,66,77,88,99,100], 9)
