
def encrypt(*numbers):
    new_numbers = sorted(numbers)
    new_numbers[0] += 1

    val = 1
    for i in new_numbers:
        val *= i
    return val

def encrypt2(*numbers):
    max_val = 0
    for i in range(len(numbers)):
        val  = 1
        for idx,j in enumerate(numbers):
            if i==idx:
                val *= j+1
            else:
                val *= j
        max_val = max(val,max_val)
    return max_val

if __name__ == '__main__':
    assert 12 == encrypt(1,2,3)
    assert 36 == encrypt(1,3,2,1,1,3)
    assert 986074810223904000 == encrypt(1000,999,998,997,996,995)
    assert 2 == encrypt(1,1,1,1)
