# Made by Mike_Zhang
# https://ultrafish.io

from queue import Queue
n = int(input("\nEnter n, the total number of people(integer >1):"))
m = int(input("Enter m, the number of counts for each step(integer >0):"))
position = 1 # mark next eliminated position
nowposition = 1 # mark now position
outqueue = Queue() # store the output
nqueue = Queue() # store the numbers without the eliminated one in one counting loop
for i in range(1,n+1): # create a queue from 1 to n
    nqueue.put(i)

while nqueue.empty() is False: # loop until it is empty
    # >>>the first step is getting the next elimination position<<<
    position = (m - 1) % nqueue.qsize() + 1 # use remainder % to locate the next elimination position("-1" and "+1" is for the situation that m is a multiple of nqueue.rear)
    # >>>the second step is removing the person to the rear or the output queue<<<
    if nowposition != position: # when is not the eliminated one, just remove it to the rear
        nqueue.put(nqueue.get())
        nowposition += 1 # step to next position
    else: # when is the eliminated one, remove it to the output queue
        outqueue.put(nqueue.get())
        nowposition = 1 # back to the front position

print(">>>Below is the Result of inputs[",n,"]people and [",m,"]-counts:",sep = "")
while not outqueue.empty():
     print(outqueue.get(), end=' ')# display the output queue

# Made by Mike_Zhang
# https://ultrafish.io
