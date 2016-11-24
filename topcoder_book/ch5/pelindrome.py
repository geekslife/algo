
def is_symmetric(s):
    _len = len(s)//2
    #print('is_symmetric:',s)
    for i in range(_len):
        #print('i=',i,'s_i=',s[i],',s_(-i)=',s[len(s)-i-1])
        if s[i] != s[len(s)-i-1]:
            return False
    return True

assert True == is_symmetric('abba')
assert True == is_symmetric('abcba')
assert False == is_symmetric('abca')

def pelindrome2(s):
# for i in range(len(s))
# if s[i]..s[-1] is symmetric
#    2*i + len(s)-i
    for i in range(len(s)):
        if is_symmetric(s[i:]):
            return 2*i + len(s)-i
    return len(s)*2

def pelindrome3(s):
    for i in range(len(s)):
        if s[i] == s[-1]:
            if is_symmetric(s[i:]):
                return 2*i + len(s)-i
        else:
            continue
    return len(s)*2

def pelindrome(s):
    for i in range(len(s)):
        if s[i] == s[-1]:
            is_symmetric = True
            for j in range((len(s)-i)//2):
                if s[i+j] != s[len(s)-j-1]:
                    is_symmetric = False
                    break
            if is_symmetric :
                return 2*i + len(s)-i
    return len(s)*2

def test1():
    assert 5 == pelindrome('abcb')
    assert 7 == pelindrome('abacaba')
    assert 11 == pelindrome('qwerty')
    assert 38 == pelindrome('abdfhdyrbdbsdfghjkllkjhgfds')

def test2():
    assert 5 == pelindrome2('abcb')
    assert 7 == pelindrome2('abacaba')
    assert 11 == pelindrome2('qwerty')
    assert 38 == pelindrome2('abdfhdyrbdbsdfghjkllkjhgfds')

def test3():
    assert 5 == pelindrome3('abcb')
    assert 7 == pelindrome3('abacaba')
    assert 11 == pelindrome3('qwerty')
    assert 38 == pelindrome3('abdfhdyrbdbsdfghjkllkjhgfds')
