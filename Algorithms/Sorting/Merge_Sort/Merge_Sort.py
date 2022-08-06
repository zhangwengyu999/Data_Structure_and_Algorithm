# Made by Mike_Zhang
# Merge Sort O(n log n)
def merge(left,right):
    result = list()
    while len(left)>0 and len(right)>0:
        if left[0] <= right[0]:
            result.append(left.pop(0))
        else:
            result.append(right.pop(0))
    while len(left)>0:
        result.append(left.pop(0))
    while len(right)>0:
        result.append(right.pop(0))
    return result

def mergesort(x):
    if len(x)==0 or len(x)==1:
        return x
    else:
        middle = int(len(x)/2)
        a = mergesort(x[:middle])
        b = mergesort(x[middle:])
        return merge(a,b)
    
def main():
    aList=[10,5,2,9,6,3,4,8,1,7]
    print(mergesort(aList))
    list1 = [1,4,6,10]
    list2 = [5,7,8,11,12]
    print(merge(list1,list2))
    
main()
# Made by Mike_Zhang
# Merge Sort O(n log n)