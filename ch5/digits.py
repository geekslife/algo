def interesting(base):
    print 'interesting(',base,')'
    digits = []
    # for all digits choose b,
    #   set 3 digit number with mod b == 0
    #   check if sum mod b == 0
    #   if pass, add to digits
    for b in range(2,base):
        #print '... ',b,'/',base
        valid = True
        for d1 in range(0,base):
            for d2 in range(0,base):
                for d3 in range(0,base):
                    n = d1*base**2 + d2*base + d3
                    if n % b == 0 and (d1+d2+d3)%b != 0:
                        valid=False
                        break
                if not valid: break
            if not valid: break
        if valid :
                #print "!",b
                digits.append(b)
    return digits

if __name__ == '__main__':
    assert [ 3, 9 ] == interesting(10)
    assert [ 2 ] == interesting(3)
    assert [ 2,4,8 ] == interesting(9)
    assert [5,25] == interesting(26)
    assert [29] == interesting(30)