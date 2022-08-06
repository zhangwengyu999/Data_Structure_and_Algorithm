# Made by Mike_Zhang
# Balanced braces (Python implementation)
def isBalanced(inBra):
    pair = ["()","[]","{}"]
    isBalance = True
    while (isBalance):
        isBalance = False
        for p in pair:
            if (p in inBra):
                isBalance = True
                inBra = inBra.replace(p,"") # !!! Not just inBra.replace(p,"")
                
    return len(inBra)==0
    

def isValid(s):
        bracket_pairs = {'(': ')', '[': ']', '{': '}'}
        brackets = []
        for ch in s:
            if ch in bracket_pairs:
                brackets.append(ch)
            elif not brackets or ch != bracket_pairs[brackets.pop()]:
                return False
        return not brackets   
    
def main():
    inBra = input("Enter:")
    print(isBalanced(inBra))
    print(isValid(inBra))
# Made by Mike_Zhang
# Balanced braces (Python implementation)