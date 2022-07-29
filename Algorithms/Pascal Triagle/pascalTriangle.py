# Made by Mike_Zhang
# Pascal's Triangle
def pascalTri(n):
    outList = [[1]]
    left = 0
    right = 0
    for i in range(1,n+1):
        inList = list()
        for j in range(i+1):
            if (j != 0):
                left = outList[i-1][j-1]
            else:
                left = 0
            if (j != i):
                right = outList[i-1][j]
            else:
                right = 0
            inList.append(left+right)
        outList.append(inList)
    return outList
   
def main():
    for row in pascalTri(10):
        print(row)
        
main()
# Made by Mike_Zhang
# Pascal's Triangle