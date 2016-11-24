def test1():
    first = ['fishing','gardening','swimming','fishing']
    second = ['hunting','fishing','fishing','biting']
    assert 4 == best_invitation(first,second)

def test2():
    first = ['v','d','l','c']
    second = ['t','s','disc','m']
    assert 1 == best_invitation(first,second)

def test3():
    first = ['s','p','c','m']
    second = ['p','p','a','p']
    assert 3 == best_invitation(first,second)

def test4():
    first = ['t','o','p','c','o','d','e','r','s','i','n','g','l','e','r','o','u','n','d','m','a','t','c','h','f','o','u','r','n','i']
    second= ['n','e','f','o','u','r','j','a','n','u','a','r','y','t','w','e','n','t','y','t','w','o','s','a','t','u','r','d','a','y']
    assert 6 == best_invitation(first,second)

def best_invitation(first,second):
    count = {}
    for s1, s2 in zip(first,second):
        if count.has_key(s1):
            count[s1] += 1
        else:
            count[s1] = 1

        if s1 == s2:
            continue

        if count.has_key(s2):
            count[s2] += 1
        else:
            count[s2] = 1

    invitation = max(count.values())
    return invitation


if __name__ == '__main__':
    test1()
    test2()
    test3()
    test4()
