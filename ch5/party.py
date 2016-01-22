def test1():
    first = ['fishing','gardening','swimming','fishing']
    second = ['hunting','fishing','fishing','biting']
    assert 4 == best_invitation(first,second)

def best_invitation(first,second):
    matches = []
    size = len(first)
    for i in range(size):
        i1, i2 = iter(first), iter(second)
        for j in range(i):
            i1.next(),i2.next()

        m = []
        topic1,topic2 = (i1.next(),i2.next())
        print topic1,',',topic2

        for j in range(size-i-1):
            j1 = i1.next()
            j2 = i2.next()
            topics = (j1,j2)
            print topics
            if topic1 in topics or topic2 in topics:
                m.append(1)
            else:
                m.append(0)
        matches.append(m)

    matches = []
    for idx,m in enumerate(matches):
    print matches
    return 0

if __name__ == '__main__':
    test1()
