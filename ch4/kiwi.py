N=2
capacities=[100,200,100]
bottles=[70,80,90]
fromId =[0,1,2]
toId=[2,0,1]
M=10

def ex1():
    global capacities, bottles, fromId, toId
    capacities = [20,20]
    bottles = [5,8]
    fromId = [0]
    toId = [1]
    returns = [0,13]
    print 'init bottles:',bottles
    for f in fromId:
        for t in toId:
            pour(f,t)
    print 'bottles:',bottles
    print 'returns:',returns

def ex2():
    global capacities, bottles, fromId, toId
    capacities = [10,10]
    bottles = [5,8]
    fromId = [0]
    toId = [1]
    returns = [3,10]
    print 'init bottles:',bottles
    for f in fromId:
        for t in toId:
            pour(f,t)
    print 'bottles:',bottles
    print 'returns:',returns

def ex3():
    global capacities, bottles, fromId, toId
    capacities = [30,20,10]
    bottles = [10,5,5]
    fromId = [0,1,2]
    toId = [1,2,0]
    returns = [10,10,0]
    print 'init bottles:',bottles
    for f in fromId:
        for t in toId:
            pour(f,t)
    print 'bottles:',bottles
    print 'returns:',returns

def ex4():
    global capacities, bottles, fromId, toId
    capacities = [14,35,86,58,25,62]
    bottles = [6,34,27,38,9,60]
    fromId = [1,2,4,5,3,3,1,0]
    toId = [0,1,2,4,2,5,3,1]
    returns = [0,14,65,35,25,35]
    print 'init bottles:',bottles
    for f in fromId:
        for t in toId:
            pour(f,t)
    print 'bottles:',bottles
    print 'returns:',returns

def ex5():
    global capacities, bottles, fromId, toId
    capacities = [700000,800000,900000,1000000]
    bottles = [478478,478478,478478,478478]
    fromId = [2,3,2,0,1]
    toId = [0,1,1,3,2]
    returns = [0,156956,900000,856956]
    print 'init bottles:',bottles
    for i in range(len(fromId)):
        pour(fromId[i],toId[i])
    print 'bottles:',bottles
    print 'returns:',returns

def pour(_from,_to):
    to_pour = min(capacities[_to]-bottles[_to], bottles[_from])
    bottles[_from] -= to_pour
    bottles[_to] += to_pour
    print "%d>%d:"%(_from,_to),bottles

if __name__=='__main__':
    ex5()
