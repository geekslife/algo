def numOfTwoFriends( friends ):
    max_two_friends = 0
    _len = len(friends)
    for i in range(_len):
        two_friends = 0
        for j in range(_len):
            if i == j : continue
            if friends[i][j] == 'Y':
                print '%d) found Y at (%d,%d)'%(i,i,j)
                two_friends += 1
                continue
            for k in range(_len):
                if friends[i][k] == 'Y' and\
                    friends[k][j] == 'Y' :
                    two_friends += 1
                    print '%d) two-friend w/ %d+%d'%(i,j,k)
                    break
        print '** %d ** max_two_friends = %d'%(i,two_friends)
        max_two_friends = max(two_friends,max_two_friends)
    print '<<max>>',max_two_friends
    return max_two_friends 

def test4():
  f = ['NNNNYNNNNN','NNNNYNYYNN','NNNYYYNNNN',\
       'NNYNNNNNNN','YYYNNNNNNY','NNYNNNNNYN',\
       'NYNNNNNYNN','NYNNNNYNNN','NNNNNYNNNN',\
       'NNNNYNNNNN']
  print '#test4',f
  assert numOfTwoFriends(f) == 8

def test3():
  f = ['NYNNN','YNYNN','NYNYN','NNYNY','NNNYN']
  print '#test3',f
  assert numOfTwoFriends(f) == 4

def test2():
  friends = [ 'NYY', 'YNY', 'YYN' ]
  print '#test2',friends
  assert numOfTwoFriends(friends) == 2

def test1():
  friends = [ 'NNN',
              'NNN',
              'NNN' ]
  print '#test1',friends
  assert numOfTwoFriends(friends) == 0

if __name__ == '__main__':
    test4()
    test3()
    test2()
    test1()
