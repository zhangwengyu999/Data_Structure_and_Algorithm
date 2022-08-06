# Made by Mike_Zhang
# Bubble Sort O(n^2)
def bubbleSort(inList):
    for i in range(len(inList)): #outer loop, len(alist) times
        for j in range(0,len(inList)-1-i): #inner loop 
            if inList[j] > inList[j+1]: #ascending order
                inList[j], inList[j+1] = inList[j+1] = inList[j]
    return inList

def main():
    alist = [38,76,98,28,19,48,10,54]
    print(bubbleSort(alist))
# Made by Mike_Zhang
# Bubble Sort O(n^2)