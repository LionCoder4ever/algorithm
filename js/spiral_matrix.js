let generate = function (n) {
    if (n < 1) {
        return
    }
    let x = 1
    let arr = []
    for (let i = 0; i < n; i++) {
        arr.push(new Array())
    }

    for (let i = 0; i < n, x <= n * n; i++) {
        for (let j = i; j < n - i; j++) {
            arr[i][j] = x++
        }

        for (let j = i + 1; j < n - i; j++) {
            arr[j][n - i - 1] = x++
        }

        for (let j = n - 2 - i; j >= i; j--) {
            arr[n - i - 1][j] = x++
        }

        for (let j = n - 2 - i; j > i; j--) {
            arr[j][i] = x++
        }
    }
    return arr
}
let x = 6
while(x > 0) {
    console.log(generate(x--))
}