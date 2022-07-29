# Made by Mike_Zhang
# Binary Search O(log n)
def bin_search(inList):
    x = int(input("Enter the target: ")) # target number
    alist = inList #target list

    left = 0 #left pointer
    right = len(alist) # right pointer
    while left <= right: 
        mid = (left + right)//2 # middle pionter
        if alist[mid] > x: #target in the left half, move the right to 1 position left
            right = mid - 1
        elif alist[mid] < x: #target in the right half, move the left to 1 position right
            left = mid + 1
        elif alist[mid] == x: #found
            print("Found, in position:",mid+1)
            break # exit
    else: # no found
        print("No found!")

def main():
    alist = [10,19,28,38,48,54,76,98] # must be sorted
    bin_search(alist)
# Made by Mike_Zhang
# Binary Search O(log n)