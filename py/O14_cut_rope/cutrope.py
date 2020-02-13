def dpcut(length):
    if length < 0:
        raise ValueError('invalid input')
    elif length < 2:
        return 0
    elif length == 2:
        return 1 
    elif length == 3:
        return 2
    cached = [0] * (length + 1)
    cached[0],cached[1],cached[2],cached[3] = 0,1,2,3
    i = 4
    while i <= length:
        max = 0
        j = 1
        while j <= i // 2:
            #handle half of i
            #cache the **i**(i>=4) max length
            product =  cached[j] * cached[i - j]
            max = max if max > product else product
            cached[i] = max
            j += 1
        i += 1
    return cached[length]
