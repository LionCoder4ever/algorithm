def check(row, col, k):
    return sum(int(i) for i in (str(col)+str(row))) <= k

def movingCount(rows, cols, k):
    # TODO fix input check
    if rows < 0 or cols < 0:
        raise ValueError('invalid input')
    row = col = 0
    visited = [False] * rows * cols
    result = 0
    while row < rows - 1:
        while col < cols - 1:
            movingCountCore(row, col, rows, cols, k, visited)
            col += 1
        row += 1
    return len(list(i for i in visited if i))

def movingCountCore(row, col, rows, cols, k, visited):
    if row < 0 or col < 0 or row >= rows or col >= cols:
        return 
    if visited[row * cols + col]:
        return 
    if check(row, col, k):
        visited[row * cols + col] = True
        movingCountCore(row, col - 1, rows, cols, k, visited) 
        movingCountCore(row + 1, col, rows, cols, k, visited) 
        movingCountCore(row, col + 1, rows, cols, k, visited) 
        movingCountCore(row - 1, col, rows, cols, k, visited) 



if __name__ == "__main__":
    # TODO fix unit test
    # cols, rows, k=5
    result = movingCount(10,10,5)
    print(result)

    result = movingCount(20,20,15)
    print(result)
