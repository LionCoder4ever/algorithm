def findPath(target: str,targetList,rows,cols):
    if (rows <= 0) and (cols <= 0):
        raise ValueError('invalid  matrix')
    if (len(target) <= 0) or (type(target) is not str):
        raise ValueError('invalid input target str')
    visited = [False] * (rows * cols)
    pathLength = row = col = 0
    while row < rows - 1:
        while col < cols - 1:
            if findPathCore(target, targetList, row, col, rows, cols, visited, pathLength):
                return True
            col += 1
        row += 1
    return False


def findPathCore(target, targetList, row, col, rows, cols, visited, pathLength):
    if pathLength == len(target):
        return True
    if not (row >= 0 and row < rows) or not (col >= 0 and col < cols):
        return False
    if targetList[row * cols + col] == target[pathLength] and not visited[row * cols + col]:
        pathLength += 1
        visited[row * cols + col] = True
        hasPath = findPathCore(target, targetList, row, col - 1, rows, cols, visited, pathLength)\
            or findPathCore(target, targetList, row - 1, col, rows, cols, visited, pathLength)\
            or findPathCore(target, targetList, row, col + 1, rows, cols, visited, pathLength)\
            or findPathCore(target, targetList, row + 1, col, rows, cols, visited, pathLength)
        if not hasPath:
            pathLength -= 1
            visited[row * cols + col] = False
        return hasPath
    return False