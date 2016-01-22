def interesting(base):
    digits = []
    # for all digits choose b,
    #   set 3 digit number with mod b == 0
    #   check if sum mod b == 0
    #   if pass, add to digits
    for b in range(2,base):
        num = base**2+base
        while num%b!=0:
            num += 1
        d3 = num/base**2
        res = num-d3*base**2
        d2 = res/base
        res = res-d2*base
        d1 = res
        sum_digits = d3+d2+d1
        print b,':',num,'=>',d3,d2,d1,',sum=',sum_digits
        if sum_digits%b == 0:
            print "!",b
            digits.append(b)
    return digits

if __name__ == '__main__':
    assert [ 3, 9 ] == interesting(10)
