def check(row, col, k):
    return sum(int(i) for i in (str(col)+str(row))) <= k

def movingCountByAdd(rows, cols, k):
    if rows <= 0 or cols <= 0:
            raise ValueError('invalid input')
    row = col = 0
    visited = [False] * rows * cols
    result = 0
    return movingCountCoreByAdd(row, col, rows, cols, k, visited)

def movingCountByVisited(rows, cols, k):
    if rows <= 0 or cols <= 0:
        raise ValueError('invalid input')
    row = col = 0
    visited = [False] * rows * cols
    result = 0
    movingCountCoreByVisited(row, col, rows, cols, k, visited)
    return len(list(i for i in visited if i))

def movingCountCoreByVisited(row, col, rows, cols, k, visited):
    if row < 0 or col < 0 or row >= rows or col >= cols:
        return 
    if visited[row * cols + col]:
        return 
    if check(row, col, k):
        visited[row * cols + col] = True
        movingCountCoreByVisited(row, col - 1, rows, cols, k, visited) 
        movingCountCoreByVisited(row + 1, col, rows, cols, k, visited) 
        movingCountCoreByVisited(row, col + 1, rows, cols, k, visited) 
        movingCountCoreByVisited(row - 1, col, rows, cols, k, visited) 
    
def movingCountCoreByAdd(row, col, rows, cols, k, visited):
    count = 0
    if row < 0 or col < 0 or row >= rows or col >= cols:
        return 0
    if visited[row * cols + col]:
        return 0
    if check(row, col, k):
        visited[row * cols + col] = True
        count = 1 + movingCountCoreByAdd(row, col - 1, rows, cols, k, visited)+\
        movingCountCoreByAdd(row + 1, col, rows, cols, k, visited)+\
        movingCountCoreByAdd(row, col + 1, rows, cols, k, visited)+\
        movingCountCoreByAdd(row - 1, col, rows, cols, k, visited)
    return count
    
