def count(n):
    result = 0
    while n > 0:
        result += 1
        n = (n - 1) & n
    return result
