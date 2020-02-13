def findMin(numbers):
    if len(numbers) == 0 or (not all(type(i) == int for i in numbers)):
        raise ValueError('invalid input array')
    lowIndex = 0 
    highIndex = len(numbers) - 1
    midIndex = 0 
    while numbers[lowIndex] >= numbers[highIndex]:
        if (highIndex - lowIndex == 1):
            break
        midIndex = (lowIndex + highIndex) // 2
        if numbers[lowIndex] == numbers[highIndex] and numbers[midIndex] == numbers[lowIndex]:
            return min(numbers)
        if numbers[midIndex] >= numbers[lowIndex]:
            lowIndex = midIndex
        if numbers[midIndex] <= numbers[highIndex]:
            highIndex = midIndex
    return numbers[midIndex]
